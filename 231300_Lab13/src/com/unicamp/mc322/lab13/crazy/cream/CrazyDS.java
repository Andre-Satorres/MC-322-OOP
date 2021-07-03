package com.unicamp.mc322.lab13.crazy.cream;

import java.util.PriorityQueue;

public class CrazyDS implements ICrazyDS {

    private final PriorityQueue<IOrder> priorityQueue;

    public CrazyDS(ISortStrategy sortStrategy) {
        // reversed to use max-priority (PriorityQueue by default is a min-priority)
        this.priorityQueue = new PriorityQueue<>(10, sortStrategy.reversed());
    }

    @Override
    public void addElement(IOrder order) throws CrazyDSException {
        if (this.priorityQueue.contains(order)) {
            throw new IllegalArgumentException("This order has already been added to the queue!");
        }

        this.priorityQueue.add(order);
    }

    @Override
    public void removeElement(IOrder order) throws CrazyDSException {
        boolean removed = priorityQueue.remove(order);

        if (!removed) {
            throw new CrazyDSException("Element not found on queue!");
        }

        for (IOrder toUpdate : priorityQueue) {
            toUpdate.newShift();
        }
    }

    @Override
    public IOrder peekElement() {
        return priorityQueue.peek();
    }

    @Override
    public IOrder getElementAt(int index) throws CrazyDSException {
        int runner = 0;
        IOrder element;

        for (IOrder order : priorityQueue) {
            element = order;

            if (runner == index) {
                return element;
            }

            runner++;
        }

        throw new CrazyDSException("Element at index " + index + " not found!");
    }

    @Override
    public void printElements() {
        for (IOrder order : priorityQueue) {
            order.printInfo();
        }
    }
}
