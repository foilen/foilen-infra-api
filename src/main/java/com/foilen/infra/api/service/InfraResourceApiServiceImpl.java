/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.foilen.infra.api.InfraApiUiException;
import com.foilen.infra.api.model.ResourceDetails;
import com.foilen.infra.api.model.ResourceTypeDetails;
import com.foilen.infra.api.request.RequestChanges;
import com.foilen.infra.api.request.RequestResourceSearch;
import com.foilen.infra.api.response.ResponseResourceBucket;
import com.foilen.infra.api.response.ResponseResourceBuckets;
import com.foilen.infra.api.response.ResponseResourceTypesDetails;
import com.foilen.smalltools.restapi.model.FormResult;

public class InfraResourceApiServiceImpl implements InfraResourceApiService {

    private Map<String, ResourceTypeDetails> resourceTypeDetailsByResourceType = new ConcurrentHashMap<>();
    private volatile long resourceTypeDetailsByResourceTypeExpirationTime;

    private InfraApiServiceImpl infraApiService;

    public InfraResourceApiServiceImpl(InfraApiServiceImpl infraApiService) {
        this.infraApiService = infraApiService;
    }

    @Override
    public FormResult applyChanges(RequestChanges changesRequest) {
        return infraApiService.post("/api/resource/applyChanges", changesRequest, FormResult.class);
    }

    @Override
    public ResponseResourceBuckets resourceFindAll(RequestResourceSearch resourceSearch) {
        return infraApiService.post("/api/resource/resourceFindAll", resourceSearch, null, ResponseResourceBuckets.class);
    }

    @Override
    public ResponseResourceBucket resourceFindOne(RequestResourceSearch resourceSearch) {
        return infraApiService.post("/api/resource/resourceFindOne", resourceSearch, null, ResponseResourceBucket.class);
    }

    @Override
    public ResponseResourceBucket resourceFindOneByPk(ResourceDetails resourceDetails) {

        if (resourceTypeDetailsByResourceTypeExpirationTime < System.currentTimeMillis()) {
            typeFindAll();
        }

        String resourceType = resourceDetails.getResourceType();
        ResourceTypeDetails resourceTypeDetails = resourceTypeDetailsByResourceType.get(resourceType);
        if (resourceTypeDetails == null) {
            throw new InfraApiUiException("Resource Type [" + resourceType + "] is unknown from this Infra installation");
        }

        Map<String, Object> properties = new HashMap<>();

        if (resourceDetails.getResource() instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> resource = (Map<String, Object>) resourceDetails.getResource();
            resourceTypeDetails.getPrimaryKeyProperties().forEach(propertyName -> {
                properties.put(propertyName, resource.get(propertyName));
            });
        } else {
            BeanWrapper beanWrapper = new BeanWrapperImpl(resourceDetails.getResource());
            resourceTypeDetails.getPrimaryKeyProperties().forEach(propertyName -> {
                properties.put(propertyName, beanWrapper.getPropertyValue(propertyName));
            });
        }

        return resourceFindOne(new RequestResourceSearch() //
                .setResourceType(resourceType) //
                .setProperties(properties) //
        );
    }

    @Override
    public ResponseResourceTypesDetails typeFindAll() {
        ResponseResourceTypesDetails responseResourceTypesDetails = infraApiService.get("/api/resourceType", ResponseResourceTypesDetails.class);
        resourceTypeDetailsByResourceType.clear();
        if (responseResourceTypesDetails.isSuccess()) {
            resourceTypeDetailsByResourceTypeExpirationTime = System.currentTimeMillis() + 10 * 60000; // 10 minutes
            responseResourceTypesDetails.getItems().forEach(item -> {
                resourceTypeDetailsByResourceType.put(item.getResourceType(), item);
            });
        }
        return responseResourceTypesDetails;
    }

}
