package com.unicamp.mc322.lab07.frogy.entity.frog;

import com.unicamp.mc322.lab07.frogy.direction.Direction;
import com.unicamp.mc322.lab07.frogy.entity.map.item.food.Food;
import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;
import com.unicamp.mc322.lab07.frogy.position.Position;

public class TomatoFrog extends Frog {

    public TomatoFrog(Icon icon, Position initialPosition) {
        super(icon, initialPosition);
    }

    @Override
    public void eat(Food food) {
        this.satisfactionPoints += 1.1 * food.satisfactionPointsTotal();
    }

    @Override
    protected int moveAmount(Direction direction) {
        switch (direction) {
            case LEFT:
            case RIGHT:
                return 1 + (int) (Math.random() * 3); // 1, 2 or 3
            case UP:
                return 2 + (int) (Math.random() * 2); // 2 or 3
            case DOWN:
                boolean get4 = (int) (Math.random() * 2) == 0 ? Boolean.FALSE : Boolean.TRUE;
                return get4 ? 4 : 1 + (int) (Math.random() * 2); // 1, 2 or 4
            default:
                return 1; // never should get here
        }
    }

    @Override
    public void interactWith(Frog frog) {
        this.die();
        frog.die();
    }
}
