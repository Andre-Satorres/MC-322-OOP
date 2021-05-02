package com.unicamp.mc322.lab05;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Participant andre = new Participant("Andre", "andre@andre.com", "196345563");
        Participant gabriel = new Participant("Gabriel", "gabriel@gabriel.com", "196423345563");

        Scheduler scheduler = new Scheduler();
        scheduler.addReminder("Fazer a tarefa de POO");
        scheduler.addReminder("Fazer exames", Month.APRIL);
        scheduler.addReminder("Fazer exames", Month.JULY);
        scheduler.addReminder("Fazer exames", Month.SEPTEMBER);

        scheduler.addReminder("Terapia", Arrays.asList(DayOfWeek.TUESDAY, DayOfWeek.THURSDAY));
        scheduler.addReminder("Aniversario", 1, Month.AUGUST, 2021);
        scheduler.addReminder("P1 Calc 3", 6, Month.MAY, 2021, Arrays.asList(andre, gabriel));

        SchedulerDate schedulerDate = scheduler.getAllFromToday();

        if( schedulerDate != null) {
            System.out.println(schedulerDate);
            System.out.println("=======================");
        }
        
        schedulerDate = scheduler.getAllFromDate(6, Month.MAY, 2021);
        scheduler.cancelReminder(schedulerDate.getReminder(0));
        schedulerDate = scheduler.getAllFromDate(6, Month.MAY, 2021);

        if (schedulerDate != null) {
            scheduler.confirmParticipation(andre, (MeetingEvent) schedulerDate.getReminder(1));
            System.out.println(schedulerDate);
            System.out.println("=======================");
        }

        List<SchedulerDate> schedulerDateList = scheduler.getAllBetweenDates(6, Month.APRIL, 2021, 7, Month.SEPTEMBER, 2021);

        for (SchedulerDate schedulerDate1 : schedulerDateList) {
            System.out.println(schedulerDate1 + "\n");
        }
    }
}