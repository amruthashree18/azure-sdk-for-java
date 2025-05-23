// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.compute.batch.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * StorageAccountType enums.
 */
public final class StorageAccountType extends ExpandableStringEnum<StorageAccountType> {

    /**
     * The data disk should use standard locally redundant storage.
     */
    @Generated
    public static final StorageAccountType STANDARD_LRS = fromString("standard_lrs");

    /**
     * The data disk should use premium locally redundant storage.
     */
    @Generated
    public static final StorageAccountType PREMIUM_LRS = fromString("premium_lrs");

    /**
     * The data disk / OS disk should use standard SSD locally redundant storage.
     */
    @Generated
    public static final StorageAccountType STANDARD_SSDLRS = fromString("standardssd_lrs");

    /**
     * Creates a new instance of StorageAccountType value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public StorageAccountType() {
    }

    /**
     * Creates or finds a StorageAccountType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding StorageAccountType.
     */
    @Generated
    public static StorageAccountType fromString(String name) {
        return fromString(name, StorageAccountType.class);
    }

    /**
     * Gets known StorageAccountType values.
     *
     * @return known StorageAccountType values.
     */
    @Generated
    public static Collection<StorageAccountType> values() {
        return values(StorageAccountType.class);
    }
}
