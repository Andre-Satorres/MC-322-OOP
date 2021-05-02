package br.unicamp.mc322.lab04.pidao;

public class User {
    private final String name;
    private final String cpf;
    private final Coordinate coordinate;

    User(String name, String cpf, Coordinate coordinate) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid User name!");
        }

        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("Invalid User cpf!");
        }

        if (coordinate == null) {
            throw new IllegalArgumentException("Invalid User coordinate!");
        }

        this.name = name;
        this.cpf = cpf;
        this.coordinate = coordinate;
    }

    String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "User: " + name + " (" + cpf + ")" + ". Location: " + coordinate;
    }
}
