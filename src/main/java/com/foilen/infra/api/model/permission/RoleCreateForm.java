/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.permission;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class RoleCreateForm extends AbstractApiBase {

    private String name;

    public String getName() {
        return name;
    }

    public RoleCreateForm setName(String name) {
        this.name = name;
        return this;
    }

}
