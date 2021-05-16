package com.unicamp.mc322.lab07.frogy.entity.frog;

import com.unicamp.mc322.lab07.frogy.direction.Direction;
import com.unicamp.mc322.lab07.frogy.entity.map.item.food.Food;
import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;
import com.unicamp.mc322.lab07.frogy.position.Position;

public abstract class Frog {
    private String name;
    private Icon icon;
    protected int satisfactionPoints;
    protected Position currentPosition;
    protected Position lastPosition;
    private LifeState lifeState;

    public Frog(Icon icon, Position initialPosition) {
        this.icon = icon;
        this.currentPosition = this.lastPosition = initialPosition;
        this.lifeState = LifeState.ALIVE;
    }

    public abstract void eat(Food food);

    public void move(Direction direction) {
        switch (direction) {
            case LEFT: move(this.currentPosition.left(moveAmount(Direction.LEFT)));
            case RIGHT: move(this.currentPosition.right(moveAmount(Direction.RIGHT)));
            case DOWN: move(this.currentPosition.down(moveAmount(Direction.DOWN)));
            case UP: move(this.currentPosition.up(moveAmount(Direction.UP)));
        }
    }

    public void die() {
        this.lifeState = LifeState.DEAD;
    }

    public Position getCurrentPosition() {
        return this.currentPosition;
    }

    protected abstract int moveAmount(Direction direction);

    protected void move(Position destination) {
        this.lastPosition = this.currentPosition;
        this.currentPosition = destination;
    }

    public boolean isAlive() {
        return lifeState != LifeState.DEAD;
    }
}
