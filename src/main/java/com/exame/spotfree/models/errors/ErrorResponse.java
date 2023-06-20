package com.exame.spotfree.models.errors;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponse {

    public ErrorResponse(HttpStatus responseStatusDescription, String cause, LocalDateTime responseDateTime, String calledMethod) {
        this.responseStatusDescription = responseStatusDescription;
        this.cause = cause;
        this.responseDateTime = responseDateTime;
        this.calledMethod = calledMethod;
    }

    public ErrorResponse() {
    }

    private HttpStatus responseStatusDescription;

    private String cause;

    private LocalDateTime responseDateTime;

    private String calledMethod;

    public HttpStatus getResponseStatusDescription() {
        return responseStatusDescription;
    }

    public void setResponseStatusDescription(HttpStatus responseStatusDescription) {
        this.responseStatusDescription = responseStatusDescription;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public LocalDateTime getResponseDateTime() {
        return responseDateTime;
    }

    public void setResponseDateTime(LocalDateTime responseDateTime) {
        this.responseDateTime = responseDateTime;
    }

    public String getCalledMethod() {
        return calledMethod;
    }

    public void setCalledMethod(String calledMethod) {
        this.calledMethod = calledMethod;
    }

    public static class Builder {

        public HttpStatus responseStatusDescription;

        public String cause;

        public LocalDateTime responseDateTime;

        public String calledMethod;

        public ErrorResponse.Builder withResponseStatus(HttpStatus responseStatusDescription) {
            this.responseStatusDescription = responseStatusDescription;
            return this;
        }

        public ErrorResponse.Builder withCause(String cause){
            this.cause = cause;
            return this;
        }

        public ErrorResponse.Builder withResponseDate(LocalDateTime responseDateTime){
            this.responseDateTime = responseDateTime;
            return this;
        }

        public ErrorResponse.Builder withCalledMethod(String calledMethod){
            this.calledMethod = calledMethod;
            return this;
        }

        public ErrorResponse build(){
            return new ErrorResponse(responseStatusDescription, cause, responseDateTime, calledMethod);
        }
    }
}
