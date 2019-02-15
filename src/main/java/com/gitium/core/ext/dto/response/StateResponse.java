package com.gitium.core.ext.dto.response;

import com.gitium.core.dto.response.AbstractResponse;

public class StateResponse extends AbstractResponse {
    private boolean state;

    public boolean isOK() {
        return state;
    }
}