/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.request;

import java.util.HashMap;
import java.util.Map;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class RequestResourceSearch extends AbstractApiBase {

    private String resourceType;
    private Map<String, Object> properties = new HashMap<>();
    private String tag;

    public Map<String, Object> getProperties() {
        return properties;
    }

    public String getResourceType() {
        return resourceType;
    }

    public String getTag() {
        return tag;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
