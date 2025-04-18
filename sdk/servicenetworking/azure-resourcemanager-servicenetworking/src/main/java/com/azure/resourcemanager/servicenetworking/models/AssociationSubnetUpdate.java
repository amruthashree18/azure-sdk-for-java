// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.servicenetworking.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Association Subnet.
 */
@Fluent
public final class AssociationSubnetUpdate implements JsonSerializable<AssociationSubnetUpdate> {
    /*
     * Association ID.
     */
    private String id;

    /**
     * Creates an instance of AssociationSubnetUpdate class.
     */
    public AssociationSubnetUpdate() {
    }

    /**
     * Get the id property: Association ID.
     * 
     * @return the id value.
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the id property: Association ID.
     * 
     * @param id the id value to set.
     * @return the AssociationSubnetUpdate object itself.
     */
    public AssociationSubnetUpdate withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("id", this.id);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AssociationSubnetUpdate from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AssociationSubnetUpdate if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the AssociationSubnetUpdate.
     */
    public static AssociationSubnetUpdate fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AssociationSubnetUpdate deserializedAssociationSubnetUpdate = new AssociationSubnetUpdate();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedAssociationSubnetUpdate.id = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAssociationSubnetUpdate;
        });
    }
}
