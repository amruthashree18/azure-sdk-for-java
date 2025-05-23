// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.chaos.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.chaos.models.ExperimentExecutionDetailsPropertiesRunInformation;
import java.io.IOException;
import java.time.OffsetDateTime;

/**
 * Model that represents the execution details of an Experiment.
 */
@Immutable
public final class ExperimentExecutionDetailsInner implements JsonSerializable<ExperimentExecutionDetailsInner> {
    /*
     * String of the resource type.
     */
    private String type;

    /*
     * String of the fully qualified resource ID.
     */
    private String id;

    /*
     * String of the resource name.
     */
    private String name;

    /*
     * The properties of the experiment execution details.
     */
    private ExperimentExecutionDetailsProperties innerProperties;

    /**
     * Creates an instance of ExperimentExecutionDetailsInner class.
     */
    public ExperimentExecutionDetailsInner() {
    }

    /**
     * Get the type property: String of the resource type.
     * 
     * @return the type value.
     */
    public String type() {
        return this.type;
    }

    /**
     * Get the id property: String of the fully qualified resource ID.
     * 
     * @return the id value.
     */
    public String id() {
        return this.id;
    }

    /**
     * Get the name property: String of the resource name.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Get the innerProperties property: The properties of the experiment execution details.
     * 
     * @return the innerProperties value.
     */
    private ExperimentExecutionDetailsProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the failureReason property: The reason why the execution failed.
     * 
     * @return the failureReason value.
     */
    public String failureReason() {
        return this.innerProperties() == null ? null : this.innerProperties().failureReason();
    }

    /**
     * Get the lastActionAt property: String that represents the last action date time.
     * 
     * @return the lastActionAt value.
     */
    public OffsetDateTime lastActionAt() {
        return this.innerProperties() == null ? null : this.innerProperties().lastActionAt();
    }

    /**
     * Get the runInformation property: The information of the experiment run.
     * 
     * @return the runInformation value.
     */
    public ExperimentExecutionDetailsPropertiesRunInformation runInformation() {
        return this.innerProperties() == null ? null : this.innerProperties().runInformation();
    }

    /**
     * Get the status property: The status of the execution.
     * 
     * @return the status value.
     */
    public String status() {
        return this.innerProperties() == null ? null : this.innerProperties().status();
    }

    /**
     * Get the startedAt property: String that represents the start date time.
     * 
     * @return the startedAt value.
     */
    public OffsetDateTime startedAt() {
        return this.innerProperties() == null ? null : this.innerProperties().startedAt();
    }

    /**
     * Get the stoppedAt property: String that represents the stop date time.
     * 
     * @return the stoppedAt value.
     */
    public OffsetDateTime stoppedAt() {
        return this.innerProperties() == null ? null : this.innerProperties().stoppedAt();
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
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ExperimentExecutionDetailsInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ExperimentExecutionDetailsInner if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ExperimentExecutionDetailsInner.
     */
    public static ExperimentExecutionDetailsInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ExperimentExecutionDetailsInner deserializedExperimentExecutionDetailsInner
                = new ExperimentExecutionDetailsInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("type".equals(fieldName)) {
                    deserializedExperimentExecutionDetailsInner.type = reader.getString();
                } else if ("id".equals(fieldName)) {
                    deserializedExperimentExecutionDetailsInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedExperimentExecutionDetailsInner.name = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedExperimentExecutionDetailsInner.innerProperties
                        = ExperimentExecutionDetailsProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedExperimentExecutionDetailsInner;
        });
    }
}
