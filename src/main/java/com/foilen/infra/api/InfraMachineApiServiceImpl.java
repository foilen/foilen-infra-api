/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.foilen.infra.api.model.MachineSetup;
import com.foilen.infra.api.model.SystemStats;

public class InfraMachineApiServiceImpl implements InfraMachineApiService {

    private InfraApiServiceImpl infraApiService;

    public InfraMachineApiServiceImpl(InfraApiServiceImpl infraApiService) {
        this.infraApiService = infraApiService;
    }

    @Override
    public MachineSetup getMachineSetup(String machineName) {
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("machineName", machineName);
        return infraApiService.get("/api/machine/{machineName}/setup", MachineSetup.class, uriVariables);
    }

    @Override
    public void sendSystemStats(String machineName, List<SystemStats> systemStats) {
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("machineName", machineName);
        infraApiService.post("/api/machine/{machineName}/systemStats", systemStats, uriVariables);
    }

}
