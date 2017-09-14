/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.foilen.infra.plugin.v1.core.base.resources.Application;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MachineSetup {

    // UI service
    private String uiApiBaseUrl;
    private String uiApiCert;
    private String uiApiUsername;
    private String uiApiKey;
    private String machineName;

    // Unix Users
    private List<UnixUser> unixUsers = new ArrayList<>();

    // Application
    private List<Application> application = new ArrayList<>();

    public List<Application> getApplication() {
        return application;
    }

    public String getMachineName() {
        return machineName;
    }

    public String getUiApiBaseUrl() {
        return uiApiBaseUrl;
    }

    public String getUiApiCert() {
        return uiApiCert;
    }

    public String getUiApiKey() {
        return uiApiKey;
    }

    public String getUiApiUsername() {
        return uiApiUsername;
    }

    public List<UnixUser> getUnixUsers() {
        return unixUsers;
    }

    public void setApplication(List<Application> application) {
        this.application = application;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public void setUiApiBaseUrl(String uiApiBaseUrl) {
        this.uiApiBaseUrl = uiApiBaseUrl;
    }

    public void setUiApiCert(String uiApiCert) {
        this.uiApiCert = uiApiCert;
    }

    public void setUiApiKey(String uiApiKey) {
        this.uiApiKey = uiApiKey;
    }

    public void setUiApiUsername(String uiApiUsername) {
        this.uiApiUsername = uiApiUsername;
    }

    public void setUnixUsers(List<UnixUser> unixUsers) {
        this.unixUsers = unixUsers;
    }

}
