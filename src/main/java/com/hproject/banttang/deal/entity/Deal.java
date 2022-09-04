package com.hproject.banttang.deal.entity;

import com.hproject.banttang.common.entity.BaseTimeEntity;
import com.hproject.banttang.common.entity.value.BlindStatus;
import com.hproject.banttang.deal.config.ImageDataConverter;
import com.hproject.banttang.deal.controller.request.DealUpdateRequest;
import com.hproject.banttang.deal.entity.value.Category;
import com.hproject.banttang.deal.entity.value.CategoryDetail;
import com.hproject.banttang.dealparticipant.entity.DealParticipant;
import com.hproject.banttang.location.entity.Location;
import com.hproject.banttang.user.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Deal extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, updatable = false)
    private Member member;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 500)
    private String content;

    @OneToOne
    @JoinColumn(nullable = false)
    private Location location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    private CategoryDetail categoryDetail;

    @Column
    private LocalDateTime completedAt;

    @Column(nullable = false)
    private Long beongaeCount;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(10) default 'TRADING'")
    private BlindStatus status = BlindStatus.TRADING;

    @Column(nullable = false)
    private Double tradeLatitude;

    @Column(nullable = false)
    private Double tradeLongitude;

    @Convert(converter = ImageDataConverter.class)
    @Column(columnDefinition = "json")
    private List<String> imageUrl = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "deal", cascade = CascadeType.ALL)
    private List<DealParticipant> dealParticipantList = new ArrayList<>();

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Long maxParticipant;

    @Column(nullable = false)
    private Long currentParticipant;

    @Column(nullable = false)
    private Long dutchPay;

    public Deal updateDeal(DealUpdateRequest updateRequest, Location locationData) {
        title = updateRequest.getTitle();
        content = updateRequest.getContent();
        location = locationData;
        tradeLatitude = updateRequest.getTradeLatitude();
        tradeLongitude = updateRequest.getTradeLongitude();
        category = updateRequest.getCategory();
        categoryDetail = updateRequest.getCategoryDetail();
        price = updateRequest.getPrice();
        dutchPay = updateRequest.getDutchPay();
        maxParticipant = updateRequest.getMaxParticipant();
        updateImages(updateRequest);
        return this;
    }

    private void updateImages(DealUpdateRequest deal) {
        imageUrl.clear();
        List<String> imageUrls = deal.getImageUrls();
        imageUrl.addAll(imageUrls != null ? imageUrls : Collections.emptyList());
    }

    public void deleteDeal() {
        setDeleteTime();
    }

    public Long dealRemainingTime() {
        if (!category.equals(Category.BEONGAE)) {
            return null;
        }
        return remainingTimeCalculation(getCreatedAt());
    }

    public Long remainingTimeCalculation(LocalDateTime creationTime) {
        Duration duration = Duration.between(
            LocalDateTime.now(),
            creationTime.plusHours(1));
        long remainingTime = duration.getSeconds();

        if (remainingTime < 0) {
            remainingTime = 0L;
        }

        return remainingTime;
    }
}
