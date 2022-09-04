package com.hproject.banttang.user.exception;

import com.hproject.banttang.common.exception.ErrorCodeException;

public class JwtAuthDenyException extends ErrorCodeException {
    public JwtAuthDenyException() {
        super(ErrorCode.JWT_AUTH_DENY_ERROR);
    }
}
