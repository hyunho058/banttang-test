package com.hproject.banttang.user.exception;

import com.hproject.banttang.common.exception.ErrorCodeException;

public class ForbiddenUserException extends ErrorCodeException {
    public ForbiddenUserException() {
        super(ErrorCode.FORBIDDEN_ERROR);
    }
}
