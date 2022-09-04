package com.hproject.banttang.deal.controller.request;

import com.hproject.banttang.deal.entity.value.Category;
import com.hproject.banttang.deal.entity.value.CategoryDetail;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
public class DealFilterRequest {

    private final Category category;
    private final CategoryDetail categoryDetail;
    @PositiveOrZero
    private final Double currentLatitude;
    @PositiveOrZero
    private final Double currentLongitude;
    @Length(max = 100)
    private final String titleKeyword;

    @Builder
    public DealFilterRequest(Category category,
                             CategoryDetail categoryDetail,
                             Double currentLatitude,
                             Double currentLongitude,
                             String titleKeyword) {
        this.category = category;
        this.categoryDetail = categoryDetail;
        this.currentLatitude = currentLatitude;
        this.currentLongitude = currentLongitude;
        this.titleKeyword = titleKeyword;
    }
}
