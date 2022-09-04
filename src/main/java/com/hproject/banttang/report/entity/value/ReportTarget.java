package com.hproject.banttang.report.entity.value;

public enum ReportTarget {
    USER("유저"),
    DEAL("거래"),
    COMMENT("댓글");

    private final String message;

    ReportTarget(String message) {
        this.message = message;
    }

    public String getKey() {
        return name().replace("_", "-").toLowerCase();
    }

    public String getMessage() {
        return message;
    }
}
