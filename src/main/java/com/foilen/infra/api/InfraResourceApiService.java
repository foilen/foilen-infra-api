/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api;

import com.foilen.infra.api.request.ChangesRequest;
import com.foilen.infra.api.response.ResponseWithStatus;

public interface InfraResourceApiService {

    ResponseWithStatus applyChanges(ChangesRequest changesRequest);

}
