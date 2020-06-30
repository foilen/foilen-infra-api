/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.permission;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class OwnerRule extends AbstractApiBase {

    private String id;

    private String resourceNameStartsWith;
    private String resourceNameEndsWith;

    private String assignOwner;

    public String getAssignOwner() {
        return assignOwner;
    }

    public String getId() {
        return id;
    }

    public String getResourceNameEndsWith() {
        return resourceNameEndsWith;
    }

    public String getResourceNameStartsWith() {
        return resourceNameStartsWith;
    }

    public OwnerRule setAssignOwner(String assignOwner) {
        this.assignOwner = assignOwner;
        return this;
    }

    public OwnerRule setId(String id) {
        this.id = id;
        return this;
    }

    public OwnerRule setResourceNameEndsWith(String resourceNameEndsWith) {
        this.resourceNameEndsWith = resourceNameEndsWith;
        return this;
    }

    public OwnerRule setResourceNameStartsWith(String resourceNameStartsWith) {
        this.resourceNameStartsWith = resourceNameStartsWith;
        return this;
    }

}
