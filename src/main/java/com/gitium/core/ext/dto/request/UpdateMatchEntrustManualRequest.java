package com.gitium.core.ext.dto.request;

import com.gitium.core.ext.GitiumApiExtCommands;
import com.gitium.core.ext.model.MatchEntrustOrder;
import com.gitium.core.utils.GitiumAPIUtils;

@SuppressWarnings("unused")
public class UpdateMatchEntrustManualRequest extends GitiumExtCommandRequest {

    private String address;
    private String order;
    private long status;
    private String receiveAddress;
    private String bundle;
    private String signAddress;
    private String hash;
    private String sign;

    public UpdateMatchEntrustManualRequest(MatchEntrustOrder order, String receiveAddress) {
        super(GitiumApiExtCommands.UPDATE_MATCH_ENTRUST_MANUAL);

        this.address = order.getSendAddress();
        this.order = order.getOrder();
        this.status = 1;
        this.receiveAddress = receiveAddress;
        this.bundle = toBundle();
    }

    private String toBundle() {
        return GitiumAPIUtils.generateBundle(address, order, status);
    }

    public void sign(String seed, String hash, int index) {
        this.signAddress = hash;
        this.hash = hash;
        try {
            this.sign = GitiumAPIUtils.sign(seed, bundle, index, 2);
        } catch (Exception e) {
        }
    }
}