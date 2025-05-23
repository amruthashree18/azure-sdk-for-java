// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.datafactory.fluent.models.SapHanaLinkedServiceProperties;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * SAP HANA Linked Service.
 */
@Fluent
public final class SapHanaLinkedService extends LinkedService {
    /*
     * Type of linked service.
     */
    private String type = "SapHana";

    /*
     * Properties specific to this linked service type.
     */
    private SapHanaLinkedServiceProperties innerTypeProperties = new SapHanaLinkedServiceProperties();

    /**
     * Creates an instance of SapHanaLinkedService class.
     */
    public SapHanaLinkedService() {
    }

    /**
     * Get the type property: Type of linked service.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the innerTypeProperties property: Properties specific to this linked service type.
     * 
     * @return the innerTypeProperties value.
     */
    SapHanaLinkedServiceProperties innerTypeProperties() {
        return this.innerTypeProperties;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SapHanaLinkedService withVersion(String version) {
        super.withVersion(version);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SapHanaLinkedService withConnectVia(IntegrationRuntimeReference connectVia) {
        super.withConnectVia(connectVia);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SapHanaLinkedService withDescription(String description) {
        super.withDescription(description);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SapHanaLinkedService withParameters(Map<String, ParameterSpecification> parameters) {
        super.withParameters(parameters);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SapHanaLinkedService withAnnotations(List<Object> annotations) {
        super.withAnnotations(annotations);
        return this;
    }

    /**
     * Get the connectionString property: SAP HANA ODBC connection string. Type: string, SecureString or
     * AzureKeyVaultSecretReference.
     * 
     * @return the connectionString value.
     */
    public Object connectionString() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().connectionString();
    }

    /**
     * Set the connectionString property: SAP HANA ODBC connection string. Type: string, SecureString or
     * AzureKeyVaultSecretReference.
     * 
     * @param connectionString the connectionString value to set.
     * @return the SapHanaLinkedService object itself.
     */
    public SapHanaLinkedService withConnectionString(Object connectionString) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new SapHanaLinkedServiceProperties();
        }
        this.innerTypeProperties().withConnectionString(connectionString);
        return this;
    }

    /**
     * Get the server property: Host name of the SAP HANA server. Type: string (or Expression with resultType string).
     * 
     * @return the server value.
     */
    public Object server() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().server();
    }

    /**
     * Set the server property: Host name of the SAP HANA server. Type: string (or Expression with resultType string).
     * 
     * @param server the server value to set.
     * @return the SapHanaLinkedService object itself.
     */
    public SapHanaLinkedService withServer(Object server) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new SapHanaLinkedServiceProperties();
        }
        this.innerTypeProperties().withServer(server);
        return this;
    }

    /**
     * Get the authenticationType property: The authentication type to be used to connect to the SAP HANA server.
     * 
     * @return the authenticationType value.
     */
    public SapHanaAuthenticationType authenticationType() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().authenticationType();
    }

    /**
     * Set the authenticationType property: The authentication type to be used to connect to the SAP HANA server.
     * 
     * @param authenticationType the authenticationType value to set.
     * @return the SapHanaLinkedService object itself.
     */
    public SapHanaLinkedService withAuthenticationType(SapHanaAuthenticationType authenticationType) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new SapHanaLinkedServiceProperties();
        }
        this.innerTypeProperties().withAuthenticationType(authenticationType);
        return this;
    }

    /**
     * Get the username property: Username to access the SAP HANA server. Type: string (or Expression with resultType
     * string).
     * 
     * @return the username value.
     */
    public Object username() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().username();
    }

    /**
     * Set the username property: Username to access the SAP HANA server. Type: string (or Expression with resultType
     * string).
     * 
     * @param username the username value to set.
     * @return the SapHanaLinkedService object itself.
     */
    public SapHanaLinkedService withUsername(Object username) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new SapHanaLinkedServiceProperties();
        }
        this.innerTypeProperties().withUsername(username);
        return this;
    }

    /**
     * Get the password property: Password to access the SAP HANA server.
     * 
     * @return the password value.
     */
    public SecretBase password() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().password();
    }

    /**
     * Set the password property: Password to access the SAP HANA server.
     * 
     * @param password the password value to set.
     * @return the SapHanaLinkedService object itself.
     */
    public SapHanaLinkedService withPassword(SecretBase password) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new SapHanaLinkedServiceProperties();
        }
        this.innerTypeProperties().withPassword(password);
        return this;
    }

    /**
     * Get the encryptedCredential property: The encrypted credential used for authentication. Credentials are encrypted
     * using the integration runtime credential manager. Type: string.
     * 
     * @return the encryptedCredential value.
     */
    public String encryptedCredential() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().encryptedCredential();
    }

    /**
     * Set the encryptedCredential property: The encrypted credential used for authentication. Credentials are encrypted
     * using the integration runtime credential manager. Type: string.
     * 
     * @param encryptedCredential the encryptedCredential value to set.
     * @return the SapHanaLinkedService object itself.
     */
    public SapHanaLinkedService withEncryptedCredential(String encryptedCredential) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new SapHanaLinkedServiceProperties();
        }
        this.innerTypeProperties().withEncryptedCredential(encryptedCredential);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (innerTypeProperties() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property innerTypeProperties in model SapHanaLinkedService"));
        } else {
            innerTypeProperties().validate();
        }
        if (connectVia() != null) {
            connectVia().validate();
        }
        if (parameters() != null) {
            parameters().values().forEach(e -> {
                if (e != null) {
                    e.validate();
                }
            });
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(SapHanaLinkedService.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("version", version());
        jsonWriter.writeJsonField("connectVia", connectVia());
        jsonWriter.writeStringField("description", description());
        jsonWriter.writeMapField("parameters", parameters(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("annotations", annotations(), (writer, element) -> writer.writeUntyped(element));
        jsonWriter.writeJsonField("typeProperties", this.innerTypeProperties);
        jsonWriter.writeStringField("type", this.type);
        if (additionalProperties() != null) {
            for (Map.Entry<String, Object> additionalProperty : additionalProperties().entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SapHanaLinkedService from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SapHanaLinkedService if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SapHanaLinkedService.
     */
    public static SapHanaLinkedService fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SapHanaLinkedService deserializedSapHanaLinkedService = new SapHanaLinkedService();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("version".equals(fieldName)) {
                    deserializedSapHanaLinkedService.withVersion(reader.getString());
                } else if ("connectVia".equals(fieldName)) {
                    deserializedSapHanaLinkedService.withConnectVia(IntegrationRuntimeReference.fromJson(reader));
                } else if ("description".equals(fieldName)) {
                    deserializedSapHanaLinkedService.withDescription(reader.getString());
                } else if ("parameters".equals(fieldName)) {
                    Map<String, ParameterSpecification> parameters
                        = reader.readMap(reader1 -> ParameterSpecification.fromJson(reader1));
                    deserializedSapHanaLinkedService.withParameters(parameters);
                } else if ("annotations".equals(fieldName)) {
                    List<Object> annotations = reader.readArray(reader1 -> reader1.readUntyped());
                    deserializedSapHanaLinkedService.withAnnotations(annotations);
                } else if ("typeProperties".equals(fieldName)) {
                    deserializedSapHanaLinkedService.innerTypeProperties
                        = SapHanaLinkedServiceProperties.fromJson(reader);
                } else if ("type".equals(fieldName)) {
                    deserializedSapHanaLinkedService.type = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedSapHanaLinkedService.withAdditionalProperties(additionalProperties);

            return deserializedSapHanaLinkedService;
        });
    }
}
