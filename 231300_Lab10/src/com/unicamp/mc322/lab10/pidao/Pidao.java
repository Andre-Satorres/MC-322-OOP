package com.unicamp.mc322.lab10.pidao;

import com.unicamp.mc322.lab10.pidao.food.Food;
import com.unicamp.mc322.lab10.pidao.order.OrderType;
import com.unicamp.mc322.lab10.pidao.order.Orders;
import com.unicamp.mc322.lab10.pidao.position.Position;
import com.unicamp.mc322.lab10.pidao.restaurant.Restaurants;
import com.unicamp.mc322.lab10.pidao.user.Users;

public class Pidao {
    private final Users users;
    private final Restaurants restaurants;
    private Orders orders;

    public Pidao() {
        this.users = new Users();
        this.restaurants = new Restaurants();
        this.orders = new Orders();
    }

    public void registerCustomer(String name, String cpf, Position position) {
        this.users.addCustomer(name, cpf, position);
    }

    public void registerDeliveryman(String name, String cpf) {
        this.users.addDeliveryman(name, cpf);
    }

    public void registerRestaurant(String name, String cnpj, Position position) {
        this.restaurants.addRestaurant(name, cnpj, position);
    }

    public void assignDeliverymanToRestaurant(String cpf, String cnpj) {

    }

    public void addFoodToRestaurantMenu(String cnpj, Food food) {

    }

    public void registerDeliveryOrder(String cpf, String cnpj, String... foodIds) {
        this.orders.addOrder(cpf, cnpj, OrderType.DELIVERY, foodIds);
    }

    public void registerWithdrawalOrder(String cpf, String cnpj, String... foodIds) {
        this.orders.addOrder(cpf, cnpj, OrderType.WITHDRAWAL, foodIds);
    }

    public void cancelOrder(String cpf) {
        this.orders.cancelOrder(cpf);
    }

    public void addDiscountToFood(String cnpj, String foodId) {
        this.restaurants.
    }

//    public void rateRestaurant(String cnpj);
//
//    public void rateDeliveryman(String cpf);
//
//    public void rateFood(String foodId);
}
