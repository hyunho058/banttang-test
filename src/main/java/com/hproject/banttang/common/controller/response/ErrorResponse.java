package com.hproject.banttang.common.controller.response;

import com.hproject.banttang.common.exception.ErrorCodeException;
import lombok.Data;

@Data
public class ErrorResponse {
    private final Meta meta;

    public ErrorResponse(String errorCode, String errorMessage) {
        this.meta = new Meta.Fail(errorCode, errorMessage);
    }

    public ErrorResponse(ErrorCodeException e) {
        this(
                e.getKey(),
                e.getMessage()
        );
    }
}
