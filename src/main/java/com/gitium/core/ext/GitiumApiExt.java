package com.gitium.core.ext;

import java.util.Collections;
import java.util.List;

import com.gitium.core.AddressDelegate;
import com.gitium.core.GitiumAPI;
import com.gitium.core.ext.dto.request.CheckTransRequest;
import com.gitium.core.ext.dto.request.KLineRequest;
import com.gitium.core.ext.dto.request.MatchEntrustAutoListRequest;
import com.gitium.core.ext.dto.request.MatchEntrustManualListRequest;
import com.gitium.core.ext.dto.request.MatchEntrustMyListRequest;
import com.gitium.core.ext.dto.request.MatchEntrustRequest;
import com.gitium.core.ext.dto.request.PagedGitiumExtCommandRequest;
import com.gitium.core.ext.dto.request.UpdateMatchEntrustManualRequest;
import com.gitium.core.ext.dto.response.MatchEntrustListResponse;
import com.gitium.core.ext.model.KLine;
import com.gitium.core.ext.model.MatchEntrustOrder;
import com.gitium.core.model.GitiumContract;

import org.apache.commons.lang3.StringUtils;

import io.reactivex.Single;

public class GitiumApiExt extends GitiumAPI implements IGitiumApiExt {

    protected GitiumApiExtService extService;

    protected GitiumApiExt(Builder builder) {
        super(builder);
        extService = retrofit.create(GitiumApiExtService.class);
    }

    @Override
    public Single<List<KLine>> kLine(String inCurrency, String outCurrency) {
        KLineRequest request = new KLineRequest(inCurrency, outCurrency);
        return extService.kLine(request)

                .map(response -> response.getList())

                .map(list -> list == null ? Collections.emptyList() : list);
    }

    @Override
    public Single<Boolean> matchEntrust(MatchEntrustRequest request) {
        return extService.matchEntrust(request).map(r -> r.isOK());
    }

    @Override
    public Single<Boolean> checkTrans(MatchEntrustOrder order) {
        CheckTransRequest request = new CheckTransRequest(order);
        return extService.checkTrans(request).map(r -> r.isOK());
    }

    @Override
    public Single<Boolean> updateMatchEntrustManual(UpdateMatchEntrustManualRequest request) {
        return extService.updateMatchEntrustManual(request).map(r -> r.isOK());
    }

    @Override
    public Single<List<MatchEntrustOrder>> getMatchEntrustAutoList(int pageSize, int pageIndex) {
        MatchEntrustAutoListRequest request = new MatchEntrustAutoListRequest(pageSize, pageIndex);
        return extService.matchEntrustAutoList(request).map(r -> setContractToMatchEntrustList(r));
    }

    @Override
    public Single<List<MatchEntrustOrder>> getMatchEntrustManualList(int pageSize, int pageIndex, String inCurrency,
            String outCurrency) {
        MatchEntrustManualListRequest request = new MatchEntrustManualListRequest(pageSize, pageIndex, inCurrency,
                outCurrency);
        return extService.matchEntrustManualList(request).map(r -> setContractToMatchEntrustList(r));
    }

    @Override
    public Single<List<MatchEntrustOrder>> getMatchEntrustCompleteList(int pageSize, int pageIndex) {
        return extService
                .matchEntrustCompleteList(
                        PagedGitiumExtCommandRequest.createMatchEntrustCompleteListRequest(pageSize, pageIndex))
                .map(r -> setContractToMatchEntrustList(r));
    }

    @Override
    public Single<List<MatchEntrustOrder>> getMatchEntrustMyList(String seed) {
        String address = getFirstAddress(seed).map(pair -> pair.getAddress()).blockingGet();
        MatchEntrustMyListRequest request = new MatchEntrustMyListRequest(address);
        return extService.matchEntrustMyList(request).map(r -> setContractToMatchEntrustList(r));
    }

    private List<MatchEntrustOrder> setContractToMatchEntrustList(MatchEntrustListResponse response) {
        List<MatchEntrustOrder> list = response.getList();
        for (GitiumContract c : mContracts) {
            for (MatchEntrustOrder o : list) {
                if (StringUtils.equals(c.getAddress(), o.getInCurrency())) {
                    o.setInContract(c);
                }
                if (StringUtils.equals(c.getAddress(), o.getOutCurrency())) {
                    o.setOutContract(c);
                }
            }
        }
        return list;
    }

    public static class Builder extends GitiumAPI.Builder {
        public Builder(String centralizationUrl, String url) {
            super(centralizationUrl, url);
        }

        @Override
        public Builder setDebug(boolean debug) {
            super.setDebug(debug);
            return this;
        }

        @Override
        public Builder setAddressDelegate(AddressDelegate addressDelegate) {
            super.setAddressDelegate(addressDelegate);
            return this;
        }

        @Override
        public Builder setSecurity(int security) {
            super.setSecurity(security);
            return this;
        }

        @Override
        public Builder setDepth(int depth) {
            super.setDepth(depth);
            return this;
        }

        @Override
        public Builder setMinWeightMagnitude(int minWeightMagnitude) {
            super.setMinWeightMagnitude(minWeightMagnitude);
            return this;
        }

        @Override
        public GitiumApiExt build() {
            return new GitiumApiExt(this);
        }
    }

}