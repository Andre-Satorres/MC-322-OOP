package com.unicamp.mc322.lab07.frogy.entity.map.item.obstacle;

import com.unicamp.mc322.lab07.frogy.entity.frog.Frog;
import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;
import com.unicamp.mc322.lab07.frogy.entity.map.item.MapItem;
import com.unicamp.mc322.lab07.frogy.position.Position;


public class Obstacle extends MapItem {
    private Position[] positions;

    public Obstacle(Icon icon, Position ... positions) {
        super(icon);
        this.positions = new Position[positions.length];
    }

    @Override
    public void interactWith(Frog frog) {
        frog.die();
    }
}
