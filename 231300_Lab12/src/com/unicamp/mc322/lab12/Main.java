package com.unicamp.mc322.lab12;

import com.unicamp.mc322.lab12.labyrinth.engine.GameEngine;
import com.unicamp.mc322.lab12.labyrinth.engine.TextGameEngine;
import com.unicamp.mc322.lab12.labyrinth.entity.LabyrinthMap;
import com.unicamp.mc322.lab12.labyrinth.entity.LabyrinthMapLoader;

public class Main {

    private static void runGame(GameEngine gameEngine) {
        gameEngine.gameLoop();
    }

    public static void main(String[] args) {
        LabyrinthMap map = LabyrinthMapLoader.getInstance().createDefaultMap();
        runGame(new TextGameEngine(map));
    }
}
