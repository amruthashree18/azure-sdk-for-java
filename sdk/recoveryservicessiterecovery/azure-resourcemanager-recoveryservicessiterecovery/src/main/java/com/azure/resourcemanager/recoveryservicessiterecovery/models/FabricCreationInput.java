// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Site details provided during the time of site creation.
 */
@Fluent
public final class FabricCreationInput implements JsonSerializable<FabricCreationInput> {
    /*
     * Fabric creation input.
     */
    private FabricCreationInputProperties properties;

    /**
     * Creates an instance of FabricCreationInput class.
     */
    public FabricCreationInput() {
    }

    /**
     * Get the properties property: Fabric creation input.
     * 
     * @return the properties value.
     */
    public FabricCreationInputProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties property: Fabric creation input.
     * 
     * @param properties the properties value to set.
     * @return the FabricCreationInput object itself.
     */
    public FabricCreationInput withProperties(FabricCreationInputProperties properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (properties() != null) {
            properties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("properties", this.properties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of FabricCreationInput from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of FabricCreationInput if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the FabricCreationInput.
     */
    public static FabricCreationInput fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            FabricCreationInput deserializedFabricCreationInput = new FabricCreationInput();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("properties".equals(fieldName)) {
                    deserializedFabricCreationInput.properties = FabricCreationInputProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedFabricCreationInput;
        });
    }
}
