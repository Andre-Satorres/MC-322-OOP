package com.unicamp.mc322.lab09.person;

import java.util.StringJoiner;

public class Person {
    private String name;
    private String cpf;
    private int age;

    public Person(String name, String cpf, int age) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "(", ")")
                .add("name='" + name + "'")
                .add("cpf='" + cpf + "'")
                .add("age=" + age)
                .toString();
    }

    public Person(Person model) {
        if (model == null) {
            return;
        }

        this.age = model.age;
        this.cpf = model.cpf;
        this.name = model.name;
    }
}
