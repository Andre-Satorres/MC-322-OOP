package com.unicamp.mc322.lab05;

import java.time.LocalDateTime;
import java.time.Month;

public class MonthlyReminder extends CommonReminder {
    protected Month month;

    public MonthlyReminder(String description, Month month) {
        super(description);

        if (month == null) {
            throw new IllegalArgumentException("Month cannot be null!");
        }

        this.month = month;
    }

    @Override
    protected boolean occursIn(LocalDateTime date) {
        return super.occursIn(date) && date.getMonth() == month;
    }
}
