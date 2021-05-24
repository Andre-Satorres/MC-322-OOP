package com.unicamp.mc322.lab09.list;

import com.unicamp.mc322.lab09.person.Person;

import java.util.StringJoiner;

public class Node {
    private Node previous, next;
    private final Person person;

    public Node(Node previous, Node next, Person person) {
        this.previous = previous;
        this.next = next;
        this.person = person;
    }

    public Node(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public Node getPrevious() {
        return previous;
    }

    public Node getNext() {
        return next;
    }

    public void addPrevious(Person person) {
        Node prevPrev = this.previous == null ? null : this.previous.previous;
        this.previous = new Node(prevPrev, this, person);
    }

    public void addNext(Person person) {
        this.next = new Node(this, null, person);
    }

    public void removeNext() {
        this.next = null;
    }

    public Node getLastNonNull() {
        Node aux = this;
        while (aux.next != null) {
            aux = aux.next;
        }

        return aux;
    }
}
