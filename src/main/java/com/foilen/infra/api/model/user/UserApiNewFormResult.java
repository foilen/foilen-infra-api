/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.user;

import com.foilen.smalltools.restapi.model.FormResult;

public class UserApiNewFormResult extends FormResult {

    private String userId;
    private String password;

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return this.userId;
    }

    public UserApiNewFormResult setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserApiNewFormResult setUserId(String userId) {
        this.userId = userId;
        return this;
    }

}
