// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.apimanagement.fluent.models.ReportRecordContractInner;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;

public final class ReportRecordContractInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ReportRecordContractInner model = BinaryData.fromString(
            "{\"name\":\"cxbeuuqutkzwtjww\",\"timestamp\":\"2021-06-11T12:35:16Z\",\"interval\":\"tijcxfnondegjdy\",\"country\":\"qkkkbjuckcatuqbh\",\"region\":\"wcnxtpzdlyseid\",\"zip\":\"akatprytg\",\"userId\":\"zbqfdpfawrptvcsh\",\"productId\":\"utzcttbqgdirda\",\"apiId\":\"tzjgcfjfxtbwj\",\"operationId\":\"rmuydgfttmdofg\",\"apiRegion\":\"agfuoftnxod\",\"subscriptionId\":\"m\",\"callCountSuccess\":1870102340,\"callCountBlocked\":1504707561,\"callCountFailed\":190262848,\"callCountOther\":1629273800,\"callCountTotal\":1123209033,\"bandwidth\":5317199108479544168,\"cacheHitCount\":599346072,\"cacheMissCount\":1654770372,\"apiTimeAvg\":72.81362625330617,\"apiTimeMin\":17.50198089256362,\"apiTimeMax\":42.78017849996877,\"serviceTimeAvg\":4.703675291538644,\"serviceTimeMin\":15.036176575966053,\"serviceTimeMax\":84.82847328847627}")
            .toObject(ReportRecordContractInner.class);
        Assertions.assertEquals("cxbeuuqutkzwtjww", model.name());
        Assertions.assertEquals(OffsetDateTime.parse("2021-06-11T12:35:16Z"), model.timestamp());
        Assertions.assertEquals("tijcxfnondegjdy", model.interval());
        Assertions.assertEquals("qkkkbjuckcatuqbh", model.country());
        Assertions.assertEquals("wcnxtpzdlyseid", model.region());
        Assertions.assertEquals("akatprytg", model.zip());
        Assertions.assertEquals("tzjgcfjfxtbwj", model.apiId());
        Assertions.assertEquals("rmuydgfttmdofg", model.operationId());
        Assertions.assertEquals("agfuoftnxod", model.apiRegion());
        Assertions.assertEquals("m", model.subscriptionId());
        Assertions.assertEquals(1870102340, model.callCountSuccess());
        Assertions.assertEquals(1504707561, model.callCountBlocked());
        Assertions.assertEquals(190262848, model.callCountFailed());
        Assertions.assertEquals(1629273800, model.callCountOther());
        Assertions.assertEquals(1123209033, model.callCountTotal());
        Assertions.assertEquals(5317199108479544168L, model.bandwidth());
        Assertions.assertEquals(599346072, model.cacheHitCount());
        Assertions.assertEquals(1654770372, model.cacheMissCount());
        Assertions.assertEquals(72.81362625330617D, model.apiTimeAvg());
        Assertions.assertEquals(17.50198089256362D, model.apiTimeMin());
        Assertions.assertEquals(42.78017849996877D, model.apiTimeMax());
        Assertions.assertEquals(4.703675291538644D, model.serviceTimeAvg());
        Assertions.assertEquals(15.036176575966053D, model.serviceTimeMin());
        Assertions.assertEquals(84.82847328847627D, model.serviceTimeMax());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ReportRecordContractInner model = new ReportRecordContractInner().withName("cxbeuuqutkzwtjww")
            .withTimestamp(OffsetDateTime.parse("2021-06-11T12:35:16Z"))
            .withInterval("tijcxfnondegjdy")
            .withCountry("qkkkbjuckcatuqbh")
            .withRegion("wcnxtpzdlyseid")
            .withZip("akatprytg")
            .withApiId("tzjgcfjfxtbwj")
            .withOperationId("rmuydgfttmdofg")
            .withApiRegion("agfuoftnxod")
            .withSubscriptionId("m")
            .withCallCountSuccess(1870102340)
            .withCallCountBlocked(1504707561)
            .withCallCountFailed(190262848)
            .withCallCountOther(1629273800)
            .withCallCountTotal(1123209033)
            .withBandwidth(5317199108479544168L)
            .withCacheHitCount(599346072)
            .withCacheMissCount(1654770372)
            .withApiTimeAvg(72.81362625330617D)
            .withApiTimeMin(17.50198089256362D)
            .withApiTimeMax(42.78017849996877D)
            .withServiceTimeAvg(4.703675291538644D)
            .withServiceTimeMin(15.036176575966053D)
            .withServiceTimeMax(84.82847328847627D);
        model = BinaryData.fromObject(model).toObject(ReportRecordContractInner.class);
        Assertions.assertEquals("cxbeuuqutkzwtjww", model.name());
        Assertions.assertEquals(OffsetDateTime.parse("2021-06-11T12:35:16Z"), model.timestamp());
        Assertions.assertEquals("tijcxfnondegjdy", model.interval());
        Assertions.assertEquals("qkkkbjuckcatuqbh", model.country());
        Assertions.assertEquals("wcnxtpzdlyseid", model.region());
        Assertions.assertEquals("akatprytg", model.zip());
        Assertions.assertEquals("tzjgcfjfxtbwj", model.apiId());
        Assertions.assertEquals("rmuydgfttmdofg", model.operationId());
        Assertions.assertEquals("agfuoftnxod", model.apiRegion());
        Assertions.assertEquals("m", model.subscriptionId());
        Assertions.assertEquals(1870102340, model.callCountSuccess());
        Assertions.assertEquals(1504707561, model.callCountBlocked());
        Assertions.assertEquals(190262848, model.callCountFailed());
        Assertions.assertEquals(1629273800, model.callCountOther());
        Assertions.assertEquals(1123209033, model.callCountTotal());
        Assertions.assertEquals(5317199108479544168L, model.bandwidth());
        Assertions.assertEquals(599346072, model.cacheHitCount());
        Assertions.assertEquals(1654770372, model.cacheMissCount());
        Assertions.assertEquals(72.81362625330617D, model.apiTimeAvg());
        Assertions.assertEquals(17.50198089256362D, model.apiTimeMin());
        Assertions.assertEquals(42.78017849996877D, model.apiTimeMax());
        Assertions.assertEquals(4.703675291538644D, model.serviceTimeAvg());
        Assertions.assertEquals(15.036176575966053D, model.serviceTimeMin());
        Assertions.assertEquals(84.82847328847627D, model.serviceTimeMax());
    }
}
