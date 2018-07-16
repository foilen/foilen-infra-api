/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.request;

import com.foilen.infra.api.InfraApiUiException;
import com.foilen.infra.plugin.v1.core.resource.IPResourceDefinition;
import com.foilen.infra.plugin.v1.core.service.IPResourceService;
import com.foilen.infra.plugin.v1.model.resource.IPResource;
import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class ResourceDetails extends AbstractApiBase {

    private String resourceType;
    private Object resource;

    public ResourceDetails() {
    }

    public ResourceDetails(IPResourceService resourceService, IPResource resource) {
        IPResourceDefinition resourceDefinition = resourceService.getResourceDefinition(resource.getClass());
        if (resourceDefinition == null) {
            throw new InfraApiUiException("The class " + resourceType.getClass().getName() + " has no known resource type");
        }
        this.resourceType = resourceDefinition.getResourceType();
        this.resource = resource;
    }

    public ResourceDetails(String resourceType, Object resource) {
        this.resourceType = resourceType;
        this.resource = resource;
    }

    public Object getResource() {
        return resource;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResource(Object resource) {
        this.resource = resource;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

}
