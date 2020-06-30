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

/**
 * All the details of a resource and of its metadata.
 */
public class ResourceBucket extends AbstractApiBase {

    private ResourceDetails resourceDetails;
    private List<PartialLinkDetails> linksFrom = new ArrayList<>();
    private List<PartialLinkDetails> linksTo = new ArrayList<>();
    private List<String> tags = new ArrayList<>();

    public List<PartialLinkDetails> getLinksFrom() {
        return linksFrom;
    }

    public List<PartialLinkDetails> getLinksTo() {
        return linksTo;
    }

    public ResourceDetails getResourceDetails() {
        return resourceDetails;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setLinksFrom(List<PartialLinkDetails> linksFrom) {
        this.linksFrom = linksFrom;
    }

    public void setLinksTo(List<PartialLinkDetails> linksTo) {
        this.linksTo = linksTo;
    }

    public void setResourceDetails(ResourceDetails resourceDetails) {
        this.resourceDetails = resourceDetails;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

}
