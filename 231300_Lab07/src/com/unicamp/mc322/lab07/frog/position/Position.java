package com.unicamp.mc322.lab07.frog.position;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position left(int amount) {
        return new Position(x - amount, y);
    }

    public Position right(int amount) {
        return new Position(x + amount, y);
    }

    public Position down(int amount) {
        return new Position(x, y - amount);
    }

    public Position up(int amount) {
        return new Position(x, y + amount);
    }

}
