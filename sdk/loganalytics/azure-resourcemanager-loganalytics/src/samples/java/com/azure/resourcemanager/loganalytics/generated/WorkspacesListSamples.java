// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.loganalytics.generated;

/**
 * Samples for Workspaces List.
 */
public final class WorkspacesListSamples {
    /*
     * x-ms-original-file:
     * specification/operationalinsights/resource-manager/Microsoft.OperationalInsights/stable/2022-10-01/examples/
     * WorkspacesSubscriptionList.json
     */
    /**
     * Sample code: WorkspacesSubscriptionList.
     * 
     * @param manager Entry point to LogAnalyticsManager.
     */
    public static void workspacesSubscriptionList(com.azure.resourcemanager.loganalytics.LogAnalyticsManager manager) {
        manager.workspaces().list(com.azure.core.util.Context.NONE);
    }
}
