/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api;

import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.foilen.smalltools.crypt.cert.RSACertificate;
import com.foilen.smalltools.tools.JsonTools;
import com.google.common.base.Strings;

/**
 * Use this config to use the infra system API.
 */
@Configuration
public class InfraApiUiSpringConfig {

    @Autowired
    public Environment environment;

    @Bean
    public InfraApiUiService infraApiUiService() {
        try {

            String loginConfigFile = environment.getRequiredProperty("infraApi.configFile");
            InfraApiUiConfigDetails config = JsonTools.readFromFile(loginConfigFile, InfraApiUiConfigDetails.class);

            String baseUrl = config.getBaseUrl();
            String apiUser = config.getApiUser();
            String apiKey = config.getApiKey();

            InfraApiUiServiceImpl loginClient = new InfraApiUiServiceImpl(baseUrl, apiUser, apiKey);

            // Trust the certificate itself
            String certFile = config.getCertFile();
            RSACertificate rsaCertificate = null;
            if (Strings.isNullOrEmpty(certFile)) {
                String certText = config.getCertText();
                if (!Strings.isNullOrEmpty(certText)) {
                    // From text
                    rsaCertificate = RSACertificate.loadPemFromString(certText);
                }
            } else {
                // From file
                rsaCertificate = RSACertificate.loadPemFromFile(certFile);
            }

            // Configure SSL with a custom cert if needed
            if (rsaCertificate != null) {
                KeyStore truststore = KeyStore.getInstance(KeyStore.getDefaultType());
                truststore.load(null, null);
                truststore.setCertificateEntry("foilen-infra", rsaCertificate.getCertificate());
                SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(truststore, null).build();

                SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);
                HttpClient httpClient = HttpClientBuilder.create().useSystemProperties().setSSLSocketFactory(sslConnectionSocketFactory).build();
                ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
                RestTemplate restTemplate = new RestTemplate(requestFactory);
                loginClient.setRestTemplate(restTemplate);
            }

            return loginClient;
        } catch (Exception e) {
            throw new InfraApiUiException(e);
        }

    }
}
