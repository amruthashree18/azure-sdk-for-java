// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos;

import com.azure.core.util.Context;
import com.azure.cosmos.implementation.AsyncDocumentClient;
import com.azure.cosmos.implementation.CosmosPagedFluxOptions;
import com.azure.cosmos.implementation.DiagnosticsProvider;
import com.azure.cosmos.implementation.HttpConstants;
import com.azure.cosmos.implementation.ImplementationBridgeHelpers;
import com.azure.cosmos.implementation.Offer;
import com.azure.cosmos.implementation.OperationType;
import com.azure.cosmos.implementation.Paths;
import com.azure.cosmos.implementation.QueryFeedOperationState;
import com.azure.cosmos.implementation.RequestOptions;
import com.azure.cosmos.implementation.ResourceType;
import com.azure.cosmos.implementation.apachecommons.lang.StringUtils;
import com.azure.cosmos.models.CosmosClientEncryptionKeyProperties;
import com.azure.cosmos.models.CosmosClientEncryptionKeyResponse;
import com.azure.cosmos.models.CosmosContainerProperties;
import com.azure.cosmos.models.CosmosContainerRequestOptions;
import com.azure.cosmos.models.CosmosContainerResponse;
import com.azure.cosmos.models.CosmosDatabaseRequestOptions;
import com.azure.cosmos.models.CosmosDatabaseResponse;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.models.CosmosUserProperties;
import com.azure.cosmos.models.CosmosUserResponse;
import com.azure.cosmos.models.ModelBridgeInternal;
import com.azure.cosmos.models.SqlParameter;
import com.azure.cosmos.models.SqlQuerySpec;
import com.azure.cosmos.models.ThroughputProperties;
import com.azure.cosmos.models.ThroughputResponse;
import com.azure.cosmos.util.CosmosPagedFlux;
import com.azure.cosmos.util.UtilBridgeInternal;
import reactor.core.Exceptions;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

import static com.azure.core.util.FluxUtil.withContext;

/**
 * Perform read and delete databases, update database throughput, and perform operations on child resources
 */
public class CosmosAsyncDatabase {
    private static final ImplementationBridgeHelpers.CosmosQueryRequestOptionsHelper.CosmosQueryRequestOptionsAccessor queryOptionsAccessor =
        ImplementationBridgeHelpers.CosmosQueryRequestOptionsHelper.getCosmosQueryRequestOptionsAccessor();

    private static final ImplementationBridgeHelpers.FeedResponseHelper.FeedResponseAccessor feedResponseAccessor =
        ImplementationBridgeHelpers.FeedResponseHelper.getFeedResponseAccessor();

    private final CosmosAsyncClient client;
    private final String id;
    private final String link;

    CosmosAsyncDatabase(String id, CosmosAsyncClient client) {
        this.id = id;
        this.client = client;
        this.link = getParentLink() + "/" + getURIPathSegment() + "/" + getId();
    }

    /**
     * Get the id of the CosmosAsyncDatabase.
     *
     * @return the id of the CosmosAsyncDatabase.
     */
    public String getId() {
        return id;
    }

    /**
     * Reads a database.
     * Fetch the details and properties of a database based on its unique identifier.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.read -->
     * <pre>
     * CosmosAsyncDatabase database = cosmosAsyncClient
     *     .getDatabase&#40;&quot;&lt;YOUR DATABASE NAME&gt;&quot;&#41;;
     * database.read&#40;&#41;.subscribe&#40;databaseResponse -&gt; &#123;
     *         System.out.println&#40;databaseResponse&#41;;
     *     &#125;,
     *     throwable -&gt; &#123;
     *         throwable.printStackTrace&#40;&#41;;
     *     &#125;&#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.read -->
     * <p>
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a single cosmos database response with the
     * read database. In case of failure the {@link Mono} will error.
     *
     * @return an {@link Mono} containing the single cosmos database respone with
     * the read database or an error.
     */
    public Mono<CosmosDatabaseResponse> read() {
        return read(new CosmosDatabaseRequestOptions());
    }

    /**
     * Reads a database.
     * Fetch the details and properties of a database based on its unique identifier.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.read -->
     * <pre>
     * CosmosAsyncDatabase database = cosmosAsyncClient
     *     .getDatabase&#40;&quot;&lt;YOUR DATABASE NAME&gt;&quot;&#41;;
     * database.read&#40;&#41;.subscribe&#40;databaseResponse -&gt; &#123;
     *         System.out.println&#40;databaseResponse&#41;;
     *     &#125;,
     *     throwable -&gt; &#123;
     *         throwable.printStackTrace&#40;&#41;;
     *     &#125;&#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.read -->
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a cosmos database response with the
     * read database. In case of failure the {@link Mono} will error.
     *
     * @param options the request options.
     * @return an {@link Mono} containing the single cosmos database response with
     * the read database or an error.
     */
    public Mono<CosmosDatabaseResponse> read(CosmosDatabaseRequestOptions options) {
        final CosmosDatabaseRequestOptions requestOptions = options == null ? new CosmosDatabaseRequestOptions() : options;
        return withContext(context -> readInternal(requestOptions, context));
    }

    /**
     * Deletes the current Cosmos database.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.delete -->
     * <pre>
     * CosmosAsyncDatabase database = cosmosAsyncClient
     *     .getDatabase&#40;&quot;&lt;YOUR DATABASE NAME&gt;&quot;&#41;;
     * database.delete&#40;&#41;.subscribe&#40;databaseResponse -&gt; &#123;
     *         System.out.println&#40;databaseResponse&#41;;
     *     &#125;,
     *     throwable -&gt; &#123;
     *         throwable.printStackTrace&#40;&#41;;
     *     &#125;&#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.delete -->
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a cosmos database response with the
     * deleted database. In case of failure the {@link Mono} will error.
     *
     * @return an {@link Mono} containing the single cosmos database response.
     */
    public Mono<CosmosDatabaseResponse> delete() {
        return delete(new CosmosDatabaseRequestOptions());
    }

    /**
     * Deletes the current Cosmos database while specifying additional request options.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.delete -->
     * <pre>
     * CosmosAsyncDatabase database = cosmosAsyncClient
     *     .getDatabase&#40;&quot;&lt;YOUR DATABASE NAME&gt;&quot;&#41;;
     * database.delete&#40;&#41;.subscribe&#40;databaseResponse -&gt; &#123;
     *         System.out.println&#40;databaseResponse&#41;;
     *     &#125;,
     *     throwable -&gt; &#123;
     *         throwable.printStackTrace&#40;&#41;;
     *     &#125;&#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.delete -->
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a cosmos database response with the
     * deleted database. In case of failure the {@link Mono} will error.
     *
     * @param options the request options.
     * @return an {@link Mono} containing the single cosmos database response.
     */
    public Mono<CosmosDatabaseResponse> delete(CosmosDatabaseRequestOptions options) {
        final CosmosDatabaseRequestOptions requestOptions = options == null ? new CosmosDatabaseRequestOptions() : options;
        return withContext(context -> deleteInternal(requestOptions, context));
    }

    /* CosmosAsyncContainer operations */

    /**
     * Creates a Cosmos container.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.createContainer -->
     * <pre>
     * CosmosContainerProperties containerProperties =
     *     new CosmosContainerProperties&#40;containerId, partitionKeyDefinition&#41;;
     * cosmosAsyncDatabase.createContainer&#40;containerProperties&#41;
     *     .subscribe&#40;
     *         cosmosContainerResponse -&gt; System.out.println&#40;cosmosContainerResponse&#41;,
     *         throwable -&gt; System.out.println&#40;&quot;Failed to create container: &quot; + throwable&#41;
     *     &#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.createContainer -->
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a cosmos container response with the
     * created container. In case of failure the {@link Mono} will error.
     *
     * @param containerProperties the container properties.
     * @return a {@link Mono} containing the single cosmos container response with
     * the created container or an error.
     * @throws IllegalArgumentException containerProperties cannot be null.
     */
    public Mono<CosmosContainerResponse> createContainer(CosmosContainerProperties containerProperties) {
        return createContainer(containerProperties, new CosmosContainerRequestOptions());
    }

    /**
     * Creates a Cosmos container with custom throughput properties.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.createContainerProps -->
     * <pre>
     * CosmosContainerProperties containerProperties =
     *     new CosmosContainerProperties&#40;containerId, partitionKeyDefinition&#41;;
     * ThroughputProperties throughputProperties =
     *     ThroughputProperties.createAutoscaledThroughput&#40;autoScaleMaxThroughput&#41;;
     * cosmosAsyncDatabase.createContainer&#40;containerProperties, throughputProperties&#41;
     *     .subscribe&#40;
     *         cosmosContainerResponse -&gt; System.out.println&#40;cosmosContainerResponse&#41;,
     *         throwable -&gt; System.out.println&#40;&quot;Failed to create container: &quot; + throwable&#41;
     *     &#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.createContainerProps -->
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a cosmos container response with the
     * created container. In case of failure the {@link Mono} will error.
     *
     * @param containerProperties the container properties.
     * @param throughputProperties the throughput properties for the container.
     * @return a {@link Mono} containing the single cosmos container response with
     * the created container or an error.
     * @throws IllegalArgumentException thown if containerProerties are null.
     */
    public Mono<CosmosContainerResponse> createContainer(
        CosmosContainerProperties containerProperties,
        ThroughputProperties throughputProperties) {
        if (containerProperties == null) {
            throw new IllegalArgumentException("containerProperties");
        }
        CosmosContainerRequestOptions options = new CosmosContainerRequestOptions();
        ModelBridgeInternal.setThroughputProperties(options, throughputProperties);
        return createContainer(containerProperties, options);
    }

    /**
     * Creates a container.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.createContainerThroughput -->
     * <pre>
     * CosmosContainerProperties containerProperties =
     *     new CosmosContainerProperties&#40;containerId, partitionKeyDefinition&#41;;
     *
     * cosmosAsyncDatabase.createContainer&#40;
     *         containerProperties,
     *         throughput,
     *         options
     *     &#41;
     *     .subscribe&#40;
     *         cosmosContainerResponse -&gt; System.out.println&#40;cosmosContainerResponse&#41;,
     *         throwable -&gt; System.out.println&#40;&quot;Failed to create container: &quot; + throwable&#41;
     *     &#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.createContainerThroughput -->
     * @param containerProperties the container properties.
     * @param throughputProperties the throughput properties.
     * @param options the request options.
     * @return the mono.
     */
    public Mono<CosmosContainerResponse> createContainer(
        CosmosContainerProperties containerProperties,
        ThroughputProperties throughputProperties,
        CosmosContainerRequestOptions options){
        ModelBridgeInternal.setThroughputProperties(options, throughputProperties);
        return createContainer(containerProperties, options);
    }

    /**
     * Creates a Cosmos container.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.createContainer -->
     * <pre>
     * CosmosContainerProperties containerProperties =
     *     new CosmosContainerProperties&#40;containerId, partitionKeyDefinition&#41;;
     * cosmosAsyncDatabase.createContainer&#40;containerProperties&#41;
     *     .subscribe&#40;
     *         cosmosContainerResponse -&gt; System.out.println&#40;cosmosContainerResponse&#41;,
     *         throwable -&gt; System.out.println&#40;&quot;Failed to create container: &quot; + throwable&#41;
     *     &#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.createContainer -->
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a cosmos container response with the
     * created container. In case of failure the {@link Mono} will error.
     *
     * @param containerProperties the containerProperties.
     * @param options the cosmos container request options.
     * @return a {@link Mono} containing the cosmos container response with the
     * created container or an error.
     * @throws IllegalArgumentException containerProperties can not be null.
     */
    public Mono<CosmosContainerResponse> createContainer(
        CosmosContainerProperties containerProperties,
        CosmosContainerRequestOptions options) {
        if (containerProperties == null) {
            throw new IllegalArgumentException("containerProperties");
        }

        final CosmosContainerRequestOptions requestOptions = options == null ? new CosmosContainerRequestOptions() : options;
        return withContext(context -> createContainerInternal(containerProperties, requestOptions, context));
    }

    /**
     * Creates a Cosmos container.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.createContainerThroughput -->
     * <pre>
     * CosmosContainerProperties containerProperties =
     *     new CosmosContainerProperties&#40;containerId, partitionKeyDefinition&#41;;
     *
     * cosmosAsyncDatabase.createContainer&#40;
     *         containerProperties,
     *         throughput,
     *         options
     *     &#41;
     *     .subscribe&#40;
     *         cosmosContainerResponse -&gt; System.out.println&#40;cosmosContainerResponse&#41;,
     *         throwable -&gt; System.out.println&#40;&quot;Failed to create container: &quot; + throwable&#41;
     *     &#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.createContainerThroughput -->
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a cosmos container response with the
     * created container. In case of failure the {@link Mono} will error.
     *
     * @param containerProperties the containerProperties.
     * @param throughput the throughput for the container.
     * @param options the cosmos container request options.
     * @return a {@link Mono} containing the cosmos container response with the
     * created container or an error.
     * @throws IllegalArgumentException containerProperties cannot be null.
     */
    Mono<CosmosContainerResponse> createContainer(
        CosmosContainerProperties containerProperties,
        int throughput,
        CosmosContainerRequestOptions options) {
        if (options == null) {
            options = new CosmosContainerRequestOptions();
        }
        ModelBridgeInternal.setThroughputProperties(options, ThroughputProperties.createManualThroughput(throughput));
        return createContainer(containerProperties, options);
    }

    /**
     * Creates a Cosmos container.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.createContainerPartitionKey -->
     * <pre>
     * ThroughputProperties throughputProperties =
     *     ThroughputProperties.createAutoscaledThroughput&#40;autoscaledThroughput&#41;;
     * cosmosAsyncDatabase.createContainer&#40;
     *         containerId,
     *         partitionKeyPath,
     *         throughputProperties
     *     &#41;
     *     .subscribe&#40;
     *         cosmosContainerResponse -&gt; System.out.println&#40;cosmosContainerResponse&#41;,
     *         throwable -&gt; System.out.println&#40;&quot;Failed to create container: &quot; + throwable&#41;
     *     &#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.createContainerPartitionKey -->
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a cosmos container response with the
     * created container. In case of failure the {@link Mono} will error.
     *
     * @param id the cosmos container id.
     * @param partitionKeyPath the partition key path.
     * @return a {@link Mono} containing the cosmos container response with the
     * created container or an error.
     */
    public Mono<CosmosContainerResponse> createContainer(String id, String partitionKeyPath) {
        return createContainer(new CosmosContainerProperties(id, partitionKeyPath));
    }

    /**
     * Creates a Cosmos container.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.createContainerPartitionKey -->
     * <pre>
     * ThroughputProperties throughputProperties =
     *     ThroughputProperties.createAutoscaledThroughput&#40;autoscaledThroughput&#41;;
     * cosmosAsyncDatabase.createContainer&#40;
     *         containerId,
     *         partitionKeyPath,
     *         throughputProperties
     *     &#41;
     *     .subscribe&#40;
     *         cosmosContainerResponse -&gt; System.out.println&#40;cosmosContainerResponse&#41;,
     *         throwable -&gt; System.out.println&#40;&quot;Failed to create container: &quot; + throwable&#41;
     *     &#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.createContainerPartitionKey -->
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a cosmos container response with the
     * created container. In case of failure the {@link Mono} will error.
     *
     * @param id the cosmos container id.
     * @param partitionKeyPath the partition key path.
     * @param throughputProperties the throughput properties for the container.
     * @return a {@link Mono} containing the cosmos container response with the
     * created container or an error.
     */
    public Mono<CosmosContainerResponse> createContainer(String id, String partitionKeyPath, ThroughputProperties throughputProperties) {
        CosmosContainerRequestOptions options = new CosmosContainerRequestOptions();
        ModelBridgeInternal.setThroughputProperties(options, throughputProperties);
        return createContainer(new CosmosContainerProperties(id, partitionKeyPath), options);
    }

    /**
     * Creates a Cosmos container if it does not exist on the service.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.createContainerIfNotExists -->
     * <pre>
     * CosmosContainerProperties containerProperties =
     *     new CosmosContainerProperties&#40;containerId, partitionKeyDefinition&#41;;
     * cosmosAsyncDatabase.createContainerIfNotExists&#40;containerProperties&#41;
     *     .subscribe&#40;
     *         cosmosContainerResponse -&gt; System.out.println&#40;cosmosContainerResponse&#41;,
     *         throwable -&gt; System.out.println&#40;&quot;Failed to create container: &quot; + throwable&#41;
     *     &#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.createContainerIfNotExists -->
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a cosmos container response with the
     * created or existing container. In case of failure the {@link Mono} will
     * error.
     *
     * @param containerProperties the container properties
     * @return a {@link Mono} containing the cosmos container response with the
     * created or existing container or an error.
     */
    public Mono<CosmosContainerResponse> createContainerIfNotExists(
        CosmosContainerProperties containerProperties) {
        CosmosAsyncContainer container = getContainer(containerProperties.getId());
        return withContext(context -> createContainerIfNotExistsInternal(containerProperties, container, null,
            context));
    }

    /**
     * Creates a Cosmos container if it does not exist on the service.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.createContainerIfNotExistsThroughput -->
     * <pre>
     * CosmosContainerProperties containerProperties =
     *     new CosmosContainerProperties&#40;containerId, partitionKeyDefinition&#41;;
     * cosmosAsyncDatabase.createContainerIfNotExists&#40;containerProperties, throughputProperties&#41;
     *     .subscribe&#40;
     *         cosmosContainerResponse -&gt; System.out.println&#40;cosmosContainerResponse&#41;,
     *         throwable -&gt; System.out.println&#40;&quot;Failed to create container: &quot; + throwable&#41;
     *     &#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.createContainerIfNotExistsThroughput -->
     * The throughput setting will only be used if the specified container
     * does not exist and therefore a new container will be created.
     * <p>
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a cosmos container response with the
     * created or existing container. In case of failure the {@link Mono} will
     * error.
     *
     * @param containerProperties the container properties.
     * @param throughput the throughput for the container.
     * @return a {@link Mono} containing the cosmos container response with the
     * created or existing container or an error.
     */
    Mono<CosmosContainerResponse> createContainerIfNotExists(
        CosmosContainerProperties containerProperties,
        int throughput) {
        CosmosContainerRequestOptions options = new CosmosContainerRequestOptions();
        ModelBridgeInternal.setThroughputProperties(options, ThroughputProperties.createManualThroughput(throughput));
        CosmosAsyncContainer container = getContainer(containerProperties.getId());
        return withContext(context -> createContainerIfNotExistsInternal(containerProperties, container, options,
            context));
    }

    /**
     * Creates a Cosmos container if it does not exist on the service.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.createContainerIfNotExistsThroughput -->
     * <pre>
     * CosmosContainerProperties containerProperties =
     *     new CosmosContainerProperties&#40;containerId, partitionKeyDefinition&#41;;
     * cosmosAsyncDatabase.createContainerIfNotExists&#40;containerProperties, throughputProperties&#41;
     *     .subscribe&#40;
     *         cosmosContainerResponse -&gt; System.out.println&#40;cosmosContainerResponse&#41;,
     *         throwable -&gt; System.out.println&#40;&quot;Failed to create container: &quot; + throwable&#41;
     *     &#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.createContainerIfNotExistsThroughput -->
     * The throughput properties will only be used if the specified container
     * does not exist and therefor a new container will be created.
     * <p>
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a cosmos container response with the
     * created or existing container. In case of failure the {@link Mono} will
     * error.
     *
     * @param containerProperties the container properties.
     * @param throughputProperties the throughput properties for the container.
     * @return a {@link Mono} containing the cosmos container response with the
     * created or existing container or an error.
     */
    public Mono<CosmosContainerResponse> createContainerIfNotExists(
        CosmosContainerProperties containerProperties,
        ThroughputProperties throughputProperties) {
        CosmosContainerRequestOptions options = new CosmosContainerRequestOptions();
        ModelBridgeInternal.setThroughputProperties(options, throughputProperties);
        CosmosAsyncContainer container = getContainer(containerProperties.getId());
        return withContext(context -> createContainerIfNotExistsInternal(containerProperties, container, options,
            context));
    }

    /**
     * Creates a Cosmos container if it does not exist on the service.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.createContainerIfNotExists -->
     * <pre>
     * CosmosContainerProperties containerProperties =
     *     new CosmosContainerProperties&#40;containerId, partitionKeyDefinition&#41;;
     * cosmosAsyncDatabase.createContainerIfNotExists&#40;containerProperties&#41;
     *     .subscribe&#40;
     *         cosmosContainerResponse -&gt; System.out.println&#40;cosmosContainerResponse&#41;,
     *         throwable -&gt; System.out.println&#40;&quot;Failed to create container: &quot; + throwable&#41;
     *     &#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.createContainerIfNotExists -->
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a cosmos container response with the
     * created container. In case of failure the {@link Mono} will error.
     *
     * @param id the cosmos container id.
     * @param partitionKeyPath the partition key path.
     * @return a {@link Mono} containing the cosmos container response with the
     * created container or an error.
     */
    public Mono<CosmosContainerResponse> createContainerIfNotExists(String id, String partitionKeyPath) {
        CosmosAsyncContainer container = getContainer(id);
        return withContext(context -> createContainerIfNotExistsInternal(new CosmosContainerProperties(id,
                partitionKeyPath), container, null,
            context));
    }

    /**
     * Creates a Cosmos container if it does not exist on the service.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.createContainerIfNotExistsThroughput -->
     * <pre>
     * CosmosContainerProperties containerProperties =
     *     new CosmosContainerProperties&#40;containerId, partitionKeyDefinition&#41;;
     * cosmosAsyncDatabase.createContainerIfNotExists&#40;containerProperties, throughputProperties&#41;
     *     .subscribe&#40;
     *         cosmosContainerResponse -&gt; System.out.println&#40;cosmosContainerResponse&#41;,
     *         throwable -&gt; System.out.println&#40;&quot;Failed to create container: &quot; + throwable&#41;
     *     &#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.createContainerIfNotExistsThroughput -->
     * The throughput properties will only be used if the specified container
     * does not exist and therefor a new container will be created.
     * <p>
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a cosmos container response with the
     * created container. In case of failure the {@link Mono} will error.
     *
     * @param id the cosmos container id.
     * @param partitionKeyPath the partition key path.
     * @param throughputProperties the throughput properties for the container.
     * @return a {@link Mono} containing the cosmos container response with the
     * created container or an error.
     */
    public Mono<CosmosContainerResponse> createContainerIfNotExists(
        String id, String partitionKeyPath,
        ThroughputProperties throughputProperties) {
        CosmosContainerRequestOptions options = new CosmosContainerRequestOptions();
        ModelBridgeInternal.setThroughputProperties(options, throughputProperties);
        CosmosAsyncContainer container = getContainer(id);
        return withContext(context -> createContainerIfNotExistsInternal(new CosmosContainerProperties(id,
            partitionKeyPath), container, options, context));
    }

    /**
     * Creates a Cosmos container if it does not exist on the service.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.createContainerIfNotExists -->
     * <pre>
     * CosmosContainerProperties containerProperties =
     *     new CosmosContainerProperties&#40;containerId, partitionKeyDefinition&#41;;
     * cosmosAsyncDatabase.createContainerIfNotExists&#40;containerProperties&#41;
     *     .subscribe&#40;
     *         cosmosContainerResponse -&gt; System.out.println&#40;cosmosContainerResponse&#41;,
     *         throwable -&gt; System.out.println&#40;&quot;Failed to create container: &quot; + throwable&#41;
     *     &#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.createContainerIfNotExists -->
     * The throughput setting will only be used if the specified container
     * does not exist and a new container will be created.
     * <p>
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a cosmos container response with the
     * created container. In case of failure the {@link Mono} will error.
     *
     * @param id the cosmos container id.
     * @param partitionKeyPath the partition key path.
     * @param throughput the throughput for the container.
     * @return a {@link Mono} containing the cosmos container response with the
     * created container or an error.
     */
    Mono<CosmosContainerResponse> createContainerIfNotExists(
        String id, String partitionKeyPath,
        int throughput) {
        CosmosContainerRequestOptions options = new CosmosContainerRequestOptions();
        ModelBridgeInternal.setThroughputProperties(options, ThroughputProperties.createManualThroughput(throughput));
        CosmosAsyncContainer container = getContainer(id);
        return withContext(context -> createContainerIfNotExistsInternal(new CosmosContainerProperties(id,
            partitionKeyPath), container, options, context));
    }

    /**
     * Reads all cosmos containers.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.readAllContainers -->
     * <pre>
     * cosmosAsyncDatabase.readAllContainers&#40;&#41;
     *     .byPage&#40;&#41;
     *     .flatMap&#40;containerPropertiesFeedResponse -&gt; &#123;
     *         for &#40;CosmosContainerProperties properties : containerPropertiesFeedResponse.getResults&#40;&#41;&#41; &#123;
     *             System.out.println&#40;properties&#41;;
     *         &#125;
     *         return Flux.empty&#40;&#41;;
     *     &#125;&#41;
     *     .subscribe&#40;&#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.readAllContainers -->
     * After subscription the operation will be performed. The {@link CosmosPagedFlux} will
     * contain one or several feed response of the read containers. In case of
     * failure the {@link CosmosPagedFlux} will error.
     *
     * @param options {@link CosmosQueryRequestOptions}
     * @return a {@link CosmosPagedFlux} containing one or several feed response pages of read
     * containers or an error.
     */
    public CosmosPagedFlux<CosmosContainerProperties> readAllContainers(CosmosQueryRequestOptions options) {
        CosmosQueryRequestOptions requestOptions = options == null ? new CosmosQueryRequestOptions() : options;
        return UtilBridgeInternal.createCosmosPagedFlux(pagedFluxOptions -> {
            String spanName = "readAllContainers." + this.getId();
            CosmosAsyncClient client = this.getClient();
            String operationId = ImplementationBridgeHelpers
                .CosmosQueryRequestOptionsHelper
                .getCosmosQueryRequestOptionsAccessor()
                .getQueryNameOrDefault(requestOptions, spanName);

            QueryFeedOperationState state = new QueryFeedOperationState(
                client,
                spanName,
                getId(),
                null,
                ResourceType.DocumentCollection,
                OperationType.ReadFeed,
                queryOptionsAccessor.getQueryNameOrDefault(requestOptions, spanName),
                requestOptions,
                pagedFluxOptions
            );

            pagedFluxOptions.setFeedOperationState(state);

            return getDocClientWrapper().readCollections(getLink(), state)
                .map(response -> feedResponseAccessor.createFeedResponse(
                    ModelBridgeInternal.getCosmosContainerPropertiesFromV2Results(response.getResults()),
                    response.getResponseHeaders(),
                    response.getCosmosDiagnostics()));
        });
    }

    /**
     * Reads all cosmos containers.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.readAllContainers -->
     * <pre>
     * cosmosAsyncDatabase.readAllContainers&#40;&#41;
     *     .byPage&#40;&#41;
     *     .flatMap&#40;containerPropertiesFeedResponse -&gt; &#123;
     *         for &#40;CosmosContainerProperties properties : containerPropertiesFeedResponse.getResults&#40;&#41;&#41; &#123;
     *             System.out.println&#40;properties&#41;;
     *         &#125;
     *         return Flux.empty&#40;&#41;;
     *     &#125;&#41;
     *     .subscribe&#40;&#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.readAllContainers -->
     * After subscription the operation will be performed. The {@link CosmosPagedFlux} will
     * contain one or several feed response of the read containers. In case of
     * failure the {@link CosmosPagedFlux} will error.
     *
     * @return a {@link CosmosPagedFlux} containing one or several feed response pages of read
     * containers or an error.
     */
    public CosmosPagedFlux<CosmosContainerProperties> readAllContainers() {
        return readAllContainers(new CosmosQueryRequestOptions());
    }

    /**
     * Query for cosmos containers in a cosmos database.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.queryContainers -->
     * <pre>
     * cosmosAsyncDatabase.queryContainers&#40;&quot;SELECT * FROM DB_NAME&quot;&#41;
     *     .byPage&#40;&#41;
     *     .flatMap&#40;containerPropertiesFeedResponse -&gt; &#123;
     *         for &#40;CosmosContainerProperties properties : containerPropertiesFeedResponse.getResults&#40;&#41;&#41; &#123;
     *             System.out.println&#40;properties&#41;;
     *         &#125;
     *         return Flux.empty&#40;&#41;;
     *     &#125;&#41;
     *     .subscribe&#40;&#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.queryContainers -->
     * After subscription the operation will be performed. The {@link CosmosPagedFlux} will
     * contain one or several feed response of the obtained containers. In case of
     * failure the {@link CosmosPagedFlux} will error.
     *
     * @param query the query.
     * @return a {@link CosmosPagedFlux} containing one or several feed response pages of the
     * obtained containers or an error.
     */
    public CosmosPagedFlux<CosmosContainerProperties> queryContainers(String query) {
        return queryContainersInternal(new SqlQuerySpec(query), new CosmosQueryRequestOptions());
    }

    /**
     * Query for cosmos containers in a cosmos database.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.queryContainers -->
     * <pre>
     * cosmosAsyncDatabase.queryContainers&#40;&quot;SELECT * FROM DB_NAME&quot;&#41;
     *     .byPage&#40;&#41;
     *     .flatMap&#40;containerPropertiesFeedResponse -&gt; &#123;
     *         for &#40;CosmosContainerProperties properties : containerPropertiesFeedResponse.getResults&#40;&#41;&#41; &#123;
     *             System.out.println&#40;properties&#41;;
     *         &#125;
     *         return Flux.empty&#40;&#41;;
     *     &#125;&#41;
     *     .subscribe&#40;&#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.queryContainers -->
     * After subscription the operation will be performed. The {@link CosmosPagedFlux} will
     * contain one or several feed response of the obtained containers. In case of
     * failure the {@link CosmosPagedFlux} will error.
     *
     * @param query the query.
     * @param options the query request options.
     * @return a {@link CosmosPagedFlux} containing one or several feed response pages of the
     * obtained containers or an error.
     */
    public CosmosPagedFlux<CosmosContainerProperties> queryContainers(String query, CosmosQueryRequestOptions options) {
        if (options == null) {
            options = new CosmosQueryRequestOptions();
        }

        return queryContainersInternal(new SqlQuerySpec(query), options);
    }

    /**
     * Query for cosmos containers in a cosmos database.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.queryContainers -->
     * <pre>
     * cosmosAsyncDatabase.queryContainers&#40;&quot;SELECT * FROM DB_NAME&quot;&#41;
     *     .byPage&#40;&#41;
     *     .flatMap&#40;containerPropertiesFeedResponse -&gt; &#123;
     *         for &#40;CosmosContainerProperties properties : containerPropertiesFeedResponse.getResults&#40;&#41;&#41; &#123;
     *             System.out.println&#40;properties&#41;;
     *         &#125;
     *         return Flux.empty&#40;&#41;;
     *     &#125;&#41;
     *     .subscribe&#40;&#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.queryContainers -->
     * After subscription the operation will be performed. The {@link CosmosPagedFlux} will
     * contain one or several feed response of the obtained containers. In case of
     * failure the {@link CosmosPagedFlux} will error.
     *
     * @param querySpec the SQL query specification.
     * @return a {@link CosmosPagedFlux} containing one or several feed response pages of the
     * obtained containers or an error.
     */
    public CosmosPagedFlux<CosmosContainerProperties> queryContainers(SqlQuerySpec querySpec) {
        return queryContainersInternal(querySpec, new CosmosQueryRequestOptions());
    }

    /**
     * Query for cosmos containers in a cosmos database.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.queryContainers -->
     * <pre>
     * cosmosAsyncDatabase.queryContainers&#40;&quot;SELECT * FROM DB_NAME&quot;&#41;
     *     .byPage&#40;&#41;
     *     .flatMap&#40;containerPropertiesFeedResponse -&gt; &#123;
     *         for &#40;CosmosContainerProperties properties : containerPropertiesFeedResponse.getResults&#40;&#41;&#41; &#123;
     *             System.out.println&#40;properties&#41;;
     *         &#125;
     *         return Flux.empty&#40;&#41;;
     *     &#125;&#41;
     *     .subscribe&#40;&#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.queryContainers -->
     * After subscription the operation will be performed. The {@link CosmosPagedFlux} will
     * contain one or several feed response of the obtained containers. In case of
     * failure the {@link CosmosPagedFlux} will error.
     *
     * @param querySpec the SQL query specification.
     * @param options the query request options.
     * @return a {@link CosmosPagedFlux} containing one or several feed response pages of the
     * obtained containers or an error.
     */
    public CosmosPagedFlux<CosmosContainerProperties> queryContainers(SqlQuerySpec querySpec
        , CosmosQueryRequestOptions options) {
        if (options == null) {
            options = new CosmosQueryRequestOptions();
        }

        return queryContainersInternal(querySpec, options);
    }

    /**
     * Gets a CosmosAsyncContainer object without making a service call
     *
     * @param id id of the container
     * @return Cosmos Container
     */
    public CosmosAsyncContainer getContainer(String id) {
        CosmosAsyncContainer asyncContainer = this
            .client
            .getContainerCreationInterceptor()
            .apply(new CosmosAsyncContainer(id, this));

        if (asyncContainer == null) {
            throw new IllegalStateException(
                "The implementation of the custom container creation interceptor must not return null.");
        }
        return asyncContainer;
    }

    /**
     * Creates a user After subscription the operation will be performed. The
     * {@link Mono} upon successful completion will contain a single resource
     * response with the created user. In case of failure the {@link Mono} will
     * error.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.createUser -->
     * <pre>
     * String userId = &quot;userId&quot;;
     * CosmosUserProperties userProperties = new CosmosUserProperties&#40;&#41;;
     * userProperties.setId&#40;userId&#41;;
     * cosmosAsyncDatabase.createUser&#40;userProperties&#41;
     *     .subscribe&#40;
     *         userResponse -&gt; System.out.println&#40;userResponse&#41;,
     *         throwable -&gt; System.out.println&#40;&quot;Failed to create user: &quot; + throwable&#41;
     *     &#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.createUser -->
     *
     * @param userProperties the cosmos user properties
     * @return an {@link Mono} containing the single resource response with the
     * created cosmos user or an error.
     */
    public Mono<CosmosUserResponse> createUser(CosmosUserProperties userProperties) {
        return withContext(context -> createUserInternal(userProperties, context));
    }

    /**
     * Creates a client encryption key after subscription the operation will be performed. The
     * {@link Mono} upon successful completion will contain a single resource
     * response with the created client encryption key. In case of failure the {@link Mono} will
     * error.
     *
     * @param keyProperties the cosmos client encryption key properties
     * @return an {@link Mono} containing the single resource response with the
     * created cosmos client encryption key or an error.
     */
    public Mono<CosmosClientEncryptionKeyResponse> createClientEncryptionKey(CosmosClientEncryptionKeyProperties keyProperties) {
        return withContext(context -> createClientEncryptionKeyInternal(keyProperties, context));
    }

    /**
     * Upsert a user. Upsert will create a new user if it doesn't exist, or replace
     * the existing one if it does. After subscription the operation will be
     * performed. The {@link Mono} upon successful completion will contain a single
     * resource response with the created user. In case of failure the {@link Mono}
     * will error.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.upsertUser -->
     * <pre>
     * String userId = &quot;userId&quot;;
     * CosmosUserProperties userProperties = new CosmosUserProperties&#40;&#41;;
     * userProperties.setId&#40;userId&#41;;
     * cosmosAsyncDatabase.upsertUser&#40;userProperties&#41;
     *     .subscribe&#40;
     *         userResponse -&gt; System.out.println&#40;userResponse&#41;,
     *         throwable -&gt; System.out.println&#40;&quot;Failed to upsert user: &quot; + throwable&#41;
     *     &#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.upsertUser -->
     *
     * @param userProperties the cosmos user properties
     * @return an {@link Mono} containing the single resource response with the
     * upserted user or an error.
     */
    public Mono<CosmosUserResponse> upsertUser(CosmosUserProperties userProperties) {
        return withContext(context -> upsertUserInternal(userProperties, context));
    }

    /**
     * Reads all cosmos users in a database.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.readAllUsers -->
     * <pre>
     * cosmosAsyncDatabase.readAllUsers&#40;&#41;
     *     .byPage&#40;&#41;
     *     .flatMap&#40;userPropertiesFeedResponse -&gt; &#123;
     *         for &#40;CosmosUserProperties properties : userPropertiesFeedResponse.getResults&#40;&#41;&#41; &#123;
     *             System.out.println&#40;properties&#41;;
     *         &#125;
     *         return Flux.empty&#40;&#41;;
     *     &#125;&#41;
     *     .subscribe&#40;&#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.readAllUsers -->
     * After subscription the operation will be performed. The {@link CosmosPagedFlux} will
     * contain one or several feed response of the read cosmos users. In case of
     * failure the {@link CosmosPagedFlux} will error.
     *
     * @return a {@link CosmosPagedFlux} containing one or several feed response pages of the
     * read cosmos users or an error.
     */
    public CosmosPagedFlux<CosmosUserProperties> readAllUsers() {
        return readAllUsers(new CosmosQueryRequestOptions());
    }

    /**
     * Reads all cosmos users in a database.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.readAllUsers -->
     * <pre>
     * cosmosAsyncDatabase.readAllUsers&#40;&#41;
     *     .byPage&#40;&#41;
     *     .flatMap&#40;userPropertiesFeedResponse -&gt; &#123;
     *         for &#40;CosmosUserProperties properties : userPropertiesFeedResponse.getResults&#40;&#41;&#41; &#123;
     *             System.out.println&#40;properties&#41;;
     *         &#125;
     *         return Flux.empty&#40;&#41;;
     *     &#125;&#41;
     *     .subscribe&#40;&#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.readAllUsers -->
     * After subscription the operation will be performed. The {@link CosmosPagedFlux} will
     * contain one or several feed response of the read cosmos users. In case of
     * failure the {@link CosmosPagedFlux} will error.
     *
     * @param options the query request options.
     * @return a {@link CosmosPagedFlux} containing one or several feed response pages of the
     * read cosmos users or an error.
     */
    CosmosPagedFlux<CosmosUserProperties> readAllUsers(CosmosQueryRequestOptions options) {
        return UtilBridgeInternal.createCosmosPagedFlux(pagedFluxOptions -> {
            String spanName = "readAllUsers." + this.getId();
            CosmosAsyncClient client = this.getClient();
            CosmosQueryRequestOptions nonNullOptions = options != null ? options : new CosmosQueryRequestOptions();

            QueryFeedOperationState state = new QueryFeedOperationState(
                client,
                spanName,
                getId(),
                null,
                ResourceType.User,
                OperationType.ReadFeed,
                queryOptionsAccessor.getQueryNameOrDefault(nonNullOptions, spanName),
                nonNullOptions,
                pagedFluxOptions
            );

            pagedFluxOptions.setFeedOperationState(state);

            return getDocClientWrapper().readUsers(getLink(), state)
                .map(response -> feedResponseAccessor.createFeedResponse(
                    ModelBridgeInternal.getCosmosUserPropertiesFromV2Results(response.getResults()), response
                        .getResponseHeaders(),
                    response.getCosmosDiagnostics()));
        });
    }

    /**
     * Gets a CosmosAsyncClientEncryptionKey object without making a service call
     *
     * @param id id of the clientEncryptionKey
     * @return Cosmos ClientEncryptionKey
     */
    public CosmosAsyncClientEncryptionKey getClientEncryptionKey(String id) {
        return new CosmosAsyncClientEncryptionKey(id, this);
    }

    /**
     * Reads all cosmos client encryption keys in a database.
     * <p>
     * After subscription the operation will be performed. The {@link CosmosPagedFlux} will
     * contain one or several feed response of the read cosmos client encryption keys. In case of
     * failure the {@link CosmosPagedFlux} will error.
     *
     * @return a {@link CosmosPagedFlux} containing one or several feed response pages of the
     * read cosmos client encryption keys or an error.
     */
    public CosmosPagedFlux<CosmosClientEncryptionKeyProperties> readAllClientEncryptionKeys() {
        return readAllClientEncryptionKeys(new CosmosQueryRequestOptions());
    }

    /**
     * Reads all cosmos client encryption keys in a database.
     * <p>
     * After subscription the operation will be performed. The {@link CosmosPagedFlux} will
     * contain one or several feed response of the read cosmos client encryption keys. In case of
     * failure the {@link CosmosPagedFlux} will error.
     *
     * @param options the query request options.
     * @return a {@link CosmosPagedFlux} containing one or several feed response pages of the
     * read cosmos client encryption keys or an error.
     */
    public CosmosPagedFlux<CosmosClientEncryptionKeyProperties> readAllClientEncryptionKeys(CosmosQueryRequestOptions options) {
        return UtilBridgeInternal.createCosmosPagedFlux(pagedFluxOptions -> {
            String spanName = "readAllClientEncryptionKeys." + this.getId();
            CosmosAsyncClient client = this.getClient();
            CosmosQueryRequestOptions nonNullOptions = options != null ? options : new CosmosQueryRequestOptions();

            QueryFeedOperationState state = new QueryFeedOperationState(
                client,
                spanName,
                getId(),
                null,
                ResourceType.ClientEncryptionKey,
                OperationType.ReadFeed,
                queryOptionsAccessor.getQueryNameOrDefault(nonNullOptions, spanName),
                nonNullOptions,
                pagedFluxOptions
            );

            pagedFluxOptions.setFeedOperationState(state);

            return getDocClientWrapper().readClientEncryptionKeys(getLink(), state)
                .map(response -> feedResponseAccessor.createFeedResponse(
                    ModelBridgeInternal.getClientEncryptionKeyPropertiesList(response.getResults()), response
                        .getResponseHeaders(),
                    response.getCosmosDiagnostics()));
        });
    }

    /**
     * Query for cosmos client encryption keys in a database.
     * <p>
     * After subscription the operation will be performed. The {@link CosmosPagedFlux} will
     * contain one or several feed response of the obtained client encryption keys. In case of
     * failure the {@link CosmosPagedFlux} will error.
     *
     * @param query query as string.
     * @return a {@link CosmosPagedFlux} containing one or several feed response pages of the
     * obtained client encryption keys or an error.
     */
    public CosmosPagedFlux<CosmosClientEncryptionKeyProperties> queryClientEncryptionKeys(String query) {
        return queryClientEncryptionKeys(query, new CosmosQueryRequestOptions());
    }

    /**
     * Query for cosmos client encryption keys in a database.
     * <p>
     * After subscription the operation will be performed. The {@link CosmosPagedFlux} will
     * contain one or several feed response of the obtained client encryption keys. In case of
     * failure the {@link CosmosPagedFlux} will error.
     *
     * @param query   query as string.
     * @param options the query request options.
     * @return a {@link CosmosPagedFlux} containing one or several feed response pages of the
     * obtained client encryption keys or an error.
     */
    public CosmosPagedFlux<CosmosClientEncryptionKeyProperties> queryClientEncryptionKeys(String query, CosmosQueryRequestOptions options) {
        if (options == null) {
            options = new CosmosQueryRequestOptions();
        }

        return queryClientEncryptionKeysInternal(new SqlQuerySpec(query), options);
    }

    /**
     * Query for cosmos client encryption keys in a database.
     * <p>
     * After subscription the operation will be performed. The {@link CosmosPagedFlux} will
     * contain one or several feed response of the obtained client encryption keys. In case of
     * failure the {@link CosmosPagedFlux} will error.
     *
     * @param querySpec the SQL query specification.
     * @return a {@link CosmosPagedFlux} containing one or several feed response pages of the
     * obtained client encryption keys or an error.
     */
    public CosmosPagedFlux<CosmosClientEncryptionKeyProperties> queryClientEncryptionKeys(SqlQuerySpec querySpec) {
        return queryClientEncryptionKeysInternal(querySpec, new CosmosQueryRequestOptions());
    }

    /**
     * Query for cosmos client encryption keys in a database.
     * <p>
     * After subscription the operation will be performed. The {@link CosmosPagedFlux} will
     * contain one or several feed response of the obtained client encryption keys. In case of
     * failure the {@link CosmosPagedFlux} will error.
     *
     * @param querySpec the SQL query specification.
     * @param options   the query request options.
     * @return a {@link CosmosPagedFlux} containing one or several feed response pages of the
     * obtained client encryption keys or an error.
     */
    public CosmosPagedFlux<CosmosClientEncryptionKeyProperties> queryClientEncryptionKeys(SqlQuerySpec querySpec, CosmosQueryRequestOptions options) {
        if (options == null) {
            options = new CosmosQueryRequestOptions();
        }

        return queryClientEncryptionKeysInternal(querySpec, options);
    }

    private CosmosPagedFlux<CosmosClientEncryptionKeyProperties> queryClientEncryptionKeysInternal(
        SqlQuerySpec querySpec,
        CosmosQueryRequestOptions options) {

        return UtilBridgeInternal.createCosmosPagedFlux(pagedFluxOptions -> {
            String spanName = "queryClientEncryptionKeys." + this.getId();
            CosmosAsyncClient client = this.getClient();
            CosmosQueryRequestOptions nonNullOptions = options != null ? options : new CosmosQueryRequestOptions();

            QueryFeedOperationState state = new QueryFeedOperationState(
                client,
                spanName,
                getId(),
                null,
                ResourceType.ClientEncryptionKey,
                OperationType.Query,
                queryOptionsAccessor.getQueryNameOrDefault(nonNullOptions, spanName),
                nonNullOptions,
                pagedFluxOptions
            );

            pagedFluxOptions.setFeedOperationState(state);

            return getDocClientWrapper().queryClientEncryptionKeys(getLink(), querySpec, state)
                .map(response -> BridgeInternal.createFeedResponseWithQueryMetrics(
                    ModelBridgeInternal.getClientEncryptionKeyPropertiesList(response.getResults()),
                    response.getResponseHeaders(),
                    ModelBridgeInternal.queryMetrics(response),
                    ModelBridgeInternal.getQueryPlanDiagnosticsContext(response),
                    false,
                    false,
                    response.getCosmosDiagnostics()));
        });
    }

    /**
     * Query for cosmos users in a database.
     * <p>
     * After subscription the operation will be performed. The {@link CosmosPagedFlux} will
     * contain one or several feed response of the obtained users. In case of
     * failure the {@link CosmosPagedFlux} will error.
     *
     * @param query query as string.
     * @return a {@link CosmosPagedFlux} containing one or several feed response pages of the
     * obtained users or an error.
     */
    public CosmosPagedFlux<CosmosUserProperties> queryUsers(String query) {
        return queryUsers(query, new CosmosQueryRequestOptions());
    }

    /**
     * Query for cosmos users in a database.
     * <p>
     * After subscription the operation will be performed. The {@link CosmosPagedFlux} will
     * contain one or several feed response of the obtained users. In case of
     * failure the {@link CosmosPagedFlux} will error.
     *
     * @param query   query as string.
     * @param options the query request options.
     * @return a {@link CosmosPagedFlux} containing one or several feed response pages of the
     * obtained users or an error.
     */
    public CosmosPagedFlux<CosmosUserProperties> queryUsers(String query, CosmosQueryRequestOptions options) {
        if (options == null) {
            options = new CosmosQueryRequestOptions();
        }

        return queryUsersInternal(new SqlQuerySpec(query), options);
    }

    /**
     * Query for cosmos users in a database.
     * <p>
     * After subscription the operation will be performed. The {@link CosmosPagedFlux} will
     * contain one or several feed response of the obtained users. In case of
     * failure the {@link CosmosPagedFlux} will error.
     *
     * @param querySpec the SQL query specification.
     * @return a {@link CosmosPagedFlux} containing one or several feed response pages of the
     * obtained users or an error.
     */
    public CosmosPagedFlux<CosmosUserProperties> queryUsers(SqlQuerySpec querySpec) {
        return queryUsersInternal(querySpec, new CosmosQueryRequestOptions());
    }

    /**
     * Query for cosmos users in a database.
     * <p>
     * After subscription the operation will be performed. The {@link CosmosPagedFlux} will
     * contain one or several feed response of the obtained users. In case of
     * failure the {@link CosmosPagedFlux} will error.
     *
     * @param querySpec the SQL query specification.
     * @param options   the query request options.
     * @return a {@link CosmosPagedFlux} containing one or several feed response pages of the
     * obtained users or an error.
     */
    public CosmosPagedFlux<CosmosUserProperties> queryUsers(SqlQuerySpec querySpec, CosmosQueryRequestOptions options) {
        if (options == null) {
            options = new CosmosQueryRequestOptions();
        }

        return queryUsersInternal(querySpec, options);
    }

    /**
     * Gets user.
     *
     * @param id the id
     * @return the user
     */
    public CosmosAsyncUser getUser(String id) {
        return new CosmosAsyncUser(id, this);
    }

    /**
     * Sets throughput provisioned for a container in measurement of
     * Requests-per-Unit in the Azure Cosmos service.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.replaceThroughput -->
     * <pre>
     * ThroughputProperties autoscaledThroughput = ThroughputProperties
     *     .createAutoscaledThroughput&#40;autoScaleMaxThroughput&#41;;
     * cosmosAsyncDatabase.replaceThroughput&#40;autoscaledThroughput&#41;
     *     .subscribe&#40;throughputResponse -&gt; &#123;
     *             System.out.println&#40;throughputResponse&#41;;
     *         &#125;,
     *         throwable -&gt; &#123;
     *             throwable.printStackTrace&#40;&#41;;
     *         &#125;&#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.replaceThroughput -->
     * @param throughputProperties the throughput properties.
     * @return the mono.
     */
    public Mono<ThroughputResponse> replaceThroughput(ThroughputProperties throughputProperties) {
        return withContext(context -> replaceThroughputInternal(throughputProperties, context));
    }

    /**
     * Gets the throughput of the database.
     * <!-- src_embed com.azure.cosmos.CosmosAsyncDatabase.readThroughput -->
     * <pre>
     * cosmosAsyncDatabase.readThroughput&#40;&#41;
     *     .subscribe&#40;throughputResponse -&gt; &#123;
     *             System.out.println&#40;throughputResponse&#41;;
     *         &#125;,
     *         throwable -&gt; &#123;
     *             throwable.printStackTrace&#40;&#41;;
     *         &#125;&#41;;
     * </pre>
     * <!-- end com.azure.cosmos.CosmosAsyncDatabase.readThroughput -->
     * @return the mono containing throughput response.
     */
    public Mono<ThroughputResponse> readThroughput() {
        return withContext(this::readThroughputInternal);
    }

    SqlQuerySpec getOfferQuerySpecFromResourceId(String resourceId) {
        String queryText = "select * from c where c.offerResourceId = @resourceId";
        SqlQuerySpec querySpec = new SqlQuerySpec(queryText);
        List<SqlParameter> parameters = Collections
            .singletonList(new SqlParameter("@resourceId", resourceId));
        querySpec.setParameters(parameters);
        return querySpec;
    }

    CosmosAsyncClient getClient() {
        return client;
    }

    AsyncDocumentClient getDocClientWrapper() {
        return client.getDocClientWrapper();
    }

    String getURIPathSegment() {
        return Paths.DATABASES_PATH_SEGMENT;
    }

    String getParentLink() {
        return StringUtils.EMPTY;
    }

    String getLink() {
        return this.link;
    }

    private CosmosPagedFlux<CosmosContainerProperties> queryContainersInternal(SqlQuerySpec querySpec
        , CosmosQueryRequestOptions options) {
        return UtilBridgeInternal.createCosmosPagedFlux(pagedFluxOptions -> {
            String spanName = "queryContainers." + this.getId();
            CosmosAsyncClient client = this.getClient();
            CosmosQueryRequestOptions nonNullOptions = options != null ? options : new CosmosQueryRequestOptions();

            QueryFeedOperationState state = new QueryFeedOperationState(
                client,
                spanName,
                getId(),
                null,
                ResourceType.DocumentCollection,
                OperationType.Query,
                queryOptionsAccessor.getQueryNameOrDefault(nonNullOptions, spanName),
                nonNullOptions,
                pagedFluxOptions
            );

            pagedFluxOptions.setFeedOperationState(state);

            return getDocClientWrapper().queryCollections(getLink(), querySpec, state)
                .map(response -> feedResponseAccessor.createFeedResponse(
                    ModelBridgeInternal.getCosmosContainerPropertiesFromV2Results(response.getResults()),
                    response.getResponseHeaders(),
                    response.getCosmosDiagnostics()));
        });
    }

    private CosmosPagedFlux<CosmosUserProperties> queryUsersInternal(SqlQuerySpec querySpec, CosmosQueryRequestOptions options) {
        return UtilBridgeInternal.createCosmosPagedFlux(pagedFluxOptions -> {
            String spanName = "queryUsers." + this.getId();
            CosmosAsyncClient client = this.getClient();
            CosmosQueryRequestOptions nonNullOptions = options != null ? options : new CosmosQueryRequestOptions();

            QueryFeedOperationState state = new QueryFeedOperationState(
                client,
                spanName,
                getId(),
                null,
                ResourceType.User,
                OperationType.Query,
                queryOptionsAccessor.getQueryNameOrDefault(nonNullOptions, spanName),
                nonNullOptions,
                pagedFluxOptions
            );

            pagedFluxOptions.setFeedOperationState(state);

            return getDocClientWrapper().queryUsers(getLink(), querySpec, state)
                .map(response -> BridgeInternal.createFeedResponseWithQueryMetrics(
                    ModelBridgeInternal.getCosmosUserPropertiesFromV2Results(response.getResults()),
                    response.getResponseHeaders(),
                    ModelBridgeInternal.queryMetrics(response),
                    ModelBridgeInternal.getQueryPlanDiagnosticsContext(response),
                    false,
                    false,
                    response.getCosmosDiagnostics()));
        });
    }

    private Mono<CosmosContainerResponse> createContainerIfNotExistsInternal(
        CosmosContainerProperties containerProperties,
        CosmosAsyncContainer container,
        CosmosContainerRequestOptions options,
        Context context) {
        String spanName = "createContainerIfNotExists." + containerProperties.getId();
        Context nestedContext = context.addData(
            DiagnosticsProvider.COSMOS_CALL_DEPTH,
            DiagnosticsProvider.COSMOS_CALL_DEPTH_VAL);
        final CosmosContainerRequestOptions requestOptions = options == null ? new CosmosContainerRequestOptions() :
            options;

        Mono<CosmosContainerResponse> responseMono =
            container.read(requestOptions, nestedContext).onErrorResume(exception -> {
                final Throwable unwrappedException = Exceptions.unwrap(exception);
                if (unwrappedException instanceof CosmosException) {
                    final CosmosException cosmosException = (CosmosException) unwrappedException;
                    if (cosmosException.getStatusCode() == HttpConstants.StatusCodes.NOTFOUND) {
                        return createContainerInternal(containerProperties, requestOptions, nestedContext);
                    }
                }
                return Mono.error(unwrappedException);
            });

        return this.client.getDiagnosticsProvider().traceEnabledCosmosResponsePublisher(
            responseMono,
            context,
            spanName,
            getId(),
            containerProperties.getId(),
            this.client,
            null,
            OperationType.Create,
            ResourceType.DocumentCollection,
            ModelBridgeInternal.toRequestOptions(requestOptions));
    }

    private Mono<CosmosContainerResponse> createContainerInternal(
        CosmosContainerProperties containerProperties,
        CosmosContainerRequestOptions options,
        Context context) {
        String spanName = "createContainer." + containerProperties.getId();
        RequestOptions nonNullRequestOptions =
            options != null ? ModelBridgeInternal.toRequestOptions(options) : new RequestOptions();
        Mono<CosmosContainerResponse> responseMono = getDocClientWrapper()
            .createCollection(this.getLink(), ModelBridgeInternal.getV2Collection(containerProperties),
                nonNullRequestOptions)
            .map(ModelBridgeInternal::createCosmosContainerResponse).single();

        return this.client.getDiagnosticsProvider().traceEnabledCosmosResponsePublisher(
            responseMono,
            context,
            spanName,
            getId(),
            containerProperties.getId(),
            this.client,
            null,
            OperationType.Create,
            ResourceType.DocumentCollection,
            nonNullRequestOptions);
    }

    Mono<CosmosDatabaseResponse> readInternal(CosmosDatabaseRequestOptions options, Context context) {
        String spanName = "readDatabase." + this.getId();
        RequestOptions nonNullRequestOptions =
            options != null ? ModelBridgeInternal.toRequestOptions(options) : new RequestOptions();
        Mono<CosmosDatabaseResponse> responseMono = getDocClientWrapper()
            .readDatabase(getLink(), nonNullRequestOptions)
            .map(ModelBridgeInternal::createCosmosDatabaseResponse).single();

        return this.client.getDiagnosticsProvider().traceEnabledCosmosResponsePublisher(
            responseMono,
            context,
            spanName,
            getId(),
            null,
            this.client,
            null,
            OperationType.Read,
            ResourceType.Database,
            nonNullRequestOptions);
    }

    private Mono<CosmosDatabaseResponse> deleteInternal(CosmosDatabaseRequestOptions options, Context context) {
        String spanName = "deleteDatabase." + this.getId();
        RequestOptions nonNullRequestOptions =
            options != null ? ModelBridgeInternal.toRequestOptions(options) : new RequestOptions();
        Mono<CosmosDatabaseResponse> responseMono = getDocClientWrapper()
            .deleteDatabase(getLink(), nonNullRequestOptions)
            .map(ModelBridgeInternal::createCosmosDatabaseResponse).single();

        return this.client.getDiagnosticsProvider().traceEnabledCosmosResponsePublisher(
            responseMono,
            context,
            spanName,
            getId(),
            null,
            this.client,
            null,
            OperationType.Delete,
            ResourceType.Database,
            nonNullRequestOptions);
    }

    private Mono<CosmosUserResponse> createUserInternal(CosmosUserProperties userProperties, Context context) {
        String spanName = "createUser." + this.getId();
        Mono<CosmosUserResponse> responseMono = getDocClientWrapper()
            .createUser(this.getLink(), ModelBridgeInternal.getV2User(userProperties), null)
            .map(ModelBridgeInternal::createCosmosUserResponse).single();

        return this.client.getDiagnosticsProvider().traceEnabledCosmosResponsePublisher(
            responseMono,
            context,
            spanName,
            getId(),
            null,
            this.client,
            null,
            OperationType.Create,
            ResourceType.User,
            null);
    }

    private Mono<CosmosUserResponse> upsertUserInternal(CosmosUserProperties userProperties, Context context) {
        String spanName = "upsertUser." + this.getId();
        Mono<CosmosUserResponse> responseMono = getDocClientWrapper()
            .upsertUser(this.getLink(), ModelBridgeInternal.getV2User(userProperties), null)
            .map(ModelBridgeInternal::createCosmosUserResponse).single();
        return this.client.getDiagnosticsProvider().traceEnabledCosmosResponsePublisher(
            responseMono,
            context,
            spanName,
            getId(),
            null,
            this.client,
            null,
            OperationType.Upsert,
            ResourceType.User,
            null);
    }

    private Mono<CosmosClientEncryptionKeyResponse> createClientEncryptionKeyInternal(CosmosClientEncryptionKeyProperties keyProperties, Context context) {
        String spanName = "createClientEncryptionKey." + this.getId();
        Mono<CosmosClientEncryptionKeyResponse> responseMono =
            getDocClientWrapper()
                .createClientEncryptionKey(
                    this.getLink(),
                    ModelBridgeInternal.getClientEncryptionKey(keyProperties),
                    null)
                .map(ModelBridgeInternal::createCosmosClientEncryptionKeyResponse).single();
        return this.client.getDiagnosticsProvider().traceEnabledCosmosResponsePublisher(
            responseMono,
            context,
            spanName,
            getId(),
            null,
            this.client,
            null,
            OperationType.Create,
            ResourceType.ClientEncryptionKey,
            null);
    }

    private Mono<ThroughputResponse> replaceThroughputInternal(ThroughputProperties throughputProperties, Context context) {
        String spanName = "replaceThroughput." + this.getId();
        Context nestedContext = context.addData(
            DiagnosticsProvider.COSMOS_CALL_DEPTH,
            DiagnosticsProvider.COSMOS_CALL_DEPTH_VAL);
        Mono<ThroughputResponse> responseMono = replaceThroughputInternal(this.readInternal(new CosmosDatabaseRequestOptions(), nestedContext), throughputProperties);
        return this.client.getDiagnosticsProvider().traceEnabledCosmosResponsePublisher(
            responseMono,
            context,
            spanName,
            getId(),
            null,
            this.client,
            null,
            OperationType.Replace,
            ResourceType.Offer,
            null);
    }

    private Mono<ThroughputResponse> replaceThroughputInternal(Mono<CosmosDatabaseResponse> responseMono, ThroughputProperties throughputProperties) {

        QueryFeedOperationState state = new QueryFeedOperationState(
            this.getClient(),
            "replaceThroughputInternal",
            this.getId(),
            null,
            ResourceType.Offer,
            OperationType.Query,
            null,
            new CosmosQueryRequestOptions(),
            new CosmosPagedFluxOptions()
        );

        return responseMono
            .flatMap(response -> this.getDocClientWrapper()
                .queryOffers(getOfferQuerySpecFromResourceId(response.getProperties().getResourceId()),
                    state)
                .single()
                .flatMap(offerFeedResponse -> {
                    if (offerFeedResponse.getResults().isEmpty()) {
                        return Mono.error(BridgeInternal
                            .createCosmosException(
                                HttpConstants.StatusCodes.BADREQUEST,
                                "No offers found for the " +
                                    "resource " + this.getId()));
                    }

                    Offer existingOffer = offerFeedResponse.getResults().get(0);
                    Offer updatedOffer =
                        ModelBridgeInternal.updateOfferFromProperties(existingOffer,
                            throughputProperties);

                    return this.getDocClientWrapper()
                        .replaceOffer(updatedOffer)
                        .single();
                })
                .map(ModelBridgeInternal::createThroughputRespose));
    }

    private Mono<ThroughputResponse> readThroughputInternal(Context context) {
        String spanName = "readThroughput." + this.getId();
        Context nestedContext = context.addData(
            DiagnosticsProvider.COSMOS_CALL_DEPTH,
            DiagnosticsProvider.COSMOS_CALL_DEPTH_VAL);
        CosmosQueryRequestOptions qryOptions = new CosmosQueryRequestOptions();
        Mono<ThroughputResponse> responseMono = readThroughputInternal(this.readInternal(new CosmosDatabaseRequestOptions(), nestedContext), qryOptions);
        return this.client.getDiagnosticsProvider().traceEnabledCosmosResponsePublisher(
            responseMono,
            context,
            spanName,
            getId(),
            null,
            this.client,
            null,
            OperationType.Read,
            ResourceType.Offer,
            ImplementationBridgeHelpers
                .CosmosQueryRequestOptionsHelper
                .getCosmosQueryRequestOptionsAccessor()
                .toRequestOptions(qryOptions));
    }

    private Mono<ThroughputResponse> readThroughputInternal(Mono<CosmosDatabaseResponse> responseMono, CosmosQueryRequestOptions qryOptions) {

        QueryFeedOperationState state = new QueryFeedOperationState(
            this.getClient(),
            "readThroughputInternal",
            this.getId(),
            null,
            ResourceType.Offer,
            OperationType.Query,
            null,
            new CosmosQueryRequestOptions(),
            new CosmosPagedFluxOptions()
        );

        return responseMono
            .flatMap(response -> getDocClientWrapper()
                .queryOffers(getOfferQuerySpecFromResourceId(response.getProperties().getResourceId()),
                    state)
                .single()
                .flatMap(offerFeedResponse -> {
                    if (offerFeedResponse.getResults().isEmpty()) {
                        return Mono.error(BridgeInternal
                            .createCosmosException(
                                HttpConstants.StatusCodes.BADREQUEST,
                                "No offers found for the resource " + this.getId())
                            .setDiagnostics(offerFeedResponse.getCosmosDiagnostics())
                        );
                    }
                    return getDocClientWrapper()
                        .readOffer(offerFeedResponse.getResults()
                            .get(0)
                            .getSelfLink())
                        .single();
                })
                .map(ModelBridgeInternal::createThroughputRespose));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    // the following helper/accessor only helps to access this class outside of this package.//
    ///////////////////////////////////////////////////////////////////////////////////////////
    static void initialize() {
        ImplementationBridgeHelpers.CosmosAsyncDatabaseHelper.setCosmosAsyncDatabaseAccessor(
            new ImplementationBridgeHelpers.CosmosAsyncDatabaseHelper.CosmosAsyncDatabaseAccessor() {

                @Override
                public CosmosAsyncClient getCosmosAsyncClient(CosmosAsyncDatabase cosmosAsyncDatabase) {
                    return cosmosAsyncDatabase.getClient();
                }

                @Override
                public String getLink(CosmosAsyncDatabase cosmosAsyncDatabase) {
                    return cosmosAsyncDatabase.getLink();
                }
            });
    }

    static {
        initialize();
    }
}
