package com.hproject.banttang.common.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EmptyResponse {
    private Meta meta;

    public static class Ok<T> extends EmptyResponse{
        public Ok() {
            super(new Meta.Ok());
        }
    }
}