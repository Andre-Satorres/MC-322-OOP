package com.unicamp.mc322.lab13;

import com.unicamp.mc322.lab13.crazy.cream.*;

import java.time.LocalDate;
import java.time.Month;

public class CrazyCreamApp {
    public static void main(String[] args) {
        //ICrazyDS crazyDS = new CrazyDS(new PriorityScore());
        ICrazyDS crazyDS = new CrazyDS(new MyCrazyScore());
        IOrder order1 = new InternetOrder(new BRPerson(LocalDate.of( 1985 , Month.JANUARY , 1 ), "CPF1", "name1"));
        IOrder order2 = new InternetOrder(new BRPerson(LocalDate.of( 1986 , Month.JANUARY , 2 ), "CPF2", "name2"));
        IOrder order3 = new InternetOrder(new BRPerson(LocalDate.of( 1987 , Month.JANUARY , 3 ), "CPF3", "name3"));

        crazyDS.addElement(order1);
        crazyDS.addElement(order2);
        crazyDS.addElement(order3);
        System.out.println("---- A: Elements ----");
        crazyDS.printElements();

        System.out.println("---- B: Getting and removing the element with highest priority ----");
        IOrder p1;
        try {
            p1 = crazyDS.peekElement();
            System.out.println("-selected element");
            p1.printOwner();
            crazyDS.removeElement(p1);
            System.out.println("-elements");
            crazyDS.printElements();
        } catch (CrazyDSException e) {
            e.printStackTrace();
        }

        System.out.println("---- C: Adding an old person ----");
        IOrder order4 = new PhysicalOrder(new BRPerson(LocalDate.of( 1880 , Month.JUNE , 1 ), "CPF", "name3"));
        crazyDS.addElement(order4);
        crazyDS.printElements();
        System.out.println("-selected element");
        IOrder p2 = crazyDS.peekElement();
        p2.printOwnerFullData();

        System.out.println("---- D: Checking an exception ----");
        try {
            IOrder p3 = crazyDS.getElementAt(1000);
            p3.printOwnerFullData();
        } catch (CrazyDSException e) {
            //e.printStackTrace();
            System.out.println("-ok: Show error in logs");
        }
    }
}
