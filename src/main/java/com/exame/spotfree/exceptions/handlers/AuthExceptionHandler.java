package com.exame.spotfree.exceptions.handlers;

import com.exame.spotfree.models.errors.ErrorResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class AuthExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ AuthenticationException.class })
    @ResponseBody
    public ResponseEntity<Object> handleAuthenticationException(Exception ex, WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse.Builder()
                .withResponseDate(LocalDateTime.now())
                .withResponseStatus(HttpStatus.UNAUTHORIZED)
                .withCause("Error on Authentication")
                .withCalledMethod(request.getDescription(false).substring(4))
                .build();

        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler({ ExpiredJwtException.class })
    @ResponseBody
    public ResponseEntity<Object> handleExpiredToken(ExpiredJwtException ex, WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse.Builder()
                .withResponseDate(LocalDateTime.now())
                .withResponseStatus(HttpStatus.UNAUTHORIZED)
                .withCause("Expired Token")
                .withCalledMethod(request.getDescription(false).substring(4))
                .build();

        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler({ UsernameNotFoundException.class })
    protected ResponseEntity<Object> handleUserNotFound(AuthenticationException ex, WebRequest request) {

        String calledMethod = request.getDescription(false).substring(3);

        ErrorResponse errorResponse = new ErrorResponse.Builder()
                .withResponseDate(LocalDateTime.now())
                .withResponseStatus(HttpStatus.NOT_FOUND)
                .withCause(ex.getMessage())
                .withCalledMethod(calledMethod)
                .build();


        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
