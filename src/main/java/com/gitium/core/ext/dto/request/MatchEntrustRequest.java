package com.gitium.core.ext.dto.request;

import com.gitium.core.ext.GitiumApiExtCommands;
import com.gitium.core.model.TransferResult;
import com.gitium.core.utils.Checksum;
import com.gitium.core.utils.GitiumAPIUtils;

@SuppressWarnings("unused")
public class MatchEntrustRequest extends GitiumExtCommandRequest {

    private String address;
    private String incomeCurrency;
    private String outcomeCurrency;
    private long leastIncomeValue;
    private long outcomeValue;
    private long laterMinite;
    private String receiveAddress;
    private String hash;
    private String bundle;
    private String sign;

    public MatchEntrustRequest(

            boolean isAuto,

            String inCurrency,

            String outCurrency,

            long inValue,

            long outValue,

            int days,

            String receiveAddress

    ) {
        super(isAuto ? GitiumApiExtCommands.MATCH_ENTRUST_AUTO : GitiumApiExtCommands.MATCH_ENTRUST_MANUAL);
        this.incomeCurrency = inCurrency;
        this.outcomeCurrency = outCurrency;
        this.leastIncomeValue = inValue;
        this.outcomeValue = outValue;
        this.laterMinite = days * 24 * 60;
        try {
            this.receiveAddress = Checksum.removeChecksum(receiveAddress);
        } catch (Exception e) {
        }

        this.bundle = toBundle();
    }

    private String toBundle() {
        return GitiumAPIUtils.generateBundle(

                incomeCurrency,

                outcomeCurrency,

                leastIncomeValue,

                outcomeValue,

                laterMinite,

                receiveAddress

        );
    }

    public void sign(String seed, String hash, int index) {
        this.hash = hash;
        try {
            this.sign = GitiumAPIUtils.sign(seed, bundle, index, 2);
        } catch (Exception e) {
        }
    }

    public void setFirstAddress(String address) {
        this.address = address;
    }

    public String getOutCurrency() {
        return outcomeCurrency;
    }

    public long getOutValue() {
        return outcomeValue;
    }

}