/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.service;

import com.foilen.infra.api.model.permission.RoleEditForm;
import com.foilen.infra.api.model.permission.RoleResult;
import com.foilen.infra.api.model.permission.RoleSmallWithPagination;
import com.foilen.smalltools.restapi.model.FormResult;

public interface InfraRoleApiService {

    FormResult roleAdd(String roleName);

    FormResult roleDelete(String roleName);

    FormResult roleEdit(String roleName, RoleEditForm form);

    RoleSmallWithPagination roleFindAll(int pageId, String search);

    RoleResult roleFindOne(String roleName);

}
