package com.hproject.banttang.user.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class UpdateUserRequest {
    private final String imageUrl;
    @NotBlank
    private final String nickname;

}
