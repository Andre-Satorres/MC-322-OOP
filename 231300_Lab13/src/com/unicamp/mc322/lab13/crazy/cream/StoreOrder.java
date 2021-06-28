package com.unicamp.mc322.lab13.crazy.cream;

public abstract class StoreOrder implements IOrder {

    private int shifts;
    private String code;
    private final IOwner owner;

    public StoreOrder(IOwner owner) {
        this.shifts = 0;
        this.owner = owner;
        this.generateCode();
    }

    @Override
    public void newShift() {
        this.shifts++;
    }

    @Override
    public int getShifts() {
        return shifts;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void generateCode() {
        this.code = RandomAlphaGenerator.getInstance().randomString(10);
    }

    @Override
    public Integer getOwnerAge() {
        return owner.getAge();
    }

    @Override
    public void printOwner() {
        System.out.println(owner.getName());
    }

    @Override
    public void printOwnerFullData() {
        System.out.println(owner.getCompleteInfo());
    }

    @Override
    public void printInfo() {
        System.out.println("Shifts: " + shifts + " // Code: " + code + " // Owner: " + owner.getName());
    }
}
