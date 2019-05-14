package com.fis.distancecalculator.model.api;

public class ApiHeader {
    private String code;
    private String message;

    public ApiHeader(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}