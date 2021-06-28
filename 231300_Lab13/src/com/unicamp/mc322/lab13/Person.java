package com.unicamp.mc322.lab13;

import com.unicamp.mc322.lab13.crazy.cream.IOwner;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person implements IOwner {

    protected final String name;
    protected final String id;
    protected final LocalDate birth;

    public Person(LocalDate birth, String id, String name) {
        this.name = name;
        this.id = id;
        this.birth = birth;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getAge() {
        return Period.between(birth, LocalDate.now()).getYears();
    }
}
