package com.btsy.intw.exception;

public class BetPlacementException extends RuntimeException{
    public BetPlacementException(String message) {
        super(message);
    }

    public BetPlacementException(String message, Throwable cause) {
        super(message, cause);
    }

    public BetPlacementException(Throwable cause) {
        super(cause);
    }
}
