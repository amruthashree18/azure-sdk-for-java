// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The UserIdentityProperties model.
 */
@Fluent
public final class UserIdentityProperties implements JsonSerializable<UserIdentityProperties> {
    /*
     * The principal id of user assigned identity.
     */
    private String principalId;

    /*
     * The client id of user assigned identity.
     */
    private String clientId;

    /**
     * Creates an instance of UserIdentityProperties class.
     */
    public UserIdentityProperties() {
    }

    /**
     * Get the principalId property: The principal id of user assigned identity.
     * 
     * @return the principalId value.
     */
    public String principalId() {
        return this.principalId;
    }

    /**
     * Set the principalId property: The principal id of user assigned identity.
     * 
     * @param principalId the principalId value to set.
     * @return the UserIdentityProperties object itself.
     */
    public UserIdentityProperties withPrincipalId(String principalId) {
        this.principalId = principalId;
        return this;
    }

    /**
     * Get the clientId property: The client id of user assigned identity.
     * 
     * @return the clientId value.
     */
    public String clientId() {
        return this.clientId;
    }

    /**
     * Set the clientId property: The client id of user assigned identity.
     * 
     * @param clientId the clientId value to set.
     * @return the UserIdentityProperties object itself.
     */
    public UserIdentityProperties withClientId(String clientId) {
        this.clientId = clientId;
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
        jsonWriter.writeStringField("principalId", this.principalId);
        jsonWriter.writeStringField("clientId", this.clientId);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of UserIdentityProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of UserIdentityProperties if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the UserIdentityProperties.
     */
    public static UserIdentityProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            UserIdentityProperties deserializedUserIdentityProperties = new UserIdentityProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("principalId".equals(fieldName)) {
                    deserializedUserIdentityProperties.principalId = reader.getString();
                } else if ("clientId".equals(fieldName)) {
                    deserializedUserIdentityProperties.clientId = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedUserIdentityProperties;
        });
    }
}
