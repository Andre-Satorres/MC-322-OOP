package com.unicamp.mc322.teste2;

public class Triangulo extends PoligonoConvexo {

    public Triangulo(Number a , Number b, Number c) {
        super(a, b, c);
    }

    @Override
    protected double area() {
        double semiPerimetro = perimetro() / 2;
        double a = getLadoDouble(0), b = getLadoDouble(1), c = getLadoDouble(2);
        return Math.sqrt(semiPerimetro * (semiPerimetro - a) * (semiPerimetro - b) * (semiPerimetro - c)); // Formula de Heron
    }
}
