package com.gitium.core.ext;

import java.util.List;

import com.gitium.core.IGitiumApi;
import com.gitium.core.ext.dto.request.MatchEntrustRequest;
import com.gitium.core.ext.dto.request.UpdateMatchEntrustManualRequest;
import com.gitium.core.ext.model.KLine;
import com.gitium.core.ext.model.MatchEntrustOrder;

import io.reactivex.Single;

public interface IGitiumApiExt extends IGitiumApi {

    String MATCH_CENTER_ADDRESS = "LCWHKVSIFUNWJGGYWBQF9JDMT9LESW9LHETWFDIV9HO9AQFYSNJAMLGGWISBHVQIHXPNKUVGMPOFVTWUXWMWQYNKKZ";

    Single<List<KLine>> kLine(String inCurrency, String outCurrency);

    Single<Boolean> matchEntrust(MatchEntrustRequest request);

    Single<Boolean> checkTrans(MatchEntrustOrder order);

    Single<Boolean> updateMatchEntrustManual(UpdateMatchEntrustManualRequest request);

    Single<List<MatchEntrustOrder>> getMatchEntrustAutoList(int pageSize, int pageIndex);

    Single<List<MatchEntrustOrder>> getMatchEntrustManualList(int pageSize, int pageIndex, String inCurrency,
            String outCurrency);

    Single<List<MatchEntrustOrder>> getMatchEntrustCompleteList(int pageSize, int pageIndex);

    Single<List<MatchEntrustOrder>> getMatchEntrustMyList(String seed);

}