/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2019 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.foilen.smalltools.restapi.model.AbstractApiBase;
import com.foilen.smalltools.systemusage.results.NetworkInfo;

/**
 * The details about the system.
 */
public class SystemStats extends AbstractApiBase {

    private Date timestamp = new Date();

    private long cpuUsed;
    private long cpuTotal;

    private long memoryUsed;
    private long memoryTotal;

    private long memorySwapUsed;
    private long memorySwapTotal;

    private List<DiskStat> diskStats = new ArrayList<>();

    private List<NetworkInfo> networkDeltas = new ArrayList<>();

    public long getCpuTotal() {
        return cpuTotal;
    }

    public long getCpuUsed() {
        return cpuUsed;
    }

    public List<DiskStat> getDiskStats() {
        return diskStats;
    }

    public long getMemorySwapTotal() {
        return memorySwapTotal;
    }

    public long getMemorySwapUsed() {
        return memorySwapUsed;
    }

    public long getMemoryTotal() {
        return memoryTotal;
    }

    public long getMemoryUsed() {
        return memoryUsed;
    }

    public List<NetworkInfo> getNetworkDeltas() {
        return networkDeltas;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setCpuTotal(long cpuTotal) {
        this.cpuTotal = cpuTotal;
    }

    public void setCpuUsed(long cpuUsed) {
        this.cpuUsed = cpuUsed;
    }

    public void setDiskStats(List<DiskStat> diskStats) {
        this.diskStats = diskStats;
    }

    public void setMemorySwapTotal(long memorySwapTotal) {
        this.memorySwapTotal = memorySwapTotal;
    }

    public void setMemorySwapUsed(long memorySwapUsed) {
        this.memorySwapUsed = memorySwapUsed;
    }

    public void setMemoryTotal(long memoryTotal) {
        this.memoryTotal = memoryTotal;
    }

    public void setMemoryUsed(long memoryUsed) {
        this.memoryUsed = memoryUsed;
    }

    public void setNetworkDeltas(List<NetworkInfo> networkDeltas) {
        this.networkDeltas = networkDeltas;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
