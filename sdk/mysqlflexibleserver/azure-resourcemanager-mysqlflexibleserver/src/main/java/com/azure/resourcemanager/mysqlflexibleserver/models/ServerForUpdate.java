// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mysqlflexibleserver.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.mysqlflexibleserver.fluent.models.ServerPropertiesForUpdate;
import java.io.IOException;
import java.util.Map;

/**
 * Parameters allowed to update for a server.
 */
@Fluent
public final class ServerForUpdate implements JsonSerializable<ServerForUpdate> {
    /*
     * The cmk identity for the server.
     */
    private Identity identity;

    /*
     * The SKU (pricing tier) of the server.
     */
    private Sku sku;

    /*
     * The properties that can be updated for a server.
     */
    private ServerPropertiesForUpdate innerProperties;

    /*
     * Application-specific metadata in the form of key-value pairs.
     */
    private Map<String, String> tags;

    /**
     * Creates an instance of ServerForUpdate class.
     */
    public ServerForUpdate() {
    }

    /**
     * Get the identity property: The cmk identity for the server.
     * 
     * @return the identity value.
     */
    public Identity identity() {
        return this.identity;
    }

    /**
     * Set the identity property: The cmk identity for the server.
     * 
     * @param identity the identity value to set.
     * @return the ServerForUpdate object itself.
     */
    public ServerForUpdate withIdentity(Identity identity) {
        this.identity = identity;
        return this;
    }

    /**
     * Get the sku property: The SKU (pricing tier) of the server.
     * 
     * @return the sku value.
     */
    public Sku sku() {
        return this.sku;
    }

    /**
     * Set the sku property: The SKU (pricing tier) of the server.
     * 
     * @param sku the sku value to set.
     * @return the ServerForUpdate object itself.
     */
    public ServerForUpdate withSku(Sku sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get the innerProperties property: The properties that can be updated for a server.
     * 
     * @return the innerProperties value.
     */
    private ServerPropertiesForUpdate innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the tags property: Application-specific metadata in the form of key-value pairs.
     * 
     * @return the tags value.
     */
    public Map<String, String> tags() {
        return this.tags;
    }

    /**
     * Set the tags property: Application-specific metadata in the form of key-value pairs.
     * 
     * @param tags the tags value to set.
     * @return the ServerForUpdate object itself.
     */
    public ServerForUpdate withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get the administratorLoginPassword property: The password of the administrator login.
     * 
     * @return the administratorLoginPassword value.
     */
    public String administratorLoginPassword() {
        return this.innerProperties() == null ? null : this.innerProperties().administratorLoginPassword();
    }

    /**
     * Set the administratorLoginPassword property: The password of the administrator login.
     * 
     * @param administratorLoginPassword the administratorLoginPassword value to set.
     * @return the ServerForUpdate object itself.
     */
    public ServerForUpdate withAdministratorLoginPassword(String administratorLoginPassword) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ServerPropertiesForUpdate();
        }
        this.innerProperties().withAdministratorLoginPassword(administratorLoginPassword);
        return this;
    }

    /**
     * Get the storage property: Storage related properties of a server.
     * 
     * @return the storage value.
     */
    public Storage storage() {
        return this.innerProperties() == null ? null : this.innerProperties().storage();
    }

    /**
     * Set the storage property: Storage related properties of a server.
     * 
     * @param storage the storage value to set.
     * @return the ServerForUpdate object itself.
     */
    public ServerForUpdate withStorage(Storage storage) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ServerPropertiesForUpdate();
        }
        this.innerProperties().withStorage(storage);
        return this;
    }

    /**
     * Get the backup property: Backup related properties of a server.
     * 
     * @return the backup value.
     */
    public Backup backup() {
        return this.innerProperties() == null ? null : this.innerProperties().backup();
    }

    /**
     * Set the backup property: Backup related properties of a server.
     * 
     * @param backup the backup value to set.
     * @return the ServerForUpdate object itself.
     */
    public ServerForUpdate withBackup(Backup backup) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ServerPropertiesForUpdate();
        }
        this.innerProperties().withBackup(backup);
        return this;
    }

    /**
     * Get the highAvailability property: High availability related properties of a server.
     * 
     * @return the highAvailability value.
     */
    public HighAvailability highAvailability() {
        return this.innerProperties() == null ? null : this.innerProperties().highAvailability();
    }

    /**
     * Set the highAvailability property: High availability related properties of a server.
     * 
     * @param highAvailability the highAvailability value to set.
     * @return the ServerForUpdate object itself.
     */
    public ServerForUpdate withHighAvailability(HighAvailability highAvailability) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ServerPropertiesForUpdate();
        }
        this.innerProperties().withHighAvailability(highAvailability);
        return this;
    }

    /**
     * Get the maintenanceWindow property: Maintenance window of a server.
     * 
     * @return the maintenanceWindow value.
     */
    public MaintenanceWindow maintenanceWindow() {
        return this.innerProperties() == null ? null : this.innerProperties().maintenanceWindow();
    }

    /**
     * Set the maintenanceWindow property: Maintenance window of a server.
     * 
     * @param maintenanceWindow the maintenanceWindow value to set.
     * @return the ServerForUpdate object itself.
     */
    public ServerForUpdate withMaintenanceWindow(MaintenanceWindow maintenanceWindow) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ServerPropertiesForUpdate();
        }
        this.innerProperties().withMaintenanceWindow(maintenanceWindow);
        return this;
    }

    /**
     * Get the replicationRole property: The replication role of the server.
     * 
     * @return the replicationRole value.
     */
    public ReplicationRole replicationRole() {
        return this.innerProperties() == null ? null : this.innerProperties().replicationRole();
    }

    /**
     * Set the replicationRole property: The replication role of the server.
     * 
     * @param replicationRole the replicationRole value to set.
     * @return the ServerForUpdate object itself.
     */
    public ServerForUpdate withReplicationRole(ReplicationRole replicationRole) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ServerPropertiesForUpdate();
        }
        this.innerProperties().withReplicationRole(replicationRole);
        return this;
    }

    /**
     * Get the dataEncryption property: The Data Encryption for CMK.
     * 
     * @return the dataEncryption value.
     */
    public DataEncryption dataEncryption() {
        return this.innerProperties() == null ? null : this.innerProperties().dataEncryption();
    }

    /**
     * Set the dataEncryption property: The Data Encryption for CMK.
     * 
     * @param dataEncryption the dataEncryption value to set.
     * @return the ServerForUpdate object itself.
     */
    public ServerForUpdate withDataEncryption(DataEncryption dataEncryption) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ServerPropertiesForUpdate();
        }
        this.innerProperties().withDataEncryption(dataEncryption);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (identity() != null) {
            identity().validate();
        }
        if (sku() != null) {
            sku().validate();
        }
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
        jsonWriter.writeJsonField("identity", this.identity);
        jsonWriter.writeJsonField("sku", this.sku);
        jsonWriter.writeJsonField("properties", this.innerProperties);
        jsonWriter.writeMapField("tags", this.tags, (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ServerForUpdate from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ServerForUpdate if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ServerForUpdate.
     */
    public static ServerForUpdate fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ServerForUpdate deserializedServerForUpdate = new ServerForUpdate();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("identity".equals(fieldName)) {
                    deserializedServerForUpdate.identity = Identity.fromJson(reader);
                } else if ("sku".equals(fieldName)) {
                    deserializedServerForUpdate.sku = Sku.fromJson(reader);
                } else if ("properties".equals(fieldName)) {
                    deserializedServerForUpdate.innerProperties = ServerPropertiesForUpdate.fromJson(reader);
                } else if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedServerForUpdate.tags = tags;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedServerForUpdate;
        });
    }
}
