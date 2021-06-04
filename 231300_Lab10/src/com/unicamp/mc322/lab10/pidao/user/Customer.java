package com.unicamp.mc322.lab10.pidao.user;

import com.unicamp.mc322.lab10.pidao.position.Position;

public class Customer extends User {

    private final Position position;

    public Customer(String name, String cpf, Position position) {
        super(name, cpf);
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("Customer: %s - %s - %s", name, cpf, position);
    }
}
