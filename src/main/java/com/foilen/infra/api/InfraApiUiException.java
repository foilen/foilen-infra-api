/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api;

public class InfraApiUiException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InfraApiUiException() {
        super();
    }

    public InfraApiUiException(String message) {
        super(message);
    }

    public InfraApiUiException(String message, Throwable cause) {
        super(message, cause);
    }

    public InfraApiUiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InfraApiUiException(Throwable cause) {
        super(cause);
    }

}
