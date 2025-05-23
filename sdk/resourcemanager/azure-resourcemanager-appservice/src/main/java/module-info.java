// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

module com.azure.resourcemanager.appservice {
    requires transitive com.azure.resourcemanager.resources;
    requires transitive com.azure.resourcemanager.dns;
    requires transitive com.azure.resourcemanager.keyvault;
    requires transitive com.azure.resourcemanager.msi;
    requires transitive com.azure.resourcemanager.storage;
    requires transitive com.azure.core.management;

    // export public APIs of appservice
    exports com.azure.resourcemanager.appservice;
    exports com.azure.resourcemanager.appservice.fluent;
    exports com.azure.resourcemanager.appservice.fluent.models;
    exports com.azure.resourcemanager.appservice.models;

    // open packages specifically for azure core
    opens com.azure.resourcemanager.appservice.fluent.models to com.azure.core;
    opens com.azure.resourcemanager.appservice.models to com.azure.core;
    opens com.azure.resourcemanager.appservice.implementation to com.azure.core;
}
