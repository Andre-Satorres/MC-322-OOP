package com.unicamp.mc322.lab07.frogy.entity.map.item.food;

import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;

public class Cricket extends Food {
    public Cricket(Icon icon) {
        super(icon);
    }

    @Override
    public int satisfactionPointsTotal() {
        return 20;
    }
}
