package com.sapient.exercise.exception;

import org.springframework.http.HttpStatus;

public class EntertainmentServiceException extends RuntimeException {
    private HttpStatus statusCode;
    private String errorMessage;

    public EntertainmentServiceException(HttpStatus statusCode, String errorMessage){
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }
    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
