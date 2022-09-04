package com.hproject.banttang.deal.service.exception;

import com.hproject.banttang.common.exception.ErrorCodeException;

public class JsonConvertException extends ErrorCodeException {
    public JsonConvertException(Throwable cause) {
        super(ErrorCode.JSON_CONVERT_ERROR, cause);
    }
}
