package com.exame.spotfree.exceptions.handlers;

import com.exame.spotfree.exceptions.EmptyListException;
import com.exame.spotfree.models.errors.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ EmptyListException.class })
    @ResponseBody
    public ResponseEntity<Object> handleContentNotFound(EmptyListException ex, WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse.Builder()
                .withResponseDate(LocalDateTime.now())
                .withResponseStatus(HttpStatus.NOT_FOUND)
                .withCause(ex.getMessage())
                .withCalledMethod(request.getDescription(false).substring(4))
                .build();

        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ NoSuchElementException.class })
    @ResponseBody
    public ResponseEntity<Object> handleNoSuchElementException(Exception ex, WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse.Builder()
                .withResponseDate(LocalDateTime.now())
                .withResponseStatus(HttpStatus.NOT_FOUND)
                .withCause("Content not found")
                .withCalledMethod(request.getDescription(false).substring(4))
                .build();

        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
