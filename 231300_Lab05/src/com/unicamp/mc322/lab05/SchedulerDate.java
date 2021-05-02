package com.unicamp.mc322.lab05;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class SchedulerDate {
    private final LocalDateTime date;
    private final List<Reminder> reminders;

    public SchedulerDate(LocalDateTime date) {
        this.date = date;
        this.reminders = new ArrayList<>();
    }

    public void addReminder(Reminder reminder) {
        if (!reminders.contains(reminder)) {
            this.reminders.add(reminder);
        }
    }

    public int reminderAmount() {
        return this.reminders.size();
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        for (Reminder reminder : reminders) {
            stringJoiner.add(" - " + reminder);
        }

        return stringJoiner.toString();
    }
}
