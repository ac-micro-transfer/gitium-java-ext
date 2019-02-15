package com.gitium.core.ext.dto.request;

import com.gitium.core.ext.GitiumApiExtCommands;

@SuppressWarnings("unused")
public class MatchEntrustManualListRequest extends PagedGitiumExtCommandRequest {

    private String inCurrency;
    private String outCurrency;

    public MatchEntrustManualListRequest(int pageSize, int pageIndex, String inCurrency, String outCurrency) {
        super(GitiumApiExtCommands.MATCH_ENTRUST_MANUAL_LIST, pageSize, pageIndex);
        this.inCurrency = inCurrency;
        this.outCurrency = outCurrency;
    }

}