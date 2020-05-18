/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class TagDetails extends AbstractApiBase {

    private String tagName;
    private ResourceDetails resourcePk;

    public TagDetails() {
    }

    public TagDetails(String tagName, ResourceDetails resourcePk) {
        this.tagName = tagName;
        this.resourcePk = resourcePk;
    }

    public ResourceDetails getResourcePk() {
        return resourcePk;
    }

    public String getTagName() {
        return tagName;
    }

    public void setResourcePk(ResourceDetails resourcePk) {
        this.resourcePk = resourcePk;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

}
