// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.databox.generated;

import com.azure.resourcemanager.databox.models.AddressType;
import com.azure.resourcemanager.databox.models.ContactDetails;
import com.azure.resourcemanager.databox.models.DataAccountType;
import com.azure.resourcemanager.databox.models.DataBoxJobDetails;
import com.azure.resourcemanager.databox.models.DataExportDetails;
import com.azure.resourcemanager.databox.models.DataImportDetails;
import com.azure.resourcemanager.databox.models.DoubleEncryption;
import com.azure.resourcemanager.databox.models.EncryptionPreferences;
import com.azure.resourcemanager.databox.models.ModelName;
import com.azure.resourcemanager.databox.models.Preferences;
import com.azure.resourcemanager.databox.models.ResourceIdentity;
import com.azure.resourcemanager.databox.models.ShippingAddress;
import com.azure.resourcemanager.databox.models.Sku;
import com.azure.resourcemanager.databox.models.SkuName;
import com.azure.resourcemanager.databox.models.StorageAccountDetails;
import com.azure.resourcemanager.databox.models.TransferAllDetails;
import com.azure.resourcemanager.databox.models.TransferConfiguration;
import com.azure.resourcemanager.databox.models.TransferConfigurationTransferAllDetails;
import com.azure.resourcemanager.databox.models.TransferConfigurationType;
import com.azure.resourcemanager.databox.models.TransferType;
import com.azure.resourcemanager.databox.models.UserAssignedIdentity;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Samples for Jobs Create.
 */
public final class JobsCreateSamples {
    /*
     * x-ms-original-file:
     * specification/databox/resource-manager/Microsoft.DataBox/stable/2025-02-01/examples/JobsCreateDevicePassword.json
     */
    /**
     * Sample code: JobsCreateDevicePassword.
     * 
     * @param manager Entry point to DataBoxManager.
     */
    public static void jobsCreateDevicePassword(com.azure.resourcemanager.databox.DataBoxManager manager) {
        manager.jobs()
            .define("TestJobName1")
            .withRegion("westus")
            .withExistingResourceGroup("YourResourceGroupName")
            .withSku(new Sku().withName(SkuName.DATA_BOX).withModel(ModelName.DATA_BOX))
            .withTransferType(TransferType.IMPORT_TO_AZURE)
            .withDetails(new DataBoxJobDetails()
                .withContactDetails(new ContactDetails().withContactName("XXXX XXXX")
                    .withPhone("0000000000")
                    .withPhoneExtension("")
                    .withEmailList(Arrays.asList("xxxx@xxxx.xxx")))
                .withShippingAddress(new ShippingAddress().withStreetAddress1("XXXX XXXX")
                    .withStreetAddress2("XXXX XXXX")
                    .withCity("XXXX XXXX")
                    .withStateOrProvince("XX")
                    .withCountry("XX")
                    .withPostalCode("fakeTokenPlaceholder")
                    .withCompanyName("XXXX XXXX")
                    .withAddressType(AddressType.COMMERCIAL))
                .withDataImportDetails(Arrays.asList(new DataImportDetails()
                    .withAccountDetails(new StorageAccountDetails().withSharePassword("fakeTokenPlaceholder")
                        .withStorageAccountId(
                            "/subscriptions/YourSubscriptionId/resourceGroups/YourResourceGroupName/providers/Microsoft.Storage/storageAccounts/YourStorageAccountName"))))
                .withDevicePassword("fakeTokenPlaceholder"))
            .create();
    }

    /*
     * x-ms-original-file:
     * specification/databox/resource-manager/Microsoft.DataBox/stable/2025-02-01/examples/JobsCreate.json
     */
    /**
     * Sample code: JobsCreate.
     * 
     * @param manager Entry point to DataBoxManager.
     */
    public static void jobsCreate(com.azure.resourcemanager.databox.DataBoxManager manager) {
        manager.jobs()
            .define("TestJobName1")
            .withRegion("westus")
            .withExistingResourceGroup("YourResourceGroupName")
            .withSku(new Sku().withName(SkuName.DATA_BOX).withModel(ModelName.DATA_BOX))
            .withTransferType(TransferType.IMPORT_TO_AZURE)
            .withDetails(new DataBoxJobDetails()
                .withContactDetails(new ContactDetails().withContactName("XXXX XXXX")
                    .withPhone("0000000000")
                    .withPhoneExtension("")
                    .withEmailList(Arrays.asList("xxxx@xxxx.xxx")))
                .withShippingAddress(new ShippingAddress().withStreetAddress1("XXXX XXXX")
                    .withStreetAddress2("XXXX XXXX")
                    .withCity("XXXX XXXX")
                    .withStateOrProvince("XX")
                    .withCountry("XX")
                    .withPostalCode("fakeTokenPlaceholder")
                    .withCompanyName("XXXX XXXX")
                    .withAddressType(AddressType.COMMERCIAL))
                .withDataImportDetails(Arrays
                    .asList(new DataImportDetails().withAccountDetails(new StorageAccountDetails().withStorageAccountId(
                        "/subscriptions/YourSubscriptionId/resourcegroups/YourResourceGroupName/providers/Microsoft.Storage/storageAccounts/YourStorageAccountName")))))
            .create();
    }

    /*
     * x-ms-original-file:
     * specification/databox/resource-manager/Microsoft.DataBox/stable/2025-02-01/examples/JobsCreateDoubleEncryption.
     * json
     */
    /**
     * Sample code: JobsCreateDoubleEncryption.
     * 
     * @param manager Entry point to DataBoxManager.
     */
    public static void jobsCreateDoubleEncryption(com.azure.resourcemanager.databox.DataBoxManager manager) {
        manager.jobs()
            .define("TestJobName1")
            .withRegion("westus")
            .withExistingResourceGroup("YourResourceGroupName")
            .withSku(new Sku().withName(SkuName.DATA_BOX).withModel(ModelName.DATA_BOX))
            .withTransferType(TransferType.IMPORT_TO_AZURE)
            .withDetails(new DataBoxJobDetails()
                .withContactDetails(new ContactDetails().withContactName("XXXX XXXX")
                    .withPhone("0000000000")
                    .withPhoneExtension("")
                    .withEmailList(Arrays.asList("xxxx@xxxx.xxx")))
                .withShippingAddress(new ShippingAddress().withStreetAddress1("XXXX XXXX")
                    .withStreetAddress2("XXXX XXXX")
                    .withCity("XXXX XXXX")
                    .withStateOrProvince("XX")
                    .withCountry("XX")
                    .withPostalCode("fakeTokenPlaceholder")
                    .withCompanyName("XXXX XXXX")
                    .withAddressType(AddressType.COMMERCIAL))
                .withDataImportDetails(Arrays
                    .asList(new DataImportDetails().withAccountDetails(new StorageAccountDetails().withStorageAccountId(
                        "/subscriptions/YourSubscriptionId/resourcegroups/YourResourceGroupName/providers/Microsoft.Storage/storageAccounts/YourStorageAccountName"))))
                .withPreferences(new Preferences().withEncryptionPreferences(
                    new EncryptionPreferences().withDoubleEncryption(DoubleEncryption.ENABLED))))
            .create();
    }

    /*
     * x-ms-original-file: specification/databox/resource-manager/Microsoft.DataBox/stable/2025-02-01/examples/
     * JobsCreateWithUserAssignedIdentity.json
     */
    /**
     * Sample code: JobsCreateWithUserAssignedIdentity.
     * 
     * @param manager Entry point to DataBoxManager.
     */
    public static void jobsCreateWithUserAssignedIdentity(com.azure.resourcemanager.databox.DataBoxManager manager) {
        manager.jobs()
            .define("TestJobName1")
            .withRegion("westus")
            .withExistingResourceGroup("YourResourceGroupName")
            .withSku(new Sku().withName(SkuName.DATA_BOX).withModel(ModelName.DATA_BOX))
            .withTransferType(TransferType.IMPORT_TO_AZURE)
            .withIdentity(new ResourceIdentity().withType("UserAssigned")
                .withUserAssignedIdentities(mapOf(
                    "/subscriptions/YourSubscriptionId/resourceGroups/YourResourceGroupName/providers/Microsoft.ManagedIdentity/userAssignedIdentities/testIdentity",
                    new UserAssignedIdentity())))
            .withDetails(new DataBoxJobDetails()
                .withContactDetails(new ContactDetails().withContactName("XXXX XXXX")
                    .withPhone("0000000000")
                    .withPhoneExtension("")
                    .withEmailList(Arrays.asList("xxxx@xxxx.xxx")))
                .withShippingAddress(new ShippingAddress().withStreetAddress1("XXXX XXXX")
                    .withStreetAddress2("XXXX XXXX")
                    .withCity("XXXX XXXX")
                    .withStateOrProvince("XX")
                    .withCountry("XX")
                    .withPostalCode("fakeTokenPlaceholder")
                    .withCompanyName("XXXX XXXX")
                    .withAddressType(AddressType.COMMERCIAL))
                .withDataImportDetails(Arrays
                    .asList(new DataImportDetails().withAccountDetails(new StorageAccountDetails().withStorageAccountId(
                        "/subscriptions/YourSubscriptionId/resourceGroups/YourResourceGroupName/providers/Microsoft.Storage/storageAccounts/YourStorageAccountName")))))
            .create();
    }

    /*
     * x-ms-original-file:
     * specification/databox/resource-manager/Microsoft.DataBox/stable/2025-02-01/examples/JobsCreateExport.json
     */
    /**
     * Sample code: JobsCreateExport.
     * 
     * @param manager Entry point to DataBoxManager.
     */
    public static void jobsCreateExport(com.azure.resourcemanager.databox.DataBoxManager manager) {
        manager.jobs()
            .define("TestJobName1")
            .withRegion("westus")
            .withExistingResourceGroup("YourResourceGroupName")
            .withSku(new Sku().withName(SkuName.DATA_BOX).withModel(ModelName.DATA_BOX))
            .withTransferType(TransferType.EXPORT_FROM_AZURE)
            .withDetails(new DataBoxJobDetails()
                .withContactDetails(new ContactDetails().withContactName("XXXX XXXX")
                    .withPhone("0000000000")
                    .withPhoneExtension("")
                    .withEmailList(Arrays.asList("xxxx@xxxx.xxx")))
                .withShippingAddress(new ShippingAddress().withStreetAddress1("XXXX XXXX")
                    .withStreetAddress2("XXXX XXXX")
                    .withCity("XXXX XXXX")
                    .withStateOrProvince("XX")
                    .withCountry("XX")
                    .withPostalCode("fakeTokenPlaceholder")
                    .withCompanyName("XXXX XXXX")
                    .withAddressType(AddressType.COMMERCIAL))
                .withDataExportDetails(Arrays.asList(new DataExportDetails()
                    .withTransferConfiguration(new TransferConfiguration()
                        .withTransferConfigurationType(TransferConfigurationType.TRANSFER_ALL)
                        .withTransferAllDetails(new TransferConfigurationTransferAllDetails()
                            .withInclude(new TransferAllDetails().withDataAccountType(DataAccountType.STORAGE_ACCOUNT)
                                .withTransferAllBlobs(true)
                                .withTransferAllFiles(true))))
                    .withAccountDetails(new StorageAccountDetails().withStorageAccountId(
                        "/subscriptions/YourSubscriptionId/resourceGroups/YourResourceGroupName/providers/Microsoft.Storage/storageAccounts/YourStorageAccountName")))))
            .create();
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
