package com.hproject.banttang.report.entity.value;

public enum ReportCategory {
    PORNOGRAPHY("음란물"),
    ILLEGAL_INFORMATION("불법정보"),
    HARMFUL_CONTENT("유해한 내용"),
    VILIFICATION("욕설"),
    DISCLOSURE_OF_PERSONAL_INFORMATION("개인정보 노출"),
    ETC("기타");

    private final String message;

    ReportCategory(String message) {
        this.message = message;
    }

    public String getKey() {
        return name().replace("_", "-").toLowerCase();
    }

    public String getMessage() {
        return message;
    }
}
