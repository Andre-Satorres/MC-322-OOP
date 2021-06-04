package com.unicamp.mc322.lab10.pidao.food;

import com.unicamp.mc322.lab10.pidao.cost.Cost;
import com.unicamp.mc322.lab10.pidao.cost.discount.DiscountType;

public class Food {
    private String name;
    private String id;
    private Cost cost;
    private final int preparingTimeSeconds;
    public static final int ID_LENGTH = 5;

    public Food(String name, String id, double originalPrice, int preparingTimeSeconds) {
        this.name = name;
        this.id = id;
        this.cost = new Cost(originalPrice);
        this.preparingTimeSeconds = preparingTimeSeconds;
    }

    public String getId() {
        return id;
    }

    public void applyDiscount(DiscountType discountType, double discountAmount) {
        this.cost.createDiscount(discountType, discountAmount);
    }

    public int getPreparingTimeSeconds() {
        return preparingTimeSeconds;
    }
}
