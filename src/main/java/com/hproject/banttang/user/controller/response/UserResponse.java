package com.hproject.banttang.user.controller.response;

import com.hproject.banttang.user.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String nickname;
    private String provider;
    private String userKey;
    private String imageUrl;

    public UserResponse(Member member) {
        this.id = member.getId();
        this.nickname = member.getNickname();
        this.provider = member.getProvider().name();
        this.userKey = member.getUserKey();
        this.imageUrl = member.getImageUrl();
    }
}
