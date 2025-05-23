// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.devopsinfrastructure.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.devopsinfrastructure.implementation.models.PoolListResult;
import com.azure.resourcemanager.devopsinfrastructure.models.ManagedServiceIdentityType;
import com.azure.resourcemanager.devopsinfrastructure.models.ProvisioningState;
import org.junit.jupiter.api.Assertions;

public final class PoolListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PoolListResult model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"provisioningState\":\"Failed\",\"maximumConcurrency\":137439916,\"organizationProfile\":{\"kind\":\"OrganizationProfile\"},\"agentProfile\":{\"kind\":\"AgentProfile\",\"resourcePredictions\":{},\"resourcePredictionsProfile\":{\"kind\":\"ResourcePredictionsProfile\"}},\"fabricProfile\":{\"kind\":\"FabricProfile\"},\"devCenterProjectResourceId\":\"ejctbzaqsqsycb\"},\"identity\":{\"principalId\":\"k\",\"tenantId\":\"kdkexxp\",\"type\":\"None\",\"userAssignedIdentities\":{\"i\":{\"clientId\":\"axcfjpgddtocjjx\",\"principalId\":\"pmouexhdz\"},\"btwnpzaoqvuhrhcf\":{\"clientId\":\"eojnxqbzvddn\",\"principalId\":\"ndei\"}}},\"location\":\"yd\",\"tags\":{\"eicxmqciwqvhkhi\":\"mjthjqkwp\",\"m\":\"uigdtopbobjog\"},\"id\":\"w\",\"name\":\"a\",\"type\":\"a\"},{\"properties\":{\"provisioningState\":\"Deleting\",\"maximumConcurrency\":425108971,\"organizationProfile\":{\"kind\":\"OrganizationProfile\"},\"agentProfile\":{\"kind\":\"AgentProfile\",\"resourcePredictions\":{},\"resourcePredictionsProfile\":{\"kind\":\"ResourcePredictionsProfile\"}},\"fabricProfile\":{\"kind\":\"FabricProfile\"},\"devCenterProjectResourceId\":\"vtpgvdfgiotkf\"},\"identity\":{\"principalId\":\"qxlngx\",\"tenantId\":\"fgugnxkrxdqmid\",\"type\":\"None\",\"userAssignedIdentities\":{\"oqfbowskanyk\":{\"clientId\":\"vqdra\",\"principalId\":\"jybige\"},\"ocpecfvmmco\":{\"clientId\":\"lcuiywgqywgndr\",\"principalId\":\"nhzgpphrcgyn\"}}},\"location\":\"sxlzevgbmqj\",\"tags\":{\"pmivkwlzu\":\"c\",\"ebxetqgtzxdp\":\"ccfwnfnbacfion\"},\"id\":\"qbqqwxr\",\"name\":\"feallnwsu\",\"type\":\"isnjampmngnz\"},{\"properties\":{\"provisioningState\":\"Failed\",\"maximumConcurrency\":431293436,\"organizationProfile\":{\"kind\":\"OrganizationProfile\"},\"agentProfile\":{\"kind\":\"AgentProfile\",\"resourcePredictions\":{},\"resourcePredictionsProfile\":{\"kind\":\"ResourcePredictionsProfile\"}},\"fabricProfile\":{\"kind\":\"FabricProfile\"},\"devCenterProjectResourceId\":\"ochcbonqvpkvl\"},\"identity\":{\"principalId\":\"jease\",\"tenantId\":\"heoflokeyyienjbd\",\"type\":\"UserAssigned\",\"userAssignedIdentities\":{\"jj\":{\"clientId\":\"hpdjpjumasxa\",\"principalId\":\"pqyegualhbxxh\"},\"mcy\":{\"clientId\":\"v\",\"principalId\":\"dgwdslfhot\"},\"dejbavo\":{\"clientId\":\"wlbjnpgacftade\",\"principalId\":\"nltyfsoppusuesnz\"}}},\"location\":\"zdmohctbqvu\",\"tags\":{\"ujjugwdkcglh\":\"dndnvow\"},\"id\":\"lazjdyggdtjixhbk\",\"name\":\"ofqweykhmenevfye\",\"type\":\"fwhybcibvy\"},{\"properties\":{\"provisioningState\":\"Canceled\",\"maximumConcurrency\":301752241,\"organizationProfile\":{\"kind\":\"OrganizationProfile\"},\"agentProfile\":{\"kind\":\"AgentProfile\",\"resourcePredictions\":{},\"resourcePredictionsProfile\":{\"kind\":\"ResourcePredictionsProfile\"}},\"fabricProfile\":{\"kind\":\"FabricProfile\"},\"devCenterProjectResourceId\":\"nnaamdectehfiqsc\"},\"identity\":{\"principalId\":\"pvhez\",\"tenantId\":\"gqhcjrefovg\",\"type\":\"UserAssigned\",\"userAssignedIdentities\":{\"rcczsqpjhvmd\":{\"clientId\":\"eyyvxyqjpkcat\",\"principalId\":\"ngj\"}}},\"location\":\"v\",\"tags\":{\"eupfhyhltrpm\":\"ounqecano\",\"odsfcpkvxodpuozm\":\"pjmcmatuokthfuiu\",\"ktwh\":\"zydagfuaxbezyiuo\",\"o\":\"dxwzywqsmbsurexi\"},\"id\":\"yocf\",\"name\":\"fksymddystki\",\"type\":\"uxh\"}],\"nextLink\":\"udxorrqn\"}")
            .toObject(PoolListResult.class);
        Assertions.assertEquals("yd", model.value().get(0).location());
        Assertions.assertEquals("mjthjqkwp", model.value().get(0).tags().get("eicxmqciwqvhkhi"));
        Assertions.assertEquals(ProvisioningState.FAILED, model.value().get(0).properties().provisioningState());
        Assertions.assertEquals(137439916, model.value().get(0).properties().maximumConcurrency());
        Assertions.assertEquals("ejctbzaqsqsycb", model.value().get(0).properties().devCenterProjectResourceId());
        Assertions.assertEquals(ManagedServiceIdentityType.NONE, model.value().get(0).identity().type());
        Assertions.assertEquals("udxorrqn", model.nextLink());
    }
}
