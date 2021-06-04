package com.unicamp.mc322.lab10.pidao.user;

import com.unicamp.mc322.lab10.pidao.rating.Ratings;

public class Deliveryman extends User {

    private Ratings ratings;

    public Deliveryman(String name, String cpf) {
        super(name, cpf);
        this.ratings = new Ratings();
    }

    @Override
    public String toString() {
        return String.format("Deliveryman: %s - %s", name, cpf);
    }
}
