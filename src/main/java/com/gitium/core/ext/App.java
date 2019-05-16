package com.gitium.core.ext;

import com.gitium.core.MyLog;
import com.gitium.core.error.GitiumException;

import org.apache.commons.lang3.math.NumberUtils;

import io.reactivex.functions.Consumer;

public class App {

    private static Consumer<Throwable> onError = (error) -> {
        if (error instanceof GitiumException) {
            String msg = ((GitiumException) error).getError().getMessage();
            MyLog.error(error, msg);
        } else {
            MyLog.error(error, "error");
        }
    };

    private static IGitiumApiExt api;

    public static void main(String[] args) {
        api = new GitiumApiExt.Builder("http://test.gitium.io", "http://180.210.204.240").setDebug(true).build();
        api.getContractList().blockingGet();

        String command = args[0];
        switch (command) {
        case "kline":
            kline(args[1], args[2]);
            break;
        case "getMatchEntrustAutoList":
            getMatchEntrustAutoList(NumberUtils.toInt(args[1], 0));
            break;
        case "getMatchEntrustManualList":
            getMatchEntrustManualList(NumberUtils.toInt(args[1], 0));
            break;
        }
    }

    private static void kline(String inCurrency, String outCurrency) {
        api.kLine(inCurrency, outCurrency)

                .toObservable()

                .blockingSubscribe(result -> MyLog.debug(result.size() + ""), onError);
        ;
    }

    private static void getMatchEntrustAutoList(int pageIndex) {
        api

                .getMatchEntrustAutoList(20, pageIndex)

                .toObservable()

                .blockingSubscribe(

                        result -> {
                            MyLog.debug(result.size() + "");
                        },

                        onError

                );
        ;
    }

    private static void getMatchEntrustManualList(int pageIndex) {
        api

                .getMatchEntrustManualList(20, pageIndex, "", "")

                .toObservable()

                .blockingSubscribe(

                        result -> {
                            MyLog.debug(result.size() + "");
                        },

                        onError

                );
        ;
    }
}