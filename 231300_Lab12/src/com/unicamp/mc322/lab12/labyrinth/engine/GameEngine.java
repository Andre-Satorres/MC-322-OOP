package com.unicamp.mc322.lab12.labyrinth.engine;

import com.unicamp.mc322.lab12.labyrinth.entity.LabyrinthMap;

public abstract class GameEngine {
    private final LabyrinthMap labyrinthMap;

    public GameEngine(LabyrinthMap labyrinthMap) {
        if (labyrinthMap == null) {
            throw new IllegalArgumentException("Invalid Labyrinth Map!");
        }

        this.labyrinthMap = labyrinthMap;
    }

    protected LabyrinthMap getLabyrinthMap() {
        return labyrinthMap;
    }

    public abstract void gameLoop();
}
