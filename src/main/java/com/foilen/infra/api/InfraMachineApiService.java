/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api;

import java.util.List;

import com.foilen.infra.api.model.SystemStats;
import com.foilen.infra.api.response.ResponseMachineSetup;
import com.foilen.infra.api.response.ResponseWithStatus;

public interface InfraMachineApiService {

    /**
     * Retrieve the softwares to install and how to configure them on the machine.
     *
     * @param machineName
     *            the hostname of the machine
     * @return the configuration
     */
    ResponseMachineSetup getMachineSetup(String machineName);

    /**
     * Send some recorded system stats.
     *
     * @param machineName
     *            the hostname of the machine
     * @param systemStats
     *            the recorded stats
     */
    ResponseWithStatus sendSystemStats(String machineName, List<SystemStats> systemStats);

}
