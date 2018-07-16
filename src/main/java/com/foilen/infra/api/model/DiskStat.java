/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model;

import com.foilen.smalltools.restapi.model.AbstractApiBase;

public class DiskStat extends AbstractApiBase {

    private String path;
    private boolean isRoot = true;
    private long freeSpace;
    private double freeSpacePercent;
    private long totalSpace;
    private long usedSpace;
    private double usedSpacePercent;

    public long getFreeSpace() {
        return freeSpace;
    }

    public double getFreeSpacePercent() {
        return freeSpacePercent;
    }

    public String getPath() {
        return path;
    }

    public long getTotalSpace() {
        return totalSpace;
    }

    public long getUsedSpace() {
        return usedSpace;
    }

    public double getUsedSpacePercent() {
        return usedSpacePercent;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setFreeSpace(long freeSpace) {
        this.freeSpace = freeSpace;
    }

    public void setFreeSpacePercent(double freeSpacePercent) {
        this.freeSpacePercent = freeSpacePercent;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setRoot(boolean isRoot) {
        this.isRoot = isRoot;
    }

    public void setTotalSpace(long totalSpace) {
        this.totalSpace = totalSpace;
    }

    public void setUsedSpace(long usedSpace) {
        this.usedSpace = usedSpace;
    }

    public void setUsedSpacePercent(double usedSpacePercent) {
        this.usedSpacePercent = usedSpacePercent;
    }

}
