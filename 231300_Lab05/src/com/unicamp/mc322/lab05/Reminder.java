package com.unicamp.mc322.lab05;

import java.time.LocalDateTime;

public class Reminder {
    protected String description;
    protected LocalDateTime createdOn;

    public Reminder(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("The Reminder description cannot be empty!");
        }

        this.description = description;
        this.createdOn = LocalDateTime.now();
    }

    protected boolean occursIn(LocalDateTime date) {
        return date.isAfter(createdOn) || date.isEqual(createdOn);
    }

    @Override
    public String toString() {
        return description;
    }
}
