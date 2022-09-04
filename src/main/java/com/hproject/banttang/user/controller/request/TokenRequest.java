package com.hproject.banttang.user.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TokenRequest {
    @NotNull
    private String accessToken;
    @NotNull
    private String refreshToken;
    @NotNull
    private String fcmToken;
}
