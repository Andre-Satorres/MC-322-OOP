package com.unicamp.mc322.lab06.musicfy;

public class Video extends MediaEntity {
    private int pixelAmount;
    private int fps;
    private static final double SIZE_PER_MINUTES_MB = 5;

    public Video(String name, String artist, double durationSeconds) {
        super(name, artist, durationSeconds, SIZE_PER_MINUTES_MB);
    }

    @Override
    protected double calcTotalStorageMB() {
        return (fps * pixelAmount + mbPerMinutes) * getDurationMinutes();
    }
}
