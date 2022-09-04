package com.hproject.banttang.user.entity;

import com.hproject.banttang.common.entity.BaseTimeEntity;
import com.hproject.banttang.deal.entity.Deal;
import com.hproject.banttang.faq.entity.Faq;
import com.hproject.banttang.user.entity.value.Provider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private Provider provider;

    @Column(nullable = false, updatable = false)
    private String userKey;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Deal> dealList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Faq> faqList = new ArrayList<>();

    @Column(nullable = true, length = 500)
    private String refreshToken;

    @Column(nullable = true, length = 500)
    private String fcmToken;

    @Column(nullable = true, length = 255)
    private String imageUrl;

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void updateFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public void updateUser(String nickname, String imageUrl) {
        this.nickname = nickname;
        this.imageUrl = imageUrl;
    }
}
