package com.unicamp.mc322.lab06.musicfy;

public class Song extends MediaEntity {
    private static final double SIZE_PER_MINUTES_MB = 5;

    public Song(String name, String artist, double durationSeconds) {
        super(name, artist, durationSeconds, SIZE_PER_MINUTES_MB);
    }

    @Override
    protected double calcTotalStorageMB() {
        return mbPerMinutes * getDurationMinutes();
    }
}
