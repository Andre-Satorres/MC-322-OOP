package com.unicamp.mc322.lab07.frogy.position;

import java.util.Objects;

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

    public Position diagonalLeftUp(int amount) {
        return new Position(x - amount, y - amount);
    }

    public Position diagonalLeftDown(int amount) {
        return new Position(x - amount, y + amount);
    }

    public Position diagonalRightUp(int amount) {
        return new Position(x + amount, y - amount);
    }

    public Position diagonalRightDown(int amount) {
        return new Position(x + amount, y + amount);
    }

    public boolean areNeighbours(Position p1, Position p2) {
        return p1.equals(p2) ||
                p1.left(1).equals(p2) ||
                p1.right(1).equals(p2) ||
                p1.down(1).equals(p2) ||
                p1.up(1).equals(p2) ||
                p1.diagonalLeftUp(1).equals(p2) ||
                p1.diagonalLeftDown(1).equals(p2) ||
                p1.diagonalRightUp(1).equals(p2) ||
                p1.diagonalRightDown(1).equals(p2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }
}
