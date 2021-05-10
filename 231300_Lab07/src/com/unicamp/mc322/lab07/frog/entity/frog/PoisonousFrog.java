package com.unicamp.mc322.lab07.frog.entity.frog;

import com.unicamp.mc322.lab07.frog.direction.Direction;
import com.unicamp.mc322.lab07.frog.position.Position;

public class PoisonousFrog extends Frog {
    public PoisonousFrog(Position initialPosition) {
        super(FrogType.POISONOUS, initialPosition);
    }

    @Override
    public void move(Direction direction) {
        int randomDirIndex = (int) (Math.random() * Direction.values().length); // 0 to length-1
        Direction randomDirection = Direction.values()[randomDirIndex];

        switch (randomDirection) {
            case LEFT: move(currentPosition.left(moveAmount(randomDirection)));
            case RIGHT: move(currentPosition.right(moveAmount(randomDirection)));
            case DOWN: move(currentPosition.down(moveAmount(randomDirection)));
            case UP: move(currentPosition.up(moveAmount(randomDirection)));
        }
    }

    @Override
    protected int moveAmount(Direction direction) {
        return 1 + (int) (Math.random() * 4); // 1, 2, 3 or 4
    }
}
