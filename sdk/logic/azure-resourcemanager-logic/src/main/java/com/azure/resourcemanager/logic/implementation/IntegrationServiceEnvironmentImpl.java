// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.logic.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.management.Region;
import com.azure.core.util.Context;
import com.azure.resourcemanager.logic.fluent.models.IntegrationServiceEnvironmentInner;
import com.azure.resourcemanager.logic.models.IntegrationServiceEnvironment;
import com.azure.resourcemanager.logic.models.IntegrationServiceEnvironmentProperties;
import com.azure.resourcemanager.logic.models.IntegrationServiceEnvironmentSku;
import com.azure.resourcemanager.logic.models.ManagedServiceIdentity;
import java.util.Collections;
import java.util.Map;

public final class IntegrationServiceEnvironmentImpl implements IntegrationServiceEnvironment,
    IntegrationServiceEnvironment.Definition, IntegrationServiceEnvironment.Update {
    private IntegrationServiceEnvironmentInner innerObject;

    private final com.azure.resourcemanager.logic.LogicManager serviceManager;

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public String location() {
        return this.innerModel().location();
    }

    public Map<String, String> tags() {
        Map<String, String> inner = this.innerModel().tags();
        if (inner != null) {
            return Collections.unmodifiableMap(inner);
        } else {
            return Collections.emptyMap();
        }
    }

    public IntegrationServiceEnvironmentProperties properties() {
        return this.innerModel().properties();
    }

    public IntegrationServiceEnvironmentSku sku() {
        return this.innerModel().sku();
    }

    public ManagedServiceIdentity identity() {
        return this.innerModel().identity();
    }

    public Region region() {
        return Region.fromName(this.regionName());
    }

    public String regionName() {
        return this.location();
    }

    public String resourceGroupName() {
        return resourceGroup;
    }

    public IntegrationServiceEnvironmentInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.logic.LogicManager manager() {
        return this.serviceManager;
    }

    private String resourceGroup;

    private String integrationServiceEnvironmentName;

    public IntegrationServiceEnvironmentImpl withExistingResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
        return this;
    }

    public IntegrationServiceEnvironment create() {
        this.innerObject = serviceManager.serviceClient()
            .getIntegrationServiceEnvironments()
            .createOrUpdate(resourceGroup, integrationServiceEnvironmentName, this.innerModel(), Context.NONE);
        return this;
    }

    public IntegrationServiceEnvironment create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getIntegrationServiceEnvironments()
            .createOrUpdate(resourceGroup, integrationServiceEnvironmentName, this.innerModel(), context);
        return this;
    }

    IntegrationServiceEnvironmentImpl(String name, com.azure.resourcemanager.logic.LogicManager serviceManager) {
        this.innerObject = new IntegrationServiceEnvironmentInner();
        this.serviceManager = serviceManager;
        this.integrationServiceEnvironmentName = name;
    }

    public IntegrationServiceEnvironmentImpl update() {
        return this;
    }

    public IntegrationServiceEnvironment apply() {
        this.innerObject = serviceManager.serviceClient()
            .getIntegrationServiceEnvironments()
            .update(resourceGroup, integrationServiceEnvironmentName, this.innerModel(), Context.NONE);
        return this;
    }

    public IntegrationServiceEnvironment apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getIntegrationServiceEnvironments()
            .update(resourceGroup, integrationServiceEnvironmentName, this.innerModel(), context);
        return this;
    }

    IntegrationServiceEnvironmentImpl(IntegrationServiceEnvironmentInner innerObject,
        com.azure.resourcemanager.logic.LogicManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroup = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.integrationServiceEnvironmentName
            = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "integrationServiceEnvironments");
    }

    public IntegrationServiceEnvironment refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getIntegrationServiceEnvironments()
            .getByResourceGroupWithResponse(resourceGroup, integrationServiceEnvironmentName, Context.NONE)
            .getValue();
        return this;
    }

    public IntegrationServiceEnvironment refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getIntegrationServiceEnvironments()
            .getByResourceGroupWithResponse(resourceGroup, integrationServiceEnvironmentName, context)
            .getValue();
        return this;
    }

    public Response<Void> restartWithResponse(Context context) {
        return serviceManager.integrationServiceEnvironments()
            .restartWithResponse(resourceGroup, integrationServiceEnvironmentName, context);
    }

    public void restart() {
        serviceManager.integrationServiceEnvironments().restart(resourceGroup, integrationServiceEnvironmentName);
    }

    public IntegrationServiceEnvironmentImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public IntegrationServiceEnvironmentImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public IntegrationServiceEnvironmentImpl withTags(Map<String, String> tags) {
        this.innerModel().withTags(tags);
        return this;
    }

    public IntegrationServiceEnvironmentImpl withProperties(IntegrationServiceEnvironmentProperties properties) {
        this.innerModel().withProperties(properties);
        return this;
    }

    public IntegrationServiceEnvironmentImpl withSku(IntegrationServiceEnvironmentSku sku) {
        this.innerModel().withSku(sku);
        return this;
    }

    public IntegrationServiceEnvironmentImpl withIdentity(ManagedServiceIdentity identity) {
        this.innerModel().withIdentity(identity);
        return this;
    }
}
