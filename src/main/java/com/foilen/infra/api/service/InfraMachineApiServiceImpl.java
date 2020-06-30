/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.foilen.infra.api.model.machine.SystemStats;
import com.foilen.infra.api.response.ResponseMachineSetup;
import com.foilen.smalltools.restapi.model.FormResult;

public class InfraMachineApiServiceImpl implements InfraMachineApiService {

    private InfraApiServiceImpl infraApiService;

    public InfraMachineApiServiceImpl(InfraApiServiceImpl infraApiService) {
        this.infraApiService = infraApiService;
    }

    @Override
    public ResponseMachineSetup getMachineSetup(String machineName) {
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("machineName", machineName);
        return infraApiService.get("/api/machine/{machineName}/setup", ResponseMachineSetup.class, uriVariables);
    }

    @Override
    public FormResult sendSystemStats(String machineName, List<SystemStats> systemStats) {
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("machineName", machineName);
        return infraApiService.post("/api/machine/{machineName}/systemStats", systemStats, uriVariables, FormResult.class);
    }

}
