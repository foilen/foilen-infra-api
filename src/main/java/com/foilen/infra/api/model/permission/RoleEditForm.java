/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.permission;

import java.util.ArrayList;
import java.util.List;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class RoleEditForm extends AbstractApiBase {

    private List<PermissionResource> resources = new ArrayList<>();
    private List<PermissionLink> links = new ArrayList<>();

    public List<PermissionLink> getLinks() {
        return links;
    }

    public List<PermissionResource> getResources() {
        return resources;
    }

    public void setLinks(List<PermissionLink> links) {
        this.links = links;
    }

    public void setResources(List<PermissionResource> resources) {
        this.resources = resources;
    }

}
