/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.service;

public interface InfraApiService {

    InfraAlertApiService getInfraAlertApiService();

    InfraMachineApiService getInfraMachineApiService();

    InfraResourceApiService getInfraResourceApiService();

}
