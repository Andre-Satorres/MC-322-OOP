package com.unicamp.mc322.lab09;

import com.unicamp.mc322.lab09.list.ListOfPerson;
import com.unicamp.mc322.lab09.person.Person;
import com.unicamp.mc322.lab09.queue.PeopleServiceQueue;
import com.unicamp.mc322.lab09.queue.QueueOfPerson;

public class App {
    private static final Person[] people = {
            new Person("Andre Satorres", "51377028892", 18),
            new Person("Gabriel Jose", "12345678900", 21),
            new Person("Flavia Almeida", "98765432134", 56),
            new Person("Dona Roberta", "65386542398", 89)
    };
    private final PeopleServiceQueue peopleServiceQueue;

    public App() {
        this.peopleServiceQueue = new PeopleServiceQueue();
    }

    public void start() {
        useListOfPerson();
        useQueueOfPerson();
        usePeopleServiceQueue();
    }

    private void ptl(Object s) {
        System.out.println(s);
    }

    private void useListOfPerson() {
        ptl("============ List of Person ==============");
        listOfPersonAdd();
        listOfPersonRemove();
    }

    private void listOfPersonAdd() {
        ListOfPerson listOfPerson = new ListOfPerson();
        listOfPerson.addFirst(people[0]);
        listOfPerson.addFirst(people[0]);
        listOfPerson.addLast(people[1]);
        listOfPerson.addLast(people[1]);
        listOfPerson.add(people[2], 1);
        listOfPerson.add(people[3], 0);
        ptl(listOfPerson);

        listOfPerson.clean();
        ptl(listOfPerson);

        listOfPerson.add(people[0], 0);
        listOfPerson.add(people[1], listOfPerson.size());
        listOfPerson.add(people[2], 1);
        listOfPerson.addFirst(people[3]);
        ptl(listOfPerson);

        listOfPerson.clean();
        ptl(listOfPerson);
    }

    private void listOfPersonRemove() {
        ListOfPerson listOfPerson = new ListOfPerson();
        listOfPerson.addFirst(people[0]);
        listOfPerson.addFirst(people[1]);
        listOfPerson.addFirst(people[2]);
        listOfPerson.addFirst(people[3]);

        ptl(listOfPerson);

        ptl("Removing: " + listOfPerson.remove(2));
        ptl("Removing: " + listOfPerson.remove(0));
        ptl("Removing: " + listOfPerson.removeFirst());
        ptl("Removing: " + listOfPerson.removeLast());
    }

    private void useQueueOfPerson() {
        ptl("============ Queue of Person ==============");
        QueueOfPerson queueOfPerson = new QueueOfPerson();
        queueOfPerson.enqueue(people[0]);
        queueOfPerson.enqueue(people[1]);
        queueOfPerson.enqueue(people[2]);
        queueOfPerson.enqueue(people[3]);

        ptl(queueOfPerson);
        queueOfPerson.clean();
        ptl(queueOfPerson);

        queueOfPerson.enqueue(people[3]);
        queueOfPerson.enqueue(people[1]);
        queueOfPerson.enqueue(people[2]);
        queueOfPerson.enqueue(people[0]);
        ptl(queueOfPerson);

        queueOfPerson.dequeue();
        queueOfPerson.dequeue();
        ptl(queueOfPerson);
        queueOfPerson.dequeue();
        queueOfPerson.dequeue();
        ptl(queueOfPerson);
    }

    private void usePeopleServiceQueue() {
        ptl("============ People Service Queue ==============");
        for (Person person : people) {
            boolean priority = Math.round(Math.random()) != 0;
            peopleServiceQueue.enqueue(person, priority);
            ptl("Enqueued " + person + ". Priority=" + priority);
        }

        ptl(peopleServiceQueue);

        ptl("Size: " + peopleServiceQueue.size());

        while (!peopleServiceQueue.isEmpty()) {
            Person dequeue = peopleServiceQueue.dequeue();
            ptl("Dequeue: " + dequeue);
        }
    }
}
