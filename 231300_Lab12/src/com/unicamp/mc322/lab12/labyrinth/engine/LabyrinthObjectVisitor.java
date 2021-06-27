package com.unicamp.mc322.lab12.labyrinth.engine;

import com.unicamp.mc322.lab12.labyrinth.entity.Checkpoint;
import com.unicamp.mc322.lab12.labyrinth.entity.Player;
import com.unicamp.mc322.lab12.labyrinth.entity.Wall;

public interface LabyrinthObjectVisitor {

    void visit(Player player);

    void visit(Wall wall);

    void visit(Checkpoint checkpoint);
}
