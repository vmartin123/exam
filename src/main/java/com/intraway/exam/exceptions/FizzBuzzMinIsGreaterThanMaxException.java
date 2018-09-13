package com.intraway.exam.exceptions;

public class FizzBuzzMinIsGreaterThanMaxException extends RuntimeException {

    public FizzBuzzMinIsGreaterThanMaxException(String message) {
        super(message);
    }

    public FizzBuzzMinIsGreaterThanMaxException(String message, Throwable cause) {
        super(message, cause);
    }

    public FizzBuzzMinIsGreaterThanMaxException(Throwable cause) {
        super(cause);
    }
}
