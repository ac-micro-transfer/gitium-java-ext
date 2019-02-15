package com.gitium.core.ext.dto.request;

import com.gitium.core.ext.GitiumApiExtCommands;

@SuppressWarnings("unused")
public class PagedGitiumExtCommandRequest extends GitiumExtCommandRequest {

    private String countPage;
    private String pageSize;

    public PagedGitiumExtCommandRequest(GitiumApiExtCommands command, int pageSize, int pageIndex) {
        super(command);
        this.pageSize = pageSize + "";
        this.countPage = pageIndex + "";
    }

    public static PagedGitiumExtCommandRequest createMatchEntrustCompleteListRequest(int pageSize, int pageIndex) {
        return new PagedGitiumExtCommandRequest(GitiumApiExtCommands.MATCH_ENTRUST_COMPLETE_LIST, pageSize, pageIndex);
    }

}