// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcontainerservice.generated;

/**
 * Samples for AgentPool Get.
 */
public final class AgentPoolGetSamples {
    /*
     * x-ms-original-file:
     * specification/hybridaks/resource-manager/Microsoft.HybridContainerService/stable/2024-01-01/examples/GetAgentPool
     * .json
     */
    /**
     * Sample code: GetAgentPool.
     * 
     * @param manager Entry point to HybridContainerServiceManager.
     */
    public static void
        getAgentPool(com.azure.resourcemanager.hybridcontainerservice.HybridContainerServiceManager manager) {
        manager.agentPools()
            .getWithResponse(
                "subscriptions/fd3c3665-1729-4b7b-9a38-238e83b0f98b/resourceGroups/testrg/providers/Microsoft.Kubernetes/connectedClusters/test-hybridakscluster",
                "testnodepool", com.azure.core.util.Context.NONE);
    }
}
