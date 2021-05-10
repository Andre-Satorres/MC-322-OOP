package com.unicamp.mc322.teste2;

public class Retangulo extends PoligonoConvexo {

    public Retangulo(Number x, Number y) {
        super(x, y, x, y);
    }

    @Override
    protected double area() {
        return this.getLadoDouble(0) * this.getLadoDouble(1);
    }
}
