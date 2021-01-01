/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.audit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.foilen.smalltools.restapi.model.AbstractListResultWithPagination;

public class AuditItemWithPagination extends AbstractListResultWithPagination<AuditItem> {

    private Map<String, List<String>> validationErrorsByField = new HashMap<>();

    public Map<String, List<String>> getValidationErrorsByField() {
        return validationErrorsByField;
    }

    @Override
    public boolean isSuccess() {
        return validationErrorsByField.isEmpty() && super.isSuccess();
    }

    public AuditItemWithPagination setValidationErrorsByField(Map<String, List<String>> validationErrorsByField) {
        this.validationErrorsByField = validationErrorsByField;
        return this;
    }

}
