/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InfraApiUiConfigDetails {

    private String baseUrl;
    private String apiUser;
    private String apiKey;

    // Optional if have a trusted certificate
    private String certFile;
    private String certText;

    public String getApiKey() {
        return apiKey;
    }

    public String getApiUser() {
        return apiUser;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getCertFile() {
        return certFile;
    }

    public String getCertText() {
        return certText;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setApiUser(String apiUser) {
        this.apiUser = apiUser;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setCertFile(String certFile) {
        this.certFile = certFile;
    }

    public void setCertText(String certText) {
        this.certText = certText;
    }

}
