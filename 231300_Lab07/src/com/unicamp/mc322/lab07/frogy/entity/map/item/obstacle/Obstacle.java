package com.unicamp.mc322.lab07.frogy.entity.map.item.obstacle;

import com.unicamp.mc322.lab07.frogy.entity.frog.Frog;
import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;
import com.unicamp.mc322.lab07.frogy.entity.map.item.MapItem;
import com.unicamp.mc322.lab07.frogy.position.Position;

import java.util.List;

public class Obstacle extends MapItem {
    protected Icon icon;
    private List<Position> positions;

    public Obstacle(Icon icon, List<Position> positions) {
        this.icon = icon;
        this.positions = positions;
    }

    @Override
    public void interactWith(Frog frog) {
        frog.die();
    }
}
