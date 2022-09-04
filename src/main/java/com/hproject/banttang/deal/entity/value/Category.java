package com.hproject.banttang.deal.entity.value;

public enum Category {
    BEONGAE("번개"),
    BANTTANG("반땅");

    private final String message;

    Category(String message) {
        this.message = message;
    }

    public String getKey() {
        return name().replace("_", "-").toLowerCase();
    }

    public String getMessage() {
        return message;
    }

}
