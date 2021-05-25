package com.unicamp.mc322.lab09.list;

import com.unicamp.mc322.lab09.person.Person;

class Node {
    private final Person person;
    private Node previous, next;

    Node(Node previous, Node next, Person person) {
        this.previous = previous;
        this.next = next;
        this.person = person;
    }

    Node(Person person) {
        this.person = person;
    }

    Person getPerson() {
        return person;
    }

    Node getPrevious() {
        return previous;
    }

    Node getNext() {
        return next;
    }

    void addPrevious(Person person) {
        this.previous = new Node(this.previous, this, person);

        if (this.previous.previous != null) {
            this.previous.previous.next = this.previous;
        }
    }

    void addNext(Person person) {
        this.next = new Node(this, this.next, person);

        if (this.next.next != null) {
            this.next.next.previous = this.next;
        }
    }

    void removeNext() {
        this.next = this.next == null ? null : this.next.next;

        if (this.next != null) {
            this.next.previous = this;
        }
    }

    Node getLastNotNull() {
        Node aux = this;
        while (aux.next != null) {
            aux = aux.next;
        }

        return aux;
    }
}
