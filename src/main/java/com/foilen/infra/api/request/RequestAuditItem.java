/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.request;

import com.foilen.infra.api.model.audit.AuditAction;
import com.foilen.infra.api.model.audit.AuditType;
import com.foilen.infra.api.model.audit.AuditUserType;
import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class RequestAuditItem extends AbstractApiBase {

    private int pageId = 1;

    private String timestampFrom;
    private String timestampTo;

    private String txId;
    private Boolean explicitChange;

    private AuditType type;
    private AuditAction action;

    private AuditUserType userType;
    private String userName;

    private String resourceFirstType;
    private String resourceSecondType;

    private String linkType;
    private String tagName;

    private String documentType;
    private String documentId;

    public AuditAction getAction() {
        return action;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public Boolean getExplicitChange() {
        return explicitChange;
    }

    public String getLinkType() {
        return linkType;
    }

    public int getPageId() {
        return pageId;
    }

    public String getResourceFirstType() {
        return resourceFirstType;
    }

    public String getResourceSecondType() {
        return resourceSecondType;
    }

    public String getTagName() {
        return tagName;
    }

    public String getTimestampFrom() {
        return timestampFrom;
    }

    public String getTimestampTo() {
        return timestampTo;
    }

    public String getTxId() {
        return txId;
    }

    public AuditType getType() {
        return type;
    }

    public String getUserName() {
        return userName;
    }

    public AuditUserType getUserType() {
        return userType;
    }

    public RequestAuditItem setAction(AuditAction action) {
        this.action = action;
        return this;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public RequestAuditItem setExplicitChange(Boolean explicitChange) {
        this.explicitChange = explicitChange;
        return this;
    }

    public RequestAuditItem setLinkType(String linkType) {
        this.linkType = linkType;
        return this;
    }

    public RequestAuditItem setPageId(int pageId) {
        this.pageId = pageId;
        return this;
    }

    public RequestAuditItem setResourceFirstType(String resourceFirstType) {
        this.resourceFirstType = resourceFirstType;
        return this;
    }

    public RequestAuditItem setResourceSecondType(String resourceSecondType) {
        this.resourceSecondType = resourceSecondType;
        return this;
    }

    public RequestAuditItem setTagName(String tagName) {
        this.tagName = tagName;
        return this;
    }

    public RequestAuditItem setTimestampFrom(String timestampFrom) {
        this.timestampFrom = timestampFrom;
        return this;
    }

    public RequestAuditItem setTimestampTo(String timestampTo) {
        this.timestampTo = timestampTo;
        return this;
    }

    public RequestAuditItem setTxId(String txId) {
        this.txId = txId;
        return this;
    }

    public RequestAuditItem setType(AuditType type) {
        this.type = type;
        return this;
    }

    public RequestAuditItem setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public RequestAuditItem setUserType(AuditUserType userType) {
        this.userType = userType;
        return this;
    }

}
