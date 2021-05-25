package com.unicamp.mc322.lab09.list;

import com.unicamp.mc322.lab09.person.Person;

import java.util.StringJoiner;

public class ListOfPerson {

    private Node list;
    private int size;

    public ListOfPerson() {
        this.list = null;
        this.size = 0;
    }

    public void addFirst(Person person) {
        if (list == null) {
            addOnNullList(person);
        } else {
            list.addPrevious(personClone(person));
            list = list.getPrevious();
        }

        this.size++;
    }

    public void addLast(Person person) {
        if (list == null) {
            addOnNullList(person);
        } else {
            Node aux = list.getLastNotNull();
            aux.addNext(personClone(person));
        }

        this.size++;
    }

    public void add(Person person, int index) {
        if (index < 0) {
            throw new ListOfPersonException("Index invalid!");
        }

        if (index > this.size) {
            throw new ListOfPersonException("Index greater then list size!");
        }

        if (index == 0) {
            addFirst(person);
        } else if (index == this.size) {
            addLast(person);
        } else {
            Node aux = this.get(index - 1);
            aux.addNext(personClone(person));
        }

        this.size++;
    }

    public Person removeFirst() {
        if (this.size == 0) {
            throw new ListOfPersonException("The list is empty!");
        }

        Person ret = list.getPerson();
        list = list.getNext();
        this.size--;
        return ret;
    }

    public Person removeLast() {
        if (this.size == 0) {
            throw new ListOfPersonException("The list is empty!");
        }

        Person ret;
        if (this.size == 1) {
            ret = removeUnique();
        } else {
            Node aux = list.getLastNotNull();
            ret = aux.getPerson();
            aux.getPrevious().removeNext();
        }

        this.size--;
        return ret;
    }

    public Person remove(int index) {
        if (this.size == 0) {
            throw new ListOfPersonException("The list is empty!");
        }

        if (index < 0) {
            throw new ListOfPersonException("Index invalid!");
        }

        if (index > this.size) {
            throw new ListOfPersonException("Index greater then list size!");
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == this.size - 1) {
            return removeLast();
        }

        Node aux = this.get(index);
        Person ret = aux.getPerson();
        aux.getPrevious().removeNext();

        this.size--;
        return ret;
    }

    public int size() {
        return this.size;
    }

    public void clean() {
        this.list = null;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (Node aux = list; aux != null; aux = aux.getNext()) {
            sj.add(aux.getPerson().toString());
        }

        return sj.toString();
    }

    private Person personClone(Person person) {
        return new Person(person);
    }

    private void addOnNullList(Person person) {
        list = new Node(personClone(person));
    }

    private Node get(int index) {
        Node aux = list;
        for (int i = 0; i < index; i++) {
            aux = aux.getNext();
        }

        return aux;
    }

    private Person removeUnique() {
        Person ret = this.list.getPerson();
        this.list = null;
        return ret;
    }
}
