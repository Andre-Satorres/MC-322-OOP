package com.unicamp.mc322.lab10.pidao.restaurant;

import com.unicamp.mc322.lab10.pidao.cost.discount.DiscountType;
import com.unicamp.mc322.lab10.pidao.food.Food;
import com.unicamp.mc322.lab10.pidao.food.FoodException;
import com.unicamp.mc322.lab10.pidao.random.RandomAlphaGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<Food> foods;

    public Menu() {
        this.foods = new ArrayList<>();
    }

    public void addFood(String name, double price, int preparingTimeSeconds) {
        this.foods.add(new Food(name, generateFoodId(), price, preparingTimeSeconds));
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

    private Food getById(String id) {
        return this.foods.stream()
                .filter(food -> food.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private String generateFoodId() {
        return new RandomAlphaGenerator(Food.ID_LENGTH).randomString();
    }
}
