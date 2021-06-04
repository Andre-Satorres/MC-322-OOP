package com.unicamp.mc322.lab10.pidao.cost.discount.factory;

import com.unicamp.mc322.lab10.pidao.cost.discount.Discount;
import com.unicamp.mc322.lab10.pidao.cost.discount.PercentageDiscount;

public class PercentageDiscountFactory extends DiscountFactory {

    public PercentageDiscountFactory(double amount) {
        super(amount);
    }

    @Override
    protected Discount createDiscount() {
        return new PercentageDiscount(amount);
    }
}
