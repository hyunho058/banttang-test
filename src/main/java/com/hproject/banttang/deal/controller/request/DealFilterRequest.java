package com.hproject.banttang.deal.controller.request;

import com.hproject.banttang.deal.entity.value.Category;
import com.hproject.banttang.deal.entity.value.CategoryDetail;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
public class DealFilterRequest {

    @Schema(description = "카테고리", example = "BANTTANG", required = true)
    private final Category category;
    @Schema(description = "카테고리 상세", example = "DIGITAL")
    private final CategoryDetail categoryDetail;
    @PositiveOrZero
    @Schema(description = "위도", example = "37.500643", required = true)
    private final Double currentLatitude;
    @PositiveOrZero
    @Schema(description = "경도", example = "127.036377", required = true)
    private final Double currentLongitude;
    @Length(max = 100)
    @Schema(description = "제목 검색", example = "제목")
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
