package com.unicamp.mc322.lab13.crazy.cream;

import com.unicamp.mc322.lab13.Person;

import java.time.LocalDate;

public class BRPerson extends Person {

    public BRPerson(LocalDate birth, String cpf, String name) {
        super(birth, cpf, name);
    }

    @Override
    public String getCompleteInfo() {
        return "Name: " + name + " // CPF: " + id + " // Age: " + getAge();
    }
}
