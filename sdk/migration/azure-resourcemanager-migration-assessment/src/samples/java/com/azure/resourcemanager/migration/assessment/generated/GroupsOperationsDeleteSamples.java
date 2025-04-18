// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.migration.assessment.generated;

/**
 * Samples for GroupsOperations Delete.
 */
public final class GroupsOperationsDeleteSamples {
    /*
     * x-ms-original-file:
     * specification/migrate/resource-manager/Microsoft.Migrate/AssessmentProjects/stable/2023-03-15/examples/
     * GroupsOperations_Delete_MaximumSet_Gen.json
     */
    /**
     * Sample code: GroupsOperations_Delete_MaximumSet_Gen.
     * 
     * @param manager Entry point to MigrationAssessmentManager.
     */
    public static void groupsOperationsDeleteMaximumSetGen(
        com.azure.resourcemanager.migration.assessment.MigrationAssessmentManager manager) {
        manager.groupsOperations()
            .deleteWithResponse("ayagrawrg", "app18700project", "kuchatur-test", com.azure.core.util.Context.NONE);
    }
}
