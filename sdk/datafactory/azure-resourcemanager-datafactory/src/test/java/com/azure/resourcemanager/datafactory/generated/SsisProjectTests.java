// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.SsisEnvironmentReference;
import com.azure.resourcemanager.datafactory.models.SsisParameter;
import com.azure.resourcemanager.datafactory.models.SsisProject;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class SsisProjectTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SsisProject model = BinaryData.fromString(
            "{\"type\":\"Project\",\"folderId\":7512874295180504803,\"version\":1285901610672878172,\"environmentRefs\":[{\"id\":4606170167698003019,\"environmentFolderName\":\"qm\",\"environmentName\":\"xqcil\",\"referenceType\":\"ulgnnyxwdpm\"}],\"parameters\":[{\"id\":5352402313960943199,\"name\":\"xgbamqrbbs\",\"description\":\"tm\",\"dataType\":\"dpavcjkbyjuwhizc\",\"required\":false,\"sensitive\":true,\"designDefaultValue\":\"wdtunpcskdlrfo\",\"defaultValue\":\"koltjdauujjl\",\"sensitiveDefaultValue\":\"hddzeykud\",\"valueType\":\"rimyeh\",\"valueSet\":false,\"variable\":\"y\"},{\"id\":5817153020841436569,\"name\":\"axznqqkq\",\"description\":\"dglseuqkr\",\"dataType\":\"yakr\",\"required\":true,\"sensitive\":true,\"designDefaultValue\":\"okrl\",\"defaultValue\":\"ecannv\",\"sensitiveDefaultValue\":\"uhdcftptf\",\"valueType\":\"apmfwxmcxhwkgihi\",\"valueSet\":false,\"variable\":\"cmgadhmqy\"},{\"id\":8636015705578921283,\"name\":\"wweylszrt\",\"description\":\"iqcypmonfcorcn\",\"dataType\":\"ycigcb\",\"required\":true,\"sensitive\":true,\"designDefaultValue\":\"jfrponajz\",\"defaultValue\":\"qzbrwrfrmho\",\"sensitiveDefaultValue\":\"okrbgv\",\"valueType\":\"cks\",\"valueSet\":true,\"variable\":\"qu\"},{\"id\":8907486052377839740,\"name\":\"yxdeggnzadqmvpe\",\"description\":\"nsvkyqhrplfqqnwo\",\"dataType\":\"rgc\",\"required\":true,\"sensitive\":false,\"designDefaultValue\":\"khha\",\"defaultValue\":\"ytuecmgu\",\"sensitiveDefaultValue\":\"wdpuowlc\",\"valueType\":\"krp\",\"valueSet\":false,\"variable\":\"qnbs\"}],\"id\":1976990922267185766,\"name\":\"tcidcabn\",\"description\":\"hcxc\"}")
            .toObject(SsisProject.class);
        Assertions.assertEquals(1976990922267185766L, model.id());
        Assertions.assertEquals("tcidcabn", model.name());
        Assertions.assertEquals("hcxc", model.description());
        Assertions.assertEquals(7512874295180504803L, model.folderId());
        Assertions.assertEquals(1285901610672878172L, model.version());
        Assertions.assertEquals(4606170167698003019L, model.environmentRefs().get(0).id());
        Assertions.assertEquals("qm", model.environmentRefs().get(0).environmentFolderName());
        Assertions.assertEquals("xqcil", model.environmentRefs().get(0).environmentName());
        Assertions.assertEquals("ulgnnyxwdpm", model.environmentRefs().get(0).referenceType());
        Assertions.assertEquals(5352402313960943199L, model.parameters().get(0).id());
        Assertions.assertEquals("xgbamqrbbs", model.parameters().get(0).name());
        Assertions.assertEquals("tm", model.parameters().get(0).description());
        Assertions.assertEquals("dpavcjkbyjuwhizc", model.parameters().get(0).dataType());
        Assertions.assertEquals(false, model.parameters().get(0).required());
        Assertions.assertEquals(true, model.parameters().get(0).sensitive());
        Assertions.assertEquals("wdtunpcskdlrfo", model.parameters().get(0).designDefaultValue());
        Assertions.assertEquals("koltjdauujjl", model.parameters().get(0).defaultValue());
        Assertions.assertEquals("hddzeykud", model.parameters().get(0).sensitiveDefaultValue());
        Assertions.assertEquals("rimyeh", model.parameters().get(0).valueType());
        Assertions.assertEquals(false, model.parameters().get(0).valueSet());
        Assertions.assertEquals("y", model.parameters().get(0).variable());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SsisProject model = new SsisProject().withId(1976990922267185766L)
            .withName("tcidcabn")
            .withDescription("hcxc")
            .withFolderId(7512874295180504803L)
            .withVersion(1285901610672878172L)
            .withEnvironmentRefs(Arrays.asList(new SsisEnvironmentReference().withId(4606170167698003019L)
                .withEnvironmentFolderName("qm")
                .withEnvironmentName("xqcil")
                .withReferenceType("ulgnnyxwdpm")))
            .withParameters(Arrays.asList(
                new SsisParameter().withId(5352402313960943199L)
                    .withName("xgbamqrbbs")
                    .withDescription("tm")
                    .withDataType("dpavcjkbyjuwhizc")
                    .withRequired(false)
                    .withSensitive(true)
                    .withDesignDefaultValue("wdtunpcskdlrfo")
                    .withDefaultValue("koltjdauujjl")
                    .withSensitiveDefaultValue("hddzeykud")
                    .withValueType("rimyeh")
                    .withValueSet(false)
                    .withVariable("y"),
                new SsisParameter().withId(5817153020841436569L)
                    .withName("axznqqkq")
                    .withDescription("dglseuqkr")
                    .withDataType("yakr")
                    .withRequired(true)
                    .withSensitive(true)
                    .withDesignDefaultValue("okrl")
                    .withDefaultValue("ecannv")
                    .withSensitiveDefaultValue("uhdcftptf")
                    .withValueType("apmfwxmcxhwkgihi")
                    .withValueSet(false)
                    .withVariable("cmgadhmqy"),
                new SsisParameter().withId(8636015705578921283L)
                    .withName("wweylszrt")
                    .withDescription("iqcypmonfcorcn")
                    .withDataType("ycigcb")
                    .withRequired(true)
                    .withSensitive(true)
                    .withDesignDefaultValue("jfrponajz")
                    .withDefaultValue("qzbrwrfrmho")
                    .withSensitiveDefaultValue("okrbgv")
                    .withValueType("cks")
                    .withValueSet(true)
                    .withVariable("qu"),
                new SsisParameter().withId(8907486052377839740L)
                    .withName("yxdeggnzadqmvpe")
                    .withDescription("nsvkyqhrplfqqnwo")
                    .withDataType("rgc")
                    .withRequired(true)
                    .withSensitive(false)
                    .withDesignDefaultValue("khha")
                    .withDefaultValue("ytuecmgu")
                    .withSensitiveDefaultValue("wdpuowlc")
                    .withValueType("krp")
                    .withValueSet(false)
                    .withVariable("qnbs")));
        model = BinaryData.fromObject(model).toObject(SsisProject.class);
        Assertions.assertEquals(1976990922267185766L, model.id());
        Assertions.assertEquals("tcidcabn", model.name());
        Assertions.assertEquals("hcxc", model.description());
        Assertions.assertEquals(7512874295180504803L, model.folderId());
        Assertions.assertEquals(1285901610672878172L, model.version());
        Assertions.assertEquals(4606170167698003019L, model.environmentRefs().get(0).id());
        Assertions.assertEquals("qm", model.environmentRefs().get(0).environmentFolderName());
        Assertions.assertEquals("xqcil", model.environmentRefs().get(0).environmentName());
        Assertions.assertEquals("ulgnnyxwdpm", model.environmentRefs().get(0).referenceType());
        Assertions.assertEquals(5352402313960943199L, model.parameters().get(0).id());
        Assertions.assertEquals("xgbamqrbbs", model.parameters().get(0).name());
        Assertions.assertEquals("tm", model.parameters().get(0).description());
        Assertions.assertEquals("dpavcjkbyjuwhizc", model.parameters().get(0).dataType());
        Assertions.assertEquals(false, model.parameters().get(0).required());
        Assertions.assertEquals(true, model.parameters().get(0).sensitive());
        Assertions.assertEquals("wdtunpcskdlrfo", model.parameters().get(0).designDefaultValue());
        Assertions.assertEquals("koltjdauujjl", model.parameters().get(0).defaultValue());
        Assertions.assertEquals("hddzeykud", model.parameters().get(0).sensitiveDefaultValue());
        Assertions.assertEquals("rimyeh", model.parameters().get(0).valueType());
        Assertions.assertEquals(false, model.parameters().get(0).valueSet());
        Assertions.assertEquals("y", model.parameters().get(0).variable());
    }
}
