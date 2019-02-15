package com.gitium.core.ext;

import com.gitium.core.ext.dto.request.CheckTransRequest;
import com.gitium.core.ext.dto.request.KLineRequest;
import com.gitium.core.ext.dto.request.MatchEntrustAutoListRequest;
import com.gitium.core.ext.dto.request.MatchEntrustManualListRequest;
import com.gitium.core.ext.dto.request.MatchEntrustMyListRequest;
import com.gitium.core.ext.dto.request.MatchEntrustRequest;
import com.gitium.core.ext.dto.request.PagedGitiumExtCommandRequest;
import com.gitium.core.ext.dto.request.UpdateMatchEntrustManualRequest;
import com.gitium.core.ext.dto.response.KLineResponse;
import com.gitium.core.ext.dto.response.MatchEntrustListResponse;
import com.gitium.core.ext.dto.response.StateResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GitiumApiExtService {

    @POST("./")
    Single<KLineResponse> kLine(@Body KLineRequest request);

    @POST("./")
    Single<StateResponse> matchEntrust(@Body MatchEntrustRequest request);

    @POST("./")
    Single<StateResponse> checkTrans(@Body CheckTransRequest request);

    @POST("./")
    Single<StateResponse> updateMatchEntrustManual(@Body UpdateMatchEntrustManualRequest request);

    @POST("./")
    Single<MatchEntrustListResponse> matchEntrustAutoList(@Body MatchEntrustAutoListRequest request);

    @POST("./")
    Single<MatchEntrustListResponse> matchEntrustManualList(@Body MatchEntrustManualListRequest request);

    @POST("./")
    Single<MatchEntrustListResponse> matchEntrustCompleteList(@Body PagedGitiumExtCommandRequest request);

    @POST("./")
    Single<MatchEntrustListResponse> matchEntrustMyList(@Body MatchEntrustMyListRequest request);

}