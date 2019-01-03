/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2019 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class ResourceDetailsSmall extends AbstractApiBase {

    private String resourceType;
    private String resourceName;

    public ResourceDetailsSmall() {
    }

    public ResourceDetailsSmall(String resourceType, String resourceName) {
        this.resourceType = resourceType;
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

}
