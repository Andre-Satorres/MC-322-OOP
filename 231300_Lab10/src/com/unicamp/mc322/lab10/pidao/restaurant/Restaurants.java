package com.unicamp.mc322.lab10.pidao.restaurant;

import com.unicamp.mc322.lab10.pidao.cost.discount.DiscountType;
import com.unicamp.mc322.lab10.pidao.order.DeliveryOrder;
import com.unicamp.mc322.lab10.pidao.position.Position;
import com.unicamp.mc322.lab10.pidao.rating.Stars;
import com.unicamp.mc322.lab10.pidao.user.Deliveryman;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Restaurants {
    private final List<Restaurant> restaurants;
    private static Restaurants instance;

    private Restaurants() {
        restaurants = new ArrayList<>();
    }

    public static Restaurants getInstance() {
        if (instance == null) {
            instance = new Restaurants();
        }

        return instance;
    }

    public void addRestaurant(String name, String cnpj, Position position) {
        restaurants.add(new Restaurant(name, cnpj, position));
    }

    public void assignDeliverymanToRestaurant(Deliveryman deliveryman, String cnpj) {
        this.getByCnpj(cnpj).addDeliveryman(deliveryman);
    }

    public void addFoodToMenu(String cnpj, String foodName, double foodPrice, int foodPreparingTimeInSeconds) {
        this.getByCnpj(cnpj).addFood(foodName, foodPrice, foodPreparingTimeInSeconds);
    }

    public List<String> getFoodIdsFromMenu(String cnpj) {
        return this.getByCnpj(cnpj).getAllFoodIds();
    }

    public void removeFoodFromMenu(String cnpj, String foodId) {
        this.getByCnpj(cnpj).removeFood(foodId);
    }

    public void addFoodDiscount(String cnpj, String foodId, DiscountType discountType, double discountAmount) {
        Restaurant restaurant = getByCnpj(cnpj);
        restaurant.addDiscountToFood(foodId, discountType, discountAmount);
    }

    public void removeFoodDiscount(String cnpj, String foodId) {
        Restaurant restaurant = getByCnpj(cnpj);
        restaurant.removeDiscountToFood(foodId);
    }

    public String getMenuInfoFromAll() {
        return this.restaurants.stream().map(Restaurant::getMenuInfo).collect(Collectors.joining("\n\n"));
    }

    public double getFoodCost(String cnpj, String foodId) {
        return getByCnpj(cnpj).getFoodCost(foodId);
    }

    public int getFoodPreparingTimeSeconds(String cnpj, String foodId) {
        return getByCnpj(cnpj).getFoodPreparingTimeSeconds(foodId);
    }

    public Position getRestaurantPosition(String cnpj) {
        return getByCnpj(cnpj).getPosition();
    }

    public void assignOrderToDeliveryman(DeliveryOrder order, String cnpj) {
        this.getByCnpj(cnpj).getRandomDeliveryman().addOrderToDeliver(order);
    }

    public Restaurant getByCnpj(String cnpj) {
        return this.restaurants.stream()
                .filter(restaurant -> restaurant.getCnpj().equals(cnpj))
                .findFirst()
                .orElseThrow(() -> new RestaurantException("Restaurant with cnpj " + cnpj + " not found!"));
    }

    public void rateRestaurant(String cnpj, Stars stars, String comment) {
        getByCnpj(cnpj).rate(stars, comment);
    }

    public void rateFood(String cnpj, String foodId, Stars stars, String comment) {
        getByCnpj(cnpj).rateFood(foodId, stars, comment);
    }

    public String getAllRestaurantRatings() {
        return this.restaurants.stream().map(Restaurant::getRatingInfo).collect(Collectors.joining("\n\n"));
    }

    public String getAllFoodRatings() {
        return this.restaurants.stream().map(Restaurant::getMenuRatingInfo).collect(Collectors.joining("\n\n"));
    }
}
