/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.request;

import java.util.ArrayList;
import java.util.List;

import com.foilen.infra.api.model.resource.LinkDetails;
import com.foilen.infra.api.model.resource.ResourceDetails;
import com.foilen.infra.api.model.resource.TagDetails;
import com.foilen.smalltools.restapi.model.AbstractApiBase;

/**
 * The changes to make. For any {@link ResourceDetails}, you can put
 * <ul>
 * <li>the resource Id</li>
 * <li>or the resource properties that defines the Primary Key</li>
 * </ul>
 */
public class RequestChanges extends AbstractApiBase {

    private String defaultOwner;

    private List<ResourceDetails> resourcesToAdd = new ArrayList<>();
    private List<RequestResourceToUpdate> resourcesToUpdate = new ArrayList<>();
    private List<ResourceDetails> resourcesToDelete = new ArrayList<>();
    private List<ResourceDetails> resourcesToRefresh = new ArrayList<>();

    private List<TagDetails> tagsToAdd = new ArrayList<>();
    private List<TagDetails> tagsToDelete = new ArrayList<>();

    private List<LinkDetails> linksToAdd = new ArrayList<>();
    private List<LinkDetails> linksToDelete = new ArrayList<>();

    public String getDefaultOwner() {
        return defaultOwner;
    }

    public List<LinkDetails> getLinksToAdd() {
        return linksToAdd;
    }

    public List<LinkDetails> getLinksToDelete() {
        return linksToDelete;
    }

    public List<ResourceDetails> getResourcesToAdd() {
        return resourcesToAdd;
    }

    public List<ResourceDetails> getResourcesToDelete() {
        return resourcesToDelete;
    }

    public List<ResourceDetails> getResourcesToRefresh() {
        return resourcesToRefresh;
    }

    public List<RequestResourceToUpdate> getResourcesToUpdate() {
        return resourcesToUpdate;
    }

    public List<TagDetails> getTagsToAdd() {
        return tagsToAdd;
    }

    public List<TagDetails> getTagsToDelete() {
        return tagsToDelete;
    }

    public RequestChanges setDefaultOwner(String defaultOwner) {
        this.defaultOwner = defaultOwner;
        return this;
    }

    public RequestChanges setLinksToAdd(List<LinkDetails> linksToAdd) {
        this.linksToAdd = linksToAdd;
        return this;
    }

    public RequestChanges setLinksToDelete(List<LinkDetails> linksToDelete) {
        this.linksToDelete = linksToDelete;
        return this;
    }

    public RequestChanges setResourcesToAdd(List<ResourceDetails> resourcesToAdd) {
        this.resourcesToAdd = resourcesToAdd;
        return this;
    }

    public RequestChanges setResourcesToDelete(List<ResourceDetails> resourcesToDelete) {
        this.resourcesToDelete = resourcesToDelete;
        return this;
    }

    public RequestChanges setResourcesToRefresh(List<ResourceDetails> resourcesToRefresh) {
        this.resourcesToRefresh = resourcesToRefresh;
        return this;
    }

    public RequestChanges setResourcesToUpdate(List<RequestResourceToUpdate> resourcesToUpdate) {
        this.resourcesToUpdate = resourcesToUpdate;
        return this;
    }

    public RequestChanges setTagsToAdd(List<TagDetails> tagsToAdd) {
        this.tagsToAdd = tagsToAdd;
        return this;
    }

    public RequestChanges setTagsToDelete(List<TagDetails> tagsToDelete) {
        this.tagsToDelete = tagsToDelete;
        return this;
    }

}
