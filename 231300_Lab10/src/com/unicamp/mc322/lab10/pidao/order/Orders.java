package com.unicamp.mc322.lab10.pidao.order;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final List<Order> orders;

    public Orders() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(String cpf, String cnpj, OrderType orderType, String... foodIds) {
        if (orderType == OrderType.DELIVERY) {
            this.orders.add(new DeliveryOrder(cpf, cnpj, foodIds));
        } else if (orderType == OrderType.WITHDRAWAL) {
            this.orders.add(new WithdrawalOrder(cpf, cnpj, foodIds));
        } else {
            throw new OrderException("Order type not implemented: " + orderType);
        }
    }

    public void cancelOrder(String cpf) {
        Order userOrder = this.getCurrentOrderByCpf(cpf);

        if (userOrder == null) {
            throw new OrderException("This user does not have orders that can be canceled!");
        }

        userOrder.cancel();
    }

    private Order getCurrentOrderByCpf(String cpf) {
        return orders.stream()
                .filter(Order::canBeCanceled)
                .filter(order -> order.getCustomerCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }
}
