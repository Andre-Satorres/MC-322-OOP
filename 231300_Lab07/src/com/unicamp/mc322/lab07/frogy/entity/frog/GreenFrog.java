package com.unicamp.mc322.lab07.frogy.entity.frog;

import com.unicamp.mc322.lab07.frogy.direction.Direction;
import com.unicamp.mc322.lab07.frogy.entity.map.item.food.Food;
import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;
import com.unicamp.mc322.lab07.frogy.position.Position;

public class GreenFrog extends Frog {
    public GreenFrog(Icon icon, Position initialPosition) {
        super(icon, initialPosition);
    }

    @Override
    public void eat(Food food) {
        this.satisfactionPoints += food.satisfactionPointsTotal();
    }

    @Override
    protected int moveAmount(Direction direction) {
        return 1;
    }
}
