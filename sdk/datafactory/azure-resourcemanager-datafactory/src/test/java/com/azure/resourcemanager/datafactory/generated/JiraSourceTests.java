// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.JiraSource;

public final class JiraSourceTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        JiraSource model = BinaryData.fromString(
            "{\"type\":\"JiraSource\",\"query\":\"dataiepvjrmkk\",\"queryTimeout\":\"dataymkbfd\",\"additionalColumns\":\"datawokrhh\",\"sourceRetryCount\":\"dataahrmuw\",\"sourceRetryWait\":\"datadyruo\",\"maxConcurrentConnections\":\"datadtx\",\"disableMetricsCollection\":\"datanmjimgg\",\"\":{\"bnfbmsbetzufkvxe\":\"datagpldrnbjh\",\"mjzgzaeuu\":\"databddrtngdc\"}}")
            .toObject(JiraSource.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        JiraSource model = new JiraSource().withSourceRetryCount("dataahrmuw")
            .withSourceRetryWait("datadyruo")
            .withMaxConcurrentConnections("datadtx")
            .withDisableMetricsCollection("datanmjimgg")
            .withQueryTimeout("dataymkbfd")
            .withAdditionalColumns("datawokrhh")
            .withQuery("dataiepvjrmkk");
        model = BinaryData.fromObject(model).toObject(JiraSource.class);
    }
}
