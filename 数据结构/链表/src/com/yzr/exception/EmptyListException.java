package com.yzr.exception;

/**
 * @author Palpitate Yzr
 */
public class EmptyListException extends RuntimeException{
    public EmptyListException() {
    }

    public EmptyListException(String message) {
        super(message);
    }
}
