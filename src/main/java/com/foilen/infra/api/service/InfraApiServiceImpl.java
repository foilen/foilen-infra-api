/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.service;

import java.net.URI;
import java.security.KeyStore;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.foilen.infra.api.InfraApiUiException;
import com.foilen.smalltools.crypt.spongycastle.cert.RSACertificate;
import com.foilen.smalltools.tools.AbstractBasics;
import com.foilen.smalltools.tools.JsonTools;
import com.google.common.base.Strings;

public class InfraApiServiceImpl extends AbstractBasics implements InfraApiService {

    private String infraBaseUrl;
    private RestTemplate restTemplate = new RestTemplate();

    public InfraApiServiceImpl(String infraBaseUrl, String apiUser, String apiKey) {
        this.infraBaseUrl = infraBaseUrl;
        this.restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(apiUser, apiKey));
    }

    public InfraApiServiceImpl(String infraBaseUrl, String apiUser, String apiKey, String certText) {

        logger.debug("Will connect to {} with user {}", infraBaseUrl, apiKey);
        this.infraBaseUrl = infraBaseUrl;

        if (Strings.isNullOrEmpty(certText)) {
            restTemplate = new RestTemplate();
        } else {
            try {
                RSACertificate rsaCertificate = RSACertificate.loadPemFromString(certText);
                logger.debug("Forcing to accept only the certificate {}, for {}", rsaCertificate.getThumbprint(), rsaCertificate.getSubjectAltNames());

                KeyStore truststore = KeyStore.getInstance(KeyStore.getDefaultType());
                truststore.load(null, null);
                truststore.setCertificateEntry("foilen-infra", rsaCertificate.getCertificate());
                SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(truststore, null).build();

                SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);
                HttpClient httpClient = HttpClientBuilder.create().useSystemProperties().setSSLSocketFactory(sslConnectionSocketFactory).build();
                ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
                restTemplate = new RestTemplate(requestFactory);

            } catch (Exception e) {
                throw new InfraApiUiException(e);
            }
        }

        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(apiUser, apiKey));
    }

    protected <T> T get(String relativeUrl, Class<T> responseClass) {
        String url = infraBaseUrl + relativeUrl;
        logger.debug("[GET] {} for {},", url, responseClass);
        return restTemplate.getForObject(url, responseClass);
    }

    protected <T> T get(String relativeUrl, Class<T> responseClass, Map<String, ?> uriVariables) {
        String url = infraBaseUrl + relativeUrl;
        logger.debug("[GET] {} with variables {} for {},", url, uriVariables, responseClass);
        return restTemplate.getForObject(url, responseClass, uriVariables);
    }

    public String getInfraBaseUrl() {
        return infraBaseUrl;
    }

    @Override
    public InfraMachineApiService getInfraMachineApiService() {
        return new InfraMachineApiServiceImpl(this);
    }

    @Override
    public InfraResourceApiService getInfraResourceApiService() {
        return new InfraResourceApiServiceImpl(this);
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    protected <T> T post(String relativeUrl, Object postData, Class<T> responseClass) {
        String url = infraBaseUrl + relativeUrl;
        if (logger.isDebugEnabled()) {
            logger.debug("[POST] {} for {} with data {},", url, responseClass, JsonTools.compactPrint(postData));
        }
        return restTemplate.postForObject(url, postData, responseClass);
    }

    protected <T> T post(String relativeUrl, Object postData, Map<String, ?> uriVariables, Class<T> responseClass) {
        String url = infraBaseUrl + relativeUrl;
        if (logger.isDebugEnabled()) {
            logger.debug("[POST] {} with variables {} for {} with data {},", url, uriVariables, responseClass, JsonTools.compactPrint(postData));
        }
        URI uri = new UriTemplate(url).expand(uriVariables);
        return restTemplate.postForObject(uri, postData, responseClass);
    }

}