package com.unicamp.mc322.lab12.labyrinth.entity;

import com.unicamp.mc322.lab12.labyrinth.engine.LabyrinthObjectVisitor;

public class Checkpoint extends LabyrinthObject {
    private Boolean isConquered;

    Checkpoint(Integer x, Integer y) {
        super(x, y);
        isConquered = false;
    }

    @Override
    public void accept(LabyrinthObjectVisitor visitor) {
        visitor.visit(this);
    }

    public Boolean isConquered() {
        return isConquered;
    }

    void conquer() {
        isConquered = true;
    }
}
