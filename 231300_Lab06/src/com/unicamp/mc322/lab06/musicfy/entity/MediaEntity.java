package com.unicamp.mc322.lab06.musicfy.entity;

public abstract class MediaEntity extends Item {
    protected double mbPerMinutes;

    public MediaEntity(String name, String artist, double durationSeconds, double mbPerMinutes) {
        super(name, artist, durationSeconds);
        this.mbPerMinutes = mbPerMinutes;
    }

    @Override
    protected abstract double getTotalStorageMB();

    protected double getDurationMinutes() {
        return durationSeconds / 60;
    }
}
