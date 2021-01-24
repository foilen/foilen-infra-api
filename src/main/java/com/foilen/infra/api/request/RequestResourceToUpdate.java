/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.request;

import com.foilen.infra.api.model.resource.ResourceDetails;
import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class RequestResourceToUpdate extends AbstractApiBase {

    private ResourceDetails resource;
    private ResourceDetails updatedResource;

    public RequestResourceToUpdate() {
    }

    public RequestResourceToUpdate(ResourceDetails resource, ResourceDetails updatedResource) {
        this.resource = resource;
        this.updatedResource = updatedResource;
    }

    public ResourceDetails getResource() {
        return resource;
    }

    public ResourceDetails getUpdatedResource() {
        return updatedResource;
    }

    public RequestResourceToUpdate setResource(ResourceDetails resource) {
        this.resource = resource;
        return this;
    }

    public RequestResourceToUpdate setUpdatedResource(ResourceDetails updatedResource) {
        this.updatedResource = updatedResource;
        return this;
    }

}
