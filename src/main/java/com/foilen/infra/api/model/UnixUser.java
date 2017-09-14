/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UnixUser {

    private Integer id;
    private String name;
    private String homeFolder;
    private String shell;
    private String hashedPassword;

    public UnixUser() {
    }

    public UnixUser(Integer id, String name, String homeFolder, String shell) {
        this.id = id;
        this.name = name;
        this.homeFolder = homeFolder;
        this.shell = shell;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getHomeFolder() {
        return homeFolder;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShell() {
        return shell;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void setHomeFolder(String homeFolder) {
        this.homeFolder = homeFolder;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShell(String shell) {
        this.shell = shell;
    }

    /**
     * Get the line in /etc/passwd file.
     *
     * @return the line
     */
    public String toPasswd() {
        return name + ":x:" + id + ":" + id + "::" + homeFolder + ":" + shell;
    }

    /**
     * Get the line in /etc/shadow file.
     *
     * @return the line
     */
    public String toShadow() {
        return name + ":" + hashedPassword + ":0:0:99999:7:::";
    }

}
