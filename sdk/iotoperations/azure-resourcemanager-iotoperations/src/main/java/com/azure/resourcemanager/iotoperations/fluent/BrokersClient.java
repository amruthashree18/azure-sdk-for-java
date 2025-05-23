// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.iotoperations.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.iotoperations.fluent.models.BrokerResourceInner;

/**
 * An instance of this class provides access to all the operations defined in BrokersClient.
 */
public interface BrokersClient {
    /**
     * Get a BrokerResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param brokerName Name of broker.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a BrokerResource along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<BrokerResourceInner> getWithResponse(String resourceGroupName, String instanceName, String brokerName,
        Context context);

    /**
     * Get a BrokerResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param brokerName Name of broker.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a BrokerResource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    BrokerResourceInner get(String resourceGroupName, String instanceName, String brokerName);

    /**
     * Create a BrokerResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param brokerName Name of broker.
     * @param resource Resource create parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of instance broker resource.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<BrokerResourceInner>, BrokerResourceInner> beginCreateOrUpdate(String resourceGroupName,
        String instanceName, String brokerName, BrokerResourceInner resource);

    /**
     * Create a BrokerResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param brokerName Name of broker.
     * @param resource Resource create parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of instance broker resource.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<BrokerResourceInner>, BrokerResourceInner> beginCreateOrUpdate(String resourceGroupName,
        String instanceName, String brokerName, BrokerResourceInner resource, Context context);

    /**
     * Create a BrokerResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param brokerName Name of broker.
     * @param resource Resource create parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return instance broker resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    BrokerResourceInner createOrUpdate(String resourceGroupName, String instanceName, String brokerName,
        BrokerResourceInner resource);

    /**
     * Create a BrokerResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param brokerName Name of broker.
     * @param resource Resource create parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return instance broker resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    BrokerResourceInner createOrUpdate(String resourceGroupName, String instanceName, String brokerName,
        BrokerResourceInner resource, Context context);

    /**
     * Delete a BrokerResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param brokerName Name of broker.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String instanceName, String brokerName);

    /**
     * Delete a BrokerResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param brokerName Name of broker.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String instanceName, String brokerName,
        Context context);

    /**
     * Delete a BrokerResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param brokerName Name of broker.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String instanceName, String brokerName);

    /**
     * Delete a BrokerResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param brokerName Name of broker.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String instanceName, String brokerName, Context context);

    /**
     * List BrokerResource resources by InstanceResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a BrokerResource list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<BrokerResourceInner> listByResourceGroup(String resourceGroupName, String instanceName);

    /**
     * List BrokerResource resources by InstanceResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a BrokerResource list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<BrokerResourceInner> listByResourceGroup(String resourceGroupName, String instanceName,
        Context context);
}
