/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api;

import java.net.URI;
import java.util.Map;

import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

public class InfraApiServiceImpl implements InfraApiService {

    private String infraBaseUrl;
    private RestTemplate restTemplate = new RestTemplate();

    public InfraApiServiceImpl(String infraBaseUrl, String apiUser, String apiKey) {
        this.infraBaseUrl = infraBaseUrl;
        this.restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(apiUser, apiKey));
    }

    public InfraApiServiceImpl(String infraBaseUrl, String apiUser, String apiKey, RestTemplate restTemplate) {
        this.infraBaseUrl = infraBaseUrl;
        this.restTemplate = restTemplate;
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(apiUser, apiKey));
    }

    protected <T> T get(String relativeUrl, Class<T> responseClass) {
        return restTemplate.getForObject(infraBaseUrl + relativeUrl, responseClass);
    }

    protected <T> T get(String relativeUrl, Class<T> responseClass, Map<String, ?> uriVariables) {
        return restTemplate.getForObject(infraBaseUrl + relativeUrl, responseClass, uriVariables);
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

    protected URI post(String relativeUrl, Object postData) {
        return restTemplate.postForLocation(infraBaseUrl + relativeUrl, postData);
    }

    protected <T> T post(String relativeUrl, Object postData, Class<T> responseClass) {
        return restTemplate.postForObject(infraBaseUrl + relativeUrl, postData, responseClass);
    }

    protected URI post(String relativeUrl, Object postData, Map<String, ?> uriVariables) {
        return restTemplate.postForLocation(infraBaseUrl + relativeUrl, postData, uriVariables);
    }

}
