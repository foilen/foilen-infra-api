/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.machine.model;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class IPApplicationDefinitionService extends AbstractApiBase {

    private String name;
    private String workingDirectory = null;
    private String command;
    private Long runAs = null;

    public IPApplicationDefinitionService() {
    }

    public IPApplicationDefinitionService(String name, String command) {
        this.name = name;
        this.command = command;
    }

    public IPApplicationDefinitionService(String name, String command, Long runAs) {
        this.name = name;
        this.command = command;
        this.runAs = runAs;
    }

    public String getCommand() {
        return command;
    }

    public String getName() {
        return name;
    }

    public Long getRunAs() {
        return runAs;
    }

    public String getWorkingDirectory() {
        return workingDirectory;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRunAs(Long runAs) {
        this.runAs = runAs;
    }

    public void setWorkingDirectory(String workingDirectory) {
        this.workingDirectory = workingDirectory;
    }

}
