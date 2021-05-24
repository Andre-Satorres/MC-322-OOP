package com.unicamp.mc322.lab08.twittery.exception;

public class NickAlreadyInUseException extends UserNotAllowedException {
    public NickAlreadyInUseException(String message) {
        super(message);
    }
}
