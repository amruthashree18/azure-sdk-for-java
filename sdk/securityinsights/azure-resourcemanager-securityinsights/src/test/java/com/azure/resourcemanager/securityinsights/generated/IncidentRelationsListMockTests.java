// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.securityinsights.SecurityInsightsManager;
import com.azure.resourcemanager.securityinsights.models.Relation;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class IncidentRelationsListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"relatedResourceId\":\"wuhvaj\",\"relatedResourceName\":\"ilfemjj\",\"relatedResourceType\":\"kzwjiqullq\",\"relatedResourceKind\":\"dmvr\"},\"etag\":\"mqerndb\",\"id\":\"yeofltfnnxrkad\",\"name\":\"fynn\",\"type\":\"muii\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        SecurityInsightsManager manager = SecurityInsightsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<Relation> response = manager.incidentRelations()
            .list("ke", "bgvopemt", "oqujlyegqavn", "gflqqbtnyjp", "lxdbfvabmvms", 1081151366, "aevwjcnkot",
                com.azure.core.util.Context.NONE);

        Assertions.assertEquals("mqerndb", response.iterator().next().etag());
        Assertions.assertEquals("wuhvaj", response.iterator().next().relatedResourceId());
    }
}
