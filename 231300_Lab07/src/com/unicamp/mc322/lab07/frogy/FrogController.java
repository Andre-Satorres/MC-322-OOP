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
import com.unicamp.mc322.lab07.frogy.entity.map.item.obstacle.Obstacle;
import com.unicamp.mc322.lab07.frogy.position.Position;

public class FrogController {
    private final Frog frog;
    private final Map map;

    private static Frog frogFactory(Icon icon, FrogType frogType, Position initialPosition) {
        return switch (frogType) {
            case GREEN -> new GreenFrog(icon, initialPosition);
            case TOMATO -> new TomatoFrog(icon, initialPosition);
            case POISONOUS -> new PoisonousFrog(icon, initialPosition);
        };
    }

    private static Food foodFactory(Icon icon, FoodType foodType) {
        return switch (foodType) {
            case CRICKET -> new Cricket(icon);
            case FIREFLY -> new Firefly(icon);
        };
    }

    public FrogController(int mapWidth, int mapHeight, Icon frogIcon, FrogType frogType, Position frogInitialPosition) {
        this.map = new Map(mapWidth, mapHeight);
        this.frog = frogFactory(frogIcon, frogType, frogInitialPosition);
    }

    public void moveFrog(Direction direction) {
        frog.move(direction);
        Position currentFrogPosition = frog.getCurrentPosition();

        if (map.isInvalid(currentFrogPosition)) {
            frog.die();
        }

        map.getItem(currentFrogPosition).interactWith(frog);
    }

    public void addFood(Icon icon, FoodType foodType, Position position) {
        Food newFood = foodFactory(icon, foodType);
        createItem(newFood, position);
    }

    public void addFood(Icon icon, FoodType foodType) {
        Food newFood = foodFactory(icon, foodType);
        createItem(newFood);
    }

    private void createItem(MapItem item) {
        Position position = new Position((int) (Math.random() * map.getWidth()), (int) (Math.random() * map.getHeight()));
        this.map.setItem(position, item);
    }

    private void createItem(MapItem item, Position position) {
        this.map.setItem(position, item);
    }
}
