package com.unicamp.mc322.lab10.pidao.restaurant;

import com.unicamp.mc322.lab10.pidao.cost.discount.DiscountType;
import com.unicamp.mc322.lab10.pidao.position.Position;
import com.unicamp.mc322.lab10.pidao.rating.Ratings;
import com.unicamp.mc322.lab10.pidao.rating.Stars;
import com.unicamp.mc322.lab10.pidao.user.Deliveryman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Restaurant {
    private final String name;
    private final String cnpj;
    private final Position position;
    private final List<Deliveryman> deliverymen;
    private final Menu menu;
    private final Ratings ratings;

    public Restaurant(String name, String cnpj, Position position) {
        this.name = name;
        this.cnpj = cnpj;
        this.position = position;
        this.deliverymen = new ArrayList<>();
        this.menu = new Menu();
        this.ratings = new Ratings();
    }

    public String getCnpj() {
        return cnpj;
    }

    public Position getPosition() {
        return position;
    }

    public void addDeliveryman(Deliveryman deliveryman) {
        deliverymen.add(deliveryman);
    }

    public void addFood(String name, double price, int preparingTimeSeconds) {
        this.menu.addFood(name, price, preparingTimeSeconds);
    }

    public List<String> getAllFoodIds() {
        return this.menu.getAllFoods();
    }

    public void removeFood(String id) {
        this.menu.removeFood(id);
    }

    public void addDiscountToFood(String foodId, DiscountType discountType, double discountAmount) {
        this.menu.applyDiscount(foodId, discountType, discountAmount);
    }

    public void removeDiscountToFood(String foodId) {
        this.menu.removeDiscount(foodId);
    }

    public Deliveryman getRandomDeliveryman() {
        return this.deliverymen.stream()
                .skip(new Random().nextInt(deliverymen.size()))
                .findFirst()
                .orElseThrow(() -> new RestaurantException("There are no deliverymen to be retrieved!"));
    }

    public double getFoodCost(String foodId) {
        return this.menu.getFoodCost(foodId);
    }

    public int getFoodPreparingTimeSeconds(String foodId) {
        return this.menu.getFoodPreparingTimeSeconds(foodId);
    }

    public void rate(Stars stars, String comment) {
        this.ratings.addRating(stars.ordinal(), comment);
    }

    public void rateFood(String foodId, Stars stars, String comment) {
        this.menu.rateFood(foodId, stars, comment);
    }

    public String getMenuInfo() {
        return "Restaurant: " + name + "\n" + menu;
    }

    public String getRatingInfo() {
        return name + ":\n" + ratings.getInfo();
    }

    public String getMenuRatingInfo() {
        return name + ":\n----\n" + menu.getRatingInfoFromAllFoods() + "\n----";
    }

    @Override
    public String toString() {
        return String.format("Restaurant: %s - %s - %s", name, cnpj, position);
    }
}
