package com.unicamp.mc322.lab10.pidao;

import com.unicamp.mc322.lab10.pidao.cost.discount.DiscountType;
import com.unicamp.mc322.lab10.pidao.order.OrderType;
import com.unicamp.mc322.lab10.pidao.order.Orders;
import com.unicamp.mc322.lab10.pidao.position.Position;
import com.unicamp.mc322.lab10.pidao.restaurant.Restaurants;
import com.unicamp.mc322.lab10.pidao.user.Users;

public class Pidao {
    private final Users users;
    private final Restaurants restaurants;
    private final Orders orders;

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
        this.restaurants.assignDeliverymanToRestaurant(cpf, cnpj);
    }

    public void addFoodToRestaurantMenu(String cnpj, String foodName, double foodPrice, int foodPreparingTimeInSeconds) {
        this.restaurants.addFoodToMenu(cnpj, foodName, foodPrice, foodPreparingTimeInSeconds);
    }

    public void removeFoodFromRestaurantMenu(String cnpj, String foodId) {
        this.restaurants.removeFoodFromMenu(cnpj, foodId);
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

    public void addDiscountToFood(String cnpj, String foodId, DiscountType discountType, double discountAmount) {
        this.restaurants.addOrderDiscount(cnpj, foodId, discountType, discountAmount);
    }

    public String getAllMenu() {
        return restaurants.getMenuInfoFromAll();
    }

//    public void rateRestaurant(String cnpj);
//
//    public void rateDeliveryman(String cpf);
//
//    public void rateFood(String foodId);
}
