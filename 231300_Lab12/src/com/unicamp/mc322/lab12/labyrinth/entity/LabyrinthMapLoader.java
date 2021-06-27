package com.unicamp.mc322.lab12.labyrinth.entity;

import java.util.Arrays;

public class LabyrinthMapLoader {
    private static final LabyrinthMapLoader INSTANCE = new LabyrinthMapLoader();

    private LabyrinthMapLoader() { }

    public static LabyrinthMapLoader getInstance() {
        return INSTANCE;
    }

    public LabyrinthMap loadMapFromFile(String path) {
        return null;
    }

    public LabyrinthMap createDefaultMap() {
        return new LabyrinthMap(
                4,
                4,
                new Player(0, 0),
                Arrays.asList(new Checkpoint(1, 2), new Checkpoint(3, 3)),
                Arrays.asList(new Wall(1, 0), new Wall(1, 1), new Wall(1, 3), new Wall(3, 2))
        );

        /*
        _________
        | P W   |
        |   W   |
        |   C  W|
        |   W  C|
        ---------
        */
    }
}
