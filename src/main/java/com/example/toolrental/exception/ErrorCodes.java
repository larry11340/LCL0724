package com.example.toolrental.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCodes {
    CODE_NOT_FOUND(HttpStatus.NOT_FOUND, "The code %s not found in db"),
    UNEXPECTED_ERROR_DATABASE(HttpStatus.INTERNAL_SERVER_ERROR, "Something wrong with database"),
    UNEXPECTED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Something wrong service");
    private HttpStatus httpStatus;

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    private String message;

    ErrorCodes(HttpStatus httpStatus, String s) {
        this.httpStatus = httpStatus;
        this.message = s;
    }
    public String getName(){
        return this.name();
    }
}
