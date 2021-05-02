package br.unicamp.mc322.lab04.pidao;

public class Discount {
    private final DiscountType discountType;
    private final double evaluation;

    Discount(double evaluation, DiscountType discountType) {
        if (evaluation < 0) {
            throw new IllegalArgumentException("Discount evaluation cannot be less then zero!");
        }

        if (DiscountType.PERCENTAGE == discountType && evaluation > 100) {
            throw new IllegalArgumentException("Evaluation cannot be greater then 100 if discount type is percentage!");
        }

        this.discountType = discountType;
        this.evaluation = evaluation;
    }

    double apply(double initialValue) {
        switch (discountType) {
            case VALUE:
                return Math.max(0, initialValue - evaluation);
            case PERCENTAGE:
                return initialValue * (1 - evaluation / 100);
            default:
                return initialValue;
        }
    }
}
