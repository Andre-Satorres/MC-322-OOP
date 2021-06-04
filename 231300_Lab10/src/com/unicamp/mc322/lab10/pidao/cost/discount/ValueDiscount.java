package com.unicamp.mc322.lab10.pidao.cost.discount;

public class ValueDiscount extends Discount {
    public ValueDiscount(double amount) {
        super(amount);

        if (amount < 0) {
            throw new DiscountException("Value Discount amount out of bounds!");
        }
    }

    @Override
    public double apply(double price) {
        return Math.max(price - amount, 0);
    }
}
