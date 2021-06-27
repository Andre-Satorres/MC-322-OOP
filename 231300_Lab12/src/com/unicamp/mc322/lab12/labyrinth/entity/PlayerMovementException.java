package com.unicamp.mc322.lab12.labyrinth.entity;

public class PlayerMovementException extends IllegalStateException {
    public PlayerMovementException() {
    }

    public PlayerMovementException(String s) {
        super(s);
    }

    public PlayerMovementException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlayerMovementException(Throwable cause) {
        super(cause);
    }
}
