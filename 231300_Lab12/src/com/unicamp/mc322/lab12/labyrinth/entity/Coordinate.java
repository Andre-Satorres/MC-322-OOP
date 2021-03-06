package com.unicamp.mc322.lab12.labyrinth.entity;

import java.util.Objects;
import java.util.StringJoiner;

public class Coordinate {
    private Integer x;
    private Integer y;

    public Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void changeCoordinates(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Boolean isSameCoordinates(Integer x, Integer y) {
        return this.x.equals(x) && this.y.equals(y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "(", ")")
                .add(x + "")
                .add(y + "")
                .toString();
    }
}
