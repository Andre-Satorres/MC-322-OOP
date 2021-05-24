package com.unicamp.mc322.lab09;

import com.unicamp.mc322.lab09.person.Person;
import com.unicamp.mc322.lab09.queue.PeopleServiceQueue;

public class App {
    private final PeopleServiceQueue peopleServiceQueue;

    public App() {
        this.peopleServiceQueue = new PeopleServiceQueue();
    }

    public static Person[] people = {
        new Person("Andre Satorres", "51377028892", 18),
        new Person("Gabriel Jose", "12345678900", 21),
        new Person("Flavia Almeida", "98765432134", 56),
        new Person("Dona Roberta", "65386542398", 89)
    };

    public void start() {
        for (Person person : people) {
            boolean priority = Math.round(Math.random()) != 0;
            peopleServiceQueue.enqueue(person, priority);
            ptl("Enqueued " + person + ". priority=" + priority);
        }

        ptl(peopleServiceQueue);

        ptl("Size: " + peopleServiceQueue.size());

        while (!peopleServiceQueue.isEmpty()) {
            Person dequeue = peopleServiceQueue.dequeue();
            ptl("Dequeue: " + dequeue);
        }
    }

    public void ptl(Object s) {
        System.out.println(s);
    }
}
