package com.hproject.banttang.user.exception;

import com.hproject.banttang.common.exception.ErrorCodeException;

public class UserNotFoundException extends ErrorCodeException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }

    public UserNotFoundException(String message) {
        super(ErrorCode.USER_NOT_FOUND, message);
    }
}
