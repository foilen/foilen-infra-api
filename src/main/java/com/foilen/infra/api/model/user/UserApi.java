/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.user;

import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import com.foilen.smalltools.restapi.model.AbstractApiBase;
import com.foilen.smalltools.tools.DateTools;

public class UserApi extends AbstractApiBase {

    private String userId;
    private boolean isAdmin;

    private String description;

    private Date createdOn;
    private Date expireOn;

    private SortedSet<String> roles = new TreeSet<>();

    public Date getCreatedOn() {
        return createdOn;
    }

    public String getCreatedOnText() {
        return DateTools.formatFull(createdOn);
    }

    public String getDescription() {
        return description;
    }

    public Date getExpireOn() {
        return expireOn;
    }

    public String getExpireOnText() {
        return DateTools.formatFull(expireOn);
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

    public UserApi setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
        return this;
    }

    public UserApi setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public UserApi setDescription(String description) {
        this.description = description;
        return this;
    }

    public UserApi setExpireOn(Date expireOn) {
        this.expireOn = expireOn;
        return this;
    }

    public UserApi setRoles(SortedSet<String> roles) {
        this.roles = roles;
        return this;
    }

    public UserApi setUserId(String userId) {
        this.userId = userId;
        return this;
    }

}
