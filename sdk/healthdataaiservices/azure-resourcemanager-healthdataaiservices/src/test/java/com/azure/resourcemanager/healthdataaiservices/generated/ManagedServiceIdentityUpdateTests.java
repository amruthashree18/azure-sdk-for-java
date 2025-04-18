// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.healthdataaiservices.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.healthdataaiservices.models.ManagedServiceIdentityType;
import com.azure.resourcemanager.healthdataaiservices.models.ManagedServiceIdentityUpdate;
import com.azure.resourcemanager.healthdataaiservices.models.UserAssignedIdentity;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class ManagedServiceIdentityUpdateTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ManagedServiceIdentityUpdate model = BinaryData.fromString(
            "{\"type\":\"SystemAssigned\",\"userAssignedIdentities\":{\"ndei\":{\"clientId\":\"dzxibqeojnxqbzvd\",\"principalId\":\"t\"},\"glmjth\":{\"clientId\":\"twnpzaoqvuhrhcf\",\"principalId\":\"yd\"},\"uigdtopbobjog\":{\"clientId\":\"kw\",\"principalId\":\"eicxmqciwqvhkhi\"},\"a\":{\"clientId\":\"e\",\"principalId\":\"a\"}}}")
            .toObject(ManagedServiceIdentityUpdate.class);
        Assertions.assertEquals(ManagedServiceIdentityType.SYSTEM_ASSIGNED, model.type());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ManagedServiceIdentityUpdate model = new ManagedServiceIdentityUpdate()
            .withType(ManagedServiceIdentityType.SYSTEM_ASSIGNED)
            .withUserAssignedIdentities(mapOf("ndei", new UserAssignedIdentity(), "glmjth", new UserAssignedIdentity(),
                "uigdtopbobjog", new UserAssignedIdentity(), "a", new UserAssignedIdentity()));
        model = BinaryData.fromObject(model).toObject(ManagedServiceIdentityUpdate.class);
        Assertions.assertEquals(ManagedServiceIdentityType.SYSTEM_ASSIGNED, model.type());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
