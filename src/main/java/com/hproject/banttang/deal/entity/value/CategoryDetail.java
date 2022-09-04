package com.hproject.banttang.deal.entity.value;

public enum CategoryDetail {
    DIGITAL("디지털기기"),
    APPLIANCES("생활가전"),
    FOOD("식품"),
    CLOTHING("의류/잡화"),
    BEAUTY("미용"),
    PET_SUPPLIES("반려동물"),
    ETC("기타");

    private final String message;

    CategoryDetail(String message) {
        this.message = message;
    }

    public String getKey() {
        return name().replace("_", "-").toLowerCase();
    }

    public String getMessage() {
        return message;
    }
}
