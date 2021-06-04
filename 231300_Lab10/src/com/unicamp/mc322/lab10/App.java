package com.unicamp.mc322.lab10;

import com.unicamp.mc322.lab10.pidao.Pidao;
import com.unicamp.mc322.lab10.pidao.position.Position;

public class App {

    private final Pidao pidao;

    public App() {
        pidao = new Pidao();
    }

    public void start() {
        registerCustomers();
        registerDeliverymen();
        registerRestaurants();

        pidao.addFoodToRestaurantMenu("12345", "Comida Boa", 20, 5);
        pidao.addFoodToRestaurantMenu("12345", "Comida Rapida", 5, 1);
        pidao.addFoodToRestaurantMenu("567984", "Cervejinha", 6, 0);
        pidao.addFoodToRestaurantMenu("5435634", "Brigadeiro", 3, 2);

        pidao.assignDeliverymanToRestaurant("1244345789-00", "12345");

        System.out.println(pidao.getAllMenu());
    }

    private void registerCustomers() {
        pidao.registerCustomer("Andre", "123456789-00", Position.of(0, 0));
        pidao.registerCustomer("Jonas", "124456789-00", Position.of(10, -6));
        pidao.registerCustomer("Desiree", "423456789-00", Position.of(-5, -2));
    }

    private void registerDeliverymen() {
        pidao.registerDeliveryman("Andre", "123456789-00");
        pidao.registerDeliveryman("Camila", "1244345789-00");
        pidao.registerDeliveryman("Breno", "423236789-00");
    }

    private void registerRestaurants() {
        pidao.registerRestaurant("Restaurante Legal", "12345", Position.of(5, 5));
        pidao.registerRestaurant("Bar do Carioca", "567984", Position.of(-3, -10));
        pidao.registerRestaurant("Casa dos Doces", "5435634", Position.of(8, -6));
    }
}
