/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.resource;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class LinkDetails extends AbstractApiBase {

    private ResourceDetails fromResource;
    private String linkType;
    private ResourceDetails toResource;

    public LinkDetails() {
    }

    public LinkDetails(ResourceDetails fromResource, String linkType, ResourceDetails toResource) {
        this.fromResource = fromResource;
        this.linkType = linkType;
        this.toResource = toResource;
    }

    public ResourceDetails getFromResource() {
        return fromResource;
    }

    public String getLinkType() {
        return linkType;
    }

    public ResourceDetails getToResource() {
        return toResource;
    }

    public void setFromResource(ResourceDetails fromResource) {
        this.fromResource = fromResource;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public void setToResource(ResourceDetails toResource) {
        this.toResource = toResource;
    }

}
