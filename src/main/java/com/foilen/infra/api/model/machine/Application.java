/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.machine;

import java.util.SortedSet;
import java.util.TreeSet;

import com.foilen.infra.api.model.machine.model.IPApplicationDefinition;
import com.foilen.smalltools.restapi.model.AbstractApiBase;
import com.google.common.collect.ComparisonChain;

/**
 * This is for any application/service that is installed on a machine.
 */
public class Application extends AbstractApiBase implements Comparable<Application> {

    // Application
    private String name;
    private String description;

    // Details
    private IPApplicationDefinition applicationDefinition = new IPApplicationDefinition();

    // Network
    private SortedSet<String> domainNames = new TreeSet<>();

    public Application() {
    }

    /**
     * Primary key.
     *
     * @param name
     *            the name
     */
    public Application(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Application o) {
        return ComparisonChain.start() //
                .compare(this.name, o.name) //
                .result();
    }

    public IPApplicationDefinition getApplicationDefinition() {
        return applicationDefinition;
    }

    public String getDescription() {
        return description;
    }

    public SortedSet<String> getDomainNames() {
        return domainNames;
    }

    public String getName() {
        return name;
    }

    public void setApplicationDefinition(IPApplicationDefinition applicationDefinition) {
        this.applicationDefinition = applicationDefinition;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDomainNames(SortedSet<String> domainNames) {
        this.domainNames = domainNames;
    }

    public void setName(String name) {
        this.name = name;
    }

}
