package com.exame.spotfree.models.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDate;

public class ErrorResponse {

    public ErrorResponse(HttpStatus responseStatus, String cause, LocalDate responseDate) {
        this.responseStatus = responseStatus;
        this.cause = cause;
        this.responseDate = responseDate;
    }

    public ErrorResponse() {
    }

    private HttpStatus responseStatus;

    private String cause;

    private LocalDate responseDate;

    public HttpStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(HttpStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public LocalDate getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(LocalDate responseDate) {
        this.responseDate = responseDate;
    }

    public static class Builder {

        public HttpStatus responseStatus;

        public String cause;

        public LocalDate responseDate;

        public ErrorResponse.Builder withResponseStatus(HttpStatus responseStatus) {
            this.responseStatus = responseStatus;
            return this;
        }

        public ErrorResponse.Builder withCause(String cause){
            this.cause = cause;
            return this;
        }

        public ErrorResponse.Builder withResponseDate(LocalDate responseDate){
            this.responseDate = responseDate;
            return this;
        }

        public ErrorResponse build(){
            return new ErrorResponse(responseStatus, cause, responseDate);
        }
    }
}
