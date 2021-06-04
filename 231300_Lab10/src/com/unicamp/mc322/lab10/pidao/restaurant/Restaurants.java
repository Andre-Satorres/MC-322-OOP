package com.unicamp.mc322.lab10.pidao.restaurant;

import com.unicamp.mc322.lab10.pidao.position.Position;

import java.util.ArrayList;
import java.util.List;

public class Restaurants {
    private final List<Restaurant> restaurants;

    public Restaurants() {
        restaurants = new ArrayList<>();
    }

    public void addRestaurant(String name, String cnpj, Position position) {
        restaurants.add(new Restaurant(name, cnpj, position));
    }

    public void addOrderDiscount(String cnpj) {
        Restaurant restaurant = getByCnpj(cnpj);

        if (restaurant == null) {
            throw new RestaurantException("Restaurant not found!");
        }

        restaurant
    }

    private Restaurant getByCnpj(String cnpj) {
        return this.restaurants.stream()
                .filter(restaurant -> restaurant.getCnpj().equals(cnpj))
                .findFirst()
                .orElse(null);
    }
}
