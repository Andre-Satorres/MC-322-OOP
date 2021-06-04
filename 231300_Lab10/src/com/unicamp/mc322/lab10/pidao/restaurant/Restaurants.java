package com.unicamp.mc322.lab10.pidao.restaurant;

import com.unicamp.mc322.lab10.pidao.cost.discount.DiscountType;
import com.unicamp.mc322.lab10.pidao.position.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Restaurants {
    private final List<Restaurant> restaurants;

    public Restaurants() {
        restaurants = new ArrayList<>();
    }

    public void addRestaurant(String name, String cnpj, Position position) {
        restaurants.add(new Restaurant(name, cnpj, position));
    }

    public void assignDeliverymanToRestaurant(String cpf, String cnpj) {
        this.getByCnpj(cnpj).addDeliveryman(cpf);
    }

    public void addFoodToMenu(String cnpj, String foodName, double foodPrice, int foodPreparingTimeInSeconds) {
        this.getByCnpj(cnpj).addFood(foodName, foodPrice, foodPreparingTimeInSeconds);
    }

    public void removeFoodFromMenu(String cnpj, String foodId) {
        this.getByCnpj(cnpj).removeFood(foodId);
    }

    public void addOrderDiscount(String cnpj, String foodId, DiscountType discountType, double discountAmount) {
        Restaurant restaurant = getByCnpj(cnpj);

        if (restaurant == null) {
            throw new RestaurantException("Restaurant not found!");
        }

        restaurant.addDiscountToFood(foodId, discountType, discountAmount);
    }

    public String getMenuInfoFromAll() {
        return this.restaurants.stream().map(Restaurant::getMenuInfo).collect(Collectors.joining("\n\n"));
    }

    private Restaurant getByCnpj(String cnpj) {
        return this.restaurants.stream()
                .filter(restaurant -> restaurant.getCnpj().equals(cnpj))
                .findFirst()
                .orElse(null);
    }
}
