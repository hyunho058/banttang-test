package com.hproject.banttang.common.infra.fcmtoken.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class FCMTokenRequest {
    @NotBlank
    String title;
    @NotBlank
    String body;
}
