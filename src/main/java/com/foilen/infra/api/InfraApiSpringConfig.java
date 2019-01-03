/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2019 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.foilen.infra.api.service.InfraApiService;
import com.foilen.infra.api.service.InfraApiServiceImpl;
import com.foilen.smalltools.tools.FileTools;
import com.foilen.smalltools.tools.JsonTools;
import com.google.common.base.Strings;

/**
 * Use this config to use the infra system API.
 */
@Configuration
public class InfraApiSpringConfig {

    @Autowired
    public Environment environment;

    @Bean
    public InfraApiService infraApiService() {
        try {

            String loginConfigFile = environment.getRequiredProperty("infraApi.configFile");
            InfraApiUiConfigDetails config = JsonTools.readFromFile(loginConfigFile, InfraApiUiConfigDetails.class);

            String baseUrl = config.getBaseUrl();
            String apiUser = config.getApiUser();
            String apiKey = config.getApiKey();

            InfraApiServiceImpl infraApiService = new InfraApiServiceImpl(baseUrl, apiUser, apiKey);

            // Check for certificate to trust
            String certText = null;
            String certFile = config.getCertFile();
            if (Strings.isNullOrEmpty(certFile)) {
                // From text
                certText = config.getCertText();
            } else {
                // From file
                certText = FileTools.getFileAsString(certFile);
            }

            // Configure SSL with a custom cert if needed
            if (certText != null) {
                infraApiService = new InfraApiServiceImpl(baseUrl, apiUser, apiKey, certText);
            }

            return infraApiService;
        } catch (Exception e) {
            throw new InfraApiUiException(e);
        }

    }
}
