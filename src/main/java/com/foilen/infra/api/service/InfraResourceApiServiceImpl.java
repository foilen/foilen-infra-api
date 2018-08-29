/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.service;

import com.foilen.infra.api.request.RequestChanges;
import com.foilen.infra.api.request.RequestResourceSearch;
import com.foilen.infra.api.response.ResponseResourceBucket;
import com.foilen.infra.api.response.ResponseResourceBuckets;
import com.foilen.infra.api.response.ResponseResourceTypesDetails;
import com.foilen.smalltools.restapi.model.FormResult;

public class InfraResourceApiServiceImpl implements InfraResourceApiService {

    private InfraApiServiceImpl infraApiService;

    public InfraResourceApiServiceImpl(InfraApiServiceImpl infraApiService) {
        this.infraApiService = infraApiService;
    }

    @Override
    public FormResult applyChanges(RequestChanges changesRequest) {
        return infraApiService.post("/api/resource/applyChanges", changesRequest, FormResult.class);
    }

    @Override
    public ResponseResourceBuckets resourceFindAll(RequestResourceSearch resourceSearch) {
        return infraApiService.post("/api/resource/resourceFindAll", resourceSearch, null, ResponseResourceBuckets.class);
    }

    @Override
    public ResponseResourceBucket resourceFindOne(RequestResourceSearch resourceSearch) {
        return infraApiService.post("/api/resource/resourceFindOne", resourceSearch, null, ResponseResourceBucket.class);
    }

    @Override
    public ResponseResourceTypesDetails typeFindAll() {
        return infraApiService.get("/api/resourceType", ResponseResourceTypesDetails.class);
    }

}
