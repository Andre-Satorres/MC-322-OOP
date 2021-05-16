package com.unicamp.mc322.lab07.frogy;

import com.unicamp.mc322.lab07.frogy.direction.Direction;
import com.unicamp.mc322.lab07.frogy.entity.frog.*;
import com.unicamp.mc322.lab07.frogy.entity.map.Map;
import com.unicamp.mc322.lab07.frogy.entity.map.item.MapItem;
import com.unicamp.mc322.lab07.frogy.entity.map.item.food.Cricket;
import com.unicamp.mc322.lab07.frogy.entity.map.item.food.Firefly;
import com.unicamp.mc322.lab07.frogy.entity.map.item.food.Food;
import com.unicamp.mc322.lab07.frogy.entity.map.item.food.FoodType;
import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;
import com.unicamp.mc322.lab07.frogy.entity.map.item.obstacle.*;
import com.unicamp.mc322.lab07.frogy.exception.InvalidObstacleException;
import com.unicamp.mc322.lab07.frogy.position.Position;

import java.util.StringJoiner;

public class Lagoon {
    private Frog frog;
    private final Map map;
    private final Icon emptyItemIcon;

    public Lagoon(int mapWidth, int mapHeight, Icon emptyItemIcon) {
        this.map = new Map(mapWidth, mapHeight, emptyItemIcon);
        this.frog = null;
        this.emptyItemIcon = emptyItemIcon;
    }

    public void generateFrog(Icon frogIcon, FrogType frogType, Position frogInitialPosition) {
        this.frog = frogFactory(frogIcon, frogType, frogInitialPosition);
        this.map.setItem(frogInitialPosition, frog);
    }

    private static Frog frogFactory(Icon icon, FrogType frogType, Position initialPosition) {
        switch (frogType) {
            case GREEN: return new GreenFrog(icon, initialPosition);
            case TOMATO: return new TomatoFrog(icon, initialPosition);
            case POISONOUS: return new PoisonousFrog(icon, initialPosition);
            default: return null;
        }
    }

    private static Food foodFactory(Icon icon, FoodType foodType) {
        switch (foodType) {
            case CRICKET: return new Cricket(icon);
            case FIREFLY: return new Firefly(icon);
            default: return null;
        }
    }

    private static Obstacle obstacleFactory(Icon icon, ObstacleType obstacleType, Position... positions) {
        switch (obstacleType) {
            case STONE: {
                if (positions.length == 1) {
                    return new Stone(icon, positions[0]);
                }
                throw new InvalidObstacleException("Stone must be in only one Position!");
            }
            case PREDATOR: {
                switch (positions.length) {
                    case 1:
                        return new Predator(icon, positions[0]);
                    case 2:
                        return new Predator(icon, positions[0], positions[1]);
                    default:
                        throw new InvalidObstacleException("Predator must be in one or two Positions!");
                }
            }
            case TRAP: {
                switch (positions.length) {
                    case 1:
                        return new Trap(icon, positions[0]);
                    case 2:
                        return new Trap(icon, positions[0], positions[1]);
                    case 3:
                        return new Trap(icon, positions[0], positions[1], positions[2]);
                    default:
                        throw new InvalidObstacleException("Trap must be in one or two or three Positions!");
                }
            }
            default: return null;
        }
    }

    public boolean isFrogDead() {
        return !frog.isAlive();
    }

    public void moveFrog(Direction direction) {
        frog.move(direction);
        Position currentFrogPosition = frog.getCurrentPosition();

        if (map.isInvalid(currentFrogPosition)) {
            frog.die();
            return;
        }

        map.getItem(currentFrogPosition).interactWith(frog);
        map.removeItem(currentFrogPosition, emptyItemIcon);
        map.removeItem(frog.getLastPosition(), emptyItemIcon);
        map.setItem(currentFrogPosition, frog);
    }

    public void addFood(Icon icon, FoodType foodType, Position position) {
        Food newFood = foodFactory(icon, foodType);
        createItem(newFood, position);
    }

    public void addFood(Icon icon, FoodType foodType) {
        Food newFood = foodFactory(icon, foodType);
        createItem(newFood);
    }

    public void addObstacle(Icon icon, ObstacleType obstacleType, Position ... positions) {
        Obstacle obstacle = obstacleFactory(icon, obstacleType, positions);

        for (Position p : positions) {
            createItem(obstacle, p);
        }
    }

    public void addObstacle(Icon icon, ObstacleType obstacleType) {
        Position position = randomMapPosition();
        Obstacle obstacle = obstacleFactory(icon, obstacleType, position);
        createItem(obstacle);
    }

    private void createItem(MapItem item) {
        this.map.setItem(randomMapPosition(), item);
    }

    private void createItem(MapItem item, Position position) {
        this.map.setItem(position, item);
    }

    private Position randomMapPosition() {
        return Position.random(map.getWidth(), map.getHeight());
    }

    public Map getLagoon() {
        return map;
    }
}
