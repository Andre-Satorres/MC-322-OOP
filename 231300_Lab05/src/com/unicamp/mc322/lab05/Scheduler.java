package com.unicamp.mc322.lab05;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private final List<Reminder> reminders;

    public Scheduler() {
        this.reminders = new ArrayList<>();
    }

    public void addReminder(String description) {
        this.reminders.add(new Reminder(description));
    }

    public void addReminder(String description, Month month) {
        this.reminders.add(new MonthlyReminder(description, month));
    }

    public void addReminder(String description, List<DayOfWeek> daysOfWeek) {
        this.reminders.add(new WeeklyReminder(description, daysOfWeek));
    }

    public void addReminder(String description, int day, Month month, int year) {
        this.reminders.add(new Event(description, createLocalDateTime(day, month, year)));
    }

    public void addReminder(String description, int day, Month month, int year, List<Participant> participants) {
        this.reminders.add(new MeetingEvent(description, createLocalDateTime(day, month, year), participants));
    }

    public void cancelReminder(Reminder reminder) {
        this.reminders.remove(reminder);
    }

    public SchedulerDate getAllFromToday() {
        LocalDateTime now = LocalDateTime.now();
        return getAllFromDate(now.getDayOfMonth(), now.getMonth(), now.getYear());
    }

    public List<SchedulerDate> getAllBetweenDates(int startDay, Month startMonth, int startYear, int endDay, Month endMonth, int endYear) {
        LocalDateTime startDate = createLocalDateTime(startYear, startMonth, startDay);
        LocalDateTime endDate = createLocalDateTime(endYear, endMonth, endDay);
        List<SchedulerDate> allDays = new ArrayList<>();

        while (startDate.isBefore(endDate)) {
            SchedulerDate schedulerDate = getAllFromDate(startDay, startMonth, startYear);

            if (schedulerDate.reminderAmount() > 0) {
                allDays.add(schedulerDate);
            }

            startDate = startDate.plusDays(1);
        }

        return allDays;
    }

    public SchedulerDate getAllFromDate(int day, Month month, int year) {
        LocalDateTime date = createLocalDateTime(day, month, year);
        SchedulerDate schedulerDate = new SchedulerDate(date);

        reminders.stream().filter(reminder -> reminder.occursIn(date)).forEach(schedulerDate::addReminder);
        return schedulerDate;
    }

    private LocalDateTime createLocalDateTime(int day, Month month, int year) {
        try {
            return LocalDateTime.of(year, month, day, 0, 0);
        } catch (RuntimeException ex) {
            throw new IllegalArgumentException("Invalid day, month and/or year!");
        }
    }
}
