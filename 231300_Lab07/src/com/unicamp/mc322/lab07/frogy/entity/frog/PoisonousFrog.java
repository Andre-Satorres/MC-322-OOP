package com.unicamp.mc322.lab07.frogy.entity.frog;

import com.unicamp.mc322.lab07.frogy.direction.Direction;
import com.unicamp.mc322.lab07.frogy.entity.map.item.food.Food;
import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;
import com.unicamp.mc322.lab07.frogy.position.Position;

public class PoisonousFrog extends Frog {
    public PoisonousFrog(Icon icon, Position initialPosition) {
        super(icon, initialPosition);
    }

    @Override
    public void move(Direction direction) {
        int randomDirIndex = (int) (Math.random() * Direction.values().length); // 0 to length-1
        Direction randomDirection = Direction.values()[randomDirIndex];

        switch (randomDirection) {
            case LEFT: move(currentPosition.left(moveAmount(randomDirection))); break;
            case RIGHT: move(currentPosition.right(moveAmount(randomDirection))); break;
            case DOWN: move(currentPosition.down(moveAmount(randomDirection))); break;
            case UP: move(currentPosition.up(moveAmount(randomDirection))); break;
        }
    }

    @Override
    public void eat(Food food) {
        this.satisfactionPoints += 1.2 * food.satisfactionPointsTotal();
    }

    @Override
    protected int moveAmount(Direction direction) {
        return 1 + (int) (Math.random() * 4); // 1, 2, 3 or 4
    }

    @Override
    public void interactWith(Frog frog) {
        frog.die();
    }
}
