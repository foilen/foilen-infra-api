/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.machine;

import java.util.ArrayList;
import java.util.List;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class MachineSetup extends AbstractApiBase {

    // UI service
    private String uiApiBaseUrl;
    private String uiApiCert;
    private String uiApiUserId;
    private String uiApiUserKey;
    private String machineName;

    // Redirector
    private int redirectorBridgePort = 11000;
    private List<String> redirectorCaCerts = new ArrayList<>();
    private String redirectorNodeCert;
    private String redirectorNodeKey;

    // Unix Users
    private List<UnixUser> unixUsers = new ArrayList<>();

    // Applications and cron jobs
    private List<Application> applications = new ArrayList<>();
    private List<CronJob> cronJobs = new ArrayList<>();

    public List<Application> getApplications() {
        return applications;
    }

    public List<CronJob> getCronJobs() {
        return cronJobs;
    }

    public String getMachineName() {
        return machineName;
    }

    public int getRedirectorBridgePort() {
        return redirectorBridgePort;
    }

    public List<String> getRedirectorCaCerts() {
        return redirectorCaCerts;
    }

    public String getRedirectorNodeCert() {
        return redirectorNodeCert;
    }

    public String getRedirectorNodeKey() {
        return redirectorNodeKey;
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

    public void setCronJobs(List<CronJob> cronJobs) {
        this.cronJobs = cronJobs;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public void setRedirectorBridgePort(int redirectorBridgePort) {
        this.redirectorBridgePort = redirectorBridgePort;
    }

    public void setRedirectorCaCerts(List<String> redirectorCaCerts) {
        this.redirectorCaCerts = redirectorCaCerts;
    }

    public void setRedirectorNodeCert(String redirectorNodeCert) {
        this.redirectorNodeCert = redirectorNodeCert;
    }

    public void setRedirectorNodeKey(String redirectorNodeKey) {
        this.redirectorNodeKey = redirectorNodeKey;
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
