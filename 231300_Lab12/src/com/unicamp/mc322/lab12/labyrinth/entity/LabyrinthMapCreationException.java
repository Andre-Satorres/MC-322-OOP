package com.unicamp.mc322.lab12.labyrinth.entity;

public class LabyrinthMapCreationException extends IllegalArgumentException {
    public LabyrinthMapCreationException() {
    }

    public LabyrinthMapCreationException(String s) {
        super(s);
    }

    public LabyrinthMapCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public LabyrinthMapCreationException(Throwable cause) {
        super(cause);
    }
}
