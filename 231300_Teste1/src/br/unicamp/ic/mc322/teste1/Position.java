package br.unicamp.ic.mc322.teste1;

public class Position {
    private final int x;
    private final int y;

    public Position(int theX, int theY) {
        x = theX;
        y = theY;
    }

    public double distanceTo(Position other) {
        return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }
}
