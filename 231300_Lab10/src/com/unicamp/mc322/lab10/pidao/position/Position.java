package com.unicamp.mc322.lab10.pidao.position;

public class Position {
    private final double x;
    private final double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Position of(double x, double y) {
        return new Position(x, y);
    }

    public double distance(Position other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }
}
