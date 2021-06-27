package com.unicamp.mc322.lab12.labyrinth.engine;

import com.unicamp.mc322.lab12.labyrinth.entity.Direction;
import com.unicamp.mc322.lab12.labyrinth.entity.LabyrinthMap;

import java.util.Scanner;

public class TextGameEngine extends GameEngine {

    private final TextRenderManager renderManager;

    public TextGameEngine(LabyrinthMap labyrinthMap) {
        super(labyrinthMap);
        this.renderManager = new TextRenderManager(labyrinthMap.getWidth(), labyrinthMap.getHeight());
    }

    public Direction readCommandFromKeyboard(Scanner scanner) {
        for (;;) {
            String in = scanner.next().trim().toUpperCase();

            switch (in) {
                case "A":
                    return Direction.LEFT;
                case "W":
                    return Direction.UP;
                case "D":
                    return Direction.RIGHT;
                case "S":
                    return Direction.DOWN;
            }

            System.out.println("Invalid direction! Please retype.");
        }
    }

    @Override
    public void gameLoop() {
        Scanner scanner = new Scanner(System.in);
        LabyrinthMap map = getLabyrinthMap();
        Direction newDirection;

        while (!map.isDone()) {
            renderManager.render(map);
            newDirection = readCommandFromKeyboard(scanner);
            map.updateMap(newDirection);
        }

        System.out.println("Labyrinth completed! Congrats!!");
        scanner.close();
    }
}
