package com.unicamp.mc322.lab13.crazy.cream;

public interface IOrder {

    void newShift();

    int getShifts();

    String getCode();

    void generateCode();

    Integer getOwnerAge();

    void printOwner();

    void printOwnerFullData();

    void printInfo();
}
