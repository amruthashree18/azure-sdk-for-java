// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mariadb.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.mariadb.models.PrivateLinkServiceConnectionStateProperty;
import org.junit.jupiter.api.Assertions;

public final class PrivateLinkServiceConnectionStatePropertyTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PrivateLinkServiceConnectionStateProperty model = BinaryData
            .fromString("{\"status\":\"xbxwa\",\"description\":\"bogqxndlkzgxhu\",\"actionsRequired\":\"plbpodxun\"}")
            .toObject(PrivateLinkServiceConnectionStateProperty.class);
        Assertions.assertEquals("xbxwa", model.status());
        Assertions.assertEquals("bogqxndlkzgxhu", model.description());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PrivateLinkServiceConnectionStateProperty model
            = new PrivateLinkServiceConnectionStateProperty().withStatus("xbxwa").withDescription("bogqxndlkzgxhu");
        model = BinaryData.fromObject(model).toObject(PrivateLinkServiceConnectionStateProperty.class);
        Assertions.assertEquals("xbxwa", model.status());
        Assertions.assertEquals("bogqxndlkzgxhu", model.description());
    }
}
