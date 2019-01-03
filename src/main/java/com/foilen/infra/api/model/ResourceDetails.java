/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2019 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class ResourceDetails extends AbstractApiBase {

    private String resourceType;
    private Object resource;

    public ResourceDetails() {
    }

    public ResourceDetails(String resourceType, Object resource) {
        this.resourceType = resourceType;
        this.resource = resource;
    }

    public Object getResource() {
        return resource;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResource(Object resource) {
        this.resource = resource;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

}
