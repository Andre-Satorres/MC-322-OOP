package com.unicamp.mc322.lab12.labyrinth.entity;

import com.unicamp.mc322.lab12.labyrinth.engine.LabyrinthObjectVisitor;

import java.util.List;

public class Player extends LabyrinthObject {

    private Direction currentDirection;

    Player(Integer x, Integer y) {
        super(x, y);
        this.currentDirection = Direction.DOWN;
    }

    @Override
    public void accept(LabyrinthObjectVisitor visitor) {
        visitor.visit(this);
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    void move(Direction direction, List<Wall> walls) {
        Coordinate next;

        switch (direction) {
            case UP:
                next = new Coordinate(getX(), getY() - 1);
                break;
            case DOWN:
                next = new Coordinate(getX(), getY() + 1);
                break;
            case LEFT:
                next = new Coordinate(getX() - 1, getY());
                break;
            case RIGHT:
                next = new Coordinate(getX() + 1, getY());
                break;
            default:
                throw new PlayerMovementException("Unexpected direction: " + direction);
        }

        for (Wall wall: walls) {
            if (wall.isSameCoordinates(next.getX(), next.getY())) {
                throw new PlayerMovementException("Player cannot move into a wall!");
            }
        }

        this.getCoordinate().changeCoordinates(next.getX(), next.getY());
        this.currentDirection = direction;
    }
}
