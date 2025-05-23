// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.cloud.autoconfigure.implementation.storage.blob;

import com.azure.data.appconfiguration.ConfigurationClientBuilder;
import com.azure.spring.cloud.autoconfigure.implementation.AbstractAzureServiceConfigurationTests;
import com.azure.spring.cloud.autoconfigure.implementation.TestBuilderCustomizer;
import com.azure.spring.cloud.autoconfigure.implementation.context.AzureGlobalPropertiesAutoConfiguration;
import com.azure.spring.cloud.autoconfigure.implementation.storage.blob.properties.AzureStorageBlobConnectionDetails;
import com.azure.spring.cloud.autoconfigure.implementation.storage.blob.properties.AzureStorageBlobProperties;
import com.azure.spring.cloud.service.implementation.storage.blob.BlobServiceClientBuilderFactory;
import com.azure.storage.blob.BlobAsyncClient;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceAsyncClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.BlobServiceVersion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.FilteredClassLoader;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class AzureStorageBlobAutoConfigurationTests extends AbstractAzureServiceConfigurationTests<
    BlobServiceClientBuilderFactory, AzureStorageBlobProperties> {

    private static final String STORAGE_CONNECTION_STRING_PATTERN = "DefaultEndpointsProtocol=https;AccountName=%s;AccountKey=%s;EndpointSuffix=core.windows.net";
    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
        .withConfiguration(AutoConfigurations.of(AzureGlobalPropertiesAutoConfiguration.class, AzureStorageBlobAutoConfiguration.class));

    @Override
    protected ApplicationContextRunner getMinimalContextRunner() {
        return this.contextRunner
            .withPropertyValues("spring.cloud.azure.storage.blob.account-name=test-account-name");
    }

    @Override
    protected String getPropertyPrefix() {
        return AzureStorageBlobProperties.PREFIX;
    }

    @Override
    protected Class<BlobServiceClientBuilderFactory> getBuilderFactoryType() {
        return BlobServiceClientBuilderFactory.class;
    }

    @Override
    protected Class<AzureStorageBlobProperties> getConfigurationPropertiesType() {
        return AzureStorageBlobProperties.class;
    }

    @ParameterizedTest
    @ValueSource(strings = { "spring.cloud.azure.storage.blob.account-name=test-account-name", "spring.cloud.azure.storage.account-name=test-account-name" })
    void configureWithoutBlobServiceClientBuilder(String accountNameProperty) {
        this.contextRunner
            .withClassLoader(new FilteredClassLoader(BlobServiceClientBuilder.class))
            .withPropertyValues(accountNameProperty)
            .run(context -> assertThat(context).doesNotHaveBean(BlobClientConfiguration.class));
    }

    @ParameterizedTest
    @ValueSource(strings = { "spring.cloud.azure.storage.blob.account-name=test-account-name", "spring.cloud.azure.storage.account-name=test-account-name" })
    void configureWithStorageGlobalDisabled(String accoutNameProperty) {
        this.contextRunner
            .withPropertyValues(
                "spring.cloud.azure.storage.enabled=false",
                accoutNameProperty
            )
            .run(context -> assertThat(context).doesNotHaveBean(BlobClientConfiguration.class));
    }

    @ParameterizedTest
    @ValueSource(strings = { "spring.cloud.azure.storage.blob.account-name=test-account-name", "spring.cloud.azure.storage.account-name=test-account-name" })
    void configureWithStorageBlobDisabled(String accountNameProperty) {
        this.contextRunner
            .withPropertyValues(
                "spring.cloud.azure.storage.blob.enabled=false",
                accountNameProperty
            )
            .run(context -> assertThat(context).doesNotHaveBean(BlobClientConfiguration.class));
    }

    @ParameterizedTest
    @ValueSource(strings = { "spring.cloud.azure.storage.blob.account-name=test-account-name", "spring.cloud.azure.storage.account-name=test-account-name" })
    void accountNameSetShouldConfigure(String accountNameProperty) {
        this.contextRunner
            .withPropertyValues(accountNameProperty)
            .run(context -> {
                assertThat(context).hasSingleBean(BlobClientConfiguration.class);
                assertThat(context).hasSingleBean(AzureStorageBlobProperties.class);
                assertThat(context).hasSingleBean(BlobServiceClient.class);
                assertThat(context).hasSingleBean(BlobServiceAsyncClient.class);
                assertThat(context).hasSingleBean(BlobServiceClientBuilder.class);
                assertThat(context).hasSingleBean(BlobServiceClientBuilderFactory.class);
            });
    }

    @ParameterizedTest
    @ValueSource(strings = { "spring.cloud.azure.storage.blob.account-name=test-account-name", "spring.cloud.azure.storage.account-name=test-account-name" })
    void blobNameSetShouldConfigureBlobClient(String accountNameProperty) {
        this.contextRunner
            .withPropertyValues(
                accountNameProperty,
                "spring.cloud.azure.storage.blob.container-name=container1",
                "spring.cloud.azure.storage.blob.blob-name=blob1"
            )
            .run(context -> {
                assertThat(context).hasSingleBean(BlobClient.class);
                assertThat(context).hasSingleBean(BlobAsyncClient.class);
            });
    }

    @ParameterizedTest
    @ValueSource(strings = { "spring.cloud.azure.storage.blob.account-name=test-account-name", "spring.cloud.azure.storage.account-name=test-account-name" })
    void blobNameNotSetShouldNotConfigureBlobClient(String accountNameProperty) {
        this.contextRunner
            .withPropertyValues(
                accountNameProperty,
                "spring.cloud.azure.storage.blob.container-name=container1"
            )
            .run(context -> {
                assertThat(context).doesNotHaveBean(BlobClient.class);
                assertThat(context).doesNotHaveBean(BlobAsyncClient.class);
            });
    }

    @ParameterizedTest
    @ValueSource(strings = { "spring.cloud.azure.storage.blob.account-name=test-account-name", "spring.cloud.azure.storage.account-name=test-account-name" })
    void containerNameSetShouldConfigureContainerClient(String accountNameProperty) {
        this.contextRunner
            .withPropertyValues(
                accountNameProperty,
                "spring.cloud.azure.storage.blob.container-name=container1"
            )
            .run(context -> {
                assertThat(context).hasSingleBean(BlobContainerClient.class);
                assertThat(context).hasSingleBean(BlobContainerAsyncClient.class);
            });
    }

    @ParameterizedTest
    @ValueSource(strings = { "spring.cloud.azure.storage.blob.account-name=test-account-name", "spring.cloud.azure.storage.account-name=test-account-name" })
    void containerNameNotSetShouldNotConfigureContainerClient(String accountNameProperty) {
        this.contextRunner
            .withPropertyValues(accountNameProperty)
            .run(context -> {
                assertThat(context).doesNotHaveBean(BlobContainerClient.class);
                assertThat(context).doesNotHaveBean(BlobContainerAsyncClient.class);
            });
    }

    @ParameterizedTest
    @ValueSource(strings = { "spring.cloud.azure.storage.blob.account-name=test-account-name", "spring.cloud.azure.storage.account-name=test-account-name" })
    void customizerShouldBeCalled(String accountNameProperty) {
        BlobServiceClientBuilderCustomizer customizer = new BlobServiceClientBuilderCustomizer();
        this.contextRunner
            .withPropertyValues(accountNameProperty)
            .withBean("customizer1", BlobServiceClientBuilderCustomizer.class, () -> customizer)
            .withBean("customizer2", BlobServiceClientBuilderCustomizer.class, () -> customizer)
            .run(context -> assertThat(customizer.getCustomizedTimes()).isEqualTo(2));
    }

    @ParameterizedTest
    @ValueSource(strings = { "spring.cloud.azure.storage.blob.account-name=test-account-name", "spring.cloud.azure.storage.account-name=test-account-name" })
    void otherCustomizerShouldNotBeCalled(String accountNameProperty) {
        BlobServiceClientBuilderCustomizer customizer = new BlobServiceClientBuilderCustomizer();
        OtherBuilderCustomizer otherBuilderCustomizer = new OtherBuilderCustomizer();
        this.contextRunner
            .withPropertyValues(accountNameProperty)
            .withBean("customizer1", BlobServiceClientBuilderCustomizer.class, () -> customizer)
            .withBean("customizer2", BlobServiceClientBuilderCustomizer.class, () -> customizer)
            .withBean("customizer3", OtherBuilderCustomizer.class, () -> otherBuilderCustomizer)
            .run(context -> {
                assertThat(customizer.getCustomizedTimes()).isEqualTo(2);
                assertThat(otherBuilderCustomizer.getCustomizedTimes()).isEqualTo(0);
            });
    }

    @Test
    void configurationPropertiesShouldBind() {
        String accountName = "test-account-name";
        String connectionString = String.format(STORAGE_CONNECTION_STRING_PATTERN, accountName, "test-key");
        String endpoint = String.format("https://%s.blob.core.windows.net", accountName);
        String customerProvidedKey = "fakekey";
        this.contextRunner
            .withPropertyValues(
                "spring.cloud.azure.storage.blob.endpoint=" + endpoint,
                "spring.cloud.azure.storage.blob.account-key=test-key",
                "spring.cloud.azure.storage.blob.sas-token=test-sas-token",
                "spring.cloud.azure.storage.blob.connection-string=" + connectionString,
                "spring.cloud.azure.storage.blob.account-name=test-account-name",
                "spring.cloud.azure.storage.blob.customer-provided-key=" + customerProvidedKey,
                "spring.cloud.azure.storage.blob.encryption-scope=test-scope",
                "spring.cloud.azure.storage.blob.service-version=V2020_08_04",
                "spring.cloud.azure.storage.blob.container-name=test-container",
                "spring.cloud.azure.storage.blob.blob-name=test-blob"
            )
            .withBean(BlobServiceAsyncClient.class, () -> mock(BlobServiceAsyncClient.class))
            .withBean(BlobServiceClient.class, () -> mock(BlobServiceClient.class))
            .withBean(BlobAsyncClient.class, () -> mock(BlobAsyncClient.class))
            .withBean(BlobClient.class, () -> mock(BlobClient.class))
            .run(context -> {
                assertThat(context).hasSingleBean(AzureStorageBlobProperties.class);
                AzureStorageBlobProperties properties = context.getBean(AzureStorageBlobProperties.class);
                assertEquals(endpoint, properties.getEndpoint());
                assertEquals("test-key", properties.getAccountKey());
                assertEquals("test-sas-token", properties.getSasToken());
                assertEquals(connectionString, properties.getConnectionString());
                assertEquals(accountName, properties.getAccountName());
                assertEquals(customerProvidedKey, properties.getCustomerProvidedKey());
                assertEquals("test-scope", properties.getEncryptionScope());
                assertEquals(BlobServiceVersion.V2020_08_04, properties.getServiceVersion());
                assertEquals("test-container", properties.getContainerName());
                assertEquals("test-blob", properties.getBlobName());
            });
    }

    @Test
    void connectionDetailsHasHigherPriority() {
        String connectionString = String.format(STORAGE_CONNECTION_STRING_PATTERN, "property-account-name", "property-test-key");
        this.contextRunner
            .withPropertyValues(
                "spring.cloud.azure.storage.blob.connection-string=" + connectionString
            )
            .withBean(BlobServiceAsyncClient.class, () -> mock(BlobServiceAsyncClient.class))
            .withBean(BlobServiceClient.class, () -> mock(BlobServiceClient.class))
            .withBean(BlobAsyncClient.class, () -> mock(BlobAsyncClient.class))
            .withBean(BlobClient.class, () -> mock(BlobClient.class))
            .withBean(AzureStorageBlobConnectionDetails.class, CustomAzureStorageBlobConnectionDetails::new)
            .run(context -> {
                assertThat(context).hasSingleBean(AzureStorageBlobProperties.class);
                AzureStorageBlobProperties properties = context.getBean(AzureStorageBlobProperties.class);
                assertEquals(CustomAzureStorageBlobConnectionDetails.CONNECTION_STRING, properties.getConnectionString());
            });
    }

    private static class BlobServiceClientBuilderCustomizer extends TestBuilderCustomizer<BlobServiceClientBuilder> {

    }

    private static class OtherBuilderCustomizer extends TestBuilderCustomizer<ConfigurationClientBuilder> {

    }

    static class CustomAzureStorageBlobConnectionDetails implements AzureStorageBlobConnectionDetails {
        static final String CONNECTION_STRING = String.format(STORAGE_CONNECTION_STRING_PATTERN, "custom-account-name", "custom-test-key");

        @Override
        public String getConnectionString() {
            return CONNECTION_STRING;
        }
    }

}
