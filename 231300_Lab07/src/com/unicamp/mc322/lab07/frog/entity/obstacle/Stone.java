package com.unicamp.mc322.lab07.frog.entity.obstacle;

import com.unicamp.mc322.lab07.frog.entity.icon.Icon;
import com.unicamp.mc322.lab07.frog.entity.icon.TextIcon;
import com.unicamp.mc322.lab07.frog.position.Position;


public class Stone extends Obstacle {
    private static final int MAX_POSITIONS = 1;
    private static Icon icon2 = new TextIcon("--");

    public Stone(Icon icon, Position position) {
        icon2 = icon;
        super(icon, ObstacleType.STONE, position, MAX_POSITIONS);
    }
}
