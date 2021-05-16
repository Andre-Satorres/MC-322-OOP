package com.unicamp.mc322.lab07.frogy.entity.map.item.food;

import com.unicamp.mc322.lab07.frogy.entity.map.item.icon.Icon;

public class Firefly extends Food {
    public Firefly(Icon icon) {
        super(icon);
    }

    @Override
    public int satisfactionPointsTotal() {
        return 15;
    }
}
