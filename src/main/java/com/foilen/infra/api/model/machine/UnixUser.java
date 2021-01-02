/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.machine;

import com.foilen.smalltools.restapi.model.AbstractApiBase;
import com.foilen.smalltools.tools.StringTools;

/**
 * This is a unix user that is installed on some Machine.
 */
public class UnixUser extends AbstractApiBase implements Comparable<UnixUser> {

    // Specific
    private Long id;
    private String name;
    private String homeFolder;
    private String shell = "/bin/bash";
    private boolean keepClearPassword;
    private String password;
    private String hashedPassword;

    public UnixUser() {
    }

    /**
     * Primary key.
     *
     * @param id
     *            the id
     */
    public UnixUser(Long id) {
        this.id = id;
    }

    public UnixUser(Long id, String name, String homeFolder, String shell) {
        this.id = id;
        this.name = name;
        this.homeFolder = homeFolder;
        this.shell = shell;
    }

    public UnixUser(Long id, String name, String homeFolder, String shell, String hashedPassword) {
        this.id = id;
        this.name = name;
        this.homeFolder = homeFolder;
        this.shell = shell;
        this.hashedPassword = hashedPassword;
    }

    @Override
    public int compareTo(UnixUser o) {
        return StringTools.safeComparisonNullFirst(this.name, o.name);
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getHomeFolder() {
        return homeFolder;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getShell() {
        return shell;
    }

    public boolean isKeepClearPassword() {
        return keepClearPassword;
    }

    public UnixUser setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
        return this;
    }

    public UnixUser setHomeFolder(String homeFolder) {
        this.homeFolder = homeFolder;
        return this;
    }

    public UnixUser setId(Long id) {
        this.id = id;
        return this;
    }

    public UnixUser setKeepClearPassword(boolean keepClearPassword) {
        this.keepClearPassword = keepClearPassword;
        return this;
    }

    public UnixUser setName(String name) {
        this.name = name;
        return this;
    }

    public UnixUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public UnixUser setShell(String shell) {
        this.shell = shell;
        return this;
    }

}
