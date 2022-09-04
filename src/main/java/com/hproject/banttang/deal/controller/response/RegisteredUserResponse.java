package com.hproject.banttang.deal.controller.response;

import com.hproject.banttang.user.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisteredUserResponse {
    private final Long id;
    private final String nickname;
    private final String imageUrl;

    public RegisteredUserResponse(Member member) {
        this(
                member.getId(),
                member.getNickname(),
                member.getImageUrl()
        );
    }
}
