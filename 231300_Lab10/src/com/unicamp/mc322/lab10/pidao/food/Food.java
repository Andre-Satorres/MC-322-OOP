package com.unicamp.mc322.lab10.pidao.food;

import com.unicamp.mc322.lab10.pidao.cost.Cost;
import com.unicamp.mc322.lab10.pidao.cost.discount.DiscountType;
import com.unicamp.mc322.lab10.pidao.rating.Ratings;

import java.util.StringJoiner;

public class Food {
    public static final int ID_LENGTH = 5;
    private final String name;
    private final String id;
    private final Cost cost;
    private final int preparingTimeSeconds;
    private final Ratings ratings;

    public Food(String name, String id, double originalPrice, int preparingTimeSeconds) {
        this.name = name;
        this.id = id;
        this.cost = new Cost(originalPrice);
        this.preparingTimeSeconds = preparingTimeSeconds;
        this.ratings = new Ratings();
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

    @Override
    public String toString() {
        return new StringJoiner(" - ")
                .add(name)
                .add(id)
                .add("R$" + cost.getRealCost())
                .add(preparingTimeSeconds + "s")
                .toString();
    }
}
