package com.unicamp.mc322.lab05;

public class Participant {
    private final String name;
    private final String email;
    private final String phone;

    public Participant(String name, String email, String phone) {
        if (name == null || email == null || phone == null || name.isBlank() || email.isBlank() || phone.isBlank()) {
            throw new IllegalArgumentException("One or more data invalid!");
        }

        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
