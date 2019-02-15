package com.gitium.core.ext.dto.response;

import java.util.List;

import com.gitium.core.ext.model.MatchEntrustOrder;

public class MatchEntrustListResponse {
    private List<MatchEntrustOrder> list;
    private int sumNum;

    public List<MatchEntrustOrder> getList() {
        return list;
    }

    public int getSumNum() {
        return sumNum;
    }
}