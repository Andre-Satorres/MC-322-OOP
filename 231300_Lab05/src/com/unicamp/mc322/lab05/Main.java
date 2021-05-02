package com.unicamp.mc322.lab05;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Participant andre = new Participant("Andre", "andre@andre.com", "196345563");
        Participant tre = new Participant("Tre", "tre@tre.com", "196423345563");

        Scheduler scheduler = new Scheduler();
        scheduler.addReminder("Fazer a tarefa de POO");
        scheduler.addReminder("Fazer exames", Month.APRIL);

        scheduler.addReminder("Terapia", Arrays.asList(DayOfWeek.TUESDAY, DayOfWeek.THURSDAY));
        scheduler.addReminder("Aniversario", 1, Month.AUGUST, 2021);
        scheduler.addReminder("P1 Calc 3", 6, Month.MAY, 2021, Arrays.asList(andre, tre));

        SchedulerDate schedulerDate = scheduler.getAllFromToday();

        if( schedulerDate != null) {
            System.out.println(schedulerDate);
        }
        
        schedulerDate = scheduler.getAllFromDate(1, Month.MAY, 2011);

        if (schedulerDate != null) {
            System.out.println(schedulerDate);
        }

        List<SchedulerDate> schedulerDateList = scheduler.getAllBetweenDates(6, Month.APRIL, 2021, 7, Month.JUNE, 2021);

        for (SchedulerDate schedulerDate1 : schedulerDateList) {
            System.out.println(schedulerDate1 + "\n");
        }
    }
}