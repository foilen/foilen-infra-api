/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2019 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model;

import java.util.ArrayList;
import java.util.List;

import com.foilen.smalltools.restapi.model.AbstractApiBase;
import com.foilen.smalltools.restapi.model.ApiPagination;

public class AuditItemSmallWithPagination extends AbstractApiBase {

    private List<AuditItemSmall> items = new ArrayList<>();
    private ApiPagination pagination;

    public ApiPagination getPagination() {
        return pagination;
    }

    public void setPagination(ApiPagination pagination) {
        this.pagination = pagination;
    }

    public List<AuditItemSmall> getItems() {
        return items;
    }

    public void setItems(List<AuditItemSmall> items) {
        this.items = items;
    }

}
