/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.permission;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.foilen.smalltools.tools.CollectionsTools;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class PermissionLink {

    private LinkAction action;
    private boolean isExplicitChange;
    private String fromType;
    private String fromOwner;
    private String linkType;
    private String toType;
    private String toOwner;

    public LinkAction getAction() {
        return action;
    }

    public String getFromOwner() {
        return fromOwner;
    }

    public String getFromType() {
        return fromType;
    }

    public String getLinkType() {
        return linkType;
    }

    public String getToOwner() {
        return toOwner;
    }

    public String getToType() {
        return toType;
    }

    public boolean isExplicitChange() {
        return isExplicitChange;
    }

    public boolean isPartial() {
        return !CollectionsTools.isAllItemNotNull(fromType, fromOwner, linkType, toType, toOwner);
    }

    public PermissionLink setAction(LinkAction action) {
        this.action = action;
        return this;
    }

    public PermissionLink setExplicitChange(boolean isExplicitChange) {
        this.isExplicitChange = isExplicitChange;
        return this;
    }

    public PermissionLink setFromOwner(String fromOwner) {
        this.fromOwner = fromOwner;
        return this;
    }

    public PermissionLink setFromType(String fromType) {
        this.fromType = fromType;
        return this;
    }

    public PermissionLink setLinkType(String linkType) {
        this.linkType = linkType;
        return this;
    }

    public PermissionLink setToOwner(String toOwner) {
        this.toOwner = toOwner;
        return this;
    }

    public PermissionLink setToType(String toType) {
        this.toType = toType;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PermissionLink [action=");
        builder.append(action);
        builder.append(", isExplicitChange=");
        builder.append(isExplicitChange);
        builder.append(", fromType=");
        builder.append(fromType);
        builder.append(", fromOwner=");
        builder.append(fromOwner);
        builder.append(", linkType=");
        builder.append(linkType);
        builder.append(", toType=");
        builder.append(toType);
        builder.append(", toOwner=");
        builder.append(toOwner);
        builder.append("]");
        return builder.toString();
    }

}
