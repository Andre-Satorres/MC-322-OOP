package br.unicamp.mc322.lab04.pidao;

import java.util.StringJoiner;

class Restaurant {
    private final String name;
    private final String cnpj;
    private final Coordinate coordinate;

    Restaurant(String name, String cnpj, Coordinate coordinate) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid Restaurant name!");
        }

        if (cnpj == null || cnpj.isBlank()) {
            throw new IllegalArgumentException("Invalid Restaurant cnpj!");
        }

        if (coordinate == null) {
            throw new IllegalArgumentException("Invalid Restaurant coordinate!");
        }

        this.name = name;
        this.cnpj = cnpj;
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add("Restaurant " + name);
        stringJoiner.add("(CNPJ: " + cnpj + ")");
        stringJoiner.add("Location: " + coordinate);

        return stringJoiner.toString();
    }
}
