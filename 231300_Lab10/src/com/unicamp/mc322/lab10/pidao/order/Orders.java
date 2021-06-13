package com.unicamp.mc322.lab10.pidao.order;

import com.unicamp.mc322.lab10.pidao.cost.discount.DiscountType;
import com.unicamp.mc322.lab10.pidao.rating.Stars;
import com.unicamp.mc322.lab10.pidao.restaurant.Restaurants;
import com.unicamp.mc322.lab10.pidao.user.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {
    private static Orders instance;
    private final List<Order> orders;

    private Orders() {
        this.orders = new ArrayList<>();
    }

    public static Orders getInstance() {
        if (instance == null) {
            instance = new Orders();
        }

        return instance;
    }

    public int addOrder(String cpf, String cnpj, OrderType orderType, String... foodIds) {
        if (getCurrentOrderByCpf(cpf) != null) {
            throw new OrderException("User cannot have more than one current order!");
        }

        if (orderType == OrderType.DELIVERY) {
            this.orders.add(new DeliveryOrder(orders.size() + 1, cpf, cnpj, foodIds));
        } else if (orderType == OrderType.WITHDRAWAL) {
            this.orders.add(new WithdrawalOrder(orders.size() + 1, cpf, cnpj, foodIds));
        } else {
            throw new OrderException("Order type not implemented or do not exist: " + orderType);
        }

        return orders.size(); // orderId
    }

    public void processOrder(String cpf) {
        getCurrentOrderByCpf(cpf).order();
    }

    public void processOrder(String cpf, DiscountType discountType, double discountAmount) {
        getCurrentOrderByCpf(cpf).order(discountType, discountAmount);
    }

    public void cancelOrder(String cpf) {
        Order userOrder = this.getCurrentOrderByCpf(cpf);

        if (userOrder == null) {
            throw new OrderException("This user does not have orders that can be canceled!");
        }

        userOrder.cancel();
    }

    public void withdrawOrder(String cpf) {
        Order order = getCurrentOrderByCpf(cpf);

        if (order instanceof WithdrawalOrder) {
            ((WithdrawalOrder) order).take();
        }
    }

    public long amountForUser(String cpf) {
        return this.orders.stream()
                .filter(order -> order.customerCpf.equals(cpf))
                .count();
    }

    public String getAllOrdersInfo() {
        return this.orders.stream().map(Order::getOrderInfo).collect(Collectors.joining("\n\n"));
    }

    public void addFoodToOrder(String cpf, String foodId) {
        getCurrentOrderByCpf(cpf).addFood(foodId);
    }

    public void removeFoodFromOrder(String cpf, String foodId) {
        getCurrentOrderByCpf(cpf).removeFood(foodId);
    }

    public void rateRestaurantOfOrder(int id, Stars stars, String comment) {
        String cnpj = this.getOrderToRate(id).getRestaurantCnpj();
        Restaurants.getInstance().rateRestaurant(cnpj, stars, comment);
    }

    public void rateDeliverymanOfOrder(int id, Stars stars, String comment) {
        Order toRate = this.getOrderToRate(id);

        if (toRate instanceof DeliveryOrder) {
            String cpf = ((DeliveryOrder) toRate).getDeliverymanCpf();
            Users.getInstance().rateDeliveryman(cpf, stars, comment);
        } else {
            throw new OrderException("Cannot rate deliveryman of not Delivery order!!");
        }
    }

    public void rateFoodOfOrder(int id, String foodId, Stars stars, String comment) {
        Restaurants.getInstance().rateFood(getOrderToRate(id).getRestaurantCnpj(), foodId, stars, comment);
    }

    private Order getOrderToRate(int id) {
        Order ret = getById(id);
        if (ret.canBeRated()) {
            return ret;
        } else {
            throw new OrderException("Cannot rate unfinished order!");
        }
    }

    private Order getById(int id) {
        return this.orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .orElseThrow(() -> new OrderException("Order with id " + id + " not found!"));
    }

    private Order getCurrentOrderByCpf(String cpf) {
        return orders.stream()
                .filter(Order::isProcessing)
                .filter(order -> order.getCustomerCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }
}
