// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package io.clientcore.annotation.processor.test.http.models;

import io.clientcore.core.http.models.HttpHeaders;
import io.clientcore.core.http.models.HttpRequest;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.models.binarydata.BinaryData;
import io.clientcore.core.serialization.json.JsonSerializer;

public class MockHttpResponse extends Response<BinaryData> {
    private static final JsonSerializer SERIALIZER = new JsonSerializer();

    /**
     * Creates an HTTP response associated with a {@code request}, returns the {@code statusCode}, and has an empty
     * response body.
     *
     * @param request HttpRequest associated with the response.
     * @param statusCode Status code of the response.
     */
    public MockHttpResponse(HttpRequest request, int statusCode) {
        this(request, statusCode, BinaryData.empty());
    }

    /**
     * Creates an HTTP response associated with a {@code request}, returns the {@code statusCode}, and response body of
     * {@code bodyBytes}.
     *
     * @param request HttpRequest associated with the response.
     * @param statusCode Status code of the response.
     * @param body Contents of the response.
     */
    public MockHttpResponse(HttpRequest request, int statusCode, BinaryData body) {
        this(request, statusCode, new HttpHeaders(), body);
    }

    /**
     * Creates an HTTP response associated with a {@code request}, returns the {@code statusCode}, and http headers.
     *
     * @param request HttpRequest associated with the response.
     * @param statusCode Status code of the response.
     * @param headers Headers of the response.
     */
    public MockHttpResponse(HttpRequest request, int statusCode, HttpHeaders headers) {
        this(request, statusCode, headers, BinaryData.empty());
    }

    /**
     * Creates an HTTP response associated with a {@code request}, returns the {@code statusCode}, contains the
     * {@code headers}, and response body of {@code bodyBytes}.
     *
     * @param request HttpRequest associated with the response.
     * @param statusCode Status code of the response.
     * @param headers HttpHeaders of the response.
     * @param body Contents of the response.
     */
    public MockHttpResponse(HttpRequest request, int statusCode, HttpHeaders headers, BinaryData body) {
        super(request, statusCode, headers, body);
    }

    /**
     * Creates an HTTP response associated with a {@code request}, returns the {@code statusCode}, and response body
     * that is JSON serialized from {@code serializable}.
     *
     * @param request HttpRequest associated with the response.
     * @param statusCode Status code of the response.
     * @param serializable Contents to be serialized into JSON for the response.
     */
    public MockHttpResponse(HttpRequest request, int statusCode, Object serializable) {
        this(request, statusCode, new HttpHeaders(), serialize(serializable));
    }

    private static BinaryData serialize(Object serializable) {
        if (serializable == null) {
            return null;
        }

        return BinaryData.fromObject(serializable, SERIALIZER);
    }
}
