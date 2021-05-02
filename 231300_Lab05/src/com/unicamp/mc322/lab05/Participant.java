package com.unicamp.mc322.lab05;

public class Participant {
    private final String name;
    private final String email;
    private final String phone;
    private boolean confirmed;

    public Participant(String name, String email, String phone) {
        if (name == null || email == null || phone == null || name.isBlank() || email.isBlank() || phone.isBlank()) {
            throw new IllegalArgumentException("One or more data invalid!");
        }

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.confirmed = false;
    }

    public void confirmParticipation() {
        this.confirmed = true;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public boolean isNotConfirmed() {
        return !confirmed;
    }

    @Override
    public String toString() {
        return name;
    }
}
