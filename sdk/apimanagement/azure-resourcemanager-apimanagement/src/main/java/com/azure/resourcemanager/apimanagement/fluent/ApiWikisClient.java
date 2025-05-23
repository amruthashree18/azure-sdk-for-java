// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.apimanagement.fluent.models.WikiContractInner;
import com.azure.resourcemanager.apimanagement.models.ApiWikisCreateOrUpdateResponse;
import com.azure.resourcemanager.apimanagement.models.ApiWikisGetEntityTagResponse;
import com.azure.resourcemanager.apimanagement.models.ApiWikisGetResponse;
import com.azure.resourcemanager.apimanagement.models.ApiWikisUpdateResponse;
import com.azure.resourcemanager.apimanagement.models.WikiUpdateContract;

/**
 * An instance of this class provides access to all the operations defined in ApiWikisClient.
 */
public interface ApiWikisClient {
    /**
     * Gets the entity state (Etag) version of the Wiki for an API specified by its identifier.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param apiId API identifier. Must be unique in the current API Management service instance.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the entity state (Etag) version of the Wiki for an API specified by its identifier.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ApiWikisGetEntityTagResponse getEntityTagWithResponse(String resourceGroupName, String serviceName, String apiId,
        Context context);

    /**
     * Gets the entity state (Etag) version of the Wiki for an API specified by its identifier.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param apiId API identifier. Must be unique in the current API Management service instance.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void getEntityTag(String resourceGroupName, String serviceName, String apiId);

    /**
     * Gets the details of the Wiki for an API specified by its identifier.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param apiId API identifier. Must be unique in the current API Management service instance.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the details of the Wiki for an API specified by its identifier.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ApiWikisGetResponse getWithResponse(String resourceGroupName, String serviceName, String apiId, Context context);

    /**
     * Gets the details of the Wiki for an API specified by its identifier.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param apiId API identifier. Must be unique in the current API Management service instance.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the details of the Wiki for an API specified by its identifier.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    WikiContractInner get(String resourceGroupName, String serviceName, String apiId);

    /**
     * Creates a new Wiki for an API or updates an existing one.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param apiId API identifier. Must be unique in the current API Management service instance.
     * @param parameters Create parameters.
     * @param ifMatch ETag of the Entity. Not required when creating an entity, but required when updating an entity.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return wiki properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ApiWikisCreateOrUpdateResponse createOrUpdateWithResponse(String resourceGroupName, String serviceName,
        String apiId, WikiContractInner parameters, String ifMatch, Context context);

    /**
     * Creates a new Wiki for an API or updates an existing one.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param apiId API identifier. Must be unique in the current API Management service instance.
     * @param parameters Create parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return wiki properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    WikiContractInner createOrUpdate(String resourceGroupName, String serviceName, String apiId,
        WikiContractInner parameters);

    /**
     * Updates the details of the Wiki for an API specified by its identifier.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param apiId API identifier. Must be unique in the current API Management service instance.
     * @param ifMatch ETag of the Entity. ETag should match the current entity state from the header response of the GET
     * request or it should be * for unconditional update.
     * @param parameters Wiki Update parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return wiki properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ApiWikisUpdateResponse updateWithResponse(String resourceGroupName, String serviceName, String apiId,
        String ifMatch, WikiUpdateContract parameters, Context context);

    /**
     * Updates the details of the Wiki for an API specified by its identifier.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param apiId API identifier. Must be unique in the current API Management service instance.
     * @param ifMatch ETag of the Entity. ETag should match the current entity state from the header response of the GET
     * request or it should be * for unconditional update.
     * @param parameters Wiki Update parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return wiki properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    WikiContractInner update(String resourceGroupName, String serviceName, String apiId, String ifMatch,
        WikiUpdateContract parameters);

    /**
     * Deletes the specified Wiki from an API.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param apiId API identifier. Must be unique in the current API Management service instance.
     * @param ifMatch ETag of the Entity. ETag should match the current entity state from the header response of the GET
     * request or it should be * for unconditional update.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> deleteWithResponse(String resourceGroupName, String serviceName, String apiId, String ifMatch,
        Context context);

    /**
     * Deletes the specified Wiki from an API.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param apiId API identifier. Must be unique in the current API Management service instance.
     * @param ifMatch ETag of the Entity. ETag should match the current entity state from the header response of the GET
     * request or it should be * for unconditional update.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String serviceName, String apiId, String ifMatch);
}
