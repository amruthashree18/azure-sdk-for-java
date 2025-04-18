// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.agrifood.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.agrifood.models.Identity;
import com.azure.resourcemanager.agrifood.models.ResourceIdentityType;
import org.junit.jupiter.api.Assertions;

public final class IdentityTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        Identity model = BinaryData.fromString(
            "{\"principalId\":\"33d47ceb-84fd-410e-94a1-8d988d4955dd\",\"tenantId\":\"ffeca805-3f02-48a5-8195-7860a006c196\",\"type\":\"SystemAssigned\"}")
            .toObject(Identity.class);
        Assertions.assertEquals(ResourceIdentityType.SYSTEM_ASSIGNED, model.type());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        Identity model = new Identity().withType(ResourceIdentityType.SYSTEM_ASSIGNED);
        model = BinaryData.fromObject(model).toObject(Identity.class);
        Assertions.assertEquals(ResourceIdentityType.SYSTEM_ASSIGNED, model.type());
    }
}
