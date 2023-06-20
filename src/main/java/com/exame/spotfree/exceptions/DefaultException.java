package com.exame.spotfree.exceptions;

import com.exame.spotfree.models.errors.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DefaultException extends RuntimeException{

    public DefaultException(String string, String authenticationFailedAtControllerAdvice) {
    }

    public DefaultException(ErrorResponse errorResponse) {

    }

    public DefaultException(String message) {
        super(message);
    }

    public DefaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public DefaultException(Throwable cause) {
        super(cause);
    }

    public DefaultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
