// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.deviceprovisioningservices.generated;

/**
 * Samples for IotDpsResource ListPrivateEndpointConnections.
 */
public final class IotDpsResourceListPrivateEndpointConnectionsSamples {
    /*
     * x-ms-original-file:
     * specification/deviceprovisioningservices/resource-manager/Microsoft.Devices/stable/2022-02-05/examples/
     * DPSListPrivateEndpointConnections.json
     */
    /**
     * Sample code: PrivateEndpointConnections_List.
     * 
     * @param manager Entry point to IotDpsManager.
     */
    public static void
        privateEndpointConnectionsList(com.azure.resourcemanager.deviceprovisioningservices.IotDpsManager manager) {
        manager.iotDpsResources()
            .listPrivateEndpointConnectionsWithResponse("myResourceGroup", "myFirstProvisioningService",
                com.azure.core.util.Context.NONE);
    }
}
