package com.unicamp.mc322.lab12.labyrinth.entity;

import com.unicamp.mc322.lab12.labyrinth.engine.LabyrinthObjectVisitor;

public class Wall extends LabyrinthObject {

    Wall(Integer x, Integer y) {
        super(x, y);
    }

    @Override
    public void accept(LabyrinthObjectVisitor visitor) {
        visitor.visit(this);
    }
}
