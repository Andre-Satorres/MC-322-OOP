package com.unicamp.mc322.lab08.twittery.exception;

public class EmailAlreadyInUseException extends UserNotAllowedException {
    public EmailAlreadyInUseException(String message) {
        super(message);
    }
}
