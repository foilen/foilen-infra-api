/*
    Foilen Infra API
    https://github.com/foilen/foilen-infra-api
    Copyright (c) 2017-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.api.model.permission;

import com.foilen.smalltools.restapi.model.AbstractSingleResult;

public class OwnerRuleResult extends AbstractSingleResult<OwnerRule> {

    public OwnerRuleResult() {
    }

    public OwnerRuleResult(OwnerRule item) {
        this.setItem(item);
    }

}
