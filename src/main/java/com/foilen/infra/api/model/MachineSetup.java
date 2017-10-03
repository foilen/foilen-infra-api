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
import com.foilen.infra.plugin.v1.core.base.resources.UnixUser;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MachineSetup {

    // UI service
    private String uiApiBaseUrl;
    private String uiApiCert;
    private String uiApiUserId;
    private String uiApiUserKey;
    private String machineName;

    // Unix Users
    private List<UnixUser> unixUsers = new ArrayList<>();

    // Application
    private List<Application> applications = new ArrayList<>();

    public List<Application> getApplications() {
        return applications;
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

    public String getUiApiUserId() {
        return uiApiUserId;
    }

    public String getUiApiUserKey() {
        return uiApiUserKey;
    }

    public List<UnixUser> getUnixUsers() {
        return unixUsers;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
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

    public void setUiApiUserId(String uiApiUserId) {
        this.uiApiUserId = uiApiUserId;
    }

    public void setUiApiUserKey(String uiApiUserKey) {
        this.uiApiUserKey = uiApiUserKey;
    }

    public void setUnixUsers(List<UnixUser> unixUsers) {
        this.unixUsers = unixUsers;
    }

}
