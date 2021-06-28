package com.unicamp.mc322.lab13.crazy.cream;

import java.util.Comparator;

public interface ISortStrategy extends Comparator<IOrder> {

    double getPriorityPoints(IOrder order);
}
