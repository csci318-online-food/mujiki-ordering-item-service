package com.csci318.microservice.item.Exceptions.ControllerExceptionHandler;

import org.springframework.http.HttpStatus;

public class DataAccessException extends BaseControllerException {
    public DataAccessException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
