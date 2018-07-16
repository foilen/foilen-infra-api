/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.response;

import java.util.ArrayList;
import java.util.List;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class ResponseWithStatus extends AbstractApiBase {

    private List<String> errors = new ArrayList<>();
    private List<String> warnings = new ArrayList<>();

    public void addError(String errorMessage) {
        errors.add(errorMessage);
    }

    public void addWarning(String warningMessage) {
        warnings.add(warningMessage);
    }

    public List<String> getErrors() {
        return errors;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public boolean isSuccess() {
        return errors == null || errors.isEmpty();
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

}
