// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.newrelicobservability.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.core.management.SystemData;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The details of a account resource.
 */
@Fluent
public final class AccountResourceInner extends ProxyResource {
    /*
     * The resource-specific properties for this resource.
     */
    private AccountProperties innerProperties;

    /*
     * Azure Resource Manager metadata containing createdBy and modifiedBy information.
     */
    private SystemData systemData;

    /*
     * The type of the resource.
     */
    private String type;

    /*
     * The name of the resource.
     */
    private String name;

    /*
     * Fully qualified resource Id for the resource.
     */
    private String id;

    /**
     * Creates an instance of AccountResourceInner class.
     */
    public AccountResourceInner() {
    }

    /**
     * Get the innerProperties property: The resource-specific properties for this resource.
     * 
     * @return the innerProperties value.
     */
    private AccountProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     * 
     * @return the systemData value.
     */
    public SystemData systemData() {
        return this.systemData;
    }

    /**
     * Get the type property: The type of the resource.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the name property: The name of the resource.
     * 
     * @return the name value.
     */
    @Override
    public String name() {
        return this.name;
    }

    /**
     * Get the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    @Override
    public String id() {
        return this.id;
    }

    /**
     * Get the organizationId property: organization id.
     * 
     * @return the organizationId value.
     */
    public String organizationId() {
        return this.innerProperties() == null ? null : this.innerProperties().organizationId();
    }

    /**
     * Set the organizationId property: organization id.
     * 
     * @param organizationId the organizationId value to set.
     * @return the AccountResourceInner object itself.
     */
    public AccountResourceInner withOrganizationId(String organizationId) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AccountProperties();
        }
        this.innerProperties().withOrganizationId(organizationId);
        return this;
    }

    /**
     * Get the accountId property: account id.
     * 
     * @return the accountId value.
     */
    public String accountId() {
        return this.innerProperties() == null ? null : this.innerProperties().accountId();
    }

    /**
     * Set the accountId property: account id.
     * 
     * @param accountId the accountId value to set.
     * @return the AccountResourceInner object itself.
     */
    public AccountResourceInner withAccountId(String accountId) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AccountProperties();
        }
        this.innerProperties().withAccountId(accountId);
        return this;
    }

    /**
     * Get the accountName property: account name.
     * 
     * @return the accountName value.
     */
    public String accountName() {
        return this.innerProperties() == null ? null : this.innerProperties().accountName();
    }

    /**
     * Set the accountName property: account name.
     * 
     * @param accountName the accountName value to set.
     * @return the AccountResourceInner object itself.
     */
    public AccountResourceInner withAccountName(String accountName) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AccountProperties();
        }
        this.innerProperties().withAccountName(accountName);
        return this;
    }

    /**
     * Get the region property: Region where New Relic account is present.
     * 
     * @return the region value.
     */
    public String region() {
        return this.innerProperties() == null ? null : this.innerProperties().region();
    }

    /**
     * Set the region property: Region where New Relic account is present.
     * 
     * @param region the region value to set.
     * @return the AccountResourceInner object itself.
     */
    public AccountResourceInner withRegion(String region) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AccountProperties();
        }
        this.innerProperties().withRegion(region);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AccountResourceInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AccountResourceInner if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the AccountResourceInner.
     */
    public static AccountResourceInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AccountResourceInner deserializedAccountResourceInner = new AccountResourceInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedAccountResourceInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedAccountResourceInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedAccountResourceInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedAccountResourceInner.innerProperties = AccountProperties.fromJson(reader);
                } else if ("systemData".equals(fieldName)) {
                    deserializedAccountResourceInner.systemData = SystemData.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAccountResourceInner;
        });
    }
}
