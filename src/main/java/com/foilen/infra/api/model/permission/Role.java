/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.permission;

import java.util.ArrayList;
import java.util.List;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class Role extends AbstractApiBase {

    private String name;

    private List<PermissionResource> resources = new ArrayList<>();
    private List<PermissionLink> links = new ArrayList<>();

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public List<PermissionLink> getLinks() {
        return links;
    }

    public String getName() {
        return name;
    }

    public List<PermissionResource> getResources() {
        return resources;
    }

    public Role setLinks(List<PermissionLink> links) {
        this.links = links;
        return this;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public Role setResources(List<PermissionResource> resources) {
        this.resources = resources;
        return this;
    }

}
