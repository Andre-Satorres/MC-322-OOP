package com.unicamp.mc322.lab10.pidao.restaurant;

import com.unicamp.mc322.lab10.pidao.position.Position;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final String name;
    private final String cnpj;
    private final Position position;
    private final List<String> deliverymanCPFs;
    private final Menu menu;

    public Restaurant(String name, String cnpj, Position position) {
        this.name = name;
        this.cnpj = cnpj;
        this.position = position;
        this.deliverymanCPFs = new ArrayList<>();
        this.menu = new Menu();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void addDeliveryman(String cnpj) {
        deliverymanCPFs.add(cnpj);
    }

    public void addFood(String name, double price, int preparingTimeSeconds) {
        this.menu.addFood(name, price, preparingTimeSeconds);
    }

    public void removeFood(String id) {
        this.menu.removeFood(id);
    }

    public void addDiscountToFood(String foodId) {

    }

    @Override
    public String toString() {
        return String.format("Restaurant: %s - %s - %s", name, cnpj, position);
    }
}
