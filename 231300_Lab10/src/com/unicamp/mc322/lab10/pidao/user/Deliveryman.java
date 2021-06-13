package com.unicamp.mc322.lab10.pidao.user;

import com.unicamp.mc322.lab10.pidao.order.DeliveryOrder;
import com.unicamp.mc322.lab10.pidao.rating.Ratings;
import com.unicamp.mc322.lab10.pidao.rating.Stars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deliveryman extends User {

    private final List<DeliveryOrder> ordersToDeliver;
    private static final double VELOCITY_UNITS_SECOND = 20; // just a guess
    private final Ratings ratings;

    public Deliveryman(String name, String cpf) {
        super(name, cpf);
        this.ordersToDeliver = Collections.synchronizedList(new ArrayList<>());
        this.ratings = new Ratings();

        new Thread(this::deliverOrders).start();
    }

    public void addOrderToDeliver(DeliveryOrder order) {
        this.ordersToDeliver.add(order);
        order.fillDeliverymanCpf(this.cpf);
    }

    public void deliverOrders() {
        while (true) {
            deliverNextOrder();
        }
    }

    public void deliverNextOrder() {
        if (ordersToDeliver.size() > 0) {
            DeliveryOrder toDeliver = this.ordersToDeliver.get(0);
            toDeliver.deliver();

            long timeToReachCustomer = (long) Math.ceil(toDeliver.distanceToCustomer() / VELOCITY_UNITS_SECOND);
            try {
                Thread.sleep(timeToReachCustomer * 1000);
                toDeliver.reachCustomer();
                this.ordersToDeliver.remove(toDeliver);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void rate(Stars stars, String comment) {
        this.ratings.addRating(stars.ordinal(), comment);
    }

    public String getRatingInfo() {
        return name + ":\n" + ratings.getInfo();
    }

    @Override
    public String toString() {
        return String.format("Deliveryman: %s - %s", name, cpf);
    }
}
