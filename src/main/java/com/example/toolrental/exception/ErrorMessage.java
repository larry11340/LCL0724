package com.example.toolrental.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {
    private String statusName;

    public Map<String, String> getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(Map<String, String> fieldCode) {
        this.fieldCode = fieldCode;
    }

    public ErrorMessage(String statusName, Map<String, String> fieldCode) {
        this.statusName = statusName;
        this.fieldCode = fieldCode;
    }

    private Map<String,String> fieldCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public ErrorMessage(String statusName, String message) {
        this.statusName = statusName;
        this.message = message;
    }

    private String message;

}
