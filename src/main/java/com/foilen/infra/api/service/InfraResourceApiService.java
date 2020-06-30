/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.service;

import java.util.Map;

import com.foilen.infra.api.model.resource.ResourceDetails;
import com.foilen.infra.api.request.RequestChanges;
import com.foilen.infra.api.request.RequestResourceSearch;
import com.foilen.infra.api.response.ResponseResourceAppliedChanges;
import com.foilen.infra.api.response.ResponseResourceBucket;
import com.foilen.infra.api.response.ResponseResourceBuckets;
import com.foilen.infra.api.response.ResponseResourceTypesDetails;

public interface InfraResourceApiService {

    /**
     * Apply some changes on the infrastructure.
     *
     * @param changes
     *            the changes
     * @return the results
     */
    ResponseResourceAppliedChanges applyChanges(RequestChanges changes);

    /**
     * Provided a resource details, returns a Map with only the primary keys values.
     *
     * @param resourceDetails
     *            the resource details
     * @return the map with the primary keys values
     */
    Map<String, Object> onlyPkValues(ResourceDetails resourceDetails);

    /**
     * Get all the resources.
     *
     * @param resourceSearch
     *            the search
     * @return the resources
     */
    ResponseResourceBuckets resourceFindAll(RequestResourceSearch resourceSearch);

    /**
     * Get all the resources without owners.
     *
     * @return the resources
     */
    ResponseResourceBuckets resourceFindAllWithoutOwner();

    /**
     * Get a single resource if present.
     *
     * @param resourceId
     *            the resource id
     * @return a single resource if present
     */
    ResponseResourceBucket resourceFindById(String resourceId);

    /**
     * Get a single resource if present. Will give an error if there are more than 1.
     *
     * @param resourceSearch
     *            the search
     * @return a single resource if present
     */
    ResponseResourceBucket resourceFindOne(RequestResourceSearch resourceSearch);

    /**
     * Like {@link #resourceFindOne(RequestResourceSearch)}, but will trim the search for only the properties that are part of the PK.
     *
     * @param resourceDetails
     *            the resource details
     * @return a single resource if present
     */
    ResponseResourceBucket resourceFindOneByPk(ResourceDetails resourceDetails);

    /**
     * List all the available resource types.
     *
     * @return the resource types details
     */
    ResponseResourceTypesDetails typeFindAll();

}
