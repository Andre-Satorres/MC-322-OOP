package com.unicamp.mc322.lab05.scheduler;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WeeklyReminder extends CommonReminder {
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
}
