/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.request;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class RequestAlert extends AbstractApiBase {

    private String subject;
    private String content;

    public String getContent() {
        return content;
    }

    public String getSubject() {
        return subject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
