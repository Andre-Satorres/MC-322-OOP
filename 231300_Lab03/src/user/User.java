package user;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private final String name;
    private final String cpf;
    private final Date birthDate;
    private final Gender gender;
    private double balance;
    private final boolean smoker;

    public User(String name, String cpf, Date birthDate, Gender gender, double balance, boolean smoker) {
        validateConstructorArgs(name, cpf, birthDate);

        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.gender = gender;
        this.balance = balance;
        this.smoker = smoker;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid deposit amount!");
        }

        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid withdraw amount!");
        }

        this.balance -= amount;
    }

    public boolean isSmoker() {
        return smoker;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "User{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthDate=" + dateFormat.format(birthDate) +
                ", gender=" + gender +
                ", balance=" + balance +
                ", smoker=" + smoker +
                '}';
    }

    private void validateConstructorArgs(String name, String cpf, Date birthDate) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("User's name is invalid!");
        }

        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("User's cpf is invalid!");
        }

        if (birthDate == null || birthDate.after(new Date())) {
            throw new IllegalArgumentException("User's birthDate is invalid!");
        }
    }
}
