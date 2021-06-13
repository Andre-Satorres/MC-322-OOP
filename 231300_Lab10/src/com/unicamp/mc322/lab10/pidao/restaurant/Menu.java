package com.unicamp.mc322.lab10.pidao.restaurant;

import com.unicamp.mc322.lab10.pidao.cost.discount.DiscountType;
import com.unicamp.mc322.lab10.pidao.food.Food;
import com.unicamp.mc322.lab10.pidao.food.FoodException;
import com.unicamp.mc322.lab10.pidao.random.RandomAlphaGenerator;
import com.unicamp.mc322.lab10.pidao.rating.Stars;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Menu {
    private final List<Food> foods;

    public Menu() {
        this.foods = new ArrayList<>();
    }

    public void addFood(String name, double price, int preparingTimeSeconds) {
        this.foods.add(new Food(name, generateFoodId(), price, preparingTimeSeconds));
    }

    public List<String> getAllFoods() {
        return foods.stream()
                .map(Food::getId)
                .collect(Collectors.toList());
    }

    public void removeFood(String id) {
        Food food = getById(id);

        if (food == null) {
            throw new FoodException("Food not found!");
        }

        this.foods.remove(food);
    }

    public void applyDiscount(String foodId, DiscountType discountType, double discountAmount) {
        Food food = getById(foodId);

        if (food == null) {
            throw new FoodException("Food not found!");
        }

        food.applyDiscount(discountType, discountAmount);
    }

    public void removeDiscount(String foodId) {
        Food food = getById(foodId);

        if (food == null) {
            throw new FoodException("Food not found!");
        }

        food.removeDiscount();
    }

    public double getFoodCost(String foodId) {
        return this.getById(foodId).getPrice();
    }

    public int getFoodPreparingTimeSeconds(String foodId) {
        return this.getById(foodId).getPreparingTimeSeconds();
    }

    public void rateFood(String foodId, Stars stars, String comment) {
        getById(foodId).rate(stars, comment);
    }

    @Override
    public String toString() {
        StringJoiner ret = new StringJoiner("\n - ", Menu.class.getSimpleName() + "\n - ", "");
        foods.forEach(food -> ret.add(food.toString()));
        return ret.toString();
    }

    private Food getById(String id) {
        return this.foods.stream()
                .filter(food -> food.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new FoodException("Food with id " + id + " not found!"));
    }

    private String generateFoodId() {
        return new RandomAlphaGenerator(Food.ID_LENGTH).randomString();
    }

    public String getRatingInfoFromAllFoods() {
        return this.foods.stream().map(Food::getRatingInfo).collect(Collectors.joining("\n\n"));
    }
}
