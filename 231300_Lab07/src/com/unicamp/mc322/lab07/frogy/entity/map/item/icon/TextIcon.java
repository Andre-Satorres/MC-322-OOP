package com.unicamp.mc322.lab07.frogy.entity.map.item.icon;

public class TextIcon extends Icon {
    private final String text;

    public TextIcon(String text) {
        this.text = text;
    }

    @Override
    public Object getRepresentation() {
        return text;
    }
}
