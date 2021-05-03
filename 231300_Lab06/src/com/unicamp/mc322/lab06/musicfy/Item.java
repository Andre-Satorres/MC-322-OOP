package com.unicamp.mc322.lab06.musicfy;

import java.time.LocalDateTime;

public abstract class Item {
    protected String name;
    protected String artist;
    protected double durationSeconds;
    protected LocalDateTime createdOn;

    public Item(String name, String artist, double durationSeconds) {
        this.name = name;
        this.artist = artist;
        this.durationSeconds = durationSeconds;
        this.createdOn = LocalDateTime.now();
    }

    protected abstract double getTotalStorageMB();

    public double getDurationSeconds() {
        return durationSeconds;
    }
}
