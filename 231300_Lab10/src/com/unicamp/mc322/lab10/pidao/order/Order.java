package com.unicamp.mc322.lab10.pidao.order;

import com.unicamp.mc322.lab10.pidao.cost.Cost;
import com.unicamp.mc322.lab10.pidao.cost.discount.DiscountType;
import com.unicamp.mc322.lab10.pidao.restaurant.Restaurants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public abstract class Order {
    private final int id;
    protected final List<String> foodIds;
    protected OrderStatus status;
    protected final String customerCpf;
    protected final String restaurantCnpj;
    protected Cost cost;

    public Order(int id, String customerCpf, String restaurantCnpj, String... foodIds) {
        this.id = id;
        this.foodIds = new ArrayList<>(Arrays.asList(foodIds));
        this.customerCpf = customerCpf;
        this.restaurantCnpj = restaurantCnpj;
        this.status = OrderStatus.CREATED;
    }

    public int getId() {
        return id;
    }

    public String getRestaurantCnpj() {
        return restaurantCnpj;
    }

    public void addFood(String foodId) {
        this.foodIds.add(foodId);
    }

    public void removeFood(String foodId) {
        this.foodIds.remove(foodId);
    }

    public void order() {
        this.status = OrderStatus.PREPARING;
        this.cost = new Cost(originalCost());
        this.startPreparing();
    }

    public void order(DiscountType discountType, double discountAmount) {
        this.status = OrderStatus.PREPARING;
        this.cost = new Cost(originalCost());
        this.cost.createDiscount(discountType, discountAmount);
        this.startPreparing();
    }

    private void startPreparing() {
        int timeToCookSeconds = this.foodIds.stream().mapToInt(foodId -> Restaurants.getInstance().getFoodPreparingTimeSeconds(restaurantCnpj, foodId)).sum();

        new Thread(() -> {
            try {
                Thread.sleep(timeToCookSeconds * 1000L);
                if (!(this.status == OrderStatus.CANCELED)) {
                    this.finishPreparing();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    protected void finishPreparing() {
        this.status = OrderStatus.READY;
    }

    protected abstract double originalCost();

    public void cancel() {
        if (this.canBeCanceled()) {
            this.status = OrderStatus.CANCELED;
        } else {
            throw new OrderException("Cannot cancel order after 'PREPARING' status!");
        }
    }

    public boolean canBeCanceled() {
        return this.status == OrderStatus.CREATED || this.status == OrderStatus.PREPARING;
    }

    public boolean canBeRated() {
        return this.status == OrderStatus.CANCELED || this.status == OrderStatus.DELIVERED || this.status == OrderStatus.WITHDRAWN;
    }

    public boolean isProcessing() {
        return this.status == OrderStatus.CREATED || this.status == OrderStatus.PREPARING || this.status == OrderStatus.READY;
    }

    public String getOrderInfo() {
        return new StringJoiner("\n")
                .add(String.format("Order from customer %s to restaurant %s:", customerCpf, restaurantCnpj))
                .add(" - Foods: " + foodIds)
                .add(" - Status: " + status)
                .add(" - Cost: " + (cost == null ? "Not calculated yet" : String.format("$%.2f", this.cost.getRealCost())))
                .toString();
    }

    public String getCustomerCpf() {
        return this.customerCpf;
    }
}
