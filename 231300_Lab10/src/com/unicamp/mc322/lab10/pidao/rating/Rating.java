package com.unicamp.mc322.lab10.pidao.rating;

public class Rating {
    private final int stars;
    private final String comment;

    public Rating(int stars, String comment) {
        this.stars = stars;
        this.comment = comment;
    }

    public int getStars() {
        return stars;
    }

    @Override
    public String toString() {
        return String.format("Rating: %d stars%s", stars, (comment != null ? " -> " + comment : ""));
    }
}
