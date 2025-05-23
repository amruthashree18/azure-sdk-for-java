// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.security.keyvault.secrets;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceModifiedException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.polling.LongRunningOperationStatus;
import com.azure.core.util.polling.PollResponse;
import com.azure.core.util.polling.PollingContext;
import com.azure.core.util.polling.SyncPoller;
import com.azure.security.keyvault.secrets.implementation.SecretClientImpl;
import com.azure.security.keyvault.secrets.implementation.models.BackupSecretResult;
import com.azure.security.keyvault.secrets.implementation.models.DeletedSecretBundle;
import com.azure.security.keyvault.secrets.implementation.models.DeletedSecretItem;
import com.azure.security.keyvault.secrets.implementation.models.SecretBundle;
import com.azure.security.keyvault.secrets.implementation.models.SecretItem;
import com.azure.security.keyvault.secrets.implementation.models.SecretRestoreParameters;
import com.azure.security.keyvault.secrets.implementation.models.SecretSetParameters;
import com.azure.security.keyvault.secrets.implementation.models.SecretUpdateParameters;
import com.azure.security.keyvault.secrets.models.DeletedSecret;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import com.azure.security.keyvault.secrets.models.SecretProperties;

import java.time.Duration;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.azure.security.keyvault.secrets.SecretAsyncClient.EMPTY_OPTIONS;
import static com.azure.security.keyvault.secrets.implementation.models.SecretsModelsUtils.createDeletedSecret;
import static com.azure.security.keyvault.secrets.implementation.models.SecretsModelsUtils.createKeyVaultSecret;
import static com.azure.security.keyvault.secrets.implementation.models.SecretsModelsUtils.createSecretAttributes;
import static com.azure.security.keyvault.secrets.implementation.models.SecretsModelsUtils.createSecretProperties;

/**
 * The SecretClient provides synchronous methods to manage {@link KeyVaultSecret secrets} in the Azure Key Vault. The
 * client supports creating, retrieving, updating, deleting, purging, backing up, restoring, and listing the
 * {@link KeyVaultSecret secrets}. The client also supports listing {@link DeletedSecret deleted secrets} for a
 * soft-delete enabled key vault.
 *
 * <h2>Getting Started</h2>
 *
 * <p>In order to interact with the Azure Key Vault service, you will need to create an instance of the
 * {@link SecretClient} class, a vault url and a credential object.</p>
 *
 * <p>The examples shown in this document use a credential object named DefaultAzureCredential for authentication,
 * which is appropriate for most scenarios, including local development and production environments. Additionally,
 * we recommend using a
 * <a href="https://learn.microsoft.com/azure/active-directory/managed-identities-azure-resources/">
 * managed identity</a> for authentication in production environments.
 * You can find more information on different ways of authenticating and their corresponding credential types in the
 * <a href="https://learn.microsoft.com/java/api/overview/azure/identity-readme?view=azure-java-stable">
 *     Azure Identity documentation"</a>.</p>
 *
 * <p><strong>Sample: Construct Synchronous Secret client</strong></p>
 * <!-- src_embed com.azure.security.keyvault.SecretClient.instantiation -->
 * <pre>
 * SecretClient secretClient = new SecretClientBuilder&#40;&#41;
 *     .credential&#40;new DefaultAzureCredentialBuilder&#40;&#41;.build&#40;&#41;&#41;
 *     .vaultUrl&#40;&quot;&lt;your-key-vault-url&gt;&quot;&#41;
 *     .buildClient&#40;&#41;;
 * </pre>
 * <!-- end com.azure.security.keyvault.SecretClient.instantiation -->
 *
 * <br/>
 *
 * <hr/>
 *
 * <h2>Create a Secret</h2>
 * The {@link SecretClient} can be used to create a secret in the key vault.
 *
 * <p><strong>Code Sample:</strong></p>
 * <p>The following code sample demonstrates how to synchronously create and store a secret in the key vault,
 * using the {@link SecretClient#setSecret(String, String)} API.</p>
 *
 * <!-- src_embed com.azure.security.keyvault.SecretClient.setSecret#string-string -->
 * <pre>
 * KeyVaultSecret secret = secretClient.setSecret&#40;&quot;secretName&quot;, &quot;secretValue&quot;&#41;;
 * System.out.printf&#40;&quot;Secret is created with name %s and value %s%n&quot;, secret.getName&#40;&#41;, secret.getValue&#40;&#41;&#41;;
 * </pre>
 * <!-- end com.azure.security.keyvault.SecretClient.setSecret#string-string -->
 *
 * <p><strong>Note:</strong> For the asynchronous sample, refer to
 * {@link com.azure.security.keyvault.secrets.SecretAsyncClient}.</p>
 *
 * <br/>
 *
 * <hr/>
 *
 * <h2>Get a Secret</h2>
 * The {@link SecretClient} can be used to retrieve a secret from the key vault.
 *
 * <p><strong>Code Sample:</strong></p>
 * <p>The following code sample demonstrates how to synchronously retrieve a previously stored secret from the Azure
 * KeyVault, using the {@link SecretClient#getSecret(String)} API.</p>
 *
 * <!-- src_embed com.azure.security.keyvault.SecretClient.getSecret#string -->
 * <pre>
 * KeyVaultSecret secret = secretClient.getSecret&#40;&quot;secretName&quot;&#41;;
 * System.out.printf&#40;&quot;Secret is returned with name %s and value %s%n&quot;,
 *     secret.getName&#40;&#41;, secret.getValue&#40;&#41;&#41;;
 * </pre>
 * <!-- end com.azure.security.keyvault.SecretClient.getSecret#string -->
 *
 * <p><strong>Note:</strong> For the asynchronous sample, refer to {@link SecretAsyncClient}.</p>
 *
 * <br/>
 *
 * <hr/>
 *
 * <h2>Delete a Secret</h2>
 * The {@link SecretClient} can be used to delete a secret from the key vault.
 *
 * <p><strong>Code Sample:</strong></p>
 * <p>The following code sample demonstrates how to delete a secret from the key vault, using
 * the {@link SecretClient#beginDeleteSecret(String)} API.</p>
 *
 * <!-- src_embed com.azure.security.keyvault.SecretClient.deleteSecret#String -->
 * <pre>
 * SyncPoller&lt;DeletedSecret, Void&gt; deleteSecretPoller = secretClient.beginDeleteSecret&#40;&quot;secretName&quot;&#41;;
 *
 * &#47;&#47; Deleted Secret is accessible as soon as polling begins.
 * PollResponse&lt;DeletedSecret&gt; deleteSecretPollResponse = deleteSecretPoller.poll&#40;&#41;;
 *
 * &#47;&#47; Deletion date only works for a SoftDelete-enabled Key Vault.
 * System.out.println&#40;&quot;Deleted Date  %s&quot; + deleteSecretPollResponse.getValue&#40;&#41;
 *     .getDeletedOn&#40;&#41;.toString&#40;&#41;&#41;;
 * System.out.printf&#40;&quot;Deleted Secret's Recovery Id %s&quot;, deleteSecretPollResponse.getValue&#40;&#41;
 *     .getRecoveryId&#40;&#41;&#41;;
 *
 * &#47;&#47; Secret is being deleted on server.
 * deleteSecretPoller.waitForCompletion&#40;&#41;;
 * </pre>
 * <!-- end com.azure.security.keyvault.SecretClient.deleteSecret#String -->
 *
 * <p><strong>Note:</strong> For the asynchronous sample, refer to {@link SecretAsyncClient}.</p>
 *
 * @see SecretClientBuilder
 * @see SyncPoller
 * @see PagedIterable
 */
@ServiceClient(builder = SecretClientBuilder.class, serviceInterfaces = SecretClientImpl.SecretClientService.class)
public final class SecretClient {
    private static final ClientLogger LOGGER = new ClientLogger(SecretClient.class);
    private final SecretClientImpl implClient;
    private final String vaultUrl;

    /**
     * Gets the vault endpoint url to which service requests are sent to.
     * @return the vault endpoint url.
     */
    public String getVaultUrl() {
        return vaultUrl;
    }

    /**
     * Creates a SecretClient to service requests
     *
     * @param implClient The implementation client.
     * @param vaultUrl The vault url.
     */
    SecretClient(SecretClientImpl implClient, String vaultUrl) {
        this.implClient = implClient;
        this.vaultUrl = vaultUrl;
    }

    /**
     * Adds a secret to the key vault if it does not exist. If the named secret exists, a new version of the secret is
     * created. This operation requires the {@code secrets/set} permission.
     *
     * <p>The {@link SecretProperties#getExpiresOn() expires}, {@link SecretProperties#getContentType() contentType},
     * and {@link SecretProperties#getNotBefore() notBefore} values in {@code secret} are optional.
     * If not specified, {@link SecretProperties#isEnabled() enabled} is set to true by key vault.</p>
     *
     * <p><strong>Code sample</strong></p>
     * <p>Creates a new secret in the key vault. Prints out the details of the newly created secret returned in the
     * response.</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.setSecret#secret -->
     * <pre>
     * KeyVaultSecret newSecret = new KeyVaultSecret&#40;&quot;secretName&quot;, &quot;secretValue&quot;&#41;
     *     .setProperties&#40;new SecretProperties&#40;&#41;.setExpiresOn&#40;OffsetDateTime.now&#40;&#41;.plusDays&#40;60&#41;&#41;&#41;;
     * KeyVaultSecret returnedSecret = secretClient.setSecret&#40;newSecret&#41;;
     * System.out.printf&#40;&quot;Secret is created with name %s and value %s%n&quot;, returnedSecret.getName&#40;&#41;,
     *     returnedSecret.getValue&#40;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.setSecret#secret -->
     *
     * @param secret The Secret object containing information about the secret and its properties. The properties
     * {@link KeyVaultSecret#getName() secret.name} and {@link KeyVaultSecret#getValue() secret.value} cannot be null.
     * @return The {@link KeyVaultSecret created secret}.
     * @throws NullPointerException if {@code secret} is {@code null}.
     * @throws ResourceModifiedException if {@code secret} is malformed.
     * @throws HttpResponseException if {@link KeyVaultSecret#getName() name} or {@link KeyVaultSecret#getValue() value}
     * is an empty string.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public KeyVaultSecret setSecret(KeyVaultSecret secret) {
        return callWithMappedException(() -> createKeyVaultSecret(
            implClient
                .setSecretWithResponse(secret.getName(), BinaryData.fromObject(prepareSecretSetParameters(secret)),
                    EMPTY_OPTIONS)
                .getValue()
                .toObject(SecretBundle.class)),
            SecretAsyncClient::mapSetSecretException);
    }

    /**
     * Adds a secret to the key vault if it does not exist. If the named secret exists, a new version of the secret is
     * created. This operation requires the {@code secrets/set} permission.
     *
     * <p><strong>Code sample</strong></p>
     * <p>Creates a new secret in the key vault. Prints out the details of the newly created secret returned in the
     * response.</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.setSecret#string-string -->
     * <pre>
     * KeyVaultSecret secret = secretClient.setSecret&#40;&quot;secretName&quot;, &quot;secretValue&quot;&#41;;
     * System.out.printf&#40;&quot;Secret is created with name %s and value %s%n&quot;, secret.getName&#40;&#41;, secret.getValue&#40;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.setSecret#string-string -->
     *
     * @param name The name of the secret. It is required and cannot be null.
     * @param value The value of the secret. It is required and cannot be null.
     * @return The {@link KeyVaultSecret created secret}.
     * @throws ResourceModifiedException if invalid {@code name} or {@code value} is specified.
     * @throws HttpResponseException if {@code name} or {@code value} is empty string.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public KeyVaultSecret setSecret(String name, String value) {
        return callWithMappedException(() -> createKeyVaultSecret(
            implClient.setSecretWithResponse(name, BinaryData.fromObject(new SecretSetParameters(value)), EMPTY_OPTIONS)
                .getValue()
                .toObject(SecretBundle.class)),
            SecretAsyncClient::mapSetSecretException);
    }

    /**
     * Adds a secret to the key vault if it does not exist. If the named secret exists, a new version of the secret is
     * created. This operation requires the {@code secrets/set} permission.
     *
     * <p><strong>Code sample</strong></p>
     * <p>Creates a new secret in the key vault. Prints out the details of the newly created secret returned in the
     * response.</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.setSecretWithResponse#secret-Context -->
     * <pre>
     * KeyVaultSecret newSecret = new KeyVaultSecret&#40;&quot;secretName&quot;, &quot;secretValue&quot;&#41;
     *     .setProperties&#40;new SecretProperties&#40;&#41;.setExpiresOn&#40;OffsetDateTime.now&#40;&#41;.plusDays&#40;60&#41;&#41;&#41;;
     * KeyVaultSecret secret = secretClient.setSecretWithResponse&#40;newSecret, new Context&#40;key1, value1&#41;&#41;.getValue&#40;&#41;;
     * System.out.printf&#40;&quot;Secret is created with name %s and value %s%n&quot;, secret.getName&#40;&#41;, secret.getValue&#40;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.setSecretWithResponse#secret-Context -->
     *
     * @param secret The Secret object containing information about the secret and its properties. The properties
     * secret.name and secret.value must be non null.
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     * @return A {@link Response} whose {@link Response#getValue() value} contains the
     * {@link KeyVaultSecret created secret}.
     * @throws ResourceModifiedException if invalid {@code name} or {@code value} is specified.
     * @throws HttpResponseException if {@code name} or {@code value} is empty string.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<KeyVaultSecret> setSecretWithResponse(KeyVaultSecret secret, Context context) {
        return callWithMappedException(() -> {
            Response<BinaryData> response = implClient.setSecretWithResponse(secret.getName(),
                BinaryData.fromObject(prepareSecretSetParameters(secret)), new RequestOptions().setContext(context));

            return new SimpleResponse<>(response,
                createKeyVaultSecret(response.getValue().toObject(SecretBundle.class)));
        }, SecretAsyncClient::mapSetSecretException);
    }

    static SecretSetParameters prepareSecretSetParameters(KeyVaultSecret secret) {
        SecretSetParameters secretSetParameters = new SecretSetParameters(secret.getValue());
        SecretProperties secretProperties = secret.getProperties();

        if (secretProperties != null) {
            secretSetParameters.setTags(secretProperties.getTags())
                .setContentType(secretProperties.getContentType())
                .setSecretAttributes(createSecretAttributes(secretProperties));
        }

        return secretSetParameters;
    }

    /**
     * Gets the latest version of the specified secret from the key vault.
     * This operation requires the {@code secrets/get} permission.
     *
     * <p><strong>Code sample</strong></p>
     * <p>Gets the latest version of the secret in the key vault. Prints out the details of the returned secret.</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.getSecret#string -->
     * <pre>
     * KeyVaultSecret secret = secretClient.getSecret&#40;&quot;secretName&quot;&#41;;
     * System.out.printf&#40;&quot;Secret is returned with name %s and value %s%n&quot;,
     *     secret.getName&#40;&#41;, secret.getValue&#40;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.getSecret#string -->
     *
     * @param name The name of the secret.
     * @return The requested {@link KeyVaultSecret}.
     * @throws ResourceNotFoundException When a secret with the given  {@code name} doesn't exist in the vault.
     * @throws IllegalArgumentException If {@code name} is either {@code null} or empty.
     * @throws HttpResponseException If the server reports an error when executing the request.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public KeyVaultSecret getSecret(String name) {
        if (CoreUtils.isNullOrEmpty(name)) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'name' cannot be null or empty."));
        }

        return callWithMappedException(
            () -> createKeyVaultSecret(
                implClient.getSecretWithResponse(name, "", EMPTY_OPTIONS).getValue().toObject(SecretBundle.class)),
            SecretAsyncClient::mapGetSecretException);
    }

    /**
     * Gets the specified secret with specified version from the key vault. This operation requires the
     * {@code secrets/get} permission.
     *
     * <p><strong>Code sample</strong></p>
     * <p>Gets a specific version of the secret in the key vault. Prints out the details of the returned secret.</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.getSecret#string-string -->
     * <pre>
     * String secretVersion = &quot;6A385B124DEF4096AF1361A85B16C204&quot;;
     * KeyVaultSecret secretWithVersion = secretClient.getSecret&#40;&quot;secretName&quot;, secretVersion&#41;;
     * System.out.printf&#40;&quot;Secret is returned with name %s and value %s%n&quot;,
     *     secretWithVersion.getName&#40;&#41;, secretWithVersion.getValue&#40;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.getSecret#string-string -->
     *
     * @param name The name of the secret, cannot be null.
     * @param version The version of the secret to retrieve. If this is an empty string or null, this call is
     * equivalent to calling {@link #getSecret(String)}, with the latest version being retrieved.
     * @return The requested {@link KeyVaultSecret secret}.
     * @throws ResourceNotFoundException When a secret with the given {@code name} and {@code version} doesn't exist in
     * the vault.
     * @throws IllegalArgumentException If {@code name} is either {@code null} or empty.
     * @throws HttpResponseException If the server reports an error when executing the request.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public KeyVaultSecret getSecret(String name, String version) {
        if (CoreUtils.isNullOrEmpty(name)) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'name' cannot be null or empty."));
        }

        return callWithMappedException(
            () -> createKeyVaultSecret(
                implClient.getSecretWithResponse(name, version, EMPTY_OPTIONS).getValue().toObject(SecretBundle.class)),
            SecretAsyncClient::mapGetSecretException);
    }

    /**
     * Gets the specified secret with specified version from the key vault. This operation requires the
     * {@code secrets/get} permission.
     *
     * <p><strong>Code sample</strong></p>
     * <p>Gets a specific version of the secret in the key vault. Prints out the details of the returned secret.</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.getSecretWithResponse#string-string-Context -->
     * <pre>
     * String secretVersion = &quot;6A385B124DEF4096AF1361A85B16C204&quot;;
     * KeyVaultSecret secretWithVersion = secretClient.getSecretWithResponse&#40;&quot;secretName&quot;, secretVersion,
     *     new Context&#40;key2, value2&#41;&#41;.getValue&#40;&#41;;
     * System.out.printf&#40;&quot;Secret is returned with name %s and value %s%n&quot;,
     *     secretWithVersion.getName&#40;&#41;, secretWithVersion.getValue&#40;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.getSecretWithResponse#string-string-Context -->
     *
     * @param name The name of the secret, cannot be null
     * @param version The version of the secret to retrieve. If this is an empty string or null, this call is equivalent
     * to calling {@link #getSecret(String)}, with the latest version being retrieved.
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     * @return A {@link Response} whose {@link Response#getValue() value} contains the requested {@link KeyVaultSecret}.
     * @throws ResourceNotFoundException When a secret with the given {@code name} and {@code version} doesn't exist in
     * the vault.
     * @throws IllegalArgumentException If {@code name} is either {@code null} or empty.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<KeyVaultSecret> getSecretWithResponse(String name, String version, Context context) {
        if (CoreUtils.isNullOrEmpty(name)) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'name' cannot be null or empty."));
        }

        return callWithMappedException(() -> {
            Response<BinaryData> response
                = implClient.getSecretWithResponse(name, version, new RequestOptions().setContext(context));

            return new SimpleResponse<>(response,
                createKeyVaultSecret(response.getValue().toObject(SecretBundle.class)));
        }, SecretAsyncClient::mapGetSecretException);
    }

    /**
     * Updates the attributes associated with the secret. The value of the secret in the key vault cannot be changed.
     * Only attributes populated in {@code secretProperties} are changed. Attributes not specified in the request are
     * not changed. This operation requires the {@code secrets/set} permission.
     *
     * <p>The {@code secret} is required and its fields {@link SecretProperties#getName() name} and
     * {@link SecretProperties#getVersion() version} cannot be null.</p>
     *
     * <p><strong>Code sample</strong></p>
     * <p>Gets the latest version of the secret, changes its expiry time, and the updates the secret in the key
     * vault.</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.updateSecretProperties#secretProperties -->
     * <pre>
     * SecretProperties secretProperties = secretClient.getSecret&#40;&quot;secretName&quot;&#41;.getProperties&#40;&#41;;
     * secretProperties.setExpiresOn&#40;OffsetDateTime.now&#40;&#41;.plusDays&#40;60&#41;&#41;;
     * SecretProperties updatedSecretProperties = secretClient.updateSecretProperties&#40;secretProperties&#41;;
     * KeyVaultSecret updatedSecret = secretClient.getSecret&#40;updatedSecretProperties.getName&#40;&#41;&#41;;
     * System.out.printf&#40;&quot;Updated Secret is returned with name %s, value %s and expires %s%n&quot;,
     *     updatedSecret.getName&#40;&#41;, updatedSecret.getValue&#40;&#41;, updatedSecret.getProperties&#40;&#41;.getExpiresOn&#40;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.updateSecretProperties#secretProperties -->
     *
     * @param secretProperties The {@link SecretProperties secret properties} object with updated properties.
     * @return The {@link SecretProperties updated secret}.
     * @throws NullPointerException if {@code secret} is {@code null}.
     * @throws ResourceNotFoundException when a secret with {@link SecretProperties#getName() name} and
     * {@link SecretProperties#getVersion() version} doesn't exist in the key vault.
     * @throws HttpResponseException if {@link SecretProperties#getName() name} or
     * {@link SecretProperties#getVersion() version} is empty string.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SecretProperties updateSecretProperties(SecretProperties secretProperties) {
        return createSecretProperties(implClient
            .updateSecretWithResponse(secretProperties.getName(), secretProperties.getVersion(),
                BinaryData.fromObject(prepareUpdateSecretParameters(secretProperties)), EMPTY_OPTIONS)
            .getValue()
            .toObject(SecretBundle.class));
    }

    /**
     * Updates the attributes associated with the secret. The value of the secret in the key vault cannot be changed.
     * Only attributes populated in {@code secretProperties} are changed. Attributes not specified in the request are
     * not changed. This operation requires the {@code secrets/set} permission.
     *
     * <p>The {@code secret} is required and its fields {@link SecretProperties#getName() name} and
     * {@link SecretProperties#getVersion() version} cannot be null.</p>
     *
     * <p><strong>Code sample</strong></p>
     * <p>Gets the latest version of the secret, changes its expiry time, and the updates the secret in the key vault.
     * </p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.updateSecretPropertiesWithResponse#secretProperties-Context -->
     * <pre>
     * SecretProperties secretProperties = secretClient.getSecret&#40;&quot;secretName&quot;&#41;.getProperties&#40;&#41;;
     * secretProperties.setExpiresOn&#40;OffsetDateTime.now&#40;&#41;.plusDays&#40;60&#41;&#41;;
     * SecretProperties updatedSecretBase = secretClient.updateSecretPropertiesWithResponse&#40;secretProperties,
     *     new Context&#40;key2, value2&#41;&#41;.getValue&#40;&#41;;
     * KeyVaultSecret updatedSecret = secretClient.getSecret&#40;updatedSecretBase.getName&#40;&#41;&#41;;
     * System.out.printf&#40;&quot;Updated Secret is returned with name %s, value %s and expires %s%n&quot;,
     *     updatedSecret.getName&#40;&#41;, updatedSecret.getValue&#40;&#41;, updatedSecret.getProperties&#40;&#41;.getExpiresOn&#40;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.updateSecretPropertiesWithResponse#secretProperties-Context -->
     *
     * @param secretProperties The {@link SecretProperties secret properties} object with updated properties.
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     * @return A {@link Response} whose {@link Response#getValue() value} contains the
     * {@link SecretProperties updated secret}.
     * @throws NullPointerException if {@code secret} is {@code null}.
     * @throws ResourceNotFoundException when a secret with {@link SecretProperties#getName() name} and
     * {@link SecretProperties#getVersion() version} doesn't exist in the key vault.
     * @throws HttpResponseException if {@link SecretProperties#getName() name} or
     * {@link SecretProperties#getVersion() version} is an empty string.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<SecretProperties> updateSecretPropertiesWithResponse(SecretProperties secretProperties,
        Context context) {

        Response<BinaryData> response = implClient.updateSecretWithResponse(secretProperties.getName(),
            secretProperties.getVersion(), BinaryData.fromObject(prepareUpdateSecretParameters(secretProperties)),
            new RequestOptions().setContext(context));

        return new SimpleResponse<>(response, createSecretProperties(response.getValue().toObject(SecretBundle.class)));
    }

    static SecretUpdateParameters prepareUpdateSecretParameters(SecretProperties secretProperties) {
        SecretUpdateParameters secretUpdateParameters = new SecretUpdateParameters();

        if (secretProperties != null) {
            secretUpdateParameters.setTags(secretProperties.getTags())
                .setContentType(secretProperties.getContentType())
                .setSecretAttributes(createSecretAttributes(secretProperties));
        }

        return secretUpdateParameters;
    }

    /**
     * Deletes a secret from the key vault. If soft-delete is enabled on the key vault then the secret is placed in the
     * deleted state and for permanent deletion, needs to be purged. Otherwise, the secret is permanently deleted.
     * All versions of a secret are deleted. This cannot be applied to individual versions of a secret.
     * This operation requires the {@code secrets/delete} permission.
     *
     * <p><strong>Code sample</strong></p>
     * <p>Deletes the secret from a soft-delete enabled key vault. Prints out the recovery id of the deleted secret
     * returned in the response.</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.deleteSecret#String -->
     * <pre>
     * SyncPoller&lt;DeletedSecret, Void&gt; deleteSecretPoller = secretClient.beginDeleteSecret&#40;&quot;secretName&quot;&#41;;
     *
     * &#47;&#47; Deleted Secret is accessible as soon as polling begins.
     * PollResponse&lt;DeletedSecret&gt; deleteSecretPollResponse = deleteSecretPoller.poll&#40;&#41;;
     *
     * &#47;&#47; Deletion date only works for a SoftDelete-enabled Key Vault.
     * System.out.println&#40;&quot;Deleted Date  %s&quot; + deleteSecretPollResponse.getValue&#40;&#41;
     *     .getDeletedOn&#40;&#41;.toString&#40;&#41;&#41;;
     * System.out.printf&#40;&quot;Deleted Secret's Recovery Id %s&quot;, deleteSecretPollResponse.getValue&#40;&#41;
     *     .getRecoveryId&#40;&#41;&#41;;
     *
     * &#47;&#47; Secret is being deleted on server.
     * deleteSecretPoller.waitForCompletion&#40;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.deleteSecret#String -->
     *
     * @param name The name of the secret to be deleted.
     * @return A {@link SyncPoller} to poll on and retrieve the {@link DeletedSecret deleted secret}.
     * @throws ResourceNotFoundException when a secret with {@code name} doesn't exist in the key vault.
     * @throws HttpResponseException when a secret with {@code name} is empty string.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    public SyncPoller<DeletedSecret, Void> beginDeleteSecret(String name) {
        return SyncPoller.createPoller(Duration.ofSeconds(1), deleteActivationOperation(name),
            deletePollOperation(name), (context, response) -> null, context -> null);
    }

    private Function<PollingContext<DeletedSecret>, PollResponse<DeletedSecret>>
        deleteActivationOperation(String name) {
        return pollingContext -> new PollResponse<>(LongRunningOperationStatus.NOT_STARTED, createDeletedSecret(
            implClient.deleteSecretWithResponse(name, EMPTY_OPTIONS).getValue().toObject(DeletedSecretBundle.class)));
    }

    private Function<PollingContext<DeletedSecret>, PollResponse<DeletedSecret>> deletePollOperation(String name) {
        return pollingContext -> {
            try {
                return new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                    createDeletedSecret(implClient.getDeletedSecretWithResponse(name, EMPTY_OPTIONS)
                        .getValue()
                        .toObject(DeletedSecretBundle.class)));
            } catch (HttpResponseException e) {
                if (e.getResponse().getStatusCode() == 404) {
                    return new PollResponse<>(LongRunningOperationStatus.IN_PROGRESS,
                        pollingContext.getLatestResponse().getValue());
                } else {
                    // This means either vault has soft-delete disabled or permission is not granted for the get deleted
                    // key operation. In both cases deletion operation was successful when activation operation
                    // succeeded before reaching here.
                    return new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                        pollingContext.getLatestResponse().getValue());
                }
            } catch (Exception e) {
                // This means either vault has soft-delete disabled or permission is not granted for the get deleted
                // key operation. In both cases deletion operation was successful when activation operation
                // succeeded before reaching here.
                return new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                    pollingContext.getLatestResponse().getValue());
            }
        };
    }

    /**
     * Gets a secret that has been deleted for a soft-delete enabled key vault. This operation requires the
     * {@code secrets/list} permission.
     *
     * <p><strong>Code sample</strong></p>
     * <p>Gets the deleted secret from the key vault <b>enabled for soft-delete</b>. Prints out the details of the
     * deleted secret returned in the response.</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.getDeletedSecret#string -->
     * <pre>
     * DeletedSecret deletedSecret = secretClient.getDeletedSecret&#40;&quot;secretName&quot;&#41;;
     * System.out.printf&#40;&quot;Deleted Secret's Recovery Id %s&quot;, deletedSecret.getRecoveryId&#40;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.getDeletedSecret#string -->
     *
     * @param name The name of the deleted secret.
     * @return The {@link DeletedSecret deleted secret}.
     * @throws ResourceNotFoundException when a secret with {@code name} doesn't exist in the key vault.
     * @throws HttpResponseException when a secret with {@code name} is empty string.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public DeletedSecret getDeletedSecret(String name) {
        return createDeletedSecret(implClient.getDeletedSecretWithResponse(name, EMPTY_OPTIONS)
            .getValue()
            .toObject(DeletedSecretBundle.class));
    }

    /**
     * Gets a secret that has been deleted for a soft-delete enabled key vault. This operation requires the
     * {@code secrets/list} permission.
     *
     * <p><strong>Code sample</strong></p>
     * <p>Gets the deleted secret from the key vault <b>enabled for soft-delete</b>. Prints out the details of the
     * deleted secret returned in the response.</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.getDeletedSecretWithResponse#string-Context -->
     * <pre>
     * DeletedSecret deletedSecret = secretClient.getDeletedSecretWithResponse&#40;&quot;secretName&quot;,
     *     new Context&#40;key2, value2&#41;&#41;.getValue&#40;&#41;;
     * System.out.printf&#40;&quot;Deleted Secret's Recovery Id %s&quot;, deletedSecret.getRecoveryId&#40;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.getDeletedSecretWithResponse#string-Context -->
     *
     * @param name The name of the deleted secret.
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     * @return A {@link Response} whose {@link Response#getValue() value} contains the {@link DeletedSecret deleted
     * secret}.
     * @throws ResourceNotFoundException when a secret with {@code name} doesn't exist in the key vault.
     * @throws HttpResponseException when a secret with {@code name} is empty string.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<DeletedSecret> getDeletedSecretWithResponse(String name, Context context) {
        Response<BinaryData> response
            = implClient.getDeletedSecretWithResponse(name, new RequestOptions().setContext(context));

        return new SimpleResponse<>(response,
            createDeletedSecret(response.getValue().toObject(DeletedSecretBundle.class)));
    }

    /**
     * Permanently removes a deleted secret, without the possibility of recovery. This operation can only be performed
     * on a <b>soft-delete enabled</b> vault. This operation requires the {@code secrets/purge} permission.
     *
     * <p><strong>Code sample</strong></p>
     * <p>Purges the deleted secret from the key vault enabled for <b>soft-delete</b>. Prints out the status code from
     * the server response.</p>
     *
     * <!-- src_embed com.azure.security.keyvault.SecretClient.purgeDeletedSecret#string -->
     * <pre>
     * secretClient.purgeDeletedSecret&#40;&quot;secretName&quot;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.purgeDeletedSecret#string -->
     *
     * @param name The name of the secret.
     * @throws ResourceNotFoundException when a secret with {@code name} doesn't exist in the key vault.
     * @throws HttpResponseException when a secret with {@code name} is empty string.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void purgeDeletedSecret(String name) {
        implClient.purgeDeletedSecretWithResponse(name, EMPTY_OPTIONS).getValue();
    }

    /**
     * Permanently removes a deleted secret, without the possibility of recovery. This operation can only be performed
     * on a <b>soft-delete enabled</b> vault. This operation requires the {@code secrets/purge} permission.
     *
     * <p><strong>Code sample</strong></p>
     * <p>Purges the deleted secret from the key vault enabled for <b>soft-delete</b>. Prints out the status code from
     * the server response.</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.purgeDeletedSecretWithResponse#string-Context -->
     * <pre>
     * Response&lt;Void&gt; purgeResponse = secretClient.purgeDeletedSecretWithResponse&#40;&quot;secretName&quot;,
     *     new Context&#40;key1, value1&#41;&#41;;
     * System.out.printf&#40;&quot;Purge Status Code: %d&quot;, purgeResponse.getStatusCode&#40;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.purgeDeletedSecretWithResponse#string-Context -->
     *
     * @param name The name of the secret.
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     * @return A response containing status code and HTTP headers.
     * @throws ResourceNotFoundException when a secret with {@code name} doesn't exist in the key vault.
     * @throws HttpResponseException when a secret with {@code name} is empty string.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> purgeDeletedSecretWithResponse(String name, Context context) {
        return implClient.purgeDeletedSecretWithResponse(name, new RequestOptions().setContext(context));
    }

    /**
     * Recovers the deleted secret in the key vault to its latest version. Can only be performed on a <b>soft-delete
     * enabled</b> vault. This operation requires the {@code secrets/recover} permission.
     *
     * <p><strong>Code sample</strong></p>
     * <p>Recovers the deleted secret from the key vault enabled for <b>soft-delete</b>. Prints out the details of the
     * recovered secret returned in the response.</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.recoverDeletedSecret#String -->
     * <pre>
     * SyncPoller&lt;KeyVaultSecret, Void&gt; recoverSecretPoller =
     *     secretClient.beginRecoverDeletedSecret&#40;&quot;deletedSecretName&quot;&#41;;
     *
     * &#47;&#47; Deleted Secret can be accessed as soon as polling is in progress.
     * PollResponse&lt;KeyVaultSecret&gt; recoveredSecretPollResponse = recoverSecretPoller.poll&#40;&#41;;
     * System.out.println&#40;&quot;Recovered Key Name %s&quot; + recoveredSecretPollResponse.getValue&#40;&#41;.getName&#40;&#41;&#41;;
     * System.out.printf&#40;&quot;Recovered Key's Id %s&quot;, recoveredSecretPollResponse.getValue&#40;&#41;.getId&#40;&#41;&#41;;
     *
     * &#47;&#47; Key is being recovered on server.
     * recoverSecretPoller.waitForCompletion&#40;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.recoverDeletedSecret#String -->
     *
     * @param name The name of the deleted secret to be recovered.
     * @return A {@link SyncPoller} to poll on and retrieve the {@link KeyVaultSecret recovered secret}.
     * @throws ResourceNotFoundException when a secret with {@code name} doesn't exist in the key vault.
     * @throws HttpResponseException when a secret with {@code name} is empty string.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    public SyncPoller<KeyVaultSecret, Void> beginRecoverDeletedSecret(String name) {
        return SyncPoller.createPoller(Duration.ofSeconds(1), recoverActivationOperation(name),
            recoverPollOperation(name), (context, response) -> null, context -> null);
    }

    private Function<PollingContext<KeyVaultSecret>, PollResponse<KeyVaultSecret>>
        recoverActivationOperation(String name) {

        return pollingContext -> new PollResponse<>(LongRunningOperationStatus.NOT_STARTED, createKeyVaultSecret(
            implClient.recoverDeletedSecretWithResponse(name, EMPTY_OPTIONS).getValue().toObject(SecretBundle.class)));
    }

    private Function<PollingContext<KeyVaultSecret>, PollResponse<KeyVaultSecret>> recoverPollOperation(String name) {
        return pollingContext -> {
            try {
                return new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED, createKeyVaultSecret(
                    implClient.getSecretWithResponse(name, "", EMPTY_OPTIONS).getValue().toObject(SecretBundle.class)));
            } catch (HttpResponseException e) {
                if (e.getResponse().getStatusCode() == 404) {
                    return new PollResponse<>(LongRunningOperationStatus.IN_PROGRESS,
                        pollingContext.getLatestResponse().getValue());
                } else {
                    // This means permission is not granted for the get deleted key operation. In both cases the
                    // deletion operation was successful when activation operation succeeded before reaching here.
                    return new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                        pollingContext.getLatestResponse().getValue());
                }
            } catch (Exception e) {
                // This means permission is not granted for the get deleted key operation. In both cases the
                // deletion operation was successful when activation operation succeeded before reaching here.
                return new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                    pollingContext.getLatestResponse().getValue());
            }
        };
    }

    /**
     * Requests a backup of the secret be downloaded to the client. All versions of the secret will be downloaded.
     * This operation requires the {@code secrets/backup} permission.
     *
     * <p><strong>Code sample</strong></p>
     * <p>Backs up the secret from the key vault and prints out the length of the secret's backup byte array returned in
     * the response</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.backupSecret#string -->
     * <pre>
     * byte[] secretBackup = secretClient.backupSecret&#40;&quot;secretName&quot;&#41;;
     * System.out.printf&#40;&quot;Secret's Backup Byte array's length %s&quot;, secretBackup.length&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.backupSecret#string -->
     *
     * @param name The name of the secret.
     * @return A {@link Response} whose {@link Response#getValue() value} contains the backed up secret blob.
     * @throws ResourceNotFoundException when a secret with {@code name} doesn't exist in the key vault.
     * @throws HttpResponseException when a secret with {@code name} is empty string.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public byte[] backupSecret(String name) {
        return implClient.backupSecretWithResponse(name, EMPTY_OPTIONS)
            .getValue()
            .toObject(BackupSecretResult.class)
            .getValue();
    }

    /**
     * Requests a backup of the secret be downloaded to the client. All versions of the secret will be downloaded.
     * This operation requires the {@code secrets/backup} permission.
     *
     * <p><strong>Code sample</strong></p>
     * <p>Backs up the secret from the key vault and prints out the length of the secret's backup byte array returned in
     * the response</p>
     *
     * <!-- src_embed com.azure.security.keyvault.SecretClient.backupSecretWithResponse#string-Context -->
     * <pre>
     * byte[] secretBackup = secretClient.backupSecretWithResponse&#40;&quot;secretName&quot;,
     *     new Context&#40;key1, value1&#41;&#41;.getValue&#40;&#41;;
     * System.out.printf&#40;&quot;Secret's Backup Byte array's length %s&quot;, secretBackup.length&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.backupSecretWithResponse#string-Context -->
     *
     * @param name The name of the secret.
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     * @return A {@link Response} whose {@link Response#getValue() value} contains the backed up secret blob.
     * @throws ResourceNotFoundException when a secret with {@code name} doesn't exist in the key vault.
     * @throws HttpResponseException when a secret with {@code name} is empty string.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<byte[]> backupSecretWithResponse(String name, Context context) {
        Response<BinaryData> response
            = implClient.backupSecretWithResponse(name, new RequestOptions().setContext(context));

        return new SimpleResponse<>(response, response.getValue().toBytes());
    }

    /**
     * Restores a backed up secret, and all its versions, to a vault.
     * This operation requires the {@code secrets/restore} permission.
     *
     * <p><strong>Code sample</strong></p>
     * <p>Restores the secret in the key vault from its backup byte array. Prints out the details of the restored secret
     * returned in the response.</p>
     *
     * <!-- src_embed com.azure.security.keyvault.SecretClient.restoreSecret#byte -->
     * <pre>
     * &#47;&#47; Pass the secret backup byte array of the secret to be restored.
     * byte[] secretBackupByteArray = &#123;&#125;;
     * KeyVaultSecret restoredSecret = secretClient.restoreSecretBackup&#40;secretBackupByteArray&#41;;
     * System.out
     *     .printf&#40;&quot;Restored Secret with name %s and value %s&quot;, restoredSecret.getName&#40;&#41;, restoredSecret.getValue&#40;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.restoreSecret#byte -->
     *
     * @param backup The backup blob associated with the secret.
     * @return A {@link Response} whose {@link Response#getValue() value} contains the
     * {@link KeyVaultSecret restored secret}.
     * @throws ResourceModifiedException when {@code backup} blob is malformed.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public KeyVaultSecret restoreSecretBackup(byte[] backup) {
        return callWithMappedException(() -> createKeyVaultSecret(implClient
            .restoreSecretWithResponse(BinaryData.fromObject(new SecretRestoreParameters(backup)), EMPTY_OPTIONS)
            .getValue()
            .toObject(SecretBundle.class)), SecretAsyncClient::mapRestoreSecretException);
    }

    /**
     * Restores a backed up secret, and all its versions, to a vault.
     * This operation requires the {@code secrets/restore} permission.
     *
     * <p><strong>Code sample</strong></p>
     * <p>Restores the secret in the key vault from its backup byte array. Prints out the details of the restored secret
     * returned in the response.</p>
     *
     * <!-- src_embed com.azure.security.keyvault.SecretClient.restoreSecretWithResponse#byte-Context -->
     * <pre>
     * &#47;&#47; Pass the secret backup byte array of the secret to be restored.
     * byte[] secretBackupByteArray = &#123;&#125;;
     * KeyVaultSecret restoredSecret = secretClient.restoreSecretBackupWithResponse&#40;secretBackupByteArray,
     *     new Context&#40;key2, value2&#41;&#41;.getValue&#40;&#41;;
     * System.out
     *     .printf&#40;&quot;Restored Secret with name %s and value %s&quot;, restoredSecret.getName&#40;&#41;, restoredSecret.getValue&#40;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.restoreSecretWithResponse#byte-Context -->
     *
     * @param backup The backup blob associated with the secret.
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     * @return A {@link Response} whose {@link Response#getValue() value} contains the
     * {@link KeyVaultSecret restored secret}.
     * @throws ResourceModifiedException when {@code backup} blob is malformed.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<KeyVaultSecret> restoreSecretBackupWithResponse(byte[] backup, Context context) {
        return callWithMappedException(() -> {
            Response<BinaryData> response = implClient.restoreSecretWithResponse(
                BinaryData.fromObject(new SecretRestoreParameters(backup)), new RequestOptions().setContext(context));

            return new SimpleResponse<>(response,
                createKeyVaultSecret(response.getValue().toObject(SecretBundle.class)));
        }, SecretAsyncClient::mapRestoreSecretException);
    }

    /**
     * Lists secrets in the key vault. Each {@link SecretProperties secret} returned only has its identifier and
     * attributes populated. The secret values and their versions are not listed in the response.
     * This operation requires the {@code secrets/list} permission.
     *
     * <p><strong>Iterate through secrets and fetch their latest value</strong></p>
     * <p>The snippet below loops over each {@link SecretProperties secret} and calls
     * {@link #getSecret(String, String) getSecret(String, String)}. This gets the {@link KeyVaultSecret secret} and the
     * value of its latest version.</p>
     *
     * <!-- src_embed com.azure.security.keyvault.SecretClient.listSecrets -->
     * <pre>
     * for &#40;SecretProperties secret : secretClient.listPropertiesOfSecrets&#40;&#41;&#41; &#123;
     *     KeyVaultSecret secretWithValue = secretClient.getSecret&#40;secret.getName&#40;&#41;, secret.getVersion&#40;&#41;&#41;;
     *     System.out.printf&#40;&quot;Received secret with name %s and value %s&quot;,
     *         secretWithValue.getName&#40;&#41;, secretWithValue.getValue&#40;&#41;&#41;;
     * &#125;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.listSecrets -->
     *
     * <p><strong>Iterate over secrets by page</strong></p>
     * <p>The snippet below loops over each {@link SecretProperties secret} by page and calls
     * {@link #getSecret(String, String) getSecret(String, String)}. This gets the {@link KeyVaultSecret secret} and the
     * value of its latest version.</p>
     *
     * <!-- src_embed com.azure.security.keyvault.SecretClient.listSecrets.iterableByPage -->
     * <pre>
     * secretClient.listPropertiesOfSecrets&#40;&#41;.iterableByPage&#40;&#41;.forEach&#40;resp -&gt; &#123;
     *     System.out.printf&#40;&quot;Response headers are %s. Url %s  and status code %d %n&quot;, resp.getHeaders&#40;&#41;,
     *         resp.getRequest&#40;&#41;.getUrl&#40;&#41;, resp.getStatusCode&#40;&#41;&#41;;
     *     resp.getItems&#40;&#41;.forEach&#40;value -&gt; &#123;
     *         KeyVaultSecret secretWithValue = secretClient.getSecret&#40;value.getName&#40;&#41;, value.getVersion&#40;&#41;&#41;;
     *         System.out.printf&#40;&quot;Received secret with name %s and value %s&quot;,
     *             secretWithValue.getName&#40;&#41;, secretWithValue.getValue&#40;&#41;&#41;;
     *     &#125;&#41;;
     * &#125;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.listSecrets.iterableByPage -->
     *
     * @return {@link PagedIterable} of {@link SecretProperties} of all the secrets in the vault. The
     * {@link SecretProperties} contains all the information about the secret, except its value.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<SecretProperties> listPropertiesOfSecrets() {
        return implClient.getSecrets(EMPTY_OPTIONS)
            .mapPage(binaryData -> createSecretProperties(binaryData.toObject(SecretItem.class)));
    }

    /**
     * Lists secrets in the key vault. Each {@link SecretProperties secret} returned only has its identifier and
     * attributes populated. The secret values and their versions are not listed in the response.
     * This operation requires the {@code secrets/list} permission.
     *
     * <p><strong>Iterate over secrets and fetch their latest value</strong></p>
     * <p>The snippet below loops over each {@link SecretProperties secret} and calls
     * {@link #getSecret(String, String) getSecret(String, String)}. This gets the {@link KeyVaultSecret secret} and the
     * value of its latest version.</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.listSecrets#Context -->
     * <pre>
     * for &#40;SecretProperties secret : secretClient.listPropertiesOfSecrets&#40;new Context&#40;key1, value2&#41;&#41;&#41; &#123;
     *     KeyVaultSecret secretWithValue = secretClient.getSecret&#40;secret.getName&#40;&#41;, secret.getVersion&#40;&#41;&#41;;
     *     System.out.printf&#40;&quot;Received secret with name %s and value %s&quot;,
     *         secretWithValue.getName&#40;&#41;, secretWithValue.getValue&#40;&#41;&#41;;
     * &#125;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.listSecrets#Context -->
     *
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     * @return {@link PagedIterable} of {@link SecretProperties} of all the secrets in the vault.
     * {@link SecretProperties} contains all the information about the secret, except its value.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<SecretProperties> listPropertiesOfSecrets(Context context) {
        return implClient.getSecrets(new RequestOptions().setContext(context))
            .mapPage(binaryData -> createSecretProperties(binaryData.toObject(SecretItem.class)));
    }

    /**
     * Lists {@link DeletedSecret deleted secrets} of the key vault if it has enabled soft-delete. This operation
     * requires the {@code secrets/list} permission.
     *
     * <p><strong>Iterate over secrets</strong></p>
     * <p>Lists the deleted secrets in the key vault and for each deleted secret prints out its recovery id.</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.listDeletedSecrets -->
     * <pre>
     * for &#40;DeletedSecret deletedSecret : secretClient.listDeletedSecrets&#40;&#41;&#41; &#123;
     *     System.out.printf&#40;&quot;Deleted secret's recovery Id %s&quot;, deletedSecret.getRecoveryId&#40;&#41;&#41;;
     * &#125;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.listDeletedSecrets -->
     *
     * <p><strong>Iterate over secrets by page</strong></p>
     * <p>Iterate over Lists the deleted secrets by page in the key vault and for each deleted secret prints out its
     * recovery id.</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.listDeletedSecrets.iterableByPage -->
     * <pre>
     * secretClient.listDeletedSecrets&#40;&#41;.iterableByPage&#40;&#41;.forEach&#40;resp -&gt; &#123;
     *     System.out.printf&#40;&quot;Got response headers . Url: %s, Status code: %d %n&quot;,
     *         resp.getRequest&#40;&#41;.getUrl&#40;&#41;, resp.getStatusCode&#40;&#41;&#41;;
     *     resp.getItems&#40;&#41;.forEach&#40;value -&gt; &#123;
     *         System.out.printf&#40;&quot;Deleted secret's recovery Id %s&quot;, value.getRecoveryId&#40;&#41;&#41;;
     *     &#125;&#41;;
     * &#125;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.listDeletedSecrets.iterableByPage -->
     *
     * @return {@link PagedIterable} of all of the {@link DeletedSecret deleted secrets} in the vault.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<DeletedSecret> listDeletedSecrets() {
        return implClient.getDeletedSecrets(EMPTY_OPTIONS)
            .mapPage(binaryData -> createDeletedSecret(binaryData.toObject(DeletedSecretItem.class)));
    }

    /**
     * Lists {@link DeletedSecret deleted secrets} of the key vault if it has enabled soft-delete. This operation
     * requires the {@code secrets/list} permission.
     *
     * <p><strong>Code sample</strong></p>
     * <p>Lists the deleted secrets in the key vault and for each deleted secret prints out its recovery id.</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.listDeletedSecrets#Context -->
     * <pre>
     * for &#40;DeletedSecret deletedSecret : secretClient.listDeletedSecrets&#40;new Context&#40;key1, value2&#41;&#41;&#41; &#123;
     *     System.out.printf&#40;&quot;Deleted secret's recovery Id %s&quot;, deletedSecret.getRecoveryId&#40;&#41;&#41;;
     * &#125;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.listDeletedSecrets#Context -->
     *
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     * @return {@link PagedIterable} of all of the {@link DeletedSecret deleted secrets} in the vault.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<DeletedSecret> listDeletedSecrets(Context context) {
        return implClient.getDeletedSecrets(new RequestOptions().setContext(context))
            .mapPage(binaryData -> createDeletedSecret(binaryData.toObject(DeletedSecretItem.class)));
    }

    /**
     * Lists all versions of the specified secret. Each {@link SecretProperties secret} returned only has its identifier
     * and attributes populated. The secret values and secret versions are not listed in the response.
     * This operation requires the {@code secrets/list} permission.
     *
     * <p><strong>Code sample</strong></p>
     * <p>The sample below fetches all versions of the given secret. For each secret version retrieved, makes a call
     * to {@link #getSecret(String, String) getSecret(String, String)} to get the version's value, and then prints it
     * out.</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.listSecretVersions#string -->
     * <pre>
     * for &#40;SecretProperties secret : secretClient.listPropertiesOfSecretVersions&#40;&quot;secretName&quot;&#41;&#41; &#123;
     *     KeyVaultSecret secretWithValue = secretClient.getSecret&#40;secret.getName&#40;&#41;, secret.getVersion&#40;&#41;&#41;;
     *     System.out.printf&#40;&quot;Received secret's version with name %s and value %s&quot;,
     *         secretWithValue.getName&#40;&#41;, secretWithValue.getValue&#40;&#41;&#41;;
     * &#125;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.listSecretVersions#string -->
     *
     * @param name The name of the secret.
     * @return {@link PagedIterable} of {@link SecretProperties} of all the versions of the specified secret in the
     * vault. List is empty if secret with {@code name} does not exist in key vault
     * @throws ResourceNotFoundException when a secret with {@code name} doesn't exist in the key vault.
     * @throws HttpResponseException when a secret with {@code name} is empty string.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<SecretProperties> listPropertiesOfSecretVersions(String name) {
        return implClient.getSecretVersions(name, EMPTY_OPTIONS)
            .mapPage(binaryData -> createSecretProperties(binaryData.toObject(SecretItem.class)));
    }

    /**
     * Lists all versions of the specified secret. Each {@link SecretProperties secret} returned only has its identifier
     * and attributes populated. The secret values and secret versions are not listed in the response.
     * This operation requires the {@code secrets/list} permission.
     *
     * <p><strong>Code sample</strong></p>
     * <p>The sample below fetches all versions of the given secret. For each secret version retrieved, makes a call
     * to {@link #getSecret(String, String) getSecret(String, String)} to get the version's value, and then prints it
     * out.</p>
     * <!-- src_embed com.azure.security.keyvault.SecretClient.listSecretVersions#string-Context -->
     * <pre>
     * for &#40;SecretProperties secret : secretClient
     *     .listPropertiesOfSecretVersions&#40;&quot;secretName&quot;, new Context&#40;key1, value2&#41;&#41;&#41; &#123;
     *     KeyVaultSecret secretWithValue = secretClient.getSecret&#40;secret.getName&#40;&#41;, secret.getVersion&#40;&#41;&#41;;
     *     System.out.printf&#40;&quot;Received secret's version with name %s and value %s&quot;,
     *         secretWithValue.getName&#40;&#41;, secretWithValue.getValue&#40;&#41;&#41;;
     * &#125;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.listSecretVersions#string-Context -->
     *
     * <p><strong>Iterate over secret versions by page</strong></p>
     * <p>The sample below iterates over each {@link SecretProperties secret} by each page and calls
     * {@link SecretClient#getSecret(String, String)}. This will return the {@link KeyVaultSecret secret} with the
     * corresponding version's value.</p>
     *
     * <!-- src_embed com.azure.security.keyvault.SecretClient.listSecretVersions#string-Context-iterableByPage -->
     * <pre>
     * secretClient.listPropertiesOfSecretVersions&#40;&quot;secretName&quot;, new Context&#40;key1, value2&#41;&#41;
     *     .iterableByPage&#40;&#41;.forEach&#40;resp -&gt; &#123;
     *         System.out.printf&#40;&quot;Got response headers . Url: %s, Status code: %d %n&quot;,
     *             resp.getRequest&#40;&#41;.getUrl&#40;&#41;, resp.getStatusCode&#40;&#41;&#41;;
     *         resp.getItems&#40;&#41;.forEach&#40;value -&gt; &#123;
     *             KeyVaultSecret secretWithValue = secretClient.getSecret&#40;value.getName&#40;&#41;, value.getVersion&#40;&#41;&#41;;
     *             System.out.printf&#40;&quot;Received secret's version with name %s and value %s&quot;,
     *                 secretWithValue.getName&#40;&#41;, secretWithValue.getValue&#40;&#41;&#41;;
     *         &#125;&#41;;
     *     &#125;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.SecretClient.listSecretVersions#string-Context-iterableByPage -->
     *
     * @param name The name of the secret.
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     * @return {@link PagedIterable} of {@link SecretProperties} of all the versions of the specified secret in the
     * vault. List is empty if secret with {@code name} does not exist in key vault
     * @throws ResourceNotFoundException when a secret with {@code name} doesn't exist in the key vault.
     * @throws HttpResponseException when a secret with {@code name} is empty string.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<SecretProperties> listPropertiesOfSecretVersions(String name, Context context) {
        return implClient.getSecretVersions(name, new RequestOptions().setContext(context))
            .mapPage(binaryData -> createSecretProperties(binaryData.toObject(SecretItem.class)));
    }

    private static <T> T callWithMappedException(Supplier<T> call,
        Function<HttpResponseException, HttpResponseException> exceptionMapper) {

        try {
            return call.get();
        } catch (HttpResponseException e) {
            throw exceptionMapper.apply(e);
        }
    }
}
