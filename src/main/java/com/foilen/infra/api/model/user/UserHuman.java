/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.user;

import java.util.SortedSet;
import java.util.TreeSet;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class UserHuman extends AbstractApiBase {

    private String userId;
    private boolean isAdmin;

    private String email;

    private SortedSet<String> roles = new TreeSet<>();

    public String getEmail() {
        return email;
    }

    public SortedSet<String> getRoles() {
        return roles;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public UserHuman setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
        return this;
    }

    public UserHuman setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserHuman setRoles(SortedSet<String> roles) {
        this.roles = roles;
        return this;
    }

    public UserHuman setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
