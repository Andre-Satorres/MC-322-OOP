package com.unicamp.mc322.lab07.frog.entity;

import com.unicamp.mc322.lab07.frog.exception.InvalidPositionException;
import com.unicamp.mc322.lab07.frog.exception.MapCreationException;
import com.unicamp.mc322.lab07.frog.position.Position;

public class Map {
    private final int width;
    private final int height;

    public Map(int width, int height) {
        if (width <= 0) {
            throw new MapCreationException("Invalid width. It must be greater than 0!");
        }

        if (height <= 0) {
            throw new MapCreationException("Invalid height. It must be greater than 0!");
        }

        this.width = width;
        this.height = height;
    }

    private void checkBounds(Position position) {
        if (position.getX() < 0 || position.getX() >= width || position.getY() < 0 || position.getY() >= height) {
            throw new InvalidPositionException("This position is out of bounds!");
        }
    }
}
