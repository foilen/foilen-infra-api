/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.request;

public class ResourceToUpdateRequest extends AbstractRequest {

    private ResourceDetails resourcePk;
    private ResourceDetails updatedResource;

    public ResourceToUpdateRequest() {
    }

    public ResourceToUpdateRequest(ResourceDetails resourcePk, ResourceDetails updatedResource) {
        this.resourcePk = resourcePk;
        this.updatedResource = updatedResource;
    }

    public ResourceDetails getResourcePk() {
        return resourcePk;
    }

    public ResourceDetails getUpdatedResource() {
        return updatedResource;
    }

    public void setResourcePk(ResourceDetails resourcePk) {
        this.resourcePk = resourcePk;
    }

    public void setUpdatedResource(ResourceDetails updatedResource) {
        this.updatedResource = updatedResource;
    }

}
