package com.hproject.banttang.common.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Optional;

@Getter
public class PagingRequest {
    @PositiveOrZero
    @Schema(description = "페이지", example = "0", required = true)
    private final Integer page;
    @Positive
    @Schema(description = "페이지 당 수", example = "10", required = true)
    private final Integer perPage;

    public PagingRequest(Integer page, Integer perPage) {
        this.page = Optional.ofNullable(page)
                .orElse(0);
        this.perPage = Optional.ofNullable(perPage)
                .orElse(10);
    }
}
