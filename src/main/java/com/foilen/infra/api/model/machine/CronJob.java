/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.machine;

import com.foilen.smalltools.restapi.model.AbstractApiBase;
import com.google.common.collect.ComparisonChain;

/**
 * This is for any cron job that is installed on a machine. <br>
 */
public class CronJob extends AbstractApiBase implements Comparable<CronJob> {

    // Details
    private String uid;
    private String description;

    private String time;
    private String command;
    private String workingDirectory = null;

    // Linked by
    private String applicationName;
    private UnixUser runAs;

    public CronJob() {
    }

    /**
     * Primary key.
     *
     * @param uid
     *            the uid
     */
    public CronJob(String uid) {
        this.uid = uid;
    }

    @Override
    public int compareTo(CronJob o) {
        return ComparisonChain.start() //
                .compare(this.uid, o.uid) //
                .result();
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }

    public UnixUser getRunAs() {
        return runAs;
    }

    public String getTime() {
        return time;
    }

    public String getUid() {
        return uid;
    }

    public String getWorkingDirectory() {
        return workingDirectory;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRunAs(UnixUser runAs) {
        this.runAs = runAs;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setWorkingDirectory(String workingDirectory) {
        this.workingDirectory = workingDirectory;
    }

}
