// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.policyinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.policyinsights.models.RemediationFilters;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class RemediationFiltersTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        RemediationFilters model
            = BinaryData.fromString("{\"locations\":[\"zafb\",\"jjgpb\",\"oq\",\"jmkljavbqidtqajz\"]}")
                .toObject(RemediationFilters.class);
        Assertions.assertEquals("zafb", model.locations().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        RemediationFilters model
            = new RemediationFilters().withLocations(Arrays.asList("zafb", "jjgpb", "oq", "jmkljavbqidtqajz"));
        model = BinaryData.fromObject(model).toObject(RemediationFilters.class);
        Assertions.assertEquals("zafb", model.locations().get(0));
    }
}
