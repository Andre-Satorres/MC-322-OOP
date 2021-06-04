package com.unicamp.mc322.lab10.pidao.rating;

import java.util.ArrayList;
import java.util.List;

public class Ratings {
    private final List<Rating> ratings;

    public Ratings() {
        this.ratings = new ArrayList<>();
    }

    public void addRating(int stars, String comment) {
        this.ratings.add(new Rating(stars, comment));
    }

    public double getAVG() {
        return ratings.stream().mapToDouble(Rating::getStars).average().orElse(0);
    }
}
