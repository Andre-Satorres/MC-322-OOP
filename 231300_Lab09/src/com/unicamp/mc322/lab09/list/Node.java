package com.unicamp.mc322.lab09.list;

import com.unicamp.mc322.lab09.person.Person;

public class Node {
    private final Person person;
    private Node previous, next;

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
        this.previous = new Node(this.previous, this, person);

        if (this.previous.previous != null) {
            this.previous.previous.next = this.previous;
        }
    }

    public void addNext(Person person) {
        this.next = new Node(this, this.next, person);

        if (this.next.next != null) {
            this.next.next.previous = this.next;
        }
    }

    public void removeNext() {
        this.next = this.next == null ? null : this.next.next;

        if (this.next != null) {
            this.next.previous = this;
        }
    }

    public Node getLastNonNull() {
        Node aux = this;
        while (aux.next != null) {
            aux = aux.next;
        }

        return aux;
    }
}
