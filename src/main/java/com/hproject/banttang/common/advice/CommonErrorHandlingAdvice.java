package com.hproject.banttang.common.advice;

import com.hproject.banttang.common.controller.response.ErrorResponse;
import com.hproject.banttang.common.exception.ErrorCodeException;
import com.hproject.banttang.deal.service.exception.DealNotFoundException;
import com.hproject.banttang.deal.service.exception.JsonConvertException;
import com.hproject.banttang.user.exception.AuthenticationFailException;
import com.hproject.banttang.user.exception.DuplicatedJoiningException;
import com.hproject.banttang.user.exception.ForbiddenUserException;
import com.hproject.banttang.user.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonErrorHandlingAdvice {
    private final Logger logger = LoggerFactory.getLogger(CommonErrorHandlingAdvice.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse unknownError(RuntimeException e) {
        logger.error("unknown Error", e);

        return new ErrorResponse("internal-server-error", e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse invalidRequest(BindException e) {
        logger.error("Request Data Invalid", e);

        return new ErrorResponse("invalid-request", e.getMessage());
    }

    @ExceptionHandler({
            JsonConvertException.class,
            DuplicatedJoiningException.class,
            UserNotFoundException.class,
            DealNotFoundException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequest(ErrorCodeException e) {
        return new ErrorResponse(e);
    }

    @ExceptionHandler({
            AuthenticationFailException.class,
            ForbiddenUserException.class
    })
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse unauthorized(RuntimeException e) {
        logger.error("third party authentication failed");

        return new ErrorResponse("unauthorized", e.getMessage());
    }
}
