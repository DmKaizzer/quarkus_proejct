package com.bivgroup.exception;

public class ConstraintViolationException extends Exception {
    public ConstraintViolationException(String errorMessage) {
        super(errorMessage);
    }
}
