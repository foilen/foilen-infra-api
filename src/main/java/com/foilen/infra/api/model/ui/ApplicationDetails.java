/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class ApplicationDetails extends AbstractApiBase {

    private String version;

    private String lang;

    private String userId;
    private String userEmail;
    private boolean userAdmin;

    private Map<String, Object> translations = new HashMap<>();

    private List<String> resourceTypes = new ArrayList<>();

    private Map<String, List<String>> externalJsScripts = new HashMap<>();

    public Map<String, List<String>> getExternalJsScripts() {
        return externalJsScripts;
    }

    public String getLang() {
        return lang;
    }

    public List<String> getResourceTypes() {
        return resourceTypes;
    }

    public Map<String, Object> getTranslations() {
        return translations;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public String getVersion() {
        return version;
    }

    public boolean isUserAdmin() {
        return userAdmin;
    }

    public ApplicationDetails setExternalJsScripts(Map<String, List<String>> externalJsScripts) {
        this.externalJsScripts = externalJsScripts;
        return this;
    }

    public ApplicationDetails setLang(String lang) {
        this.lang = lang;
        return this;
    }

    public ApplicationDetails setResourceTypes(List<String> resourceTypes) {
        this.resourceTypes = resourceTypes;
        return this;
    }

    public ApplicationDetails setTranslations(Map<String, Object> translations) {
        this.translations = translations;
        return this;
    }

    public ApplicationDetails setUserAdmin(boolean userAdmin) {
        this.userAdmin = userAdmin;
        return this;
    }

    public ApplicationDetails setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public ApplicationDetails setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public ApplicationDetails setVersion(String version) {
        this.version = version;
        return this;
    }

}
