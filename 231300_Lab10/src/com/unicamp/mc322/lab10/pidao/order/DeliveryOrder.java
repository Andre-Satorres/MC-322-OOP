package com.unicamp.mc322.lab10.pidao.order;

import com.unicamp.mc322.lab10.pidao.restaurant.Restaurants;
import com.unicamp.mc322.lab10.pidao.user.Users;

public class DeliveryOrder extends Order {

    private static final double PRICE_PER_DISTANCE = 0.5;
    private String deliverymanCpf;

    public DeliveryOrder(int id, String userCpf, String restaurantCnpj, String... foodIds) {
        super(id, userCpf, restaurantCnpj, foodIds);
    }

    public String getDeliverymanCpf() {
        return deliverymanCpf;
    }

    public void fillDeliverymanCpf(String deliverymanCpf) {
        if (this.deliverymanCpf == null) {
            this.deliverymanCpf = deliverymanCpf;
        }
    }

    @Override
    public double originalCost() {
        double productsCost = this.foodIds.stream().mapToDouble(foodId -> Restaurants.getInstance().getFoodCost(restaurantCnpj, foodId)).sum();
        double deliveryCost = PRICE_PER_DISTANCE * distanceToCustomer();
        return productsCost + deliveryCost;
    }

    @Override
    public String getOrderInfo() {
        return super.getOrderInfo().concat("\n - Type: " + OrderType.DELIVERY);
    }

    @Override
    protected void finishPreparing() {
        this.status = OrderStatus.READY;
        Restaurants.getInstance().assignOrderToDeliveryman(this, restaurantCnpj);
    }

    public void deliver() {
        this.status = OrderStatus.DELIVERING;
    }

    public double distanceToCustomer() {
        return Users.getInstance().getCustomerPosition(customerCpf).distance(Restaurants.getInstance().getRestaurantPosition(restaurantCnpj));
    }

    public void reachCustomer() {
        this.status = OrderStatus.DELIVERED;
    }
}
