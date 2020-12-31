/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2020 Foilen (http://foilen.com)

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

    // Execution
    @Deprecated
    private ExecutionPolicy executionPolicy = ExecutionPolicy.ALWAYS_ON;
    @Deprecated
    private String executionCronDetails;

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

    @Deprecated
    public String getExecutionCronDetails() {
        return executionCronDetails;
    }

    @Deprecated
    public ExecutionPolicy getExecutionPolicy() {
        return executionPolicy;
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

    @Deprecated
    public void setExecutionCronDetails(String executionCronDetails) {
        this.executionCronDetails = executionCronDetails;
    }

    @Deprecated
    public void setExecutionPolicy(ExecutionPolicy executionPolicy) {
        this.executionPolicy = executionPolicy;
    }

    public void setName(String name) {
        this.name = name;
    }

}
