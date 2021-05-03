package com.unicamp.mc322.lab06.musicfy;

public class Song extends Item {
    private final double SIZE_PER_MINUTES_MB = 5;

    public Song(String name, double duration, String artist, int episodesAmount) {
        super(name, duration, artist, episodesAmount);
    }

    @Override
    protected double calcTotalStorageMB() {
        return this.duration * SIZE_PER_MINUTES_MB;
    }
}
