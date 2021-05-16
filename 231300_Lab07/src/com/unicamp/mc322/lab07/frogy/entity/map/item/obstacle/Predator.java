package com.unicamp.mc322.lab07.frogy.entity.map.item.obstacle;

import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;
import com.unicamp.mc322.lab07.frogy.position.Position;

public class Predator extends Obstacle {

    public Predator(Icon icon, Position p1) {
        super(icon, p1);
    }

    public Predator(Icon icon, Position p1, Position p2) {
        super(icon, p1, p2);

        if (!p1.isNeighbourOf(p2)) {
            throw new IllegalArgumentException("The Predator positions must be neighbours!");
        }
    }
}
