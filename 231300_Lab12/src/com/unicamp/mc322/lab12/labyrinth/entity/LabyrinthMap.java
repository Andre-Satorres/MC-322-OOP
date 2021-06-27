package com.unicamp.mc322.lab12.labyrinth.entity;

import com.unicamp.mc322.lab12.labyrinth.engine.LabyrinthObjectVisitor;

import java.util.ArrayList;
import java.util.List;

public class LabyrinthMap {

    private final Integer width;
    private final Integer height;
    private final Player player;
    private final List<Checkpoint> checkpoints;
    private final List<Wall> walls;

    protected LabyrinthMap(Integer width, Integer height, Player player, List<Checkpoint> checkpoints, List<Wall> walls) {
        if (width == null || height == null || width <= 0 || height <= 0) {
            throw new LabyrinthMapCreationException("Invalid LabyrinthMap width and/or height!");
        }

        if (player == null) {
            throw new LabyrinthMapCreationException("Invalid Player!");
        }

        if (checkpoints == null || checkpoints.isEmpty()) {
            throw new LabyrinthMapCreationException("There must be at least one checkpoint!");
        }

        if (walls == null) {
            throw new LabyrinthMapCreationException("Invalid Wall list!");
        }

        this.player = player;
        this.checkpoints = new ArrayList<>(checkpoints);
        this.walls = new ArrayList<>(walls);
        this.width = width;
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public void updateMap(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Invalid direction!");
        }

        try {
            player.move(direction, walls);
        } catch (PlayerMovementException exception) {
            return;
        }

        for (Checkpoint checkpoint : checkpoints) {
            if (checkpoint.isSameCoordinates(player)) {
                checkpoint.conquer();
            }
        }
    }

    public void accept(LabyrinthObjectVisitor visitor) {
        for (Wall wall : walls) {
            wall.accept(visitor);
        }

        for (Checkpoint checkpoint : checkpoints) {
            checkpoint.accept(visitor);
        }

        player.accept(visitor);
    }

    public Boolean isDone() {
        for (Checkpoint checkpoint : checkpoints) {
            if (!checkpoint.isConquered()) {
                return false;
            }
        }

        return true;
    }
}
