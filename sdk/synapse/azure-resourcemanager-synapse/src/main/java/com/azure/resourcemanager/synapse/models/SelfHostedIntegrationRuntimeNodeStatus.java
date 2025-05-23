// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Status of the integration runtime node.
 */
public final class SelfHostedIntegrationRuntimeNodeStatus
    extends ExpandableStringEnum<SelfHostedIntegrationRuntimeNodeStatus> {
    /**
     * Static value NeedRegistration for SelfHostedIntegrationRuntimeNodeStatus.
     */
    public static final SelfHostedIntegrationRuntimeNodeStatus NEED_REGISTRATION = fromString("NeedRegistration");

    /**
     * Static value Online for SelfHostedIntegrationRuntimeNodeStatus.
     */
    public static final SelfHostedIntegrationRuntimeNodeStatus ONLINE = fromString("Online");

    /**
     * Static value Limited for SelfHostedIntegrationRuntimeNodeStatus.
     */
    public static final SelfHostedIntegrationRuntimeNodeStatus LIMITED = fromString("Limited");

    /**
     * Static value Offline for SelfHostedIntegrationRuntimeNodeStatus.
     */
    public static final SelfHostedIntegrationRuntimeNodeStatus OFFLINE = fromString("Offline");

    /**
     * Static value Upgrading for SelfHostedIntegrationRuntimeNodeStatus.
     */
    public static final SelfHostedIntegrationRuntimeNodeStatus UPGRADING = fromString("Upgrading");

    /**
     * Static value Initializing for SelfHostedIntegrationRuntimeNodeStatus.
     */
    public static final SelfHostedIntegrationRuntimeNodeStatus INITIALIZING = fromString("Initializing");

    /**
     * Static value InitializeFailed for SelfHostedIntegrationRuntimeNodeStatus.
     */
    public static final SelfHostedIntegrationRuntimeNodeStatus INITIALIZE_FAILED = fromString("InitializeFailed");

    /**
     * Creates a new instance of SelfHostedIntegrationRuntimeNodeStatus value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public SelfHostedIntegrationRuntimeNodeStatus() {
    }

    /**
     * Creates or finds a SelfHostedIntegrationRuntimeNodeStatus from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding SelfHostedIntegrationRuntimeNodeStatus.
     */
    public static SelfHostedIntegrationRuntimeNodeStatus fromString(String name) {
        return fromString(name, SelfHostedIntegrationRuntimeNodeStatus.class);
    }

    /**
     * Gets known SelfHostedIntegrationRuntimeNodeStatus values.
     * 
     * @return known SelfHostedIntegrationRuntimeNodeStatus values.
     */
    public static Collection<SelfHostedIntegrationRuntimeNodeStatus> values() {
        return values(SelfHostedIntegrationRuntimeNodeStatus.class);
    }
}
