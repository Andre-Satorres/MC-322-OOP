package com.unicamp.mc322.lab06.musicfy;

public abstract class MediaEntity extends Item {
    protected double mbPerMinutes;
    protected double durationSeconds;

    public MediaEntity(String name, String artist, double durationSeconds, double mbPerMinutes) {
        super(name, artist, durationSeconds);
        this.mbPerMinutes = mbPerMinutes;
    }

    @Override
    protected abstract double calcTotalStorageMB();

    protected double getDurationMinutes() {
        return durationSeconds / 60;
    }
}
