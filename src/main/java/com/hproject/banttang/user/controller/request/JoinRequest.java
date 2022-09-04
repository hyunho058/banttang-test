package com.hproject.banttang.user.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JoinRequest {
    @NotNull
    private String provider;
    @NotNull
    private String userKey;
    @NotNull
    private String providerAccessToken;
    @NotNull
    private String name;
    @NotNull
    private String imageUrl;
}
