// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.iotoperations.generated;

import com.azure.resourcemanager.iotoperations.models.AdvancedSettings;
import com.azure.resourcemanager.iotoperations.models.BackendChain;
import com.azure.resourcemanager.iotoperations.models.BrokerDiagnostics;
import com.azure.resourcemanager.iotoperations.models.BrokerMemoryProfile;
import com.azure.resourcemanager.iotoperations.models.BrokerProperties;
import com.azure.resourcemanager.iotoperations.models.Cardinality;
import com.azure.resourcemanager.iotoperations.models.CertManagerCertOptions;
import com.azure.resourcemanager.iotoperations.models.CertManagerPrivateKey;
import com.azure.resourcemanager.iotoperations.models.ClientConfig;
import com.azure.resourcemanager.iotoperations.models.DiagnosticsLogs;
import com.azure.resourcemanager.iotoperations.models.DiskBackedMessageBuffer;
import com.azure.resourcemanager.iotoperations.models.ExtendedLocation;
import com.azure.resourcemanager.iotoperations.models.ExtendedLocationType;
import com.azure.resourcemanager.iotoperations.models.Frontend;
import com.azure.resourcemanager.iotoperations.models.GenerateResourceLimits;
import com.azure.resourcemanager.iotoperations.models.KubernetesReference;
import com.azure.resourcemanager.iotoperations.models.LocalKubernetesReference;
import com.azure.resourcemanager.iotoperations.models.Metrics;
import com.azure.resourcemanager.iotoperations.models.OperationalMode;
import com.azure.resourcemanager.iotoperations.models.OperatorValues;
import com.azure.resourcemanager.iotoperations.models.PrivateKeyAlgorithm;
import com.azure.resourcemanager.iotoperations.models.PrivateKeyRotationPolicy;
import com.azure.resourcemanager.iotoperations.models.SelfCheck;
import com.azure.resourcemanager.iotoperations.models.SelfTracing;
import com.azure.resourcemanager.iotoperations.models.SubscriberMessageDropStrategy;
import com.azure.resourcemanager.iotoperations.models.SubscriberQueueLimit;
import com.azure.resourcemanager.iotoperations.models.Traces;
import com.azure.resourcemanager.iotoperations.models.VolumeClaimResourceRequirements;
import com.azure.resourcemanager.iotoperations.models.VolumeClaimSpec;
import com.azure.resourcemanager.iotoperations.models.VolumeClaimSpecSelector;
import com.azure.resourcemanager.iotoperations.models.VolumeClaimSpecSelectorMatchExpressions;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Samples for Broker CreateOrUpdate.
 */
public final class BrokerCreateOrUpdateSamples {
    /*
     * x-ms-original-file: 2025-04-01/Broker_CreateOrUpdate_Minimal.json
     */
    /**
     * Sample code: Broker_CreateOrUpdate_Minimal.
     * 
     * @param manager Entry point to IoTOperationsManager.
     */
    public static void
        brokerCreateOrUpdateMinimal(com.azure.resourcemanager.iotoperations.IoTOperationsManager manager) {
        manager.brokers()
            .define("resource-name123")
            .withExistingInstance("rgiotoperations", "resource-name123")
            .withExtendedLocation(
                new ExtendedLocation().withName("qmbrfwcpwwhggszhrdjv").withType(ExtendedLocationType.CUSTOM_LOCATION))
            .withProperties(new BrokerProperties().withMemoryProfile(BrokerMemoryProfile.TINY))
            .create();
    }

    /*
     * x-ms-original-file: 2025-04-01/Broker_CreateOrUpdate_Complex.json
     */
    /**
     * Sample code: Broker_CreateOrUpdate_Complex.
     * 
     * @param manager Entry point to IoTOperationsManager.
     */
    public static void
        brokerCreateOrUpdateComplex(com.azure.resourcemanager.iotoperations.IoTOperationsManager manager) {
        manager.brokers()
            .define("resource-name123")
            .withExistingInstance("rgiotoperations", "resource-name123")
            .withExtendedLocation(
                new ExtendedLocation().withName("qmbrfwcpwwhggszhrdjv").withType(ExtendedLocationType.CUSTOM_LOCATION))
            .withProperties(new BrokerProperties()
                .withCardinality(new Cardinality()
                    .withBackendChain(new BackendChain().withPartitions(2).withRedundancyFactor(2).withWorkers(2))
                    .withFrontend(new Frontend().withReplicas(2).withWorkers(2)))
                .withDiskBackedMessageBuffer(new DiskBackedMessageBuffer().withMaxSize("50M"))
                .withGenerateResourceLimits(new GenerateResourceLimits().withCpu(OperationalMode.ENABLED))
                .withMemoryProfile(BrokerMemoryProfile.MEDIUM))
            .create();
    }

    /*
     * x-ms-original-file: 2025-04-01/Broker_CreateOrUpdate_MaximumSet_Gen.json
     */
    /**
     * Sample code: Broker_CreateOrUpdate.
     * 
     * @param manager Entry point to IoTOperationsManager.
     */
    public static void brokerCreateOrUpdate(com.azure.resourcemanager.iotoperations.IoTOperationsManager manager) {
        manager.brokers()
            .define("resource-name123")
            .withExistingInstance("rgiotoperations", "resource-name123")
            .withExtendedLocation(
                new ExtendedLocation().withName("qmbrfwcpwwhggszhrdjv").withType(ExtendedLocationType.CUSTOM_LOCATION))
            .withProperties(
                new BrokerProperties()
                    .withAdvanced(new AdvancedSettings()
                        .withClients(new ClientConfig().withMaxSessionExpirySeconds(3859)
                            .withMaxMessageExpirySeconds(3263)
                            .withMaxPacketSizeBytes(3029)
                            .withSubscriberQueueLimit(new SubscriberQueueLimit().withLength(6L)
                                .withStrategy(SubscriberMessageDropStrategy.NONE))
                            .withMaxReceiveMaximum(2365)
                            .withMaxKeepAliveSeconds(3744))
                        .withEncryptInternalTraffic(OperationalMode.ENABLED)
                        .withInternalCerts(new CertManagerCertOptions().withDuration("bchrc")
                            .withRenewBefore("xkafmpgjfifkwwrhkswtopdnne")
                            .withPrivateKey(new CertManagerPrivateKey().withAlgorithm(PrivateKeyAlgorithm.EC256)
                                .withRotationPolicy(PrivateKeyRotationPolicy.ALWAYS))))
                    .withCardinality(new Cardinality()
                        .withBackendChain(new BackendChain().withPartitions(11).withRedundancyFactor(5).withWorkers(15))
                        .withFrontend(new Frontend().withReplicas(2).withWorkers(6)))
                    .withDiagnostics(new BrokerDiagnostics()
                        .withLogs(new DiagnosticsLogs().withLevel("rnmwokumdmebpmfxxxzvvjfdywotav"))
                        .withMetrics(new Metrics().withPrometheusPort(7581))
                        .withSelfCheck(new SelfCheck().withMode(OperationalMode.ENABLED)
                            .withIntervalSeconds(158)
                            .withTimeoutSeconds(14))
                        .withTraces(new Traces().withMode(OperationalMode.ENABLED)
                            .withCacheSizeMegabytes(28)
                            .withSelfTracing(
                                new SelfTracing().withMode(OperationalMode.ENABLED).withIntervalSeconds(22))
                            .withSpanChannelCapacity(1000)))
                    .withDiskBackedMessageBuffer(new DiskBackedMessageBuffer().withMaxSize("500M")
                        .withEphemeralVolumeClaimSpec(new VolumeClaimSpec().withVolumeName("c")
                            .withVolumeMode("rxvpksjuuugqnqzeiprocknbn")
                            .withStorageClassName("sseyhrjptkhrqvpdpjmornkqvon")
                            .withAccessModes(Arrays.asList("nuluhigrbb"))
                            .withDataSource(new LocalKubernetesReference().withApiGroup("npqapyksvvpkohujx")
                                .withKind("wazgyb")
                                .withName("cwhsgxxcxsyppoefm"))
                            .withDataSourceRef(new KubernetesReference().withApiGroup("mnfnykznjjsoqpfsgdqioupt")
                                .withKind("odynqzekfzsnawrctaxg")
                                .withName("envszivbbmixbyddzg")
                                .withNamespace("etcfzvxqd"))
                            .withResources(new VolumeClaimResourceRequirements()
                                .withLimits(mapOf("key2719", "fakeTokenPlaceholder"))
                                .withRequests(mapOf("key2909", "fakeTokenPlaceholder")))
                            .withSelector(new VolumeClaimSpecSelector()
                                .withMatchExpressions(Arrays.asList(
                                    new VolumeClaimSpecSelectorMatchExpressions().withKey("fakeTokenPlaceholder")
                                        .withOperator(OperatorValues.IN)
                                        .withValues(Arrays.asList("slmpajlywqvuyknipgztsonqyybt"))))
                                .withMatchLabels(mapOf("key6673", "fakeTokenPlaceholder"))))
                        .withPersistentVolumeClaimSpec(new VolumeClaimSpec().withVolumeName("c")
                            .withVolumeMode("rxvpksjuuugqnqzeiprocknbn")
                            .withStorageClassName("sseyhrjptkhrqvpdpjmornkqvon")
                            .withAccessModes(Arrays.asList("nuluhigrbb"))
                            .withDataSource(new LocalKubernetesReference().withApiGroup("npqapyksvvpkohujx")
                                .withKind("wazgyb")
                                .withName("cwhsgxxcxsyppoefm"))
                            .withDataSourceRef(new KubernetesReference().withApiGroup("mnfnykznjjsoqpfsgdqioupt")
                                .withKind("odynqzekfzsnawrctaxg")
                                .withName("envszivbbmixbyddzg")
                                .withNamespace("etcfzvxqd"))
                            .withResources(new VolumeClaimResourceRequirements()
                                .withLimits(mapOf("key2719", "fakeTokenPlaceholder"))
                                .withRequests(mapOf("key2909", "fakeTokenPlaceholder")))
                            .withSelector(new VolumeClaimSpecSelector()
                                .withMatchExpressions(Arrays.asList(
                                    new VolumeClaimSpecSelectorMatchExpressions().withKey("fakeTokenPlaceholder")
                                        .withOperator(OperatorValues.IN)
                                        .withValues(Arrays.asList("slmpajlywqvuyknipgztsonqyybt"))))
                                .withMatchLabels(mapOf("key6673", "fakeTokenPlaceholder")))))
                    .withGenerateResourceLimits(new GenerateResourceLimits().withCpu(OperationalMode.ENABLED))
                    .withMemoryProfile(BrokerMemoryProfile.TINY))
            .create();
    }

    /*
     * x-ms-original-file: 2025-04-01/Broker_CreateOrUpdate_Simple.json
     */
    /**
     * Sample code: Broker_CreateOrUpdate_Simple.
     * 
     * @param manager Entry point to IoTOperationsManager.
     */
    public static void
        brokerCreateOrUpdateSimple(com.azure.resourcemanager.iotoperations.IoTOperationsManager manager) {
        manager.brokers()
            .define("resource-name123")
            .withExistingInstance("rgiotoperations", "resource-name123")
            .withExtendedLocation(
                new ExtendedLocation().withName("qmbrfwcpwwhggszhrdjv").withType(ExtendedLocationType.CUSTOM_LOCATION))
            .withProperties(new BrokerProperties()
                .withCardinality(new Cardinality()
                    .withBackendChain(new BackendChain().withPartitions(2).withRedundancyFactor(2).withWorkers(2))
                    .withFrontend(new Frontend().withReplicas(2).withWorkers(2)))
                .withGenerateResourceLimits(new GenerateResourceLimits().withCpu(OperationalMode.ENABLED))
                .withMemoryProfile(BrokerMemoryProfile.LOW))
            .create();
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
