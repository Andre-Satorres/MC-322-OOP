package com.unicamp.mc322.lab10.pidao.cost.discount;

public abstract class Discount {
    protected final double amount;

    public Discount(double amount) {
        this.amount = amount;
    }

    public abstract double apply(double price);
}
