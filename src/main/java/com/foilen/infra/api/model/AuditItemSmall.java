/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class AuditItemSmall extends AbstractApiBase {

    private AuditType type;
    private AuditAction action;

    private ResourceDetailsSmall resourceFirst;
    private ResourceDetailsSmall resourceSecond;

    private String linkType;

    private String tagName;

    public AuditAction getAction() {
        return action;
    }

    public String getLinkType() {
        return linkType;
    }

    public ResourceDetailsSmall getResourceFirst() {
        return resourceFirst;
    }

    public ResourceDetailsSmall getResourceSecond() {
        return resourceSecond;
    }

    public String getTagName() {
        return tagName;
    }

    public AuditType getType() {
        return type;
    }

    public void setAction(AuditAction action) {
        this.action = action;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public void setResourceFirst(ResourceDetailsSmall resourceFirst) {
        this.resourceFirst = resourceFirst;
    }

    public void setResourceSecond(ResourceDetailsSmall resourceSecond) {
        this.resourceSecond = resourceSecond;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public void setType(AuditType type) {
        this.type = type;
    }

}
