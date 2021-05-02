package br.unicamp.mc322.lab04.pidao;

public class Item {
    private final String id;
    private final String name;
    private final double cost;
    private Discount discount;

    public Item(String id, String name, double cost) {
        if (id == null || id.length() != 5) {
            throw new IllegalArgumentException("Invalid Item id! Has to be a 5 alphanumeric identifier!");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid Item name!");
        }

        if (cost < 0) {
            throw new IllegalArgumentException("Item cost cannot be less then zero!");
        }

        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    String getId() {
        return id;
    }

    void applyDiscount(double evaluation, DiscountType discountType) {
        this.discount = new Discount(evaluation, discountType);
    }

    void removeDiscount() {
        this.discount = null;
    }

    double getDiscountedCost() {
        return discount == null ? cost : discount.apply(cost);
    }

    @Override
    public String toString() {
        String optionalDiscount = String.format(" (DISCOUNT! Regular cost: R$ %.2f)", cost);
        return String.format("[%s] %s: R$ %.2f%s", id, name, getDiscountedCost(), discount == null ? "" : optionalDiscount);
    }
}
