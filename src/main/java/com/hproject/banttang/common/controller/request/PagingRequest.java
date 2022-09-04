package com.hproject.banttang.common.controller.request;

import lombok.Getter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Optional;

@Getter
public class PagingRequest {
    @PositiveOrZero
    private final Integer page;
    @Positive
    private final Integer perPage;

    public PagingRequest(Integer page, Integer perPage) {
        this.page = Optional.ofNullable(page)
                .orElse(0);
        this.perPage = Optional.ofNullable(perPage)
                .orElse(10);
    }
}
