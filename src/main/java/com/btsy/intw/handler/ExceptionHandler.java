package com.btsy.intw.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = { RuntimeException.class })
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ResponseEntity<Object> handleException(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_GATEWAY);
    }
}
