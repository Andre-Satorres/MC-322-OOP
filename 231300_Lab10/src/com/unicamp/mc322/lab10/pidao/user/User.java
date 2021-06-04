package com.unicamp.mc322.lab10.pidao.user;

public class User {
    protected final String name;
    protected final String cpf;

    public User(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", name, cpf);
    }
}
