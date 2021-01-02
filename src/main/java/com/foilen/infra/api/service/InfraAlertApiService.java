/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.service;

import com.foilen.smalltools.restapi.model.FormResult;

public interface InfraAlertApiService {

    FormResult sendAlert(String subject, String content);

}
