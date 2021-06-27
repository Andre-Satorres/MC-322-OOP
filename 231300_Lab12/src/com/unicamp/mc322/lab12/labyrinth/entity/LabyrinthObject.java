package com.unicamp.mc322.lab12.labyrinth.entity;

import com.unicamp.mc322.lab12.labyrinth.engine.LabyrinthObjectVisitor;

public abstract class LabyrinthObject {
    private final Coordinate coordinate;

    LabyrinthObject(Integer x, Integer y) {
        this.coordinate = new Coordinate(x, y);
    }

    public Integer getX() {
        return coordinate.getX();
    }

    public Integer getY() {
        return coordinate.getY();
    }

    protected Coordinate getCoordinate() {
        return coordinate;
    }

    public Boolean isSameCoordinates(Integer x, Integer y) {
        return coordinate.isSameCoordinates(x, y);
    }

    public Boolean isSameCoordinates(LabyrinthObject labyrinthObject) {
        return coordinate.isSameCoordinates(labyrinthObject.getX(), labyrinthObject.getY());
    }

    public abstract void accept(LabyrinthObjectVisitor visitor);
}
