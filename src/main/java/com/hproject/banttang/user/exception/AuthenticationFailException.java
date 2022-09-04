package com.hproject.banttang.user.exception;

public class AuthenticationFailException extends RuntimeException {
    public AuthenticationFailException() {
    }

    public AuthenticationFailException(String message) {
        super(message);
    }
}
