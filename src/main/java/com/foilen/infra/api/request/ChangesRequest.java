/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.request;

import java.util.ArrayList;
import java.util.List;

public class ChangesRequest extends AbstractRequest {

    private List<ResourceDetails> resourcesToAdd = new ArrayList<>();
    private List<ResourceToUpdateRequest> resourcesToUpdate = new ArrayList<>();
    private List<ResourceDetails> resourcesToDeletePk = new ArrayList<>();

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

    public List<ResourceToUpdateRequest> getResourcesToUpdate() {
        return resourcesToUpdate;
    }

    public List<TagDetails> getTagsToAdd() {
        return tagsToAdd;
    }

    public List<TagDetails> getTagsToDelete() {
        return tagsToDelete;
    }

    public void setLinksToAdd(List<LinkDetails> linksToAdd) {
        this.linksToAdd = linksToAdd;
    }

    public void setLinksToDelete(List<LinkDetails> linksToDelete) {
        this.linksToDelete = linksToDelete;
    }

    public void setResourcesToAdd(List<ResourceDetails> resourcesToAdd) {
        this.resourcesToAdd = resourcesToAdd;
    }

    public void setResourcesToDeletePk(List<ResourceDetails> resourcesToDeletePk) {
        this.resourcesToDeletePk = resourcesToDeletePk;
    }

    public void setResourcesToUpdate(List<ResourceToUpdateRequest> resourcesToUpdate) {
        this.resourcesToUpdate = resourcesToUpdate;
    }

    public void setTagsToAdd(List<TagDetails> tagsToAdd) {
        this.tagsToAdd = tagsToAdd;
    }

    public void setTagsToDelete(List<TagDetails> tagsToDelete) {
        this.tagsToDelete = tagsToDelete;
    }

}
