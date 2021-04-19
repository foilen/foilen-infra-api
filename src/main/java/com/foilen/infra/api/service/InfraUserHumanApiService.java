/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.service;

import com.foilen.infra.api.model.user.UserHumanWithPagination;
import com.foilen.infra.api.model.user.UserRoleEditForm;
import com.foilen.smalltools.restapi.model.FormResult;

public interface InfraUserHumanApiService {

    FormResult userHumanCreateByEmail(String userEmail);

    FormResult userHumanEdit(String userId, UserRoleEditForm form);

    /**
     * Get all the human users.
     *
     * @param pageId
     *            the page id starting at 1
     * @param search
     *            (optional) search
     * @return the resources
     */
    UserHumanWithPagination userHumanFindAll(int pageId, String search);

}
