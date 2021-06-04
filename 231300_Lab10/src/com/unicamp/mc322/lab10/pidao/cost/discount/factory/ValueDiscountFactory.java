package com.unicamp.mc322.lab10.pidao.cost.discount.factory;

import com.unicamp.mc322.lab10.pidao.cost.discount.Discount;
import com.unicamp.mc322.lab10.pidao.cost.discount.ValueDiscount;

public class ValueDiscountFactory extends DiscountFactory {

    public ValueDiscountFactory(double amount) {
        super(amount);
    }

    @Override
    protected Discount createDiscount() {
        return new ValueDiscount(amount);
    }
}
