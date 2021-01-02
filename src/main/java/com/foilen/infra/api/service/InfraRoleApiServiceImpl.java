/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.foilen.infra.api.model.permission.RoleCreateForm;
import com.foilen.infra.api.model.permission.RoleEditForm;
import com.foilen.infra.api.model.permission.RoleResult;
import com.foilen.infra.api.model.permission.RoleSmallWithPagination;
import com.foilen.smalltools.restapi.model.FormResult;

public class InfraRoleApiServiceImpl implements InfraRoleApiService {

    private InfraApiServiceImpl infraApiService;

    public InfraRoleApiServiceImpl(InfraApiServiceImpl infraApiService) {
        this.infraApiService = infraApiService;
    }

    @Override
    public FormResult roleAdd(String roleName) {
        return infraApiService.post("/api/role/", new RoleCreateForm().setName(roleName), null, FormResult.class);
    }

    @Override
    public FormResult roleDelete(String roleName) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("roleName", roleName);
        return infraApiService.delete("/api/role/{roleName}", uriVariables, FormResult.class);
    }

    @Override
    public FormResult roleEdit(String roleName, RoleEditForm form) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("roleName", roleName);
        return infraApiService.post("/api/role/{roleName}", form, uriVariables, FormResult.class);
    }

    @Override
    public RoleSmallWithPagination roleFindAll(int pageId, String search) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("pageId", String.valueOf(pageId));
        queryParams.add("search", search);
        return infraApiService.get("/api/role/{roleName}", RoleSmallWithPagination.class, null, queryParams);
    }

    @Override
    public RoleResult roleFindOne(String roleName) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("roleName", roleName);
        return infraApiService.get("/api/role/{roleName}", RoleResult.class, uriVariables);
    }

}
