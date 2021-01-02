/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.response;

import java.util.HashMap;
import java.util.Map;

import com.foilen.infra.api.model.audit.AuditItemSmallWithPagination;
import com.foilen.smalltools.restapi.model.FormResult;

public class ResponseResourceAppliedChanges extends FormResult {

    private String txId;

    // Reporting
    private Map<String, Integer> updateCountByResourceId = new HashMap<>();
    private Map<String, Long> executionTimeInMsByActionHandler = new HashMap<>();

    // Auditing
    private AuditItemSmallWithPagination auditItems = new AuditItemSmallWithPagination();

    public AuditItemSmallWithPagination getAuditItems() {
        return auditItems;
    }

    public Map<String, Long> getExecutionTimeInMsByActionHandler() {
        return executionTimeInMsByActionHandler;
    }

    public String getTxId() {
        return txId;
    }

    public Map<String, Integer> getUpdateCountByResourceId() {
        return updateCountByResourceId;
    }

    public void setAuditItems(AuditItemSmallWithPagination auditItems) {
        this.auditItems = auditItems;
    }

    public void setExecutionTimeInMsByActionHandler(Map<String, Long> executionTimeInMsByActionHandler) {
        this.executionTimeInMsByActionHandler = executionTimeInMsByActionHandler;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public void setUpdateCountByResourceId(Map<String, Integer> updateCountByResourceId) {
        this.updateCountByResourceId = updateCountByResourceId;
    }

}
