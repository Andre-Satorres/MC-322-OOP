package com.unicamp.mc322.lab07.frogy.entity.map.item;

import com.unicamp.mc322.lab07.frogy.entity.frog.Frog;
import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;

public class EmptyItem extends MapItem {

    public EmptyItem(Icon icon) {
        super(icon);
    }

    @Override
    public void interactWith(Frog frog) { }
}
