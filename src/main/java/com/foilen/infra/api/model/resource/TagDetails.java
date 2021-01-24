/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.resource;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class TagDetails extends AbstractApiBase {

    private String tagName;
    private ResourceDetails resource;

    public TagDetails() {
    }

    public TagDetails(String tagName, ResourceDetails resource) {
        this.tagName = tagName;
        this.resource = resource;
    }

    public ResourceDetails getResource() {
        return resource;
    }

    public String getTagName() {
        return tagName;
    }

    public void setResource(ResourceDetails resource) {
        this.resource = resource;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

}
