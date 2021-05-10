package com.unicamp.mc322.teste2;

public abstract class PoligonoConvexo {
    protected int qtdLados;
    protected Number[] lados;
    private final int qtdAngulos;
    private final int qtdVertices;

    public PoligonoConvexo(Number ... lados) {
        this.qtdVertices = this.qtdAngulos = this.qtdLados = lados.length;
        this.lados = lados;
    }

    public double getLadoDouble(int i) {
        return this.lados[i].doubleValue();
    }

    private int somaAngulosInternos() {
        return (qtdAngulos - 2) * 180;
    }

    private int totalDiagonais() {
        return qtdVertices * (qtdLados - 3) / 2;
    }

    protected double perimetro() {
        double ret = 0;

        for (Number lado : lados) {
            ret += lado.doubleValue();
        }

        return ret;
    }

    protected abstract double area();
}
