package com.unicamp.mc322.lab10.pidao.order;

import com.unicamp.mc322.lab10.pidao.restaurant.Restaurants;

public class WithdrawalOrder extends Order {
    public WithdrawalOrder(int id, String userCpf, String restaurantCnpj, String... foodIds) {
        super(id, userCpf, restaurantCnpj, foodIds);
    }

    @Override
    public String getOrderInfo() {
        return super.getOrderInfo().concat("\n - Type: " + OrderType.WITHDRAWAL);
    }

    @Override
    public double originalCost() {
        return this.foodIds.stream().mapToDouble(foodId -> Restaurants.getInstance().getByCnpj(restaurantCnpj).getFoodCost(foodId)).sum();
    }

    public void take() {
        if (canWithdraw()) {
            this.status = OrderStatus.WITHDRAWN;
        } else {
            throw new OrderException("Cannot withdraw order not prepared yet");
        }
    }

    private boolean canWithdraw() {
        return this.status == OrderStatus.READY;
    }
}
