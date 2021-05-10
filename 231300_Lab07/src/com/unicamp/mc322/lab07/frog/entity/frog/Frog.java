package com.unicamp.mc322.lab07.frog.entity.frog;

import com.unicamp.mc322.lab07.frog.direction.Direction;
import com.unicamp.mc322.lab07.frog.entity.icon.Icon;
import com.unicamp.mc322.lab07.frog.position.Position;

public abstract class Frog {
    private String name;
    private Icon icon;
    private int satisfactionPoints;
    protected FrogType type;
    protected Position currentPosition;
    protected Position lastPosition;

    public Frog(FrogType type, Position initialPosition) {
        this.type = type;
        this.currentPosition = this.lastPosition = initialPosition;
    }

    public void move(Direction direction) {
        switch (direction) {
            case LEFT: move(this.currentPosition.left(moveAmount(Direction.LEFT)));
            case RIGHT: move(this.currentPosition.right(moveAmount(Direction.RIGHT)));
            case DOWN: move(this.currentPosition.down(moveAmount(Direction.DOWN)));
            case UP: move(this.currentPosition.up(moveAmount(Direction.UP)));
        }
    }

    protected abstract int moveAmount(Direction direction);

    protected void move(Position destination) {
        this.lastPosition = this.currentPosition;
        this.currentPosition = destination;
    }
}
