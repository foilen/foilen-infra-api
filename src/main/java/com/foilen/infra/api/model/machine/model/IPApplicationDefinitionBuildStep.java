/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.machine.model;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class IPApplicationDefinitionBuildStep extends AbstractApiBase {

    private IPApplicationDefinitionBuildStepType type;
    private String step;

    public IPApplicationDefinitionBuildStep() {
    }

    public IPApplicationDefinitionBuildStep(IPApplicationDefinitionBuildStepType type, String step) {
        this.type = type;
        this.step = step;
    }

    public String getStep() {
        return step;
    }

    public IPApplicationDefinitionBuildStepType getType() {
        return type;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public void setType(IPApplicationDefinitionBuildStepType type) {
        this.type = type;
    }

}
