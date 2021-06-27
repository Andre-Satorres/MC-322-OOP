package com.unicamp.mc322.lab12.labyrinth.engine;

import com.unicamp.mc322.lab12.labyrinth.entity.*;

class TextRenderManager implements LabyrinthObjectVisitor {

    private final char[][] charMap;

    TextRenderManager(Integer width, Integer height) {
        this.charMap = new char[width][height];
    }

    public void render(LabyrinthMap map) {
        clearMap();
        map.accept(this);
        printMap();
    }

    private void clearMap() {
        for (int i = 0; i < charMap.length; i++) {
            for (int j = 0; j < charMap[0].length; j++) {
                charMap[i][j] = ' ';
            }
        }
    }

    private void printMap() {
        for (char[] chars : charMap) {
            for (int j = 0; j < charMap[0].length; j++) {
                System.out.print(chars[j] + " ");
            }

            System.out.println();
        }
    }

    private void setSymbol(LabyrinthObject obj, char character) {
        charMap[obj.getY()][obj.getX()] = character;
    }

    @Override
    public void visit(Player player) {
        setSymbol(player, 'P');
    }

    @Override
    public void visit(Wall wall) {
        setSymbol(wall, 'X');
    }

    @Override
    public void visit(Checkpoint checkpoint) {
        if (checkpoint.isConquered()) {
            setSymbol(checkpoint, 'T');
        } else {
            setSymbol(checkpoint, 'C');
        }
    }
}
