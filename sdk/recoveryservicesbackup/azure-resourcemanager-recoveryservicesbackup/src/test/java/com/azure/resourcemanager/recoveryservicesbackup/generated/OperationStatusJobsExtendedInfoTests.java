// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicesbackup.models.OperationStatusJobsExtendedInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class OperationStatusJobsExtendedInfoTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        OperationStatusJobsExtendedInfo model = BinaryData.fromString(
            "{\"objectType\":\"OperationStatusJobsExtendedInfo\",\"jobIds\":[\"ljdjuskbrreqy\",\"kceysfaqegplw\",\"ysh\"],\"failedJobsError\":{\"gkqu\":\"kvb\"}}")
            .toObject(OperationStatusJobsExtendedInfo.class);
        Assertions.assertEquals("ljdjuskbrreqy", model.jobIds().get(0));
        Assertions.assertEquals("kvb", model.failedJobsError().get("gkqu"));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        OperationStatusJobsExtendedInfo model
            = new OperationStatusJobsExtendedInfo().withJobIds(Arrays.asList("ljdjuskbrreqy", "kceysfaqegplw", "ysh"))
                .withFailedJobsError(mapOf("gkqu", "kvb"));
        model = BinaryData.fromObject(model).toObject(OperationStatusJobsExtendedInfo.class);
        Assertions.assertEquals("ljdjuskbrreqy", model.jobIds().get(0));
        Assertions.assertEquals("kvb", model.failedJobsError().get("gkqu"));
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
