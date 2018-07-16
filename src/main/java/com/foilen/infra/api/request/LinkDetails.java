/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.request;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class LinkDetails extends AbstractApiBase {

    private ResourceDetails fromResourcePk;
    private String linkType;
    private ResourceDetails toResourcePk;

    public LinkDetails() {
    }

    public LinkDetails(ResourceDetails fromResourcePk, String linkType, ResourceDetails toResourcePk) {
        this.fromResourcePk = fromResourcePk;
        this.linkType = linkType;
        this.toResourcePk = toResourcePk;
    }

    public ResourceDetails getFromResourcePk() {
        return fromResourcePk;
    }

    public String getLinkType() {
        return linkType;
    }

    public ResourceDetails getToResourcePk() {
        return toResourcePk;
    }

    public void setFromResourcePk(ResourceDetails fromResourcePk) {
        this.fromResourcePk = fromResourcePk;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public void setToResourcePk(ResourceDetails toResourcePk) {
        this.toResourcePk = toResourcePk;
    }

}
