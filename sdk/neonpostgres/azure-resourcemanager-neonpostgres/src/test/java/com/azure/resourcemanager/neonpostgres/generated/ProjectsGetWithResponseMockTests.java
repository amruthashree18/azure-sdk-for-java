// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.neonpostgres.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.neonpostgres.NeonPostgresManager;
import com.azure.resourcemanager.neonpostgres.models.EndpointType;
import com.azure.resourcemanager.neonpostgres.models.Project;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ProjectsGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"entityId\":\"cdgzseznux\",\"entityName\":\"uairaabmdlqjb\",\"createdAt\":\"pfixlhupmo\",\"provisioningState\":\"Failed\",\"attributes\":[{\"name\":\"dnpxpkcdpr\",\"value\":\"yxelyicghflr\"},{\"name\":\"fss\",\"value\":\"yghsf\"},{\"name\":\"rkbhammgmqfm\",\"value\":\"fgvqcpdw\"}],\"regionId\":\"quxweyslandkd\",\"storage\":119386751526092271,\"pgVersion\":1672179952,\"historyRetention\":1016575602,\"defaultEndpointSettings\":{\"autoscalingLimitMinCu\":64.32770434429936,\"autoscalingLimitMaxCu\":87.51880479756822},\"branch\":{\"entityId\":\"rnquoxso\",\"entityName\":\"reimseob\",\"createdAt\":\"xstcyilbvzm\",\"provisioningState\":\"Succeeded\",\"attributes\":[{\"name\":\"lq\",\"value\":\"zexokjxeb\"},{\"name\":\"vbzinz\",\"value\":\"bwmvogljsvl\"}],\"projectId\":\"idnwceha\",\"parentId\":\"do\",\"roleName\":\"l\",\"databaseName\":\"iomqoqpepiaea\",\"roles\":[{\"entityId\":\"rgdtpeqnacyheqw\",\"entityName\":\"qq\",\"createdAt\":\"jubkhjozfymcwmb\",\"provisioningState\":\"Canceled\",\"attributes\":[{\"name\":\"yvliq\",\"value\":\"ipsejbsvsia\"},{\"name\":\"eswhd\",\"value\":\"zydisnuep\"},{\"name\":\"wyj\",\"value\":\"nldpxottd\"},{\"name\":\"i\",\"value\":\"ocqibz\"}],\"branchId\":\"hweebiph\",\"permissions\":[\"cjwqw\",\"qsratjhd\",\"zybspijhfrzgdkk\",\"gv\"],\"isSuperUser\":true},{\"entityId\":\"susmmorfmzhwi\",\"entityName\":\"zhnijmr\",\"createdAt\":\"r\",\"provisioningState\":\"Failed\",\"attributes\":[{\"name\":\"yttlrcxiv\",\"value\":\"bkut\"},{\"name\":\"umltwjflu\",\"value\":\"ynbpvzlqywauy\"},{\"name\":\"njc\",\"value\":\"hmocgjshg\"}],\"branchId\":\"a\",\"permissions\":[\"vi\",\"qqgglj\"],\"isSuperUser\":false}],\"databases\":[{\"entityId\":\"clrvtzqnrbctbh\",\"entityName\":\"hxpcvrdnyeita\",\"createdAt\":\"qady\",\"provisioningState\":\"Succeeded\",\"attributes\":[{\"name\":\"wriuomzczfkic\",\"value\":\"evsaa\"},{\"name\":\"wspcaxikhfjqebg\",\"value\":\"cx\"}],\"branchId\":\"gzzromv\",\"ownerName\":\"ysemtmesrfsvpin\"},{\"entityId\":\"pat\",\"entityName\":\"diswxspvckojazb\",\"createdAt\":\"spftesubzpv\",\"provisioningState\":\"Canceled\",\"attributes\":[{\"name\":\"ytcovqs\",\"value\":\"usrf\"}],\"branchId\":\"d\",\"ownerName\":\"fxnxml\"},{\"entityId\":\"uoswkjmdih\",\"entityName\":\"yyyzlwhbw\",\"createdAt\":\"nufzr\",\"provisioningState\":\"Succeeded\",\"attributes\":[{\"name\":\"gnnbzrtf\",\"value\":\"edzuub\"},{\"name\":\"tvgj\",\"value\":\"xmtyj\"}],\"branchId\":\"avdpwwobtdphtits\",\"ownerName\":\"ofw\"}],\"endpoints\":[{\"entityId\":\"k\",\"entityName\":\"auwazcgwd\",\"createdAt\":\"iwgy\",\"provisioningState\":\"Failed\",\"attributes\":[{\"name\":\"ok\",\"value\":\"cvgllixdg\"},{\"name\":\"yfgwewqkj\",\"value\":\"xprwpxs\"}],\"projectId\":\"hu\",\"branchId\":\"lcsklt\",\"endpointType\":\"read_write\"}]},\"roles\":[{\"entityId\":\"gzlf\",\"entityName\":\"rdcgu\",\"createdAt\":\"rtmdylperpil\",\"provisioningState\":\"Succeeded\",\"attributes\":[{\"name\":\"czfcmfpfbod\",\"value\":\"tresr\"},{\"name\":\"vtshuvf\",\"value\":\"waivmuqkevzg\"}],\"branchId\":\"panhxmpdxxze\",\"permissions\":[\"zjwotnxlkfhglh\",\"foxqwecrsn\",\"pcs\",\"lqxov\"],\"isSuperUser\":true}],\"databases\":[{\"entityId\":\"kklvzrlrmlccmet\",\"entityName\":\"czivfqbqna\",\"createdAt\":\"sye\",\"provisioningState\":\"Canceled\",\"attributes\":[{\"name\":\"uscplhyvdg\",\"value\":\"lyzkxitds\"},{\"name\":\"ezsvkolrupjov\",\"value\":\"ozsaye\"},{\"name\":\"razwzlpzbt\",\"value\":\"uykykipfsd\"}],\"branchId\":\"pfnocm\",\"ownerName\":\"zacfpztgazw\"}],\"endpoints\":[{\"entityId\":\"gaaokctgkp\",\"entityName\":\"kqzkcyzmff\",\"createdAt\":\"dyfcix\",\"provisioningState\":\"Failed\",\"attributes\":[{\"name\":\"vhoej\",\"value\":\"oiutgwrmkahpq\"},{\"name\":\"azyntacihncogm\",\"value\":\"pnmliq\"}],\"projectId\":\"lbhik\",\"branchId\":\"qgrvg\",\"endpointType\":\"read_only\"},{\"entityId\":\"p\",\"entityName\":\"dtsdfjy\",\"createdAt\":\"socwiqbuout\",\"provisioningState\":\"Succeeded\",\"attributes\":[{\"name\":\"leofj\",\"value\":\"bgbwwz\"},{\"name\":\"dajfwnncfma\",\"value\":\"iqgjjrlhiql\"},{\"name\":\"ixvt\",\"value\":\"ougu\"}],\"projectId\":\"n\",\"branchId\":\"pg\",\"endpointType\":\"read_only\"},{\"entityId\":\"asualapdlndbea\",\"entityName\":\"kixvvlwy\",\"createdAt\":\"bb\",\"provisioningState\":\"Canceled\",\"attributes\":[{\"name\":\"jmspugzfeuzjlj\",\"value\":\"phfky\"},{\"name\":\"zolgjzmicuydocc\",\"value\":\"xshanzb\"}],\"projectId\":\"adh\",\"branchId\":\"tecaa\",\"endpointType\":\"read_write\"}]},\"id\":\"hzniucbda\",\"name\":\"mbwiinjdllwktl\",\"type\":\"pow\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        NeonPostgresManager manager = NeonPostgresManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        Project response
            = manager.projects().getWithResponse("ektm", "o", "omtzamicb", com.azure.core.util.Context.NONE).getValue();

        Assertions.assertEquals("uairaabmdlqjb", response.properties().entityName());
        Assertions.assertEquals("dnpxpkcdpr", response.properties().attributes().get(0).name());
        Assertions.assertEquals("yxelyicghflr", response.properties().attributes().get(0).value());
        Assertions.assertEquals("quxweyslandkd", response.properties().regionId());
        Assertions.assertEquals(119386751526092271L, response.properties().storage());
        Assertions.assertEquals(1672179952, response.properties().pgVersion());
        Assertions.assertEquals(1016575602, response.properties().historyRetention());
        Assertions.assertEquals(64.32770434429936,
            response.properties().defaultEndpointSettings().autoscalingLimitMinCu());
        Assertions.assertEquals(87.51880479756822,
            response.properties().defaultEndpointSettings().autoscalingLimitMaxCu());
        Assertions.assertEquals("reimseob", response.properties().branch().entityName());
        Assertions.assertEquals("lq", response.properties().branch().attributes().get(0).name());
        Assertions.assertEquals("zexokjxeb", response.properties().branch().attributes().get(0).value());
        Assertions.assertEquals("idnwceha", response.properties().branch().projectId());
        Assertions.assertEquals("do", response.properties().branch().parentId());
        Assertions.assertEquals("l", response.properties().branch().roleName());
        Assertions.assertEquals("iomqoqpepiaea", response.properties().branch().databaseName());
        Assertions.assertEquals("qq", response.properties().branch().roles().get(0).entityName());
        Assertions.assertEquals("yvliq", response.properties().branch().roles().get(0).attributes().get(0).name());
        Assertions.assertEquals("ipsejbsvsia",
            response.properties().branch().roles().get(0).attributes().get(0).value());
        Assertions.assertEquals("hweebiph", response.properties().branch().roles().get(0).branchId());
        Assertions.assertEquals("cjwqw", response.properties().branch().roles().get(0).permissions().get(0));
        Assertions.assertTrue(response.properties().branch().roles().get(0).isSuperUser());
        Assertions.assertEquals("hxpcvrdnyeita", response.properties().branch().databases().get(0).entityName());
        Assertions.assertEquals("wriuomzczfkic",
            response.properties().branch().databases().get(0).attributes().get(0).name());
        Assertions.assertEquals("evsaa", response.properties().branch().databases().get(0).attributes().get(0).value());
        Assertions.assertEquals("gzzromv", response.properties().branch().databases().get(0).branchId());
        Assertions.assertEquals("ysemtmesrfsvpin", response.properties().branch().databases().get(0).ownerName());
        Assertions.assertEquals("auwazcgwd", response.properties().branch().endpoints().get(0).entityName());
        Assertions.assertEquals("ok", response.properties().branch().endpoints().get(0).attributes().get(0).name());
        Assertions.assertEquals("cvgllixdg",
            response.properties().branch().endpoints().get(0).attributes().get(0).value());
        Assertions.assertEquals("hu", response.properties().branch().endpoints().get(0).projectId());
        Assertions.assertEquals("lcsklt", response.properties().branch().endpoints().get(0).branchId());
        Assertions.assertEquals(EndpointType.READ_WRITE,
            response.properties().branch().endpoints().get(0).endpointType());
        Assertions.assertEquals("rdcgu", response.properties().roles().get(0).entityName());
        Assertions.assertEquals("czfcmfpfbod", response.properties().roles().get(0).attributes().get(0).name());
        Assertions.assertEquals("tresr", response.properties().roles().get(0).attributes().get(0).value());
        Assertions.assertEquals("panhxmpdxxze", response.properties().roles().get(0).branchId());
        Assertions.assertEquals("zjwotnxlkfhglh", response.properties().roles().get(0).permissions().get(0));
        Assertions.assertTrue(response.properties().roles().get(0).isSuperUser());
        Assertions.assertEquals("czivfqbqna", response.properties().databases().get(0).entityName());
        Assertions.assertEquals("uscplhyvdg", response.properties().databases().get(0).attributes().get(0).name());
        Assertions.assertEquals("lyzkxitds", response.properties().databases().get(0).attributes().get(0).value());
        Assertions.assertEquals("pfnocm", response.properties().databases().get(0).branchId());
        Assertions.assertEquals("zacfpztgazw", response.properties().databases().get(0).ownerName());
        Assertions.assertEquals("kqzkcyzmff", response.properties().endpoints().get(0).entityName());
        Assertions.assertEquals("vhoej", response.properties().endpoints().get(0).attributes().get(0).name());
        Assertions.assertEquals("oiutgwrmkahpq", response.properties().endpoints().get(0).attributes().get(0).value());
        Assertions.assertEquals("lbhik", response.properties().endpoints().get(0).projectId());
        Assertions.assertEquals("qgrvg", response.properties().endpoints().get(0).branchId());
        Assertions.assertEquals(EndpointType.READ_ONLY, response.properties().endpoints().get(0).endpointType());
    }
}
