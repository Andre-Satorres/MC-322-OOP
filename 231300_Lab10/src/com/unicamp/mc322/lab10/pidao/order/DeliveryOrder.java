package com.unicamp.mc322.lab10.pidao.order;

public class DeliveryOrder extends Order {

    public DeliveryOrder(String userCpf, String restaurantCnpj, String... foodIds) {
        super(userCpf, restaurantCnpj, foodIds);
    }

    public void deliver() {
        this.status = OrderStatus.DELIVERING;
    }

    public void reachCustomer() {
        this.status = OrderStatus.DELIVERED;
    }
}
