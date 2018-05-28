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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.foilen.smalltools.tools.AbstractBasics;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseWithStatus extends AbstractBasics {

    private List<String> errors = new ArrayList<>();

    public void addError(String errorMessage) {
        errors.add(errorMessage);
    }

    public List<String> getErrors() {
        return errors;
    }

    public boolean isSuccess() {
        return errors == null || errors.isEmpty();
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

}
