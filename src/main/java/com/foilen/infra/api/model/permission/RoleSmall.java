/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.permission;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class RoleSmall extends AbstractApiBase {

    private String name;

    public RoleSmall() {
    }

    public RoleSmall(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public RoleSmall setName(String name) {
        this.name = name;
        return this;
    }

}
