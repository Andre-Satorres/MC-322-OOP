package com.unicamp.mc322.lab13.crazy.cream;

public class MyCrazyScore implements ISortStrategy {
    @Override
    public double getPriorityPoints(IOrder order) {
        return (order.getOwnerAge() * 0.6) + (0.4 * order.getShifts());
    }

    @Override
    public int compare(IOrder order, IOrder t1) {
        return Double.compare(getPriorityPoints(order), getPriorityPoints(t1));
    }
}
