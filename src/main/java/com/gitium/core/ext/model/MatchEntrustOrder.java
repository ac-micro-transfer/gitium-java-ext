package com.gitium.core.ext.model;

import java.io.Serializable;

import com.gitium.core.model.GitiumContract;
import com.gitium.core.utils.GitiumAPIUtils;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.time.DateFormatUtils;

public class MatchEntrustOrder implements Serializable {

    private static final long serialVersionUID = 7307891597225520820L;

    private String order;
    @SerializedName("incomeCurrency")
    private String inCurrency;
    @SerializedName("leastIncomeValue")
    private long inValue;
    @SerializedName("outcomeCurrency")
    private String outCurrency;
    @SerializedName("outcomeValue")
    private long outValue;
    private String sendAddress;
    private String receiveAddress;
    private int status;
    @SerializedName("createDateLong")
    private long createDate;
    private String endDate;

    private GitiumContract inContract;
    private GitiumContract outContract;

    public String getOrder() {
        return order;
    }

    public String getInCurrency() {
        return inCurrency;
    }

    public long getInValue() {
        return inValue;
    }

    public String getOutCurrency() {
        return outCurrency;
    }

    public long getOutValue() {
        return outValue;
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public int getStatus() {
        return status;
    }

    public String getFormatedCreateDate() {
        return DateFormatUtils.format(createDate, "yyyy-MM-dd HH:mm:ss");
    }

    public String getFormatedDate(boolean isCreateDate) {
        return isCreateDate ? getFormatedCreateDate() : endDate;
    }

    public void setInContract(GitiumContract contract) {
        this.inContract = contract;
    }

    public void setOutContract(GitiumContract contract) {
        this.outContract = contract;
    }

    public String getInCurrencyName() {
        return inContract == null ? "" : inContract.getName();
    }

    public String getFormatedInValue() {
        int decimals = inContract == null ? 0 : inContract.getDecimals();
        return GitiumAPIUtils.formatContractValue(inValue, decimals);
    }

    public String getOutCurrencyName() {
        return outContract == null ? "" : outContract.getName();
    }

    public String getFormatedOutValue() {
        int decimals = outContract == null ? 0 : outContract.getDecimals();
        return GitiumAPIUtils.formatContractValue(outValue, decimals);
    }

}