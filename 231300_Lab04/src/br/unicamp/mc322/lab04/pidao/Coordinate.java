package br.unicamp.mc322.lab04.pidao;

class Coordinate {
    private final double x;
    private final double y;

    Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}
