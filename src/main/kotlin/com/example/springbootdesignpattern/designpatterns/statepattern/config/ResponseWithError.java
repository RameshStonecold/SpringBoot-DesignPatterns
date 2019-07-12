package com.example.springbootdesignpattern.designpatterns.statepattern.config;

import org.springframework.http.HttpStatus;

public class ResponseWithError<T> {
    private T response;
    private boolean error;
    private String errorMsg;

    public ResponseWithError() {
    }

    private ResponseWithError(String errorMsg) {
        this.error = true;
        this.errorMsg = errorMsg;
    }

    private HttpStatus httpStatus;

    private ResponseWithError(T response) {
        this.response = response;
        this.error=false;
    }
    public static <K> ResponseWithError<K> ofError(String errorMsg){
        return new ResponseWithError<>(errorMsg);
    }
    public static <K> ResponseWithError<K> of(K response){
        return new ResponseWithError<>(response);
    }

    public T getResponse() {
        return response;
    }

    public boolean isError() {
        return error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
