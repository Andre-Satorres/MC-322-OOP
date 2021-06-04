package com.unicamp.mc322.lab10.pidao.rating;

import java.util.StringJoiner;

public class Rating {
    private final int stars;
    private String comment;

    public Rating(int stars, String comment) {
        this.stars = stars;
        this.comment = comment;
    }

    public Rating(int stars) {
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Rating.class.getSimpleName() + "[", "]")
                .add("stars=" + stars)
                .add("comment='" + comment + "'")
                .toString();
    }
}
