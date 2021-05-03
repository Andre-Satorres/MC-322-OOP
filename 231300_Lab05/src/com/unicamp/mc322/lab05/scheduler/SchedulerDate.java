package com.unicamp.mc322.lab05.scheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.StringJoiner;

public class SchedulerDate {
    private final LocalDateTime date;
    private final List<CommonReminder> reminders;

    public SchedulerDate(LocalDateTime date, List<CommonReminder> reminders) {
        this.date = date;
        this.reminders = reminders;
    }

    public CommonReminder getReminder(int index) {
        return this.reminders.get(index);
    }

    public int reminderAmount() {
        return this.reminders.size();
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        for (CommonReminder reminder : reminders) {
            stringJoiner.add(" - " + reminder);
        }

        return stringJoiner.toString();
    }
}
