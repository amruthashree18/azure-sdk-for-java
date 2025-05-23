// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.WebLinkedServiceTypeProperties;

public final class WebLinkedServiceTypePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        WebLinkedServiceTypeProperties model = BinaryData
            .fromString("{\"authenticationType\":\"WebLinkedServiceTypeProperties\",\"url\":\"dataxorhsxcsoaxcme\"}")
            .toObject(WebLinkedServiceTypeProperties.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        WebLinkedServiceTypeProperties model = new WebLinkedServiceTypeProperties().withUrl("dataxorhsxcsoaxcme");
        model = BinaryData.fromObject(model).toObject(WebLinkedServiceTypeProperties.class);
    }
}
