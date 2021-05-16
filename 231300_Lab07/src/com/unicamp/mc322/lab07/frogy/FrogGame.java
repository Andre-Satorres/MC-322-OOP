package com.unicamp.mc322.lab07.frogy;

import com.unicamp.mc322.lab07.frogy.command.Command;
import com.unicamp.mc322.lab07.frogy.direction.Direction;
import com.unicamp.mc322.lab07.frogy.entity.frog.FrogType;
import com.unicamp.mc322.lab07.frogy.entity.map.item.food.FoodType;
import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;
import com.unicamp.mc322.lab07.frogy.entity.map.item.obstacle.ObstacleType;
import com.unicamp.mc322.lab07.frogy.io.FrogIO;
import com.unicamp.mc322.lab07.frogy.io.FrogKeyboardIO;
import com.unicamp.mc322.lab07.frogy.io.IOType;
import com.unicamp.mc322.lab07.frogy.position.Position;

public class FrogGame {
    private FrogIO frogIO;
    private String playerName;
    private Lagoon lagoon;

    public FrogGame(IOType ioType) {
        if (ioType == IOType.CONSOLE) {
            frogIO = new FrogKeyboardIO();
        }
    }

    public void start() {
        initialize();
        createLagoon();

        frogIO.showMessage("Your all set " + playerName + "! game starting! Have fun :)");
        Command command = frogIO.getCommand();

        while(command != Command.QUIT) {
            while (command == Command.UNKNOWN) {
                command = frogIO.getCommand();

                if (command == Command.QUIT) {
                    break;
                }
            }

            lagoon.moveFrog(toDirection(command));
        }
    }

    private static Direction toDirection(Command command) {
        switch (command) {
            case UP: return Direction.UP;
            case DOWN: return Direction.DOWN;
            case LEFT: return Direction.LEFT;
            case RIGHT: return Direction.RIGHT;
            default: return null;
        }
    }

    private void initialize() {
        frogIO.banner();
        playerName = frogIO.getPlayerName();
        frogIO.welcomeMessage(playerName);
    }

    private void createLagoon() {
        frogIO.showMessage("Let's begin with the Lagoon size:");
        Position size = getXY();
        Icon emptyItemIcon = frogIO.getIcon();
        this.lagoon = new Lagoon(size.getX(), size.getY(), emptyItemIcon);
        insertObstacles();
        insertFood();
        createPlayer();
    }

    private void insertObstacles() {
        frogIO.showMessage("Now, let's insert the obstacles!");
        insertStones();
        insertPredators();
        insertTraps();
    }

    private void insertStones() {
        frogIO.showMessage("Let's insert some stones!");
        Icon stoneIcon = frogIO.getIcon();
        int amount = frogIO.getInt("How many: ");

        for (int i=0; i<amount; i++) {
            this.lagoon.addObstacle(stoneIcon, ObstacleType.STONE, getXY());
        }
    }

    private void insertPredators() {
        frogIO.showMessage("Let's insert some predators!");
        Icon predatorIcon = frogIO.getIcon();
        int amount = frogIO.getInt("How many: ");

        for (int i=0; i<amount; i++) {
            int positionsAmount = frogIO.getInt("How many positions for this one (1/2): ");
            Position[] positions = new Position[positionsAmount];
            for (int j=0; j<positionsAmount; j++) {
                positions[j] = getXY();
            }
            this.lagoon.addObstacle(predatorIcon, ObstacleType.PREDATOR, positions);
        }
    }

    private void insertTraps() {
        frogIO.showMessage("Let's insert some traps!");
        Icon trapIcon = frogIO.getIcon();
        int amount = frogIO.getInt("How many: ");

        for (int i=0; i<amount; i++) {
            int positionsAmount = frogIO.getInt("How many positions for this one (1/2/3): ");
            Position[] positions = new Position[positionsAmount];
            for (int j=0; j<positionsAmount; j++) {
                positions[j] = getXY();
            }
            this.lagoon.addObstacle(trapIcon, ObstacleType.PREDATOR, positions);
        }
    }

    private void insertFood() {
        frogIO.showMessage("Now, let's insert the food!");
        insertCrickets();
        insertFireflies();
    }

    private void insertCrickets() {
        frogIO.showMessage("Let's insert some cricket!");
        Icon cricketIcon = frogIO.getIcon();
        int amount = frogIO.getInt("How many: ");

        for (int i=0; i<amount; i++) {
            this.lagoon.addFood(cricketIcon, FoodType.CRICKET, getXY());
        }
    }

    private void insertFireflies() {
        frogIO.showMessage("Let's insert some firefly!");
        Icon fireflyIcon = frogIO.getIcon();
        int amount = frogIO.getInt("How many: ");

        for (int i=0; i<amount; i++) {
            this.lagoon.addFood(fireflyIcon, FoodType.FIREFLY, getXY());
        }
    }

    private void createPlayer() {
        frogIO.showMessage("Finally, let's insert the player!");
        int frogType = frogIO.getFrogType();
        Icon frogIcon = frogIO.getIcon();
        this.lagoon.generateFrog(frogIcon, getFrogTypeEnum(frogType), getXY());
    }

    private FrogType getFrogTypeEnum(int value) {
        return FrogType.values()[value-1];
    }

    private Position getXY() {
        int x = frogIO.getInt("X: ");
        int y = frogIO.getInt("Y: ");
        return new Position(x, y);
    }
}
