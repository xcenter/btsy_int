package com.btsy.intw.handler;

import com.btsy.intw.exception.BetPlacementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ResponseEntity<Object> handleException(RuntimeException ex) {
        return new ResponseEntity<>("An error occured", HttpStatus.BAD_GATEWAY);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ResponseEntity<Object> handleException(IllegalArgumentException ex) {
        return new ResponseEntity<>("Illegal Argument error occured", HttpStatus.BAD_GATEWAY);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {BetPlacementException.class})
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ResponseEntity<Object> handleException(BetPlacementException ex) {
        return new ResponseEntity<>("Bet could not be placed", HttpStatus.BAD_GATEWAY);
    }
}
