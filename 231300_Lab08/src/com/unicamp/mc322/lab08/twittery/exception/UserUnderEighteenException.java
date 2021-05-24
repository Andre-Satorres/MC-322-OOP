package com.unicamp.mc322.lab08.twittery.exception;

public class UserUnderEighteenException extends UserNotAllowedException {
    public UserUnderEighteenException(String message) {
        super(message);
    }
}
