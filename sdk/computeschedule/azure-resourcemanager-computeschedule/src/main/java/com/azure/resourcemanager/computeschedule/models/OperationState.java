// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.computeschedule.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Values that define the states of operations in Scheduled Actions.
 */
public final class OperationState extends ExpandableStringEnum<OperationState> {
    /**
     * The default value for the operation state enum.
     */
    public static final OperationState UNKNOWN = fromString("Unknown");

    /**
     * Operations that are pending scheduling.
     */
    public static final OperationState PENDING_SCHEDULING = fromString("PendingScheduling");

    /**
     * Operations that have been scheduled.
     */
    public static final OperationState SCHEDULED = fromString("Scheduled");

    /**
     * Operations that are waiting to be executed.
     */
    public static final OperationState PENDING_EXECUTION = fromString("PendingExecution");

    /**
     * Operations that are in the process of being executed.
     */
    public static final OperationState EXECUTING = fromString("Executing");

    /**
     * Operations that suceeded.
     */
    public static final OperationState SUCCEEDED = fromString("Succeeded");

    /**
     * Operations that have failed.
     */
    public static final OperationState FAILED = fromString("Failed");

    /**
     * Operations that have been Cancelled by the user.
     */
    public static final OperationState CANCELLED = fromString("Cancelled");

    /**
     * Operations that are blocked.
     */
    public static final OperationState BLOCKED = fromString("Blocked");

    /**
     * Creates a new instance of OperationState value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public OperationState() {
    }

    /**
     * Creates or finds a OperationState from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding OperationState.
     */
    public static OperationState fromString(String name) {
        return fromString(name, OperationState.class);
    }

    /**
     * Gets known OperationState values.
     * 
     * @return known OperationState values.
     */
    public static Collection<OperationState> values() {
        return values(OperationState.class);
    }
}
