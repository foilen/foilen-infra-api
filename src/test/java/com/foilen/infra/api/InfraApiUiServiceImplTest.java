/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api;

import org.junit.Assert;
import org.junit.Test;

public class InfraApiUiServiceImplTest {

    @Test
    public void testTransformBaseUrl() {

        Assert.assertEquals("http://{apiUser}:{apiKey}@example.com", InfraApiUiServiceImpl.transformBaseUrl("http://example.com"));
        Assert.assertEquals("https://{apiUser}:{apiKey}@example.com", InfraApiUiServiceImpl.transformBaseUrl("https://example.com"));
        Assert.assertEquals("https://{apiUser}:{apiKey}@example.com:844", InfraApiUiServiceImpl.transformBaseUrl("https://example.com:844"));
        Assert.assertEquals("http://{apiUser}:{apiKey}@example.com", InfraApiUiServiceImpl.transformBaseUrl("http://user:key@example.com"));

    }

}
