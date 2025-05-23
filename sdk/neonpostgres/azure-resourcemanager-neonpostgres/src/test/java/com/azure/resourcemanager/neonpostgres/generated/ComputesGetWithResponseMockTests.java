// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.neonpostgres.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.neonpostgres.NeonPostgresManager;
import com.azure.resourcemanager.neonpostgres.models.Compute;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ComputesGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"entityId\":\"zqiyuqhtder\",\"entityName\":\"n\",\"createdAt\":\"a\",\"provisioningState\":\"Failed\",\"attributes\":[{\"name\":\"jlwyxedzn\",\"value\":\"xrfomcke\"},{\"name\":\"vmyifopxf\",\"value\":\"jt\"}],\"region\":\"yzoutxfptofh\",\"cpuCores\":792380942,\"memory\":1254181889,\"status\":\"zygvadgaaqwvkgjp\"},\"id\":\"pmpv\",\"name\":\"nogehlufbort\",\"type\":\"nukkfaxzsvb\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        NeonPostgresManager manager = NeonPostgresManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        Compute response = manager.computes()
            .getWithResponse("ud", "yiurztvktjh", "fecqkoqyouerga", "hpuzxkpye", "hfdyldhgye",
                com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("n", response.properties().entityName());
        Assertions.assertEquals("jlwyxedzn", response.properties().attributes().get(0).name());
        Assertions.assertEquals("xrfomcke", response.properties().attributes().get(0).value());
        Assertions.assertEquals("yzoutxfptofh", response.properties().region());
        Assertions.assertEquals(792380942, response.properties().cpuCores());
        Assertions.assertEquals(1254181889, response.properties().memory());
        Assertions.assertEquals("zygvadgaaqwvkgjp", response.properties().status());
    }
}
