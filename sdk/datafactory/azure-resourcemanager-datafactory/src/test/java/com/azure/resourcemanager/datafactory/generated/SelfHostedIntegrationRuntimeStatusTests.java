// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.core.util.serializer.JacksonAdapter;
import com.azure.core.util.serializer.SerializerEncoding;
import com.azure.resourcemanager.datafactory.fluent.models.SelfHostedIntegrationRuntimeNodeInner;
import com.azure.resourcemanager.datafactory.models.LinkedIntegrationRuntime;
import com.azure.resourcemanager.datafactory.models.SelfHostedIntegrationRuntimeStatus;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class SelfHostedIntegrationRuntimeStatusTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SelfHostedIntegrationRuntimeStatus model = BinaryData.fromString(
            "{\"type\":\"SelfHosted\",\"typeProperties\":{\"createTime\":\"2021-02-26T23:11:52Z\",\"taskQueueId\":\"cfqzxjziqcso\",\"internalChannelEncryption\":\"NotEncrypted\",\"version\":\"k\",\"nodes\":[{\"nodeName\":\"efq\",\"machineName\":\"rmgm\",\"hostServiceUri\":\"ddaxaogs\",\"status\":\"Upgrading\",\"capabilities\":{\"bfjcvmk\":\"mbipysehyyb\"},\"versionStatus\":\"pgdiwd\",\"version\":\"hdtiemb\",\"registerTime\":\"2021-03-10T22:00:56Z\",\"lastConnectTime\":\"2021-02-26T14:13:20Z\",\"expiryTime\":\"2021-06-14T22:48:16Z\",\"lastStartTime\":\"2021-03-01T08:51:48Z\",\"lastStopTime\":\"2021-05-19T23:17:23Z\",\"lastUpdateResult\":\"None\",\"lastStartUpdateTime\":\"2021-05-28T18:05:19Z\",\"lastEndUpdateTime\":\"2021-08-28T10:16:29Z\",\"isActiveDispatcher\":true,\"concurrentJobsLimit\":1506230530,\"maxConcurrentJobs\":951625190,\"\":{\"e\":\"datawjfqktuzrlt\",\"njpbhjlugcupcyfr\":\"datasdkbqfzbvttqjntv\",\"xsuw\":\"dataooyvmvuxyeeaf\"}},{\"nodeName\":\"nxzhgbspdxbhjqux\",\"machineName\":\"xqomzdfaupqve\",\"hostServiceUri\":\"zwnkbjqpz\",\"status\":\"Limited\",\"capabilities\":{\"ochtuxapewzwqlb\":\"qux\",\"mc\":\"mynslcvynavwttt\",\"caqimodn\":\"rod\"},\"versionStatus\":\"mjxkhbucm\",\"version\":\"qtkfjacktav\",\"registerTime\":\"2021-08-11T08:10:38Z\",\"lastConnectTime\":\"2021-01-13T03:30:44Z\",\"expiryTime\":\"2021-11-10T12:02:11Z\",\"lastStartTime\":\"2021-05-26T19:02:01Z\",\"lastStopTime\":\"2021-03-06T00:39:15Z\",\"lastUpdateResult\":\"Fail\",\"lastStartUpdateTime\":\"2021-06-24T00:00:51Z\",\"lastEndUpdateTime\":\"2021-12-02T11:56:22Z\",\"isActiveDispatcher\":false,\"concurrentJobsLimit\":718075939,\"maxConcurrentJobs\":1264951120,\"\":{\"fjqdfadgywylavet\":\"dataxiebnzoteik\"}},{\"nodeName\":\"vohy\",\"machineName\":\"dgjtpbtkogfg\",\"hostServiceUri\":\"lyzolrvwsgseqj\",\"status\":\"Initializing\",\"capabilities\":{\"rjybpvsoba\":\"irmgis\",\"ukegougxpyp\":\"tarirdzdgvqofl\",\"lmnxrxkuly\":\"mzqsx\"},\"versionStatus\":\"vviyqonbxxyf\",\"version\":\"b\",\"registerTime\":\"2021-02-09T08:11:56Z\",\"lastConnectTime\":\"2021-08-31T08:17:04Z\",\"expiryTime\":\"2021-08-26T00:02:37Z\",\"lastStartTime\":\"2021-04-19T13:24:32Z\",\"lastStopTime\":\"2021-01-12T06:41:07Z\",\"lastUpdateResult\":\"Succeed\",\"lastStartUpdateTime\":\"2021-03-25T10:57:13Z\",\"lastEndUpdateTime\":\"2021-05-18T01:36:42Z\",\"isActiveDispatcher\":true,\"concurrentJobsLimit\":763137103,\"maxConcurrentJobs\":1849742414,\"\":{\"vvyjehy\":\"dataaxtmvmycvjpaxjd\",\"v\":\"datanfjngoqmr\",\"xunwenbphyl\":\"databgtuhw\"}}],\"scheduledUpdateDate\":\"2021-08-09T19:35:20Z\",\"updateDelayOffset\":\"zr\",\"localTimeZoneOffset\":\"dusebkcfetxp\",\"capabilities\":{\"uiqr\":\"erma\",\"ftubqwxvs\":\"n\"},\"serviceUrls\":[\"iyzjlgrwjbsyc\",\"kbocsitsx\",\"vsg\",\"pwqieyxjkctyqst\"],\"autoUpdate\":\"On\",\"versionStatus\":\"qepeftmub\",\"links\":[{\"name\":\"epeqlhbtys\",\"subscriptionId\":\"zeq\",\"dataFactoryName\":\"tp\",\"dataFactoryLocation\":\"ofkwhgyzwfy\",\"createTime\":\"2021-05-10T10:09:31Z\"},{\"name\":\"ooelm\",\"subscriptionId\":\"d\",\"dataFactoryName\":\"qykgjjsmvsi\",\"dataFactoryLocation\":\"mlmwj\",\"createTime\":\"2021-10-24T00:35:28Z\"},{\"name\":\"wbmacvemmriyz\",\"subscriptionId\":\"quesxplcsinbulo\",\"dataFactoryName\":\"xhcynnmv\",\"dataFactoryLocation\":\"zvkwqqpw\",\"createTime\":\"2021-02-12T08:54:34Z\"},{\"name\":\"jqcqyzmrtfdlgpr\",\"subscriptionId\":\"jl\",\"dataFactoryName\":\"albcyuwahwzagvai\",\"dataFactoryLocation\":\"cephnhnuhg\",\"createTime\":\"2021-12-06T19:07:33Z\"}],\"pushedVersion\":\"hi\",\"latestVersion\":\"rwpekiprjb\",\"autoUpdateETA\":\"2021-03-14T04:58:42Z\",\"selfContainedInteractiveAuthoringEnabled\":false},\"dataFactoryName\":\"airpwj\",\"state\":\"Offline\",\"\":{\"qopugrse\":\"datasywpejt\",\"dmcbc\":\"datagiuztqefzypul\",\"gukqmkiynbfvkiwm\":\"datandidhuepikwcxoa\",\"y\":\"datanw\"}}")
            .toObject(SelfHostedIntegrationRuntimeStatus.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SelfHostedIntegrationRuntimeStatus model = new SelfHostedIntegrationRuntimeStatus()
            .withNodes(Arrays.asList(
                new SelfHostedIntegrationRuntimeNodeInner()
                    .withAdditionalProperties(mapOf("nodeName", "efq", "lastStartUpdateTime", "2021-05-28T18:05:19Z",
                        "lastConnectTime", "2021-02-26T14:13:20Z", "capabilities",
                        JacksonAdapter.createDefaultSerializerAdapter()
                            .deserialize("{\"bfjcvmk\":\"mbipysehyyb\"}", Object.class, SerializerEncoding.JSON),
                        "hostServiceUri", "ddaxaogs", "registerTime", "2021-03-10T22:00:56Z", "maxConcurrentJobs",
                        951625190, "lastStopTime", "2021-05-19T23:17:23Z", "version", "hdtiemb", "machineName", "rmgm",
                        "versionStatus", "pgdiwd", "concurrentJobsLimit", 1506230530, "lastEndUpdateTime",
                        "2021-08-28T10:16:29Z", "expiryTime", "2021-06-14T22:48:16Z", "lastStartTime",
                        "2021-03-01T08:51:48Z", "lastUpdateResult", "None", "isActiveDispatcher", true, "status",
                        "Upgrading")),
                new SelfHostedIntegrationRuntimeNodeInner().withAdditionalProperties(mapOf("nodeName",
                    "nxzhgbspdxbhjqux", "lastStartUpdateTime", "2021-06-24T00:00:51Z", "lastConnectTime",
                    "2021-01-13T03:30:44Z", "capabilities",
                    JacksonAdapter.createDefaultSerializerAdapter()
                        .deserialize("{\"ochtuxapewzwqlb\":\"qux\",\"mc\":\"mynslcvynavwttt\",\"caqimodn\":\"rod\"}",
                            Object.class, SerializerEncoding.JSON),
                    "hostServiceUri", "zwnkbjqpz", "registerTime", "2021-08-11T08:10:38Z", "maxConcurrentJobs",
                    1264951120, "lastStopTime", "2021-03-06T00:39:15Z", "version", "qtkfjacktav", "machineName",
                    "xqomzdfaupqve", "versionStatus", "mjxkhbucm", "concurrentJobsLimit", 718075939,
                    "lastEndUpdateTime", "2021-12-02T11:56:22Z", "expiryTime", "2021-11-10T12:02:11Z", "lastStartTime",
                    "2021-05-26T19:02:01Z", "lastUpdateResult", "Fail", "isActiveDispatcher", false, "status",
                    "Limited")),
                new SelfHostedIntegrationRuntimeNodeInner().withAdditionalProperties(mapOf("nodeName", "vohy",
                    "lastStartUpdateTime", "2021-03-25T10:57:13Z", "lastConnectTime", "2021-08-31T08:17:04Z",
                    "capabilities",
                    JacksonAdapter.createDefaultSerializerAdapter()
                        .deserialize(
                            "{\"rjybpvsoba\":\"irmgis\",\"ukegougxpyp\":\"tarirdzdgvqofl\",\"lmnxrxkuly\":\"mzqsx\"}",
                            Object.class, SerializerEncoding.JSON),
                    "hostServiceUri", "lyzolrvwsgseqj", "registerTime", "2021-02-09T08:11:56Z", "maxConcurrentJobs",
                    1849742414, "lastStopTime", "2021-01-12T06:41:07Z", "version", "b", "machineName", "dgjtpbtkogfg",
                    "versionStatus", "vviyqonbxxyf", "concurrentJobsLimit", 763137103, "lastEndUpdateTime",
                    "2021-05-18T01:36:42Z", "expiryTime", "2021-08-26T00:02:37Z", "lastStartTime",
                    "2021-04-19T13:24:32Z", "lastUpdateResult", "Succeed", "isActiveDispatcher", true, "status",
                    "Initializing"))))
            .withLinks(Arrays.asList(new LinkedIntegrationRuntime(), new LinkedIntegrationRuntime(),
                new LinkedIntegrationRuntime(), new LinkedIntegrationRuntime()));
        model = BinaryData.fromObject(model).toObject(SelfHostedIntegrationRuntimeStatus.class);
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
