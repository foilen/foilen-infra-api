/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.foilen.infra.api.InfraApiUiException;
import com.foilen.infra.api.model.resource.ResourceBucketsWithPagination;
import com.foilen.infra.api.model.resource.ResourceDetails;
import com.foilen.infra.api.model.resource.ResourceTypeDetails;
import com.foilen.infra.api.request.RequestChanges;
import com.foilen.infra.api.request.RequestResourceSearch;
import com.foilen.infra.api.response.ResponseResourceAppliedChanges;
import com.foilen.infra.api.response.ResponseResourceBucket;
import com.foilen.infra.api.response.ResponseResourceBuckets;
import com.foilen.infra.api.response.ResponseResourceTypesDetails;

public class InfraResourceApiServiceImpl implements InfraResourceApiService {

    private Map<String, ResourceTypeDetails> resourceTypeDetailsByResourceType = new ConcurrentHashMap<>();
    private volatile long resourceTypeDetailsByResourceTypeExpirationTime;

    private InfraApiServiceImpl infraApiService;

    public InfraResourceApiServiceImpl(InfraApiServiceImpl infraApiService) {
        this.infraApiService = infraApiService;
    }

    @Override
    public ResponseResourceAppliedChanges applyChanges(RequestChanges changesRequest) {
        return infraApiService.post("/api/resource/applyChanges", changesRequest, ResponseResourceAppliedChanges.class);
    }

    @Override
    public ResponseResourceAppliedChanges applyChangesAs(String impersonateUserId, RequestChanges changesRequest) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("impersonateUserId", impersonateUserId);
        return infraApiService.post("/api/resource/as/{impersonateUserId}/applyChanges", changesRequest, uriVariables, ResponseResourceAppliedChanges.class);
    }

    @Override
    public Map<String, Object> onlyPkValues(ResourceDetails resourceDetails) {
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

        return properties;
    }

    @Override
    public ResourceBucketsWithPagination resourceFindAll(int pageId, String search, boolean onlyWithEditor) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("pageId", String.valueOf(pageId));
        queryParams.add("search", search);
        queryParams.add("onlyWithEditor", String.valueOf(onlyWithEditor));
        return infraApiService.get("/api/resource", ResourceBucketsWithPagination.class, null, queryParams);
    }

    @Override
    public ResponseResourceBuckets resourceFindAll(RequestResourceSearch resourceSearch) {
        return infraApiService.post("/api/resource/resourceFindAll", resourceSearch, null, ResponseResourceBuckets.class);
    }

    @Override
    public ResourceBucketsWithPagination resourceFindAllAs(String impersonateUserId, int pageId, String search, boolean onlyWithEditor) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("impersonateUserId", impersonateUserId);

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("pageId", String.valueOf(pageId));
        queryParams.add("search", search);
        queryParams.add("onlyWithEditor", String.valueOf(onlyWithEditor));

        return infraApiService.get("/api/resource/as/{impersonateUserId}", ResourceBucketsWithPagination.class, uriVariables, queryParams);
    }

    @Override
    public ResponseResourceBuckets resourceFindAllAs(String impersonateUserId, RequestResourceSearch resourceSearch) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("impersonateUserId", impersonateUserId);
        return infraApiService.post("/api/resource/as/{impersonateUserId}/resourceFindAll", resourceSearch, uriVariables, ResponseResourceBuckets.class);
    }

    @Override
    public ResponseResourceBuckets resourceFindAllWithDetails(RequestResourceSearch resourceSearch) {
        return infraApiService.post("/api/resource/resourceFindAllWithDetails", resourceSearch, null, ResponseResourceBuckets.class);
    }

    @Override
    public ResponseResourceBuckets resourceFindAllWithDetailsAs(String impersonateUserId, RequestResourceSearch resourceSearch) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("impersonateUserId", impersonateUserId);
        return infraApiService.post("/api/resource/as/{impersonateUserId}/resourceFindAllWithDetails", resourceSearch, uriVariables, ResponseResourceBuckets.class);
    }

    @Override
    public ResponseResourceBuckets resourceFindAllWithoutOwner() {
        return infraApiService.get("/api/resource/resourceFindAllWithoutOwner", ResponseResourceBuckets.class);
    }

    @Override
    public ResponseResourceBucket resourceFindById(String resourceId) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("resourceId", resourceId);
        return infraApiService.get("/api/resource/resourceFindById/{resourceId}", ResponseResourceBucket.class, uriVariables, null);
    }

    @Override
    public ResponseResourceBucket resourceFindOne(RequestResourceSearch resourceSearch) {
        return infraApiService.post("/api/resource/resourceFindOne", resourceSearch, null, ResponseResourceBucket.class);
    }

    @Override
    public ResponseResourceBucket resourceFindOneByPk(ResourceDetails resourceDetails) {
        return resourceFindOne(new RequestResourceSearch() //
                .setResourceType(resourceDetails.getResourceType()) //
                .setProperties(onlyPkValues(resourceDetails)) //
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
