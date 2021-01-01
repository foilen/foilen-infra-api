/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (http://foilen.com)

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
public class PermissionResource {

    private ResourceAction action;
    private boolean isExplicitChange;
    private String type;
    private String owner;

    public ResourceAction getAction() {
        return action;
    }

    public String getOwner() {
        return owner;
    }

    public String getType() {
        return type;
    }

    public boolean isExplicitChange() {
        return isExplicitChange;
    }

    public boolean isPartial() {
        return !CollectionsTools.isAllItemNotNull(type, owner);
    }

    public PermissionResource setAction(ResourceAction action) {
        this.action = action;
        return this;
    }

    public PermissionResource setExplicitChange(boolean isExplicitChange) {
        this.isExplicitChange = isExplicitChange;
        return this;
    }

    public PermissionResource setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public PermissionResource setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PermissionResource [action=");
        builder.append(action);
        builder.append(", isExplicitChange=");
        builder.append(isExplicitChange);
        builder.append(", type=");
        builder.append(type);
        builder.append(", owner=");
        builder.append(owner);
        builder.append("]");
        return builder.toString();
    }

}
