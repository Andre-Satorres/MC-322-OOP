package com.unicamp.mc322.lab07.frog.entity.frog;

import com.unicamp.mc322.lab07.frog.direction.Direction;
import com.unicamp.mc322.lab07.frog.position.Position;

public class TomatoFrog extends Frog {

    public TomatoFrog(Position initialPosition) {
        super(FrogType.TOMATO, initialPosition);
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
}
