package com.hproject.banttang.deal.service.exception;

import com.hproject.banttang.common.exception.ErrorCodeException;

public class DealNotFoundException extends ErrorCodeException {
    public DealNotFoundException() {
        super(ErrorCode.DEAL_NOT_FOUND);
    }
}
