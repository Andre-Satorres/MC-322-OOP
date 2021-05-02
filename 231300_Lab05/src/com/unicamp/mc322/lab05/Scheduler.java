package com.unicamp.mc322.lab05;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Scheduler {
    private final List<CommonReminder> reminders;

    public Scheduler() {
        this.reminders = new ArrayList<>();
    }

    public void addReminder(String description) {
        this.reminders.add(new CommonReminder(description));
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

    public void confirmParticipation(Participant participant, MeetingEvent meetingEvent) {
        if (this.reminders.contains(meetingEvent)) {
            meetingEvent.participants.get(meetingEvent.participants.indexOf(participant)).confirmParticipation();
        }
    }

    public void cancelReminder(CommonReminder reminder) {
        this.reminders.remove(reminder);
    }

    public SchedulerDate getAllFromToday() {
        return getRemindersFromDate(LocalDateTime.now());
    }

    public SchedulerDate getAllFromDate(int day, Month month, int year) {
        return getRemindersFromDate(createLocalDateTime(day, month, year));
    }

    public List<SchedulerDate> getAllBetweenDates(int startDay, Month startMonth, int startYear, int endDay, Month endMonth, int endYear) {
        LocalDateTime startDate = createLocalDateTime(startDay, startMonth, startYear);
        LocalDateTime endDate = createLocalDateTime(endDay, endMonth, endYear);
        List<SchedulerDate> allDays = new ArrayList<>();

        while (startDate.isBefore(endDate)) {
            SchedulerDate schedulerDate = getRemindersFromDate(startDate);

            if (schedulerDate.reminderAmount() > 0) {
                allDays.add(schedulerDate);
            }

            startDate = startDate.plusDays(1);
        }

        return allDays;
    }

    private SchedulerDate getRemindersFromDate(LocalDateTime date) {
        List<CommonReminder> dateReminders = reminders.stream().filter(reminder -> reminder.occursIn(date)).collect(Collectors.toList());
        return new SchedulerDate(date, dateReminders);
    }

    private LocalDateTime createLocalDateTime(int day, Month month, int year) {
        try {
            return LocalDateTime.of(year, month, day, 0, 0);
        } catch (RuntimeException ex) {
            throw new IllegalArgumentException("Invalid day, month and/or year!");
        }
    }
}
