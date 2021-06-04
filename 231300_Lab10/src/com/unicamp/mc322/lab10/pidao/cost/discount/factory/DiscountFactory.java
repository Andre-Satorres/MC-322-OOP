package com.unicamp.mc322.lab10.pidao.cost.discount.factory;

import com.unicamp.mc322.lab10.pidao.cost.discount.Discount;

public abstract class DiscountFactory {

    protected double amount;

    public DiscountFactory(double amount) {
        this.amount = amount;
    }

    public double applyDiscount(double price) {
        return createDiscount().apply(price);
    }

    protected abstract Discount createDiscount();
}
