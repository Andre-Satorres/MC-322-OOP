package com.unicamp.mc322.lab07.frogy.entity.map.item;

import com.unicamp.mc322.lab07.frogy.entity.frog.Frog;
import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;

public abstract class MapItem {
    protected Icon icon;

    public MapItem(Icon icon) {
        this.icon = icon;
    }

    public abstract void interactWith(Frog frog);
}
