// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.eventgrid.fluent.models.VerifiedPartnerInner;
import com.azure.resourcemanager.eventgrid.models.PartnerDetails;
import com.azure.resourcemanager.eventgrid.models.VerifiedPartnerProvisioningState;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;

public final class VerifiedPartnerInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        VerifiedPartnerInner model = BinaryData.fromString(
            "{\"properties\":{\"partnerRegistrationImmutableId\":\"c7e86a55-f555-409f-b2db-3ea5eb82908b\",\"organizationName\":\"k\",\"partnerDisplayName\":\"hu\",\"partnerTopicDetails\":{\"description\":\"rctat\",\"longDescription\":\"intqpbrlcyr\",\"setupUri\":\"czkgofxyfsrucvcr\"},\"provisioningState\":\"Updating\"},\"id\":\"ttbst\",\"name\":\"jeaq\",\"type\":\"rmvvfkoxmlghktui\"}")
            .toObject(VerifiedPartnerInner.class);
        Assertions.assertEquals(UUID.fromString("c7e86a55-f555-409f-b2db-3ea5eb82908b"),
            model.partnerRegistrationImmutableId());
        Assertions.assertEquals("k", model.organizationName());
        Assertions.assertEquals("hu", model.partnerDisplayName());
        Assertions.assertEquals("rctat", model.partnerTopicDetails().description());
        Assertions.assertEquals("intqpbrlcyr", model.partnerTopicDetails().longDescription());
        Assertions.assertEquals("czkgofxyfsrucvcr", model.partnerTopicDetails().setupUri());
        Assertions.assertEquals(VerifiedPartnerProvisioningState.UPDATING, model.provisioningState());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        VerifiedPartnerInner model = new VerifiedPartnerInner()
            .withPartnerRegistrationImmutableId(UUID.fromString("c7e86a55-f555-409f-b2db-3ea5eb82908b"))
            .withOrganizationName("k")
            .withPartnerDisplayName("hu")
            .withPartnerTopicDetails(new PartnerDetails().withDescription("rctat")
                .withLongDescription("intqpbrlcyr")
                .withSetupUri("czkgofxyfsrucvcr"))
            .withProvisioningState(VerifiedPartnerProvisioningState.UPDATING);
        model = BinaryData.fromObject(model).toObject(VerifiedPartnerInner.class);
        Assertions.assertEquals(UUID.fromString("c7e86a55-f555-409f-b2db-3ea5eb82908b"),
            model.partnerRegistrationImmutableId());
        Assertions.assertEquals("k", model.organizationName());
        Assertions.assertEquals("hu", model.partnerDisplayName());
        Assertions.assertEquals("rctat", model.partnerTopicDetails().description());
        Assertions.assertEquals("intqpbrlcyr", model.partnerTopicDetails().longDescription());
        Assertions.assertEquals("czkgofxyfsrucvcr", model.partnerTopicDetails().setupUri());
        Assertions.assertEquals(VerifiedPartnerProvisioningState.UPDATING, model.provisioningState());
    }
}
