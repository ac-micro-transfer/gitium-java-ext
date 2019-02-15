package com.gitium.core.ext.dto.response;

import java.util.List;

import com.gitium.core.dto.response.AbstractResponse;
import com.gitium.core.ext.model.KLine;

public class KLineResponse extends AbstractResponse {
    private List<KLine> list;

    public List<KLine> getList() {
        return list;
    }
}