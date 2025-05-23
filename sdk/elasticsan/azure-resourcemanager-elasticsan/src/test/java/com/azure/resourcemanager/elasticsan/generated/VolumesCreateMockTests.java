// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.elasticsan.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.elasticsan.ElasticSanManager;
import com.azure.resourcemanager.elasticsan.models.ManagedByInfo;
import com.azure.resourcemanager.elasticsan.models.SourceCreationData;
import com.azure.resourcemanager.elasticsan.models.Volume;
import com.azure.resourcemanager.elasticsan.models.VolumeCreateOption;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class VolumesCreateMockTests {
    @Test
    public void testCreate() throws Exception {
        String responseStr
            = "{\"properties\":{\"volumeId\":\"ivfxzsjabibsyst\",\"creationData\":{\"createSource\":\"None\",\"sourceId\":\"jpvkvpbjxbkzbzkd\"},\"sizeGiB\":2436693610971493867,\"storageTarget\":{\"targetIqn\":\"budurgkakmo\",\"targetPortalHostname\":\"hjjklff\",\"targetPortalPort\":783879068,\"provisioningState\":\"SoftDeleting\",\"status\":\"Running\"},\"managedBy\":{\"resourceId\":\"rfzeey\"},\"provisioningState\":\"Succeeded\"},\"id\":\"ikayuhqlbjbsybb\",\"name\":\"wrv\",\"type\":\"ldgmfpgvmpip\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ElasticSanManager manager = ElasticSanManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        Volume response = manager.volumes()
            .define("nhltiugcxn")
            .withExistingVolumegroup("khevxccedc", "nmdyodnwzxl", "jc")
            .withSizeGiB(7402432030670029412L)
            .withCreationData(new SourceCreationData().withCreateSource(VolumeCreateOption.VOLUME_SNAPSHOT)
                .withSourceId("djrkvfgbvfvpd"))
            .withManagedBy(new ManagedByInfo().withResourceId("wm"))
            .create();

        Assertions.assertEquals(VolumeCreateOption.NONE, response.creationData().createSource());
        Assertions.assertEquals("jpvkvpbjxbkzbzkd", response.creationData().sourceId());
        Assertions.assertEquals(2436693610971493867L, response.sizeGiB());
        Assertions.assertEquals("rfzeey", response.managedBy().resourceId());
    }
}
