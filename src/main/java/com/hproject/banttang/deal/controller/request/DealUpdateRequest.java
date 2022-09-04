package com.hproject.banttang.deal.controller.request;

import com.hproject.banttang.deal.entity.value.Category;
import com.hproject.banttang.deal.entity.value.CategoryDetail;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
public class DealUpdateRequest {
    @NotNull
    private final Long id;
    @NotBlank
    private final String title;
    @NotBlank
    private final String content;
    @NotBlank
    private final String address1;
    @NotBlank
    private final String address2;
    @NotNull
    private final Double tradeLongitude;
    @NotNull
    private final Double tradeLatitude;
    @NotNull
    private final Category category;
    private final CategoryDetail categoryDetail;
    @Min(0)
    @NotNull
    private final Long price;
    @Min(0)
    @NotNull
    private final Long dutchPay;
    @Positive
    @NotNull
    private final Long maxParticipant;
    private final List<String> imageUrls;
    private final List<String> deleteImages;

    @Builder
    public DealUpdateRequest(Long id,
                             String title,
                             String content,
                             Category category,
                             CategoryDetail categoryDetail,
                             String address1,
                             String address2,
                             Double tradeLongitude,
                             Double tradeLatitude,
                             Long price,
                             Long dutchPay,
                             Long maxParticipant,
                             List<String> imageUrls,
                             List<String> deleteImages
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.categoryDetail = categoryDetail;
        this.address1 = address1;
        this.address2 = address2;
        this.tradeLatitude = tradeLatitude;
        this.tradeLongitude = tradeLongitude;
        this.price = price;
        this.dutchPay = dutchPay;
        this.maxParticipant = maxParticipant;
        this.imageUrls = imageUrls;
        this.deleteImages = deleteImages;
    }
}
