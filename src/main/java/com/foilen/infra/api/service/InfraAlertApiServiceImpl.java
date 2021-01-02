/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.service;

import com.foilen.infra.api.request.RequestAlert;
import com.foilen.smalltools.restapi.model.FormResult;

public class InfraAlertApiServiceImpl implements InfraAlertApiService {

    private InfraApiServiceImpl infraApiService;

    public InfraAlertApiServiceImpl(InfraApiServiceImpl infraApiService) {
        this.infraApiService = infraApiService;
    }

    @Override
    public FormResult sendAlert(String subject, String content) {
        RequestAlert requestAlert = new RequestAlert();
        requestAlert.setSubject(subject);
        requestAlert.setContent(content);
        return infraApiService.post("/api/alert/", requestAlert, null, FormResult.class);
    }

}
