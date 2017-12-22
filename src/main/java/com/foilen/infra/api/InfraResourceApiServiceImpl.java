/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api;

import com.foilen.infra.api.request.ChangesRequest;
import com.foilen.infra.api.response.ResponseWithStatus;

public class InfraResourceApiServiceImpl implements InfraResourceApiService {

    private InfraApiServiceImpl infraApiService;

    public InfraResourceApiServiceImpl(InfraApiServiceImpl infraApiService) {
        this.infraApiService = infraApiService;
    }

    @Override
    public ResponseWithStatus applyChanges(ChangesRequest changesRequest) {
        return infraApiService.post("/api/resource/applyChanges", changesRequest, ResponseWithStatus.class);
    }

}
