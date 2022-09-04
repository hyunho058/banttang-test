package com.hproject.banttang.common.service.exception;

public class UnknownErrorException extends RuntimeException {
    public UnknownErrorException() {
    }

    public UnknownErrorException(String message) {
        super(message);
    }
}
