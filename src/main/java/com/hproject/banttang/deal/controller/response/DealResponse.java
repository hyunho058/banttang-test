package com.hproject.banttang.deal.controller.response;

import com.hproject.banttang.common.entity.value.BlindStatus;
import com.hproject.banttang.deal.entity.Deal;
import com.hproject.banttang.deal.entity.value.Category;
import com.hproject.banttang.deal.entity.value.CategoryDetail;
import com.hproject.banttang.location.controller.response.LocationResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class DealResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime createAt;
    private final LocationResponse location;
    private final Double tradeLatitude;
    private final Double tradeLongitude;
    private final Category category;
    private final CategoryDetail categoryDetail;
    private final LocalDateTime completedAt;
    private final Long beongaeCount;
    private final List<String> imageUrl;
    private final Long price;
    private final Long dutchPay;
    private final BlindStatus status;
    private final Long timeRemaining;
    private final RegisteredUserResponse user;

    public DealResponse(Deal deal) {
        this(
                deal.getId(),
                deal.getTitle(),
                deal.getContent(),
                deal.getCreatedAt(),
                new LocationResponse(deal.getLocation()),
                deal.getTradeLatitude(),
                deal.getTradeLongitude(),
                deal.getCategory(),
                deal.getCategoryDetail(),
                deal.getCompletedAt(),
                deal.getBeongaeCount(),
                deal.getImageUrl(),
                deal.getPrice(),
                deal.getDutchPay(),
                deal.getStatus(),
                deal.dealRemainingTime(),
                new RegisteredUserResponse(deal.getMember())
        );
    }
}
