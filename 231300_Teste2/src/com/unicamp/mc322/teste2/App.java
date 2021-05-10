package com.unicamp.mc322.teste2;

public class App {
    public static void main(String[] args) {
        PoligonoConvexo[] poligonos = { new Triangulo(3, 4, 5), new Quadrado(4), new Retangulo(6, 8) };

        for (PoligonoConvexo poligonoConvexo : poligonos) {
            System.out.println("Perimetro: " + poligonoConvexo.perimetro());
            System.out.println("Area: " + poligonoConvexo.area());
        }
    }
}
