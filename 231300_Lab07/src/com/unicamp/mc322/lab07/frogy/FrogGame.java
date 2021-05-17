package com.unicamp.mc322.lab07.frogy;

import com.unicamp.mc322.lab07.frogy.command.Command;
import com.unicamp.mc322.lab07.frogy.direction.Direction;
import com.unicamp.mc322.lab07.frogy.entity.frog.FrogType;
import com.unicamp.mc322.lab07.frogy.entity.map.item.food.Food;
import com.unicamp.mc322.lab07.frogy.entity.map.item.food.FoodType;
import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;
import com.unicamp.mc322.lab07.frogy.entity.map.item.obstacle.ObstacleType;
import com.unicamp.mc322.lab07.frogy.exception.InvalidObstacleException;
import com.unicamp.mc322.lab07.frogy.exception.InvalidPositionException;
import com.unicamp.mc322.lab07.frogy.exception.MapCreationException;
import com.unicamp.mc322.lab07.frogy.io.FrogIO;
import com.unicamp.mc322.lab07.frogy.io.FrogKeyboardIO;
import com.unicamp.mc322.lab07.frogy.io.IOType;
import com.unicamp.mc322.lab07.frogy.position.Position;

import java.util.Arrays;
import java.util.Locale;

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
        showLagoon();

        frogIO.showMessage("Your all set " + playerName + "! Game starting ...! Have fun :)");
        frogIO.showMessage("Please, insert the direction you want your frog to move: ");
        Command command = frogIO.getCommand();

        while(command != Command.QUIT) {
            while (command == Command.UNKNOWN) {
                command = frogIO.getCommand();

                if (command == Command.QUIT) {
                    frogIO.showMessage("Quiting ...");
                    break;
                }
            }

            lagoon.moveFrog(toDirection(command));

            if (lagoon.isFrogDead()) {
                frogIO.showErrorMessage("You died! Game Over");
                break;
            }

            showLagoon();
            frogIO.showMessage("Please, insert the direction you want your frog to move: ");
            command = frogIO.getCommand();
        }

        endGame();
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

    private void endGame() {
        frogIO.showMessage("Final Points: " + lagoon.frogSatisfactionPoints());
    }

    private void createLagoon() {
        do {
            try {
                frogIO.showMessage("Let's begin with the Lagoon size:");
                Position size = getXY();
                frogIO.showMessage("Now, choose an icon for empty spaces.");
                Icon emptyItemIcon = frogIO.getIcon();
                this.lagoon = new Lagoon(size.getX(), size.getY(), emptyItemIcon);
                break;
            } catch (MapCreationException e) {
                frogIO.showErrorMessage("Error: " + e.getMessage());
                frogIO.showMessage("Please, reinsert the info!");
            }
        } while (true);

        insertObstacles();
        insertFood();
        createPlayer();
    }

    private void showLagoon() {
        frogIO.showLagoon(lagoon.getLagoon());
    }

    private void insertObstacles() {
        frogIO.showMessage("Now, let's insert the obstacles!");
        insertStones();
        insertPredators();
        insertTraps();
    }

    private void insertStones() {
        frogIO.showMessage("Let's insert some stones!");
        insertObstacleType(ObstacleType.STONE, false, null);
    }

    private void insertPredators() {
        frogIO.showMessage("Let's insert some predators!");
        insertObstacleType(ObstacleType.PREDATOR, true, "How many positions for this one (1/2): ");
    }

    private void insertTraps() {
        frogIO.showMessage("Let's insert some traps!");
        insertObstacleType(ObstacleType.TRAP, true, "How many positions for this one (1/2/3): ");
    }

    private void insertObstacleType(ObstacleType obstacleType, boolean canHaveMorePositions, String message) {
        Icon icon = frogIO.getIcon();
        int amount = frogIO.getInt("How many: ");

        for (int i=0; i<amount; i++) {
            frogIO.showMessage(obstacleType.name() + " " + (i + 1));

            do {
                try {
                    if (getUseRandom()) {
                        this.lagoon.addObstacle(icon, obstacleType);
                    } else {
                        int positionsAmount = canHaveMorePositions ? frogIO.getInt(message) : 1;
                        Position[] positions = getAllPositionsForObstacle(positionsAmount);
                        this.lagoon.addObstacle(icon, obstacleType, positions);
                    }

                    break;
                } catch (InvalidObstacleException e) {
                    frogIO.showErrorMessage("Error: " + e.getMessage());
                    frogIO.showMessage("Please, reinsert the positions...");
                }
            } while (true);
        }
    }

    private Position[] getAllPositionsForObstacle(int max) {
        Position[] positions = new Position[max];
        for (int j = 0; j< max; j++) {
            if (max > 1) {
                frogIO.showMessage("Position " + (j + 1));
            }

            Position newPosition = getFreePosition();
            if (Arrays.asList(positions).contains(newPosition)) {
                frogIO.showErrorMessage("You cannot pick the same position twice! Please choose other...");
                j--;
            } else {
                positions[j] = newPosition;
            }
        }

        return positions;
    }

    private Position getFreePosition() {
        Position p;
        do {
            p = getXY();

            try {
                if (lagoon.isPositionFree(p)) {
                    break;
                }

                frogIO.showErrorMessage("This position is already in use! Please choose a new one...");
            } catch (InvalidPositionException e) {
                frogIO.showErrorMessage("Position out of bounds! Please choose a new one...");
            }
        } while (true);

        return p;
    }

    private void insertFood() {
        frogIO.showMessage("Now, let's insert the food!");
        insertCrickets();
        insertFireflies();
    }

    private void insertCrickets() {
        frogIO.showMessage("Let's insert some cricket!");
        insertFoodType(FoodType.CRICKET);
    }

    private void insertFireflies() {
        frogIO.showMessage("Let's insert some firefly!");
        insertFoodType(FoodType.FIREFLY);
    }

    private void insertFoodType(FoodType foodType) {
        Icon icon = frogIO.getIcon();
        int amount = frogIO.getInt("How many: ");

        for (int i=0; i<amount; i++) {
            frogIO.showMessage(foodType.name() + " " + (i + 1));

            if (getUseRandom()) {
                this.lagoon.addFood(icon, foodType);
            } else {
                this.lagoon.addFood(icon, foodType, getFreePosition());
            }
        }
    }

    private void createPlayer() {
        frogIO.showMessage("Finally, let's insert the player!");
        int frogType = frogIO.getFrogType();
        Icon frogIcon = frogIO.getIcon();

        if (getUseRandom()) {
            this.lagoon.generateFrog(frogIcon, getFrogTypeEnum(frogType));
        } else {
            frogIO.showMessage("In which position do you want to start? ");
            this.lagoon.generateFrog(frogIcon, getFrogTypeEnum(frogType), getFreePosition());
        }

    }

    private FrogType getFrogTypeEnum(int value) {
        return FrogType.values()[value-1];
    }

    private Position getXY() {
        int x = frogIO.getInt("X: ");
        int y = frogIO.getInt("Y: ");
        return new Position(x, y);
    }

    private boolean getUseRandom() {
        return frogIO.getYes("Do you want to use a random position?");
    }
}
