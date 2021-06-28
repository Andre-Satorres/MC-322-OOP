package com.unicamp.mc322.lab13.crazy.cream;

public class PriorityScore implements ISortStrategy {

    @Override
    public double getPriorityPoints(IOrder order) {
        return (order.getOwnerAge() / 100.0) + ((7.0/1000) * order.getShifts());
    }

    @Override
    public int compare(IOrder order, IOrder t1) {
        return Double.compare(getPriorityPoints(order), getPriorityPoints(t1));
    }
}
