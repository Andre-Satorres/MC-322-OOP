package br.unicamp.mc322.lab04.pidao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Order {
    private final User user;
    private final List<Item> items;
    private OrderStatus status;
    private Discount discount;

    public Order(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Order cannot have null user!");
        }

        this.user = user;
        this.items = new ArrayList<>();
        this.status = OrderStatus.NEW;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    void updateStatus() {
        if (OrderStatus.DELIVERED != status && OrderStatus.CANCELED != status) {
            int currentStateIndex = status.ordinal();
            this.status = OrderStatus.values()[currentStateIndex + 1];
        } else {
            throw new UpdateStatusException("Cannot update order status after 'delivered' or 'canceled'");
        }
    }

    void cancel() {
        if (status.ordinal() >= OrderStatus.DELIVERING.ordinal()) {
            throw new UpdateStatusException("Cannot cancel order after is delivering.");
        }

        this.status = OrderStatus.CANCELED;
    }

    String getUserCpf() {
        return user.getCpf();
    }

    List<Item> getItems() {
        return items;
    }

    void setDiscount(Discount discount) {
        this.discount = discount;
    }

    double getTotalCost() {
        double totalCost = items.stream().mapToDouble(Item::getDiscountedCost).sum();
        return discount == null ? totalCost : discount.apply(totalCost);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add(user.toString());

        items.forEach(it -> stringJoiner.add(" - " + it.getId()));

        stringJoiner.add(String.format("Total cost: R$ %.2f", getTotalCost()));
        stringJoiner.add("Current Status: " + status);
        return stringJoiner.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(user, order.user) &&
                Objects.equals(items, order.items) &&
                status == order.status &&
                Objects.equals(discount, order.discount);
    }
}
