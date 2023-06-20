package com.exame.spotfree.configs;

import com.exame.spotfree.exceptions.DefaultException;
import com.exame.spotfree.exceptions.RestError;
import com.exame.spotfree.models.errors.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;
import java.time.LocalDate;
import java.util.NoSuchElementException;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ AuthenticationException.class })
    @ResponseBody
    public ResponseEntity<RestError> handleAuthenticationException(Exception ex) {

        RestError re = new RestError(HttpStatus.UNAUTHORIZED.toString(),
                "Authentication failed at controller advice");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(re);
    }

    @ExceptionHandler({ NoSuchElementException.class })
    @ResponseBody
    public ResponseEntity<DefaultException> handleNoSuchElementException(Exception ex) {

        ErrorResponse response = new ErrorResponse.Builder()
                .withResponseStatus(HttpStatus.BAD_REQUEST)
                .withCause(ex.getMessage())
                .withResponseDate(LocalDate.now())
                .build();

        DefaultException exception = new DefaultException(response);

        return ResponseEntity.status(response.getResponseStatus()).body(exception);
    }
}
