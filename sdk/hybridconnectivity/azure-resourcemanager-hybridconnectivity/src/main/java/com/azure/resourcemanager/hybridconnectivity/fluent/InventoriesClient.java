// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.hybridconnectivity.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.hybridconnectivity.fluent.models.InventoryResourceInner;

/**
 * An instance of this class provides access to all the operations defined in InventoriesClient.
 */
public interface InventoriesClient {
    /**
     * Get a InventoryResource.
     * 
     * @param resourceUri The fully qualified Azure Resource manager identifier of the resource.
     * @param solutionConfiguration Represent Solution Configuration Resource.
     * @param inventoryId Inventory resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a InventoryResource along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<InventoryResourceInner> getWithResponse(String resourceUri, String solutionConfiguration,
        String inventoryId, Context context);

    /**
     * Get a InventoryResource.
     * 
     * @param resourceUri The fully qualified Azure Resource manager identifier of the resource.
     * @param solutionConfiguration Represent Solution Configuration Resource.
     * @param inventoryId Inventory resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a InventoryResource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    InventoryResourceInner get(String resourceUri, String solutionConfiguration, String inventoryId);

    /**
     * List InventoryResource resources by SolutionConfiguration.
     * 
     * @param resourceUri The fully qualified Azure Resource manager identifier of the resource.
     * @param solutionConfiguration Represent Solution Configuration Resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a InventoryResource list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<InventoryResourceInner> listBySolutionConfiguration(String resourceUri, String solutionConfiguration);

    /**
     * List InventoryResource resources by SolutionConfiguration.
     * 
     * @param resourceUri The fully qualified Azure Resource manager identifier of the resource.
     * @param solutionConfiguration Represent Solution Configuration Resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a InventoryResource list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<InventoryResourceInner> listBySolutionConfiguration(String resourceUri, String solutionConfiguration,
        Context context);
}
