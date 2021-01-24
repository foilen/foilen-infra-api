/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.resource;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class ResourceDetails extends AbstractApiBase {

    private String resourceId;
    private String resourceType;
    private Object resource;

    public ResourceDetails() {
    }

    public ResourceDetails(String resourceType, Object resource) {
        this.resourceType = resourceType;
        this.resource = resource;
    }

    public ResourceDetails(String resourceId, String resourceType) {
        this.resourceId = resourceId;
        this.resourceType = resourceType;
    }

    public ResourceDetails(String resourceId, String resourceType, Object resource) {
        this.resourceId = resourceId;
        this.resourceType = resourceType;
        this.resource = resource;
    }

    public Object getResource() {
        return resource;
    }

    public String getResourceId() {
        return resourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResource(Object resource) {
        this.resource = resource;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

}
