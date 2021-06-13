package com.unicamp.mc322.lab10.pidao.user;

import com.unicamp.mc322.lab10.pidao.order.Orders;
import com.unicamp.mc322.lab10.pidao.position.Position;
import com.unicamp.mc322.lab10.pidao.rating.Stars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private static Users instance;
    private final List<Customer> customers;
    private final List<Deliveryman> deliverymen;

    private Users() {
        customers = new ArrayList<>();
        deliverymen = new ArrayList<>();
    }

    public static Users getInstance() {
        if (instance == null) {
            instance = new Users();
        }

        return instance;
    }

    public void addCustomer(String name, String cpf, Position position) {
        customers.add(new Customer(name, cpf, position));
    }

    public void addDeliveryman(String name, String cpf) {
        deliverymen.add(new Deliveryman(name, cpf));
    }

    public Position getCustomerPosition(String cpf) {
        return getCustomer(cpf).getPosition();
    }

    public Customer getCustomer(String cpf) {
        return this.customers.stream()
                .filter(it -> it.cpf.equals(cpf))
                .findFirst()
                .orElseThrow(() -> new UserException("Customer with CPF " + cpf + " not found!"));
    }

    public Deliveryman getDeliveryman(String cpf) {
        return this.deliverymen.stream()
                .filter(it -> it.cpf.equals(cpf))
                .findFirst()
                .orElseThrow(() -> new UserException("Deliveryman with CPF " + cpf + " not found!"));
    }

    public boolean isTheFirstOrder(String cpf) {
        return Orders.getInstance().amountForUser(cpf) == 1;
    }

    public void rateDeliveryman(String cpf, Stars stars, String comment) {
        getDeliveryman(cpf).rate(stars, comment);
    }

    public String getAllDeliverymanRatings() {
        return this.deliverymen.stream().map(Deliveryman::getRatingInfo).collect(Collectors.joining("\n\n"));
    }
}
