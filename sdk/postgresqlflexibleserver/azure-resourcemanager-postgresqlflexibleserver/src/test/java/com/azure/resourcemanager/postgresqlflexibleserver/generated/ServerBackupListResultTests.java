// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.postgresqlflexibleserver.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.postgresqlflexibleserver.fluent.models.ServerBackupInner;
import com.azure.resourcemanager.postgresqlflexibleserver.models.Origin;
import com.azure.resourcemanager.postgresqlflexibleserver.models.ServerBackupListResult;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class ServerBackupListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ServerBackupListResult model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"backupType\":\"Customer On-Demand\",\"completedTime\":\"2021-08-18T11:52:54Z\",\"source\":\"hkryhtn\"},\"id\":\"czwlokjyem\",\"name\":\"kvnipjoxz\",\"type\":\"nchgej\"}],\"nextLink\":\"odmailzyd\"}")
            .toObject(ServerBackupListResult.class);
        Assertions.assertEquals(Origin.CUSTOMER_ON_DEMAND, model.value().get(0).backupType());
        Assertions.assertEquals(OffsetDateTime.parse("2021-08-18T11:52:54Z"), model.value().get(0).completedTime());
        Assertions.assertEquals("hkryhtn", model.value().get(0).source());
        Assertions.assertEquals("odmailzyd", model.nextLink());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ServerBackupListResult model = new ServerBackupListResult()
            .withValue(Arrays.asList(new ServerBackupInner().withBackupType(Origin.CUSTOMER_ON_DEMAND)
                .withCompletedTime(OffsetDateTime.parse("2021-08-18T11:52:54Z"))
                .withSource("hkryhtn")))
            .withNextLink("odmailzyd");
        model = BinaryData.fromObject(model).toObject(ServerBackupListResult.class);
        Assertions.assertEquals(Origin.CUSTOMER_ON_DEMAND, model.value().get(0).backupType());
        Assertions.assertEquals(OffsetDateTime.parse("2021-08-18T11:52:54Z"), model.value().get(0).completedTime());
        Assertions.assertEquals("hkryhtn", model.value().get(0).source());
        Assertions.assertEquals("odmailzyd", model.nextLink());
    }
}
