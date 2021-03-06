package com.unicamp.mc322.lab05.scheduler;

import java.time.LocalDateTime;

public class Event extends CommonReminder {
    protected LocalDateTime date;

    public Event(String description, LocalDateTime date) {
        super(description);

        try {
            this.date = LocalDateTime.of(date.toLocalDate(), date.toLocalTime());
        } catch (NullPointerException ex) {
            throw new IllegalArgumentException("Month must not be null!");
        }
    }

    @Override
    protected boolean occursIn(LocalDateTime date) {
        return super.occursIn(date) && this.date.isEqual(date);
    }
}
