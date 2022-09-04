package com.hproject.banttang.user.entity.value;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Token {
    private String grantType;
    private String accessToken;
    private Long accessTokenExpiresIn;
    private String refreshToken;
}
