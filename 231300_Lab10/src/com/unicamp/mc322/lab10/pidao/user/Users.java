package com.unicamp.mc322.lab10.pidao.user;

import com.unicamp.mc322.lab10.pidao.position.Position;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private final List<Customer> customers;
    private final List<Deliveryman> deliverymen;

    public Users() {
        customers = new ArrayList<>();
        deliverymen = new ArrayList<>();
    }

    public void addCustomer(String name, String cpf, Position position) {
        customers.add(new Customer(name, cpf, position));
    }

    public void addDeliveryman(String name, String cpf) {
        deliverymen.add(new Deliveryman(name, cpf));
    }
}
