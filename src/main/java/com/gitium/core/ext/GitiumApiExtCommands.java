package com.gitium.core.ext;

public enum GitiumApiExtCommands {

    KLINE("kLine"),

    MATCH_ENTRUST_AUTO("prepareOrder"),

    MATCH_ENTRUST_MANUAL("prepareVolOrder"),

    CHECK_TRANS("checkTrans"),

    UPDATE_MATCH_ENTRUST_MANUAL("updatePrepareOrderVol"),

    MATCH_ENTRUST_AUTO_LIST("allPrepareOrder"),

    MATCH_ENTRUST_MANUAL_LIST("allPrepareOrderVol"),

    MATCH_ENTRUST_MY_LIST("myPrepareOrder"),

    MATCH_ENTRUST_COMPLETE_LIST("allPrepareCompVol");

    private String command;

    GitiumApiExtCommands(String command) {
        this.command = command;
    }

    public String command() {
        return command;
    }
}