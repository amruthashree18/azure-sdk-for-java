// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.netapp.fluent.models.UsageProperties;

public final class UsagePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        UsageProperties model
            = BinaryData.fromString("{\"currentValue\":830050857,\"limit\":1193107670,\"unit\":\"iuxhqyudxorr\"}")
                .toObject(UsageProperties.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        UsageProperties model = new UsageProperties();
        model = BinaryData.fromObject(model).toObject(UsageProperties.class);
    }
}
