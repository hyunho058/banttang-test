package com.hproject.banttang.common.entity.value;

public enum BlindStatus {
    TRADING("거래중"),
    COMPLETION("거래 완료"),
    THE_END("거래 종료"),
    DELETE("거래 삭제"),
    NORMAL("정상"),
    DECLARATION("신고"),
    BLIND("블라인드");

    private final String message;

    BlindStatus(String message) {
        this.message = message;
    }

    public String getKey() {
        return name().replace("_", "-").toLowerCase();
    }

    public String getMessage() {
        return message;
    }
}
