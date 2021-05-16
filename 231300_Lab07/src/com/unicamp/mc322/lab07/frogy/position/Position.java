package com.unicamp.mc322.lab07.frogy.position;

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

    public boolean isNeighbourOf(Position other) {
        return equals(other) ||
                left(1).equals(other) ||
                right(1).equals(other) ||
                down(1).equals(other) ||
                up(1).equals(other) ||
                diagonalLeftUp(1).equals(other) ||
                diagonalLeftDown(1).equals(other) ||
                diagonalRightUp(1).equals(other) ||
                diagonalRightDown(1).equals(other);
    }

    public double manhattanDistanceTo(Position destination) {
        return Math.abs(this.x - destination.x) + Math.abs(this.y + destination.y); // |x1 - x2| + |y1 - y2|.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    public static Position random(int maxX, int maxY) {
        return new Position((int) (Math.random() * maxX), (int) (Math.random() * maxY));
    }
}
