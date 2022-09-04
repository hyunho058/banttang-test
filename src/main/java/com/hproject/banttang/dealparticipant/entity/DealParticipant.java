package com.hproject.banttang.dealparticipant.entity;

import com.hproject.banttang.deal.entity.Deal;
import com.hproject.banttang.user.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DealParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, updatable = false)
    private Deal deal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, updatable = false)
    private Member member;

    @Column(nullable = false)
    private Long cancelCount;

    @Column
    private LocalDateTime canceledAt;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public void setDealParticipantRejoin(){
        this.canceledAt = null;
    }

    public void setAddCancelCount(){
        cancelCount ++;
        this.canceledAt = LocalDateTime.now();
    }
}
