package com.gitium.core.ext.dto.request;

import com.gitium.core.GitiumAPICommands;
import com.gitium.core.ext.GitiumApiExtCommands;

import org.apache.commons.lang3.time.DateFormatUtils;

@SuppressWarnings("unused")
public class KLineRequest extends GitiumExtCommandRequest {
    private String inCurrency;
    private String outCurrency;
    private String date;

    public KLineRequest(String inCurrency, String outCurrency) {
        super(GitiumApiExtCommands.KLINE);
        this.inCurrency = inCurrency;
        this.outCurrency = outCurrency;
        this.date = DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss");
    }
}