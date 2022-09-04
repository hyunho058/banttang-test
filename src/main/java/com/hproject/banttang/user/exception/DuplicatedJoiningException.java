package com.hproject.banttang.user.exception;

import com.hproject.banttang.common.exception.ErrorCodeException;

public class DuplicatedJoiningException extends ErrorCodeException {
    public DuplicatedJoiningException() {
        super(ErrorCode.DUPLICATED_JOINING);
    }
}
