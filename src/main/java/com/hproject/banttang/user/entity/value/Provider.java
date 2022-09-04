package com.hproject.banttang.user.entity.value;

import com.hproject.banttang.common.entity.exception.NotFoundException;

public enum Provider {
    GOOGLE,
    KAKAO,

    BANTTANG_TEST;

    public static Provider of(String name) {
        for (Provider value : values()) {
            if (value.name().equals(name)) {
                return value;
            }
        }

        throw new NotFoundException();
    }
}
