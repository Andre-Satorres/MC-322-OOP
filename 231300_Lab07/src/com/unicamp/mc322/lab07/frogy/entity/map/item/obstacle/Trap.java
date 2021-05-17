package com.unicamp.mc322.lab07.frogy.entity.map.item.obstacle;

import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;
import com.unicamp.mc322.lab07.frogy.exception.InvalidObstacleException;
import com.unicamp.mc322.lab07.frogy.position.Position;

public class Trap extends Obstacle {
    private static final double maxDistance = 2;

    public Trap(Icon icon, Position p1) {
        super(icon, p1);
    }

    public Trap(Icon icon, Position p1, Position p2) {
        super(icon, p1, p2);

        if (p1.manhattanDistanceTo(p2) > maxDistance) {
            throw new InvalidObstacleException("The Manhattan distance of the Positions must be at least " + maxDistance);
        }
    }

    public Trap(Icon icon, Position p1, Position p2, Position p3) {
        super(icon, p1, p2, p3);

        if (p1.manhattanDistanceTo(p2) > maxDistance || p1.manhattanDistanceTo(p3) > maxDistance || p2.manhattanDistanceTo(p3) > maxDistance) {
            throw new InvalidObstacleException("The Manhattan distance of the Positions must be less then " + maxDistance);
        }
    }
}
