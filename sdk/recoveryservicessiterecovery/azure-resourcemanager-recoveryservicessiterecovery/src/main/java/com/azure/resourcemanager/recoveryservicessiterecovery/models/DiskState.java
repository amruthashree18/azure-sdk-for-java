// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The disk state.
 */
public final class DiskState extends ExpandableStringEnum<DiskState> {
    /**
     * Static value Unavailable for DiskState.
     */
    public static final DiskState UNAVAILABLE = fromString("Unavailable");

    /**
     * Static value InitialReplicationPending for DiskState.
     */
    public static final DiskState INITIAL_REPLICATION_PENDING = fromString("InitialReplicationPending");

    /**
     * Static value InitialReplicationFailed for DiskState.
     */
    public static final DiskState INITIAL_REPLICATION_FAILED = fromString("InitialReplicationFailed");

    /**
     * Static value Protected for DiskState.
     */
    public static final DiskState PROTECTED = fromString("Protected");

    /**
     * Creates a new instance of DiskState value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public DiskState() {
    }

    /**
     * Creates or finds a DiskState from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding DiskState.
     */
    public static DiskState fromString(String name) {
        return fromString(name, DiskState.class);
    }

    /**
     * Gets known DiskState values.
     * 
     * @return known DiskState values.
     */
    public static Collection<DiskState> values() {
        return values(DiskState.class);
    }
}
