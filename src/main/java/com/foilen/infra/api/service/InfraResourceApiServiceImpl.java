/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.service;

import com.foilen.infra.api.request.ChangesRequest;
import com.foilen.smalltools.restapi.model.FormResult;

public class InfraResourceApiServiceImpl implements InfraResourceApiService {

    private InfraApiServiceImpl infraApiService;

    public InfraResourceApiServiceImpl(InfraApiServiceImpl infraApiService) {
        this.infraApiService = infraApiService;
    }

    @Override
    public FormResult applyChanges(ChangesRequest changesRequest) {
        return infraApiService.post("/api/resource/applyChanges", changesRequest, FormResult.class);
    }

}
