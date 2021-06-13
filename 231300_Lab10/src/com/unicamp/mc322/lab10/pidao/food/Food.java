package com.unicamp.mc322.lab10.pidao.food;

import com.unicamp.mc322.lab10.pidao.cost.Cost;
import com.unicamp.mc322.lab10.pidao.cost.discount.DiscountType;
import com.unicamp.mc322.lab10.pidao.rating.Ratings;
import com.unicamp.mc322.lab10.pidao.rating.Stars;

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

    public void removeDiscount() {
        this.cost.removeDiscount();
    }

    public double getPrice() {
        return this.cost.getRealCost();
    }

    public int getPreparingTimeSeconds() {
        return preparingTimeSeconds;
    }

    public void rate(Stars stars, String comment) {
        this.ratings.addRating(stars.ordinal(), comment);
    }

    @Override
    public String toString() {
        return new StringJoiner("\n")
                .add(name)
                .add("    - Id: " + id)
                .add("    - Cost: " + cost)
                .add("    - Preparing time: " + preparingTimeSeconds + "s")
                .toString();
    }

    public String getRatingInfo() {
        return name + ":\n" + ratings.getInfo();
    }
}
