// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.customerinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.customerinsights.fluent.models.RelationshipLinkDefinition;
import com.azure.resourcemanager.customerinsights.models.LinkTypes;
import com.azure.resourcemanager.customerinsights.models.ParticipantProfilePropertyReference;
import com.azure.resourcemanager.customerinsights.models.RelationshipLinkFieldMapping;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class RelationshipLinkDefinitionTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        RelationshipLinkDefinition model = BinaryData.fromString(
            "{\"displayName\":{\"resmkssjhoiftxfk\":\"fidltug\",\"tillucbiqtg\":\"wegprh\",\"hm\":\"q\"},\"description\":{\"llibphbqzmizak\":\"ldrizetpwbra\",\"jpdn\":\"kan\",\"xprimrsop\":\"zhajoylhjlmuo\",\"stvasylwxdzaumw\":\"eecjmeis\"},\"interactionType\":\"oohgu\",\"linkName\":\"uzboyjathw\",\"mappings\":[{\"interactionFieldName\":\"lbaemwmdxmeb\",\"linkType\":\"CopyIfNull\",\"relationshipFieldName\":\"cjpahl\"},{\"interactionFieldName\":\"veabfqxnmwmqtib\",\"linkType\":\"UpdateAlways\",\"relationshipFieldName\":\"jddtvqct\"},{\"interactionFieldName\":\"adijaeukmrsie\",\"linkType\":\"CopyIfNull\",\"relationshipFieldName\":\"ndzaapmudq\"}],\"profilePropertyReferences\":[{\"interactionPropertyName\":\"qwigpibudqwyxe\",\"profilePropertyName\":\"e\"}],\"provisioningState\":\"Deleting\",\"relatedProfilePropertyReferences\":[{\"interactionPropertyName\":\"zznrtffyaqi\",\"profilePropertyName\":\"mhh\"},{\"interactionPropertyName\":\"ioqaqhvs\",\"profilePropertyName\":\"ufuqyrx\"},{\"interactionPropertyName\":\"dlcgqlsismjqfr\",\"profilePropertyName\":\"dgamquhiosrsj\"},{\"interactionPropertyName\":\"ivfcdisyirnx\",\"profilePropertyName\":\"hcz\"}],\"relationshipName\":\"xrxzbujrtr\",\"relationshipGuidId\":\"vwrevkhgnlnzon\",\"tenantId\":\"rpiqywncv\"}")
            .toObject(RelationshipLinkDefinition.class);
        Assertions.assertEquals("fidltug", model.displayName().get("resmkssjhoiftxfk"));
        Assertions.assertEquals("ldrizetpwbra", model.description().get("llibphbqzmizak"));
        Assertions.assertEquals("oohgu", model.interactionType());
        Assertions.assertEquals("lbaemwmdxmeb", model.mappings().get(0).interactionFieldName());
        Assertions.assertEquals(LinkTypes.COPY_IF_NULL, model.mappings().get(0).linkType());
        Assertions.assertEquals("cjpahl", model.mappings().get(0).relationshipFieldName());
        Assertions.assertEquals("qwigpibudqwyxe", model.profilePropertyReferences().get(0).interactionPropertyName());
        Assertions.assertEquals("e", model.profilePropertyReferences().get(0).profilePropertyName());
        Assertions.assertEquals("zznrtffyaqi",
            model.relatedProfilePropertyReferences().get(0).interactionPropertyName());
        Assertions.assertEquals("mhh", model.relatedProfilePropertyReferences().get(0).profilePropertyName());
        Assertions.assertEquals("xrxzbujrtr", model.relationshipName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        RelationshipLinkDefinition model = new RelationshipLinkDefinition()
            .withDisplayName(mapOf("resmkssjhoiftxfk", "fidltug", "tillucbiqtg", "wegprh", "hm", "q"))
            .withDescription(mapOf("llibphbqzmizak", "ldrizetpwbra", "jpdn", "kan", "xprimrsop", "zhajoylhjlmuo",
                "stvasylwxdzaumw", "eecjmeis"))
            .withInteractionType("oohgu")
            .withMappings(Arrays.asList(
                new RelationshipLinkFieldMapping().withInteractionFieldName("lbaemwmdxmeb")
                    .withLinkType(LinkTypes.COPY_IF_NULL)
                    .withRelationshipFieldName("cjpahl"),
                new RelationshipLinkFieldMapping().withInteractionFieldName("veabfqxnmwmqtib")
                    .withLinkType(LinkTypes.UPDATE_ALWAYS)
                    .withRelationshipFieldName("jddtvqct"),
                new RelationshipLinkFieldMapping().withInteractionFieldName("adijaeukmrsie")
                    .withLinkType(LinkTypes.COPY_IF_NULL)
                    .withRelationshipFieldName("ndzaapmudq")))
            .withProfilePropertyReferences(
                Arrays.asList(new ParticipantProfilePropertyReference().withInteractionPropertyName("qwigpibudqwyxe")
                    .withProfilePropertyName("e")))
            .withRelatedProfilePropertyReferences(Arrays.asList(
                new ParticipantProfilePropertyReference().withInteractionPropertyName("zznrtffyaqi")
                    .withProfilePropertyName("mhh"),
                new ParticipantProfilePropertyReference().withInteractionPropertyName("ioqaqhvs")
                    .withProfilePropertyName("ufuqyrx"),
                new ParticipantProfilePropertyReference().withInteractionPropertyName("dlcgqlsismjqfr")
                    .withProfilePropertyName("dgamquhiosrsj"),
                new ParticipantProfilePropertyReference().withInteractionPropertyName("ivfcdisyirnx")
                    .withProfilePropertyName("hcz")))
            .withRelationshipName("xrxzbujrtr");
        model = BinaryData.fromObject(model).toObject(RelationshipLinkDefinition.class);
        Assertions.assertEquals("fidltug", model.displayName().get("resmkssjhoiftxfk"));
        Assertions.assertEquals("ldrizetpwbra", model.description().get("llibphbqzmizak"));
        Assertions.assertEquals("oohgu", model.interactionType());
        Assertions.assertEquals("lbaemwmdxmeb", model.mappings().get(0).interactionFieldName());
        Assertions.assertEquals(LinkTypes.COPY_IF_NULL, model.mappings().get(0).linkType());
        Assertions.assertEquals("cjpahl", model.mappings().get(0).relationshipFieldName());
        Assertions.assertEquals("qwigpibudqwyxe", model.profilePropertyReferences().get(0).interactionPropertyName());
        Assertions.assertEquals("e", model.profilePropertyReferences().get(0).profilePropertyName());
        Assertions.assertEquals("zznrtffyaqi",
            model.relatedProfilePropertyReferences().get(0).interactionPropertyName());
        Assertions.assertEquals("mhh", model.relatedProfilePropertyReferences().get(0).profilePropertyName());
        Assertions.assertEquals("xrxzbujrtr", model.relationshipName());
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
