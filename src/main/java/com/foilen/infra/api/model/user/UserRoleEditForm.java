/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.user;

import java.util.SortedSet;
import java.util.TreeSet;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class UserRoleEditForm extends AbstractApiBase {

    private SortedSet<String> roles = new TreeSet<>();

    public SortedSet<String> getRoles() {
        return roles;
    }

    public UserRoleEditForm setRoles(SortedSet<String> roles) {
        this.roles = roles;
        return this;
    }

}
