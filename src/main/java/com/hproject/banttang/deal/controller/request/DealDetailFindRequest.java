package com.hproject.banttang.deal.controller.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class DealDetailFindRequest {
    @NotNull
    private final Long id;

    public DealDetailFindRequest(Long id) {
        this.id = id;
    }
}
