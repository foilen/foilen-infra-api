/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class PartialLinkDetails extends AbstractApiBase {

    private ResourceDetails otherResource;
    private String linkType;

    public PartialLinkDetails() {
    }

    public PartialLinkDetails(ResourceDetails otherResource, String linkType) {
        this.otherResource = otherResource;
        this.linkType = linkType;
    }

    public String getLinkType() {
        return linkType;
    }

    public ResourceDetails getOtherResource() {
        return otherResource;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public void setOtherResource(ResourceDetails otherResource) {
        this.otherResource = otherResource;
    }

}
