package com.unicamp.mc322.lab10.pidao.user;

public class Deliveryman extends User {

    public Deliveryman(String name, String cpf) {
        super(name, cpf);
    }

    @Override
    public String toString() {
        return String.format("Deliveryman: %s - %s", name, cpf);
    }
}
