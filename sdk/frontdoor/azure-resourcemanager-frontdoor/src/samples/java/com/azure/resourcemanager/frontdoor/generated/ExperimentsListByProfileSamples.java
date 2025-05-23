// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.frontdoor.generated;

/**
 * Samples for Experiments ListByProfile.
 */
public final class ExperimentsListByProfileSamples {
    /*
     * x-ms-original-file: specification/frontdoor/resource-manager/Microsoft.Network/stable/2019-11-01/examples/
     * NetworkExperimentListExperiments.json
     */
    /**
     * Sample code: Gets a list of Experiments.
     * 
     * @param manager Entry point to FrontDoorManager.
     */
    public static void getsAListOfExperiments(com.azure.resourcemanager.frontdoor.FrontDoorManager manager) {
        manager.experiments().listByProfile("MyResourceGroup", "MyProfile", com.azure.core.util.Context.NONE);
    }
}
