/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2019 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.response;

import java.util.HashMap;
import java.util.Map;

import com.foilen.infra.api.model.AuditItemSmallWithPagination;
import com.foilen.smalltools.restapi.model.FormResult;

public class ResponseResourceAppliedChanges extends FormResult {

    private String txId;

    // Reporting
    private Map<String, Integer> updateCountByResourceId = new HashMap<>();
    private Map<String, Long> executionTimeInMsByUpdateHandler = new HashMap<>();
    private Map<String, Long> updateDirectCheckByUpdateHandler = new HashMap<>();
    private Map<String, Long> updateFarCheckByUpdateHandler = new HashMap<>();

    // Auditing
    private AuditItemSmallWithPagination auditItems = new AuditItemSmallWithPagination();

    public AuditItemSmallWithPagination getAuditItems() {
        return auditItems;
    }

    public Map<String, Long> getExecutionTimeInMsByUpdateHandler() {
        return executionTimeInMsByUpdateHandler;
    }

    public String getTxId() {
        return txId;
    }

    public Map<String, Integer> getUpdateCountByResourceId() {
        return updateCountByResourceId;
    }

    public Map<String, Long> getUpdateDirectCheckByUpdateHandler() {
        return updateDirectCheckByUpdateHandler;
    }

    public Map<String, Long> getUpdateFarCheckByUpdateHandler() {
        return updateFarCheckByUpdateHandler;
    }

    public void setAuditItems(AuditItemSmallWithPagination auditItems) {
        this.auditItems = auditItems;
    }

    public void setExecutionTimeInMsByUpdateHandler(Map<String, Long> executionTimeInMsByUpdateHandler) {
        this.executionTimeInMsByUpdateHandler = executionTimeInMsByUpdateHandler;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public void setUpdateCountByResourceId(Map<String, Integer> updateCountByResourceId) {
        this.updateCountByResourceId = updateCountByResourceId;
    }

    public void setUpdateDirectCheckByUpdateHandler(Map<String, Long> updateDirectCheckByUpdateHandler) {
        this.updateDirectCheckByUpdateHandler = updateDirectCheckByUpdateHandler;
    }

    public void setUpdateFarCheckByUpdateHandler(Map<String, Long> updateFarCheckByUpdateHandler) {
        this.updateFarCheckByUpdateHandler = updateFarCheckByUpdateHandler;
    }

}
