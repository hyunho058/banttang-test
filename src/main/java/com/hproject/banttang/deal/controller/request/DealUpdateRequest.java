package com.hproject.banttang.deal.controller.request;

import com.hproject.banttang.deal.entity.value.Category;
import com.hproject.banttang.deal.entity.value.CategoryDetail;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "게시글 등록 번호", example = "1", required = true)
    private final Long id;
    @NotBlank
    @Schema(description = "제목", example = "제목", required = true)
    private final String title;
    @NotBlank
    @Schema(description = "내용", example = "내용", required = true)
    private final String content;
    @NotBlank
    @Schema(description = "주소1", example = "서울특별시 강남구", required = true)
    private final String address1;
    @NotBlank
    @Schema(description = "주소2", example = "역삼동", required = true)
    private final String address2;
    @NotNull
    @Schema(description = "경도", example = "127.036377", required = true)
    private final Double tradeLongitude;
    @NotNull
    @Schema(description = "위도", example = "37.500643", required = true)
    private final Double tradeLatitude;
    @NotNull
    @Schema(description = "카테고리", example = "BANTTANG", required = true)
    private final Category category;
    @Schema(description = "카테고리 상세", example = "DIGITAL")
    private final CategoryDetail categoryDetail;
    @Min(0)
    @NotNull
    @Schema(description = "가격", example = "50000", required = true)
    private final Long price;
    @Min(0)
    @NotNull
    @Schema(description = "가격/참여자 수", example = "10000", required = true)
    private final Long dutchPay;
    @Positive
    @NotNull
    @Schema(description = "참여자 수", example = "5", required = true)
    private final Long maxParticipant;
    @Schema(description = "이미지", example = "[\"https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/b8be5b2b-5bd7-4b07-b475-2803c51e8568photo-1659102914363.jpg\"]", required = true)
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
