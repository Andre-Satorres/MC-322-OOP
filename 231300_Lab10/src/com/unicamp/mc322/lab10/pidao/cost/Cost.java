package com.unicamp.mc322.lab10.pidao.cost;

import com.unicamp.mc322.lab10.pidao.cost.discount.DiscountException;
import com.unicamp.mc322.lab10.pidao.cost.discount.DiscountType;
import com.unicamp.mc322.lab10.pidao.cost.discount.factory.DiscountFactory;
import com.unicamp.mc322.lab10.pidao.cost.discount.factory.PercentageDiscountFactory;
import com.unicamp.mc322.lab10.pidao.cost.discount.factory.ValueDiscountFactory;

public class Cost {
    private final double originalPrice;
    private DiscountFactory discount;

    public Cost(double originalPrice) {
        this.originalPrice = originalPrice;
        this.discount = new ValueDiscountFactory(0);
    }

    public void createDiscount(DiscountType discountType, double discountAmount) {
        if (discountType == DiscountType.VALUE) {
            this.discount = new ValueDiscountFactory(discountAmount);
        } else if (discountType == DiscountType.PERCENTAGE) {
            this.discount = new PercentageDiscountFactory(discountAmount);
        } else {
            throw new DiscountException("Discount type not implemented: " + discountType);
        }
    }

    public void removeDiscount() {
        this.discount = new ValueDiscountFactory(0);
    }

    public double getRealCost() {
        return discount.applyDiscount(originalPrice);
    }

    @Override
    public String toString() {
        String suffix = " (DISCOUNT! Original Price: " + String.format("$%.2f", this.originalPrice) + ")";
        boolean shouldAddSuffix = getRealCost() != originalPrice;
        return String.format("$%.2f", getRealCost()) + (shouldAddSuffix ? suffix : "");
    }
}
