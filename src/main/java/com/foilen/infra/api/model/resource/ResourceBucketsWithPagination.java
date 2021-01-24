/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.resource;

import com.foilen.smalltools.restapi.model.AbstractListResultWithPagination;

public class ResourceBucketsWithPagination extends AbstractListResultWithPagination<ResourceBucket> {

    private String search;
    private boolean onlyWithEditor;

    public String getSearch() {
        return search;
    }

    public boolean isOnlyWithEditor() {
        return onlyWithEditor;
    }

    public ResourceBucketsWithPagination setOnlyWithEditor(boolean onlyWithEditor) {
        this.onlyWithEditor = onlyWithEditor;
        return this;
    }

    public ResourceBucketsWithPagination setSearch(String search) {
        this.search = search;
        return this;
    }

}
