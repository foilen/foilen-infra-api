/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.foilen.infra.api.model.machine.DiskStat;
import com.foilen.infra.api.model.machine.SystemStats;
import com.foilen.infra.api.model.resource.ResourceDetails;
import com.foilen.infra.api.request.RequestChanges;
import com.foilen.infra.api.request.RequestResourceSearch;
import com.foilen.infra.api.response.ResponseResourceBucket;
import com.foilen.infra.api.service.InfraAlertApiService;
import com.foilen.infra.api.service.InfraApiServiceImpl;
import com.foilen.infra.api.service.InfraMachineApiService;
import com.foilen.infra.api.service.InfraResourceApiService;
import com.foilen.infra.api.service.InfraUserHumanApiService;
import com.foilen.smalltools.restapi.model.AbstractApiBaseWithError;
import com.foilen.smalltools.systemusage.results.NetworkInfo;
import com.foilen.smalltools.tools.DateTools;
import com.foilen.smalltools.tools.DirectoryTools;
import com.foilen.smalltools.tools.JsonTools;
import com.foilen.smalltools.tools.LogbackTools;
import com.foilen.smalltools.tools.SecureRandomTools;
import com.google.common.base.Supplier;

public class TestApiApp {

    private static final String DEFAULT_OWNER = "alpha";
    private static final String OUTPUT_FOLDER = "_test_output";
    private static final String DNS_ENTRY_RESOURCE_TYPE = "Dns Entry";

    private static String apiTestDnsEntryName;

    private static RequestChanges createChangeRequest() {

        apiTestDnsEntryName = SecureRandomTools.randomHexString(3) + "apitest.example2.com";

        RequestChanges changes = new RequestChanges();
        changes.setDefaultOwner(DEFAULT_OWNER);
        Map<String, String> resource = new HashMap<>();
        resource.put("name", apiTestDnsEntryName);
        resource.put("type", "CNAME");
        resource.put("details", "google.com");
        changes.getResourcesToAdd().add(new ResourceDetails(null, DNS_ENTRY_RESOURCE_TYPE, resource));
        return changes;
    }

    private static SystemStats createSystemStats() {
        SystemStats systemStat = new SystemStats();
        systemStat.setTimestamp(DateTools.addDate(Calendar.MINUTE, 1));
        systemStat.setCpuTotal(1000);
        systemStat.setCpuUsed((long) (Math.random() * 1000));
        systemStat.setMemorySwapTotal(4096);
        systemStat.setMemorySwapUsed((long) (Math.random() * 4096));
        systemStat.setMemoryTotal(8192);
        systemStat.setMemoryUsed((long) (Math.random() * (systemStat.getMemoryTotal() - systemStat.getMemorySwapTotal()) + systemStat.getMemorySwapTotal()));

        List<DiskStat> diskStats = new ArrayList<>();
        DiskStat diskRootStat = new DiskStat();
        diskRootStat.setRoot(true);
        diskRootStat.setPath("/");
        diskRootStat.setTotalSpace(200000000000l);
        diskRootStat.setFreeSpace((long) (Math.random() * 200000000000l));
        diskRootStat.setFreeSpacePercent(diskRootStat.getFreeSpace() / diskRootStat.getTotalSpace());
        diskRootStat.setUsedSpace(diskRootStat.getTotalSpace() - diskRootStat.getFreeSpace());
        diskRootStat.setUsedSpacePercent(diskRootStat.getUsedSpace() / diskRootStat.getTotalSpace());
        diskStats.add(diskRootStat);
        DiskStat diskBootStat = new DiskStat();
        diskBootStat.setRoot(true);
        diskBootStat.setPath("/boot");
        diskBootStat.setTotalSpace(1000000000l);
        diskBootStat.setFreeSpace(800000000);
        diskBootStat.setFreeSpacePercent(diskBootStat.getFreeSpace() / diskBootStat.getTotalSpace());
        diskBootStat.setUsedSpace(diskBootStat.getTotalSpace() - diskBootStat.getFreeSpace());
        diskBootStat.setUsedSpacePercent(diskBootStat.getUsedSpace() / diskBootStat.getTotalSpace());
        diskStats.add(diskBootStat);
        systemStat.setDiskStats(diskStats);

        List<NetworkInfo> networkDeltas = new ArrayList<>();
        NetworkInfo networkInfo = new NetworkInfo();
        networkInfo.setInterfaceName("eth0");
        networkInfo.setInBytes((long) (Math.random() * 1024000));
        networkInfo.setInPackets(networkInfo.getInBytes() / 1024);
        networkInfo.setOutBytes((long) (Math.random() * 1024000));
        networkInfo.setOutPackets(networkInfo.getOutBytes() / 1024);
        networkDeltas.add(networkInfo);
        systemStat.setNetworkDeltas(networkDeltas);
        return systemStat;
    }

    private static <R extends AbstractApiBaseWithError> R execute(String name, Supplier<R> supplier) {
        System.out.println("---[" + name + "]---");
        R response = supplier.get();
        System.out.println(JsonTools.prettyPrint(response));

        JsonTools.writeToFile(OUTPUT_FOLDER + "/" + name + ".json", response);

        return response;
    }

    public static void main(String[] args) {

        LogbackTools.changeConfig("/com/foilen/infra/api/test/logback-debug.xml");

        DirectoryTools.deleteFolder(OUTPUT_FOLDER);
        DirectoryTools.createPath(OUTPUT_FOLDER);

        InfraApiServiceImpl infraApiService = new InfraApiServiceImpl("http://localhost:8888", "AADMIN", "01234567");

        InfraMachineApiService machineApiService = infraApiService.getInfraMachineApiService();
        execute("machineApiService.getMachineSetup", () -> machineApiService.getMachineSetup("f001.node.example.com"));
        execute("machineApiService.sendSystemStats", () -> machineApiService.sendSystemStats("f001.node.example.com", Arrays.asList(createSystemStats())));

        InfraResourceApiService resourceApiService = infraApiService.getInfraResourceApiService();

        execute("resourceApiService.applyChanges", () -> resourceApiService.applyChanges(createChangeRequest()));
        execute("resourceApiService.resourceFindAll-search", () -> resourceApiService.resourceFindAll(new RequestResourceSearch() //
                .setResourceType(DNS_ENTRY_RESOURCE_TYPE)));
        execute("resourceApiService.resourceFindAll-page-0", () -> resourceApiService.resourceFindAll(0, null, false));
        execute("resourceApiService.resourceFindAll-page-1", () -> resourceApiService.resourceFindAll(1, null, false));
        ResponseResourceBucket oneFound = execute("resourceApiService.resourceFindOne", () -> resourceApiService.resourceFindOne(new RequestResourceSearch() //
                .setResourceType(DNS_ENTRY_RESOURCE_TYPE) //
                .setProperties(Collections.singletonMap("name", apiTestDnsEntryName))));
        execute("resourceApiService.typeFindAll", () -> resourceApiService.typeFindAll());

        execute("resourceApiService.resourceFindAllAs-search", () -> resourceApiService.resourceFindAllAs("333333", new RequestResourceSearch() //
                .setResourceType(DNS_ENTRY_RESOURCE_TYPE)));
        execute("resourceApiService.resourceFindAllAs-page", () -> resourceApiService.resourceFindAllAs("333333", 1, null, false));

        execute("resourceApiService.resourceFindAllWithDetailsAse", () -> resourceApiService.resourceFindAllWithDetailsAs("333333", new RequestResourceSearch() //
                .setResourceType(DNS_ENTRY_RESOURCE_TYPE)));

        execute("resourceApiService.applyChangesAs", () -> resourceApiService.applyChangesAs("333333", createChangeRequest()));

        // Try to get all the links
        System.out.println("---[ Get the links ]---");
        oneFound.getItem().getLinksTo().forEach(linkTo -> {
            execute("resourceApiService.resourceFindOneByPk", () -> resourceApiService.resourceFindOneByPk(linkTo.getOtherResource()));
        });

        // Send alert
        System.out.println("---[ Send alert ]---");
        InfraAlertApiService infraAlertApiService = infraApiService.getInfraAlertApiService();
        execute("alertApiService.sendAlert", () -> infraAlertApiService.sendAlert("The subject", "The content"));

        // Human users api
        System.out.println("---[ Human User ]---");
        InfraUserHumanApiService infraUserHumanApiService = infraApiService.getInfraUserHumanApiService();
        execute("userHumanApiService.userHumanCreateByEmail", () -> infraUserHumanApiService.userHumanCreateByEmail(SecureRandomTools.randomHexString(5) + "@foilen.com"));
        execute("userHumanApiService.userHumanFindAll", () -> infraUserHumanApiService.userHumanFindAll(1, null));

    }

}
