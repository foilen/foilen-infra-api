/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.resource;

import java.util.ArrayList;
import java.util.List;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class ResourceTypeDetails extends AbstractApiBase {

    private String resourceType;
    private boolean embedded;
    private List<String> primaryKeyProperties = new ArrayList<>();
    private List<String> searchableProperties = new ArrayList<>();

    public ResourceTypeDetails() {
    }

    public ResourceTypeDetails(String resourceType, boolean embedded, List<String> primaryKeyProperties, List<String> searchableProperties) {
        this.resourceType = resourceType;
        this.embedded = embedded;
        this.primaryKeyProperties = primaryKeyProperties;
        this.searchableProperties = searchableProperties;
    }

    public List<String> getPrimaryKeyProperties() {
        return primaryKeyProperties;
    }

    public String getResourceType() {
        return resourceType;
    }

    public List<String> getSearchableProperties() {
        return searchableProperties;
    }

    public boolean isEmbedded() {
        return embedded;
    }

    public void setEmbedded(boolean embedded) {
        this.embedded = embedded;
    }

    public void setPrimaryKeyProperties(List<String> primaryKeyProperties) {
        this.primaryKeyProperties = primaryKeyProperties;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public void setSearchableProperties(List<String> searchableProperties) {
        this.searchableProperties = searchableProperties;
    }

}
