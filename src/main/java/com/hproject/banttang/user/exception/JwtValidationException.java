package com.hproject.banttang.user.exception;

import com.hproject.banttang.common.exception.ErrorCodeException;

public class JwtValidationException extends ErrorCodeException {
    public JwtValidationException() {
        super(ErrorCode.JWT_VALIDATION_ERROR);
    }
}
