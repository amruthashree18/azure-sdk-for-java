// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.recoveryservicessiterecovery.fluent.models.RecoveryServicesProviderInner;
import java.io.IOException;
import java.util.List;

/**
 * Collection of providers.
 */
@Fluent
public final class RecoveryServicesProviderCollection implements JsonSerializable<RecoveryServicesProviderCollection> {
    /*
     * The Servers details.
     */
    private List<RecoveryServicesProviderInner> value;

    /*
     * The value of next link.
     */
    private String nextLink;

    /**
     * Creates an instance of RecoveryServicesProviderCollection class.
     */
    public RecoveryServicesProviderCollection() {
    }

    /**
     * Get the value property: The Servers details.
     * 
     * @return the value value.
     */
    public List<RecoveryServicesProviderInner> value() {
        return this.value;
    }

    /**
     * Set the value property: The Servers details.
     * 
     * @param value the value value to set.
     * @return the RecoveryServicesProviderCollection object itself.
     */
    public RecoveryServicesProviderCollection withValue(List<RecoveryServicesProviderInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: The value of next link.
     * 
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: The value of next link.
     * 
     * @param nextLink the nextLink value to set.
     * @return the RecoveryServicesProviderCollection object itself.
     */
    public RecoveryServicesProviderCollection withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("value", this.value, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("nextLink", this.nextLink);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RecoveryServicesProviderCollection from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RecoveryServicesProviderCollection if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the RecoveryServicesProviderCollection.
     */
    public static RecoveryServicesProviderCollection fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RecoveryServicesProviderCollection deserializedRecoveryServicesProviderCollection
                = new RecoveryServicesProviderCollection();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<RecoveryServicesProviderInner> value
                        = reader.readArray(reader1 -> RecoveryServicesProviderInner.fromJson(reader1));
                    deserializedRecoveryServicesProviderCollection.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedRecoveryServicesProviderCollection.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRecoveryServicesProviderCollection;
        });
    }
}
