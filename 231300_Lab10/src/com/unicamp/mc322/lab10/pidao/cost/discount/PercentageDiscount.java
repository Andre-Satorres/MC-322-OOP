package com.unicamp.mc322.lab10.pidao.cost.discount;

public class PercentageDiscount extends Discount {
    public PercentageDiscount(double amount) {
        super(amount);

        if (amount > 100 || amount < 0) {
            throw new DiscountException("Percentage Discount amount out of bounds!");
        }
    }

    @Override
    public double apply(double price) {
        return price * (100 - amount);
    }
}
