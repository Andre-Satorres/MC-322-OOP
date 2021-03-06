package com.unicamp.mc322.lab09.queue;

import com.unicamp.mc322.lab09.person.Person;

import java.util.StringJoiner;

public class PeopleServiceQueue extends QueueOfPerson {
    private final QueueOfPerson priorityQueue;

    public PeopleServiceQueue() {
        this.priorityQueue = new QueueOfPerson();
    }

    public void enqueue(Person person, boolean isPriority) {
        if (isPriority) {
            priorityQueue.enqueue(person);
        } else {
            queue.addLast(person);
        }
    }

    @Override
    public Person dequeue() {
        if (priorityQueue.isEmpty()) {
            return queue.removeFirst();
        }

        return priorityQueue.dequeue();
    }

    @Override
    public int size() {
        return priorityQueue.size() + queue.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PeopleServiceQueue.class.getSimpleName() + "[", "]")
                .add("priorityQueue=" + priorityQueue)
                .add("queue=" + queue)
                .toString();
    }
}
