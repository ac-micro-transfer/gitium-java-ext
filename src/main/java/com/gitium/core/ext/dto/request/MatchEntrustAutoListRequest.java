package com.gitium.core.ext.dto.request;

import com.gitium.core.ext.GitiumApiExtCommands;

@SuppressWarnings("unused")
public class MatchEntrustAutoListRequest extends PagedGitiumExtCommandRequest {

    private String type = "1";

    public MatchEntrustAutoListRequest(int pageSize, int pageIndex) {
        super(GitiumApiExtCommands.MATCH_ENTRUST_AUTO_LIST, pageSize, pageIndex);
    }
}