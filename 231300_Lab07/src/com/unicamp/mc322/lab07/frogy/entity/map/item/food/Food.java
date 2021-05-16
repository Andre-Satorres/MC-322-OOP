package com.unicamp.mc322.lab07.frogy.entity.map.item.food;

import com.unicamp.mc322.lab07.frogy.entity.frog.Frog;
import com.unicamp.mc322.lab07.frogy.entity.map.item.MapItem;
import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;

public abstract class Food extends MapItem {
    public Food(Icon icon) {
        super(icon);
    }

    @Override
    public void interactWith(Frog frog) {
        frog.eat(this);
    }

    public abstract int satisfactionPointsTotal();
}
