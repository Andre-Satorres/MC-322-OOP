package com.unicamp.mc322.lab07.frog.entity.obstacle;

import com.unicamp.mc322.lab07.frog.entity.icon.Icon;
import com.unicamp.mc322.lab07.frog.position.Position;

import java.util.List;

public class Obstacle {
    protected Icon icon;
    private ObstacleType type;
    private List<Position> positions;
    private int maxPositions;

    public Obstacle(Icon icon, ObstacleType type, List<Position> positions, int maxPositions) {
        this.icon = icon;
        this.type = type;
        this.positions = positions;
        this.maxPositions = maxPositions;
    }
}
