package com.unicamp.mc322.lab06.musicfy.entity;

import java.time.LocalDateTime;

public abstract class Item {
    protected String name;
    protected String artist;
    protected double durationSeconds;

    public Item(String name, String artist, double durationSeconds) {
        this.name = name;
        this.artist = artist;
        this.durationSeconds = durationSeconds;
    }

    protected abstract double getTotalStorageMB();

    public double getDurationSeconds() {
        return durationSeconds;
    }
}
