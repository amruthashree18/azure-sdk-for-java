// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devtestlabs.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.devtestlabs.DevTestLabsManager;
import com.azure.resourcemanager.devtestlabs.models.ArmTemplateParameterProperties;
import com.azure.resourcemanager.devtestlabs.models.DtlEnvironment;
import com.azure.resourcemanager.devtestlabs.models.EnvironmentDeploymentProperties;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class EnvironmentsCreateOrUpdateMockTests {
    @Test
    public void testCreateOrUpdate() throws Exception {
        String responseStr
            = "{\"properties\":{\"deploymentProperties\":{\"armTemplateId\":\"jguwrjmwvv\",\"parameters\":[{\"name\":\"kxxi\",\"value\":\"gxql\"},{\"name\":\"k\",\"value\":\"jgxieqfkyfh\"},{\"name\":\"vjaqu\",\"value\":\"yynvskpa\"},{\"name\":\"mgeu\",\"value\":\"xmjbxcbccwkqmtxa\"}]},\"armTemplateDisplayName\":\"qis\",\"resourceGroupId\":\"p\",\"createdByUser\":\"gftrqrejdaahuqim\",\"provisioningState\":\"Succeeded\",\"uniqueIdentifier\":\"snc\"},\"location\":\"kiioshj\",\"tags\":{\"cg\":\"etybnxgzt\",\"j\":\"tjchfjvmy\"},\"id\":\"ebecuvlbefv\",\"name\":\"cljkxpyl\",\"type\":\"woxzgwpsyxji\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        DevTestLabsManager manager = DevTestLabsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        DtlEnvironment response = manager.environments()
            .define("ky")
            .withRegion("syjprxslwhdmcvh")
            .withExistingUser("ixv", "lwynpbbfqvzfj", "spugzfeuzjljmph")
            .withTags(mapOf("zgihotje", "zjhfvhuwzbxpc", "bxwie", "ohmxvvlrrska", "derltfokyksyim", "xuy"))
            .withDeploymentProperties(new EnvironmentDeploymentProperties().withArmTemplateId("lgjzmi")
                .withParameters(Arrays.asList(new ArmTemplateParameterProperties().withName("oc").withValue("xshanzb"),
                    new ArmTemplateParameterProperties().withName("adh").withValue("tecaa"),
                    new ArmTemplateParameterProperties().withName("dohzniucbdaombwi").withValue("jdllwktle"),
                    new ArmTemplateParameterProperties().withName("wavvqxuajgcqwuly").withValue("gfcfdruwsik"))))
            .withArmTemplateDisplayName("tclhuulriqbyokv")
            .create();

        Assertions.assertEquals("kiioshj", response.location());
        Assertions.assertEquals("etybnxgzt", response.tags().get("cg"));
        Assertions.assertEquals("jguwrjmwvv", response.deploymentProperties().armTemplateId());
        Assertions.assertEquals("kxxi", response.deploymentProperties().parameters().get(0).name());
        Assertions.assertEquals("gxql", response.deploymentProperties().parameters().get(0).value());
        Assertions.assertEquals("qis", response.armTemplateDisplayName());
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
