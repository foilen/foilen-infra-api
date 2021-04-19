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

import com.foilen.infra.api.model.user.UserHumanWithPagination;
import com.foilen.infra.api.model.user.UserRoleEditForm;
import com.foilen.smalltools.restapi.model.FormResult;

public class InfraUserHumanApiServiceImpl implements InfraUserHumanApiService {

    private InfraApiServiceImpl infraApiService;

    public InfraUserHumanApiServiceImpl(InfraApiServiceImpl infraApiService) {
        this.infraApiService = infraApiService;
    }

    @Override
    public FormResult userHumanCreateByEmail(String userEmail) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("userEmail", userEmail);
        return infraApiService.post("/api/userHuman/createByEmail/{userEmail}", null, uriVariables, FormResult.class);
    }

    @Override
    public FormResult userHumanEdit(String userId, UserRoleEditForm form) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("userId", userId);
        return infraApiService.post("/api/userHuman/{userId}/roles", form, uriVariables, FormResult.class);
    }

    @Override
    public UserHumanWithPagination userHumanFindAll(int pageId, String search) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("pageId", String.valueOf(pageId));
        queryParams.add("search", search);
        return infraApiService.get("/api/userHuman/", UserHumanWithPagination.class, null, queryParams);
    }

}
