package com.hproject.banttang.user.controller.response;

import com.hproject.banttang.user.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfoResponse {
    private final Long id;
    private final String nickname;
    private final String imageUrl;

    public UserInfoResponse(Member member) {
        this(
                member.getId(),
                member.getNickname(),
                member.getImageUrl()
        );
    }
}
