package com.unicamp.mc322.lab08.twittery.exception;

public class UserNotAllowedException extends RuntimeException {
    public UserNotAllowedException(String message) {
        super(message);
    }
}
