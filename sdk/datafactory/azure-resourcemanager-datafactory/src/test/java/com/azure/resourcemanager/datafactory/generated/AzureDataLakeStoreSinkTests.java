// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.AzureDataLakeStoreSink;

public final class AzureDataLakeStoreSinkTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AzureDataLakeStoreSink model = BinaryData.fromString(
            "{\"type\":\"AzureDataLakeStoreSink\",\"copyBehavior\":\"datazysactfimcaxg\",\"enableAdlsSingleFileParallel\":\"datapzqtimqic\",\"writeBatchSize\":\"dataaqypjcpdt\",\"writeBatchTimeout\":\"datafpjkxkujwntnfoqw\",\"sinkRetryCount\":\"dataoraxbeam\",\"sinkRetryWait\":\"datansyedpyrp\",\"maxConcurrentConnections\":\"dataslcfwgrz\",\"disableMetricsCollection\":\"datafbodifgh\",\"\":{\"cxoqxtjzdpl\":\"datayh\",\"osoxxoqyikdjaog\":\"datagllvkor\",\"lg\":\"datattxqxvmybq\"}}")
            .toObject(AzureDataLakeStoreSink.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AzureDataLakeStoreSink model = new AzureDataLakeStoreSink().withWriteBatchSize("dataaqypjcpdt")
            .withWriteBatchTimeout("datafpjkxkujwntnfoqw")
            .withSinkRetryCount("dataoraxbeam")
            .withSinkRetryWait("datansyedpyrp")
            .withMaxConcurrentConnections("dataslcfwgrz")
            .withDisableMetricsCollection("datafbodifgh")
            .withCopyBehavior("datazysactfimcaxg")
            .withEnableAdlsSingleFileParallel("datapzqtimqic");
        model = BinaryData.fromObject(model).toObject(AzureDataLakeStoreSink.class);
    }
}
