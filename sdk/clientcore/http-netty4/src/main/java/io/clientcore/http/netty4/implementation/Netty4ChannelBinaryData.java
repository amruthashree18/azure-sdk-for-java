// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package io.clientcore.http.netty4.implementation;

import io.clientcore.core.instrumentation.logging.ClientLogger;
import io.clientcore.core.models.CoreException;
import io.clientcore.core.models.binarydata.BinaryData;
import io.clientcore.core.serialization.ObjectSerializer;
import io.clientcore.core.serialization.json.JsonWriter;
import io.netty.channel.Channel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

import static io.clientcore.http.netty4.implementation.Netty4Utility.awaitLatch;

final class Netty4ChannelBinaryData extends BinaryData {
    private static final ClientLogger LOGGER = new ClientLogger(Netty4ChannelBinaryData.class);
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static final String TOO_LARGE_FOR_BYTE_ARRAY
        = "The content length is too large for a byte array. Content length is: ";

    private final Channel channel;
    private final Long length;

    // Non-final to allow nulling out after use.
    private ByteArrayOutputStream eagerContent;

    private volatile byte[] bytes;

    Netty4ChannelBinaryData(ByteArrayOutputStream eagerContent, Channel channel, Long length) {
        this.eagerContent = eagerContent;
        this.channel = channel;
        this.length = length;
    }

    @Override
    public byte[] toBytes() {
        if (length != null && length > MAX_ARRAY_SIZE) {
            throw LOGGER.logThrowableAsError(new IllegalStateException(TOO_LARGE_FOR_BYTE_ARRAY + length));
        }

        if (bytes == null) {
            CountDownLatch latch = new CountDownLatch(1);
            channel.pipeline().addLast(new Netty4EagerConsumeNetworkResponseHandler(latch, buf -> {
                try {
                    buf.readBytes(eagerContent, buf.readableBytes());
                } catch (IOException ex) {
                    throw new UncheckedIOException(ex);
                }
            }));

            awaitLatch(latch);
            bytes = eagerContent.toByteArray();
            eagerContent = null;
        }

        return bytes;
    }

    @Override
    public String toString() {
        return new String(toBytes(), StandardCharsets.UTF_8);
    }

    @Override
    public <T> T toObject(Type type, ObjectSerializer serializer) {
        try {
            return serializer.deserializeFromBytes(toBytes(), type);
        } catch (IOException e) {
            throw LOGGER.logThrowableAsError(CoreException.from(e));
        }
    }

    @Override
    public InputStream toStream() {
        // TODO (alzimmer): This needs to change to a deferred InputStream that pulls content from the Channel when
        //  needed. This is just a starting point.
        return new ByteArrayInputStream(toBytes());
    }

    @Override
    public void writeTo(JsonWriter jsonWriter) {
        Objects.requireNonNull(jsonWriter, "'jsonWriter' cannot be null");

        try {
            jsonWriter.writeBinary(toBytes());
        } catch (IOException e) {
            throw LOGGER.logThrowableAsError(CoreException.from(e));
        }
    }

    @Override
    public ByteBuffer toByteBuffer() {
        return ByteBuffer.wrap(toBytes());
    }

    @Override
    public Long getLength() {
        return length;
    }

    @Override
    public boolean isReplayable() {
        return false;
    }

    @Override
    public BinaryData toReplayableBinaryData() {
        return BinaryData.fromBytes(toBytes());
    }

    @Override
    public void close() {
        channel.close();
    }
}
