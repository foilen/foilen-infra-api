/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.foilen.infra.api.model.MachineSetup;
import com.foilen.infra.api.model.SystemStats;

public class InfraApiUiServiceImpl implements InfraApiUiService {

    protected static String transformBaseUrl(String baseUrl) {
        try {
            URL url = new URL(baseUrl);

            StringBuilder newUrl = new StringBuilder();
            newUrl.append(url.getProtocol());
            newUrl.append("://{apiUser}:{apiKey}@");
            newUrl.append(url.getHost());

            if (url.getPort() != -1) {
                newUrl.append(":").append(url.getPort());
            }

            return newUrl.toString();
        } catch (MalformedURLException e) {
            throw new InfraApiUiException("Bad url", e);
        }

    }

    private RestTemplate restTemplate = new RestTemplate();
    private String infraBaseUrl;
    private String apiUser;

    private String apiKey;

    public InfraApiUiServiceImpl(String infraBaseUrl, String apiUser, String apiKey) {
        this.infraBaseUrl = transformBaseUrl(infraBaseUrl);
        this.apiUser = apiUser;
        this.apiKey = apiKey;

    }

    private Map<String, Object> createUriVariables() {
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("apiUser", apiUser);
        uriVariables.put("apiKey", apiKey);
        return uriVariables;
    }

    @Override
    public MachineSetup getMachineSetup(String machineName) {
        Map<String, Object> uriVariables = createUriVariables();
        uriVariables.put("machineName", machineName);
        return restTemplate.getForObject(infraBaseUrl + "/api/machine/{machineName}/setup", MachineSetup.class, uriVariables);
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    @Override
    public void sendSystemStats(String machineName, List<SystemStats> systemStats) {
        Map<String, Object> uriVariables = createUriVariables();
        uriVariables.put("machineName", machineName);
        restTemplate.postForLocation(infraBaseUrl + "/api/machine/{machineName}/systemStats", systemStats, uriVariables);
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}
