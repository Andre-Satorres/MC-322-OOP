package com.unicamp.mc322.lab06.musicfy;

import java.time.LocalDateTime;

public abstract class Item {
    protected String name;
    protected final double duration;
    protected String artist;
    protected final double totalStorageMB;
    protected int episodesAmount;
    protected LocalDateTime createdOn;

    public Item(String name, double duration, String artist, int episodesAmount) {
        this.name = name;
        this.duration = duration;
        this.artist = artist;
        this.totalStorageMB = calcTotalStorageMB();
        this.episodesAmount = episodesAmount;
        this.createdOn = LocalDateTime.now();
    }

    protected abstract double calcTotalStorageMB();

    double getDuration() {
        return duration;
    }

    double getTotalStorageMB() {
        return totalStorageMB;
    }
}
