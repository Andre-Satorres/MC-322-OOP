package com.unicamp.mc322.lab10.pidao;

import com.unicamp.mc322.lab10.pidao.cost.discount.DiscountType;
import com.unicamp.mc322.lab10.pidao.order.OrderType;
import com.unicamp.mc322.lab10.pidao.order.Orders;
import com.unicamp.mc322.lab10.pidao.position.Position;
import com.unicamp.mc322.lab10.pidao.rating.Stars;
import com.unicamp.mc322.lab10.pidao.restaurant.Restaurants;
import com.unicamp.mc322.lab10.pidao.user.Users;

import java.util.List;

public class Pidao {
    private final Users users;
    private final Restaurants restaurants;
    private final Orders orders;

    public Pidao() {
        this.users = Users.getInstance();
        this.restaurants = Restaurants.getInstance();
        this.orders = Orders.getInstance();
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
        this.restaurants.assignDeliverymanToRestaurant(this.users.getDeliveryman(cpf), cnpj);
    }

    public void addFoodToRestaurantMenu(String cnpj, String foodName, double foodPrice, int foodPreparingTimeInSeconds) {
        this.restaurants.addFoodToMenu(cnpj, foodName, foodPrice, foodPreparingTimeInSeconds);
    }

    public List<String> getFoodIdsFromRestaurantMenu(String cnpj) {
        return this.restaurants.getFoodIdsFromMenu(cnpj);
    }

    public void removeFoodFromRestaurantMenu(String cnpj, String foodId) {
        this.restaurants.removeFoodFromMenu(cnpj, foodId);
    }

    public int registerDeliveryOrder(String cpf, String cnpj, String... foodIds) {
        return this.registerOrder(cpf, cnpj, OrderType.DELIVERY, foodIds);
    }

    public int registerWithdrawalOrder(String cpf, String cnpj, String... foodIds) {
        return this.registerOrder(cpf, cnpj, OrderType.WITHDRAWAL, foodIds);
    }

    private int registerOrder(String cpf, String cnpj, OrderType orderType, String... foodIds) {
        return this.orders.addOrder(cpf, cnpj, orderType, foodIds);
    }

    public void addFoodToOrder(String cpf, String foodId) {
        this.orders.addFoodToOrder(cpf, foodId);
    }

    public void removeFoodFromOrder(String cpf, String foodId) {
        this.orders.removeFoodFromOrder(cpf, foodId);
    }

    public void processOrder(String cpf) {
        if (users.isTheFirstOrder(cpf)) {
            this.orders.processOrder(cpf, DiscountType.PERCENTAGE, 20);
        } else {
            this.orders.processOrder(cpf);
        }
    }

    public void cancelOrder(String cpf) {
        this.orders.cancelOrder(cpf);
    }

    public void withdrawOrder(String cpf) {
        this.orders.withdrawOrder(cpf);
    }

    public void addDiscountToFood(String cnpj, String foodId, DiscountType discountType, double discountAmount) {
        this.restaurants.addFoodDiscount(cnpj, foodId, discountType, discountAmount);
    }

    public void removeDiscountToFood(String cnpj, String foodId) {
        this.restaurants.removeFoodDiscount(cnpj, foodId);
    }

    public void rateRestaurantOfOrder(int id, Stars stars) {
        this.orders.rateRestaurantOfOrder(id, stars, null);
    }

    public void rateRestaurantOfOrder(int id, Stars stars, String comment) {
        this.orders.rateRestaurantOfOrder(id, stars, comment);
    }

    public void rateDeliverymanOfOrder(int id, Stars stars) {
        this.orders.rateDeliverymanOfOrder(id, stars, null);
    }

    public void rateDeliverymanOfOrder(int id, Stars stars, String comment) {
        this.orders.rateDeliverymanOfOrder(id, stars, comment);
    }

    public void rateFoodOfOrder(int id, String foodId, Stars stars) {
        this.orders.rateFoodOfOrder(id, foodId, stars, null);
    }

    public void rateFoodOfOrder(int id, String foodId, Stars stars, String comment) {
        this.orders.rateFoodOfOrder(id, foodId, stars, comment);
    }

    public String getAllMenus() {
        return restaurants.getMenuInfoFromAll();
    }

    public String getAllOrders() {
        return orders.getAllOrdersInfo();
    }

    public String getAllRestaurantRatings() {
        return this.restaurants.getAllRestaurantRatings();
    }

    public String getAllDeliverymanRatings() {
        return this.users.getAllDeliverymanRatings();
    }

    public String getAllFoodRatings() {
        return this.restaurants.getAllFoodRatings();
    }
}
