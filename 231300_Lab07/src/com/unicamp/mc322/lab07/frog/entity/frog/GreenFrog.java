package com.unicamp.mc322.lab07.frog.entity.frog;

import com.unicamp.mc322.lab07.frog.direction.Direction;
import com.unicamp.mc322.lab07.frog.position.Position;

public class GreenFrog extends Frog {
    public GreenFrog(Position initialPosition) {
        super(FrogType.GREEN, initialPosition);
    }

    @Override
    protected int moveAmount(Direction direction) {
        return 1;
    }
}
