// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resourceconnector.models;

import com.azure.resourcemanager.resourceconnector.fluent.models.ApplianceListCredentialResultsInner;
import java.util.List;

/**
 * An immutable client-side representation of ApplianceListCredentialResults.
 */
public interface ApplianceListCredentialResults {
    /**
     * Gets the hybridConnectionConfig property: Contains the REP (rendezvous endpoint) and “Listener” access token from
     * notification service (NS).
     * 
     * @return the hybridConnectionConfig value.
     */
    HybridConnectionConfig hybridConnectionConfig();

    /**
     * Gets the kubeconfigs property: The list of appliance kubeconfigs.
     * 
     * @return the kubeconfigs value.
     */
    List<ApplianceCredentialKubeconfig> kubeconfigs();

    /**
     * Gets the inner com.azure.resourcemanager.resourceconnector.fluent.models.ApplianceListCredentialResultsInner
     * object.
     * 
     * @return the inner object.
     */
    ApplianceListCredentialResultsInner innerModel();
}
