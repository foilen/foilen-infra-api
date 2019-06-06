/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2019 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.request;

import java.util.ArrayList;
import java.util.List;

import com.foilen.infra.api.model.LinkDetails;
import com.foilen.infra.api.model.ResourceDetails;
import com.foilen.infra.api.model.TagDetails;
import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class RequestChanges extends AbstractApiBase {

    private List<ResourceDetails> resourcesToAdd = new ArrayList<>();
    private List<RequestResourceToUpdate> resourcesToUpdate = new ArrayList<>();
    private List<ResourceDetails> resourcesToDeletePk = new ArrayList<>();
    private List<ResourceDetails> resourcesToRefreshPk = new ArrayList<>();

    private List<TagDetails> tagsToAdd = new ArrayList<>();
    private List<TagDetails> tagsToDelete = new ArrayList<>();

    private List<LinkDetails> linksToAdd = new ArrayList<>();
    private List<LinkDetails> linksToDelete = new ArrayList<>();

    public List<LinkDetails> getLinksToAdd() {
        return linksToAdd;
    }

    public List<LinkDetails> getLinksToDelete() {
        return linksToDelete;
    }

    public List<ResourceDetails> getResourcesToAdd() {
        return resourcesToAdd;
    }

    public List<ResourceDetails> getResourcesToDeletePk() {
        return resourcesToDeletePk;
    }

    public List<ResourceDetails> getResourcesToRefreshPk() {
        return resourcesToRefreshPk;
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

    public RequestChanges setResourcesToDeletePk(List<ResourceDetails> resourcesToDeletePk) {
        this.resourcesToDeletePk = resourcesToDeletePk;
        return this;
    }

    public RequestChanges setResourcesToRefreshPk(List<ResourceDetails> resourcesToRefreshPk) {
        this.resourcesToRefreshPk = resourcesToRefreshPk;
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
