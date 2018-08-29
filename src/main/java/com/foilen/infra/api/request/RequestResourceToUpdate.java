/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.request;

import com.foilen.infra.api.model.ResourceDetails;
import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class RequestResourceToUpdate extends AbstractApiBase {

    private ResourceDetails resourcePk;
    private ResourceDetails updatedResource;

    public RequestResourceToUpdate() {
    }

    public RequestResourceToUpdate(ResourceDetails resourcePk, ResourceDetails updatedResource) {
        this.resourcePk = resourcePk;
        this.updatedResource = updatedResource;
    }

    public ResourceDetails getResourcePk() {
        return resourcePk;
    }

    public ResourceDetails getUpdatedResource() {
        return updatedResource;
    }

    public RequestResourceToUpdate setResourcePk(ResourceDetails resourcePk) {
        this.resourcePk = resourcePk;
        return this;
    }

    public RequestResourceToUpdate setUpdatedResource(ResourceDetails updatedResource) {
        this.updatedResource = updatedResource;
        return this;
    }

}
