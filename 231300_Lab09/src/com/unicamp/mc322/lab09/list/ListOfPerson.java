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
            return;
        }

        list.addPrevious(personClone(person));
        this.size++;
    }

    public void addLast(Person person) {
        if (list == null) {
            addOnNullList(person);
            return;
        }

        Node aux = list.getLastNonNull();
        aux.addNext(personClone(person));
        this.size++;
    }

    public void add(Person person, int index) {
        if (list == null) {
            addOnNullList(person);
            return;
        }

        Node aux = this.get(index);
        aux.addPrevious(personClone(person));
        this.size++;
    }

    public Person removeFirst() {
        checkNull();

        Person ret = list.getPerson();
        list = list.getNext();
        this.size--;

        return ret;
    }

    public Person removeLast() {
        checkNull();

        Node aux = list.getLastNonNull();
        Person ret = aux.getPerson();
        aux.getPrevious().removeNext();
        this.size--;

        return ret;
    }

    public Person remove(int index) {
        checkNull();

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
        for (int i=0; i<index; i++) {
            aux = aux.getNext();
        }

        return aux;
    }

    private void checkNull() {
        if (list == null) {
            throw new ListOfPersonException("The list is empty!");
        }
    }
}
