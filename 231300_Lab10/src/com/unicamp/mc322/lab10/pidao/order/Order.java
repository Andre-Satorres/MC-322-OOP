package com.unicamp.mc322.lab10.pidao.order;

import java.util.Arrays;
import java.util.List;

public abstract class Order {
    private final List<String> foodIds;
    private String customerCpf;
    private String restaurantCnpj;
    protected OrderStatus status;

    public Order(String customerCpf, String restaurantCnpj, String... foodIds) {
        this.foodIds = Arrays.asList(foodIds);
        this.customerCpf = customerCpf;
        this.restaurantCnpj = restaurantCnpj;
        this.status = OrderStatus.CREATED;
    }

    public void addFood(String foodId) {
        this.foodIds.add(foodId);
    }

    public void removeFood(String foodId) {
        this.foodIds.remove(foodId);
    }

    public void order() {
        this.status = OrderStatus.PREPARING;
    }

    public void finishPreparing() {
        this.status = OrderStatus.READY;
    }

    public void cancel() {
        this.status = OrderStatus.CANCELED;
    }

    public boolean canBeCanceled() {
        return this.status == OrderStatus.CREATED || this.status == OrderStatus.PREPARING;
    }

    public String getCustomerCpf() {
        return this.customerCpf;
    }
}
