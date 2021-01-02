/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.permission;

import com.foilen.smalltools.restapi.model.AbstractSingleResult;

public class RoleResult extends AbstractSingleResult<Role> {

    public RoleResult() {
    }

    public RoleResult(Role item) {
        this.setItem(item);
    }

}
