package br.unicamp.ic.mc322.teste1;

public class Application {

    public static void main(String[] args) {

        Position p1 = new Position(1, 1);
        Position p2 = new Position(0, 0);

        double distance = p1.distanceTo(p2);

        System.out.println("Distance: " + distance);
    }
}