/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.permission;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class OwnerRuleCreateOrEditForm extends AbstractApiBase {

    private String resourceNameStartsWith;
    private String resourceNameEndsWith;

    private String assignOwner;

    public String getAssignOwner() {
        return assignOwner;
    }

    public String getResourceNameEndsWith() {
        return resourceNameEndsWith;
    }

    public String getResourceNameStartsWith() {
        return resourceNameStartsWith;
    }

    public OwnerRuleCreateOrEditForm setAssignOwner(String assignOwner) {
        this.assignOwner = assignOwner;
        return this;
    }

    public OwnerRuleCreateOrEditForm setResourceNameEndsWith(String resourceNameEndsWith) {
        this.resourceNameEndsWith = resourceNameEndsWith;
        return this;
    }

    public OwnerRuleCreateOrEditForm setResourceNameStartsWith(String resourceNameStartsWith) {
        this.resourceNameStartsWith = resourceNameStartsWith;
        return this;
    }

}
