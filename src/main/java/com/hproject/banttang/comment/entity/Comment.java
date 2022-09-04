package com.hproject.banttang.comment.entity;

import com.hproject.banttang.common.entity.BaseTimeEntity;
import com.hproject.banttang.common.entity.value.BlindStatus;
import com.hproject.banttang.deal.entity.Deal;
import com.hproject.banttang.user.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, updatable = false)
    private Deal deal;

    @ManyToOne
    private Member member;

    private String contents;

    private boolean isSecret;

    private int reportCount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(10) default 'NORMAL'")
    private BlindStatus status = BlindStatus.NORMAL;

    public void deleteComment() {
        setDeleteTime();
    }
}

