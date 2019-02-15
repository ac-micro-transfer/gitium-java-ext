package com.gitium.core.ext.dto.request;

import com.gitium.core.ext.GitiumApiExtCommands;
import com.gitium.core.ext.model.MatchEntrustOrder;

@SuppressWarnings("unused")
public class CheckTransRequest extends GitiumExtCommandRequest {

    private String address;
    private String order;

    public CheckTransRequest(MatchEntrustOrder order) {
        super(GitiumApiExtCommands.CHECK_TRANS);
        this.address = order.getSendAddress();
        this.order = order.getOrder();
    }
}