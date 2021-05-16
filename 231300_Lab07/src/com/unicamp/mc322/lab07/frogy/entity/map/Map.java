package com.unicamp.mc322.lab07.frogy.entity.map;

import com.unicamp.mc322.lab07.frogy.entity.map.item.EmptyItem;
import com.unicamp.mc322.lab07.frogy.entity.map.item.MapItem;
import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;
import com.unicamp.mc322.lab07.frogy.exception.InvalidPositionException;
import com.unicamp.mc322.lab07.frogy.exception.MapCreationException;
import com.unicamp.mc322.lab07.frogy.position.Position;

public class Map {
    private final int width;
    private final int height;
    private final MapItem[][] map;

    private void initializeMap(Icon icon) {
        for (int i=0; i<width; i++) {
            for (int j=0; j<height; j++) {
                map[i][j] = new EmptyItem(icon);
            }
        }
    }

    public Map(int width, int height, Icon emptyItemIcon) {
        if (width <= 0) {
            throw new MapCreationException("Invalid width. It must be greater than 0!");
        }

        if (height <= 0) {
            throw new MapCreationException("Invalid height. It must be greater than 0!");
        }

        this.width = width;
        this.height = height;
        this.map = new MapItem[width][height];
        initializeMap(emptyItemIcon);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isInvalid(Position position) {
        try {
            checkBounds(position);
            return false;
        } catch (InvalidPositionException e) {
            return true;
        }
    }

    private void checkBounds(Position position) {
        if (position == null || position.getX() < 0 || position.getX() >= width || position.getY() < 0 || position.getY() >= height) {
            throw new InvalidPositionException("This position is out of bounds!");
        }
    }

    public MapItem getItem(Position position) {
        this.checkBounds(position);
        return this.map[position.getX()][position.getY()];
    }

    public void setItem(Position position, MapItem item) {
        this.checkBounds(position);
        this.map[position.getX()][position.getY()] = item;
    }

    public void removeItem(Position position, Icon emptyIcon) {
        this.checkBounds(position);
        this.map[position.getX()][position.getY()] = new EmptyItem(emptyIcon);
    }
}
