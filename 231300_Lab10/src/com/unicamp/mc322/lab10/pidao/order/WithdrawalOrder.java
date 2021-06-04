package com.unicamp.mc322.lab10.pidao.order;

public class WithdrawalOrder extends Order {
    public WithdrawalOrder(String userCpf, String restaurantCnpj, String... foodIds) {
        super(userCpf, restaurantCnpj, foodIds);
    }

    public void take() {
        this.status = OrderStatus.WITHDRAWN;
    }
}
