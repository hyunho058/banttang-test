package com.hproject.banttang.common.infra.fcmtoken.value;

public enum TokenValue {
    TOPIC_ALL("ALL");

    private String code;

    TokenValue(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

}
