/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2019 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.service;

public interface InfraApiService {

    InfraMachineApiService getInfraMachineApiService();

    InfraResourceApiService getInfraResourceApiService();

}
