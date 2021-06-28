package com.unicamp.mc322.lab13.crazy.cream;

public interface ICrazyDS {

    void addElement(IOrder order) throws CrazyDSException;

    void removeElement(IOrder order) throws CrazyDSException;

    IOrder peekElement();

    IOrder getElementAt(int index) throws CrazyDSException;

    void printElements();
}
