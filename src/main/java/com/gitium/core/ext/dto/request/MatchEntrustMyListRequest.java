package com.gitium.core.ext.dto.request;

import com.gitium.core.ext.GitiumApiExtCommands;

@SuppressWarnings("unused")
public class MatchEntrustMyListRequest extends GitiumExtCommandRequest {

    private String address;

    public MatchEntrustMyListRequest(String address) {
        super(GitiumApiExtCommands.MATCH_ENTRUST_MY_LIST);
        this.address = address;
    }
}