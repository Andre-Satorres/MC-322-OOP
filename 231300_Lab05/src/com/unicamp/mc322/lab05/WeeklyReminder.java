package com.unicamp.mc322.lab05;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WeeklyReminder extends Reminder {
    protected List<DayOfWeek> daysOfWeek;

    public WeeklyReminder(String description, List<DayOfWeek> daysOfWeek) {
        super(description);

        if (daysOfWeek == null || daysOfWeek.isEmpty()) {
            throw new IllegalArgumentException("The week days must be set!");
        }

        this.daysOfWeek = new ArrayList<>();

        for(DayOfWeek dayOfWeek : daysOfWeek) {
            if (!this.daysOfWeek.contains(dayOfWeek)) {
                this.daysOfWeek.add(dayOfWeek);
            }
        }
    }

    @Override
    protected boolean occursIn(LocalDateTime date) {
        return super.occursIn(date) && this.daysOfWeek.contains(date.getDayOfWeek());
    }

    public void addWeekDay(DayOfWeek dayOfWeek) {
        if (dayOfWeek == null) {
            throw new IllegalArgumentException("Day of Week must not be null!");
        }

        if (!this.daysOfWeek.contains(dayOfWeek)) {
            this.daysOfWeek.add(dayOfWeek);
        }
    }

    public void removeWeekDay(DayOfWeek dayOfWeek) {
        if (dayOfWeek == null) {
            throw new IllegalArgumentException("Day of Week must not be null!");
        }

        if (this.daysOfWeek.size() > 1) {
            this.daysOfWeek.remove(dayOfWeek);
        } else {
            throw new IllegalArgumentException("Cannot remove the only day of week set!");
        }
    }
}
