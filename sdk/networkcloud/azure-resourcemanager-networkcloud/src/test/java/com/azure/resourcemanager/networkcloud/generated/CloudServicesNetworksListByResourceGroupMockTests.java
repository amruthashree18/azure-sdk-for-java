// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.networkcloud.NetworkCloudManager;
import com.azure.resourcemanager.networkcloud.models.CloudServicesNetwork;
import com.azure.resourcemanager.networkcloud.models.CloudServicesNetworkEnableDefaultEgressEndpoints;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class CloudServicesNetworksListByResourceGroupMockTests {
    @Test
    public void testListByResourceGroup() throws Exception {
        String responseStr
            = "{\"value\":[{\"extendedLocation\":{\"name\":\"pyc\",\"type\":\"hcoeocnhzq\"},\"properties\":{\"additionalEgressEndpoints\":[{\"category\":\"jzcfyjzptwr\",\"endpoints\":[{\"domainName\":\"h\"},{\"domainName\":\"pqinf\"},{\"domainName\":\"zpyglqdhmrj\"}]},{\"category\":\"ralcxpjbyypsj\",\"endpoints\":[{\"domainName\":\"cjenkyhfqzvsqxf\"},{\"domainName\":\"jelgcmpzqjhhhq\"},{\"domainName\":\"uwyvcacoyvi\"}]},{\"category\":\"bsizus\",\"endpoints\":[{\"domainName\":\"zlbscmnlziji\"},{\"domainName\":\"fehgmv\"}]}],\"associatedResourceIds\":[\"wyvq\",\"xrerlniylylyf\"],\"clusterId\":\"zutgqztwhghmupg\",\"detailedStatus\":\"Error\",\"detailedStatusMessage\":\"cdxa\",\"enableDefaultEgressEndpoints\":\"True\",\"enabledEgressEndpoints\":[{\"category\":\"tabenbbk\",\"endpoints\":[{\"domainName\":\"pxzuca\"},{\"domainName\":\"e\"},{\"domainName\":\"dwwnl\"},{\"domainName\":\"a\"}]},{\"category\":\"wxudgn\",\"endpoints\":[{\"domainName\":\"ookrtalvnbw\"},{\"domainName\":\"pbeme\"},{\"domainName\":\"uclvdjj\"}]},{\"category\":\"kyrdnqodx\",\"endpoints\":[{\"domainName\":\"h\"},{\"domainName\":\"hqfaqnvz\"}]}],\"hybridAksClustersAssociatedIds\":[\"yipemchgavsczuej\",\"txptlghw\"],\"interfaceName\":\"omew\",\"provisioningState\":\"Accepted\",\"virtualMachinesAssociatedIds\":[\"iuh\",\"awmo\",\"ia\",\"cz\"]},\"location\":\"odrrslblxyd\",\"tags\":{\"xiwkgfbql\":\"xvv\",\"c\":\"nqkhych\"},\"id\":\"kulehurqlrq\",\"name\":\"fawey\",\"type\":\"rkphyjdxr\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        NetworkCloudManager manager = NetworkCloudManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<CloudServicesNetwork> response
            = manager.cloudServicesNetworks().listByResourceGroup("oohguabzoghkt", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("odrrslblxyd", response.iterator().next().location());
        Assertions.assertEquals("xvv", response.iterator().next().tags().get("xiwkgfbql"));
        Assertions.assertEquals("pyc", response.iterator().next().extendedLocation().name());
        Assertions.assertEquals("hcoeocnhzq", response.iterator().next().extendedLocation().type());
        Assertions.assertEquals("jzcfyjzptwr",
            response.iterator().next().additionalEgressEndpoints().get(0).category());
        Assertions.assertEquals("h",
            response.iterator().next().additionalEgressEndpoints().get(0).endpoints().get(0).domainName());
        Assertions.assertEquals(CloudServicesNetworkEnableDefaultEgressEndpoints.TRUE,
            response.iterator().next().enableDefaultEgressEndpoints());
    }
}
