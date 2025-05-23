// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datalakestore.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datalakestore.fluent.models.DataLakeStoreAccountBasicInner;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class DataLakeStoreAccountBasicInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DataLakeStoreAccountBasicInner model = BinaryData.fromString(
            "{\"properties\":{\"accountId\":\"8f8988ee-5985-4ecf-9f06-97bcc908ff53\",\"provisioningState\":\"Deleting\",\"state\":\"Active\",\"creationTime\":\"2021-03-22T18:05:05Z\",\"lastModifiedTime\":\"2021-06-23T16:37:05Z\",\"endpoint\":\"ifpikxwczby\"},\"location\":\"cnpqxuhivyqniwby\",\"tags\":{\"mjgr\":\"xvd\"},\"id\":\"fwvuk\",\"name\":\"gaudcc\",\"type\":\"nhsjcnyej\"}")
            .toObject(DataLakeStoreAccountBasicInner.class);
        Assertions.assertEquals("cnpqxuhivyqniwby", model.location());
        Assertions.assertEquals("xvd", model.tags().get("mjgr"));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DataLakeStoreAccountBasicInner model
            = new DataLakeStoreAccountBasicInner().withLocation("cnpqxuhivyqniwby").withTags(mapOf("mjgr", "xvd"));
        model = BinaryData.fromObject(model).toObject(DataLakeStoreAccountBasicInner.class);
        Assertions.assertEquals("cnpqxuhivyqniwby", model.location());
        Assertions.assertEquals("xvd", model.tags().get("mjgr"));
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
