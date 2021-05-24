package com.unicamp.mc322.lab09.queue;

import com.unicamp.mc322.lab09.list.ListOfPerson;
import com.unicamp.mc322.lab09.person.Person;

import java.util.StringJoiner;

public class QueueOfPerson {
    protected final ListOfPerson queue;

    public QueueOfPerson() {
        this.queue = new ListOfPerson();
    }

    public void enqueue(Person person) {
        queue.addLast(person);
    }

    public Person dequeue() {
        return queue.removeFirst();
    }

    public int size() {
        return queue.size();
    }

    public void clean() {
        queue.clean();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QueueOfPerson.class.getSimpleName() + "[", "]")
                .add("listOfPerson=" + queue)
                .toString();
    }
}
