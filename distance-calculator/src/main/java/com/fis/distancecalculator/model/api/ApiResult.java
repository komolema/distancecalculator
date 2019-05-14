package com.fis.distancecalculator.model.api;

public class ApiResult {

    public ApiResult(ApiHeader header, ApiBody body) {
        this.body = body;
        this.header = header;
    }

    private ApiBody body;
    private ApiHeader header;

    public ApiHeader getHeader() {
        return header;
    }

    public ApiBody getBody() {
        return body;
    }
}