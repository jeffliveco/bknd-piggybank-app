package com.jeffersonortiz.piggybank.exception;

public class RestServiceException extends RuntimeException {

    public RestServiceException(String message){
        super(message);
    }
}
