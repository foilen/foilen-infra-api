/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.machine.model;

import java.util.ArrayList;
import java.util.List;

import com.foilen.smalltools.restapi.model.AbstractApiBase;
import com.foilen.smalltools.tools.ResourceTools;
import com.foilen.smalltools.tuple.Tuple2;

public class IPApplicationDefinitionAssetsBundle extends AbstractApiBase {

    private String assetsFolderPath;

    private List<Tuple2<String, String>> assetsRelativePathAndTextContent = new ArrayList<>();
    private List<Tuple2<String, byte[]>> assetsRelativePathAndBinaryContent = new ArrayList<>();

    public IPApplicationDefinitionAssetsBundle() {
    }

    public IPApplicationDefinitionAssetsBundle(String assetsFolderPath) {
        this.assetsFolderPath = assetsFolderPath;
    }

    public IPApplicationDefinitionAssetsBundle addAssetContent(String assetRelativePath, byte[] content) {
        assetsRelativePathAndBinaryContent.add(new Tuple2<>(assetRelativePath, content));
        return this;
    }

    public IPApplicationDefinitionAssetsBundle addAssetContent(String assetRelativePath, String content) {
        assetsRelativePathAndTextContent.add(new Tuple2<>(assetRelativePath, content));
        return this;
    }

    public IPApplicationDefinitionAssetsBundle addAssetResource(String assetRelativePath, String sourceResource) {
        String content = ResourceTools.getResourceAsString(sourceResource);
        return addAssetContent(assetRelativePath, content);
    }

    public String getAssetsFolderPath() {
        return assetsFolderPath;
    }

    public List<Tuple2<String, byte[]>> getAssetsRelativePathAndBinaryContent() {
        return assetsRelativePathAndBinaryContent;
    }

    public List<Tuple2<String, String>> getAssetsRelativePathAndTextContent() {
        return assetsRelativePathAndTextContent;
    }

    public void setAssetsFolderPath(String assetsFolderPath) {
        this.assetsFolderPath = assetsFolderPath;
    }

    public void setAssetsRelativePathAndBinaryContent(List<Tuple2<String, byte[]>> assetsRelativePathAndBinaryContent) {
        this.assetsRelativePathAndBinaryContent = assetsRelativePathAndBinaryContent;
    }

    public void setAssetsRelativePathAndTextContent(List<Tuple2<String, String>> assetsRelativePathAndTextContent) {
        this.assetsRelativePathAndTextContent = assetsRelativePathAndTextContent;
    }

}
