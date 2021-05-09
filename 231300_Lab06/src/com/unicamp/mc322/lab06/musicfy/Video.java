package com.unicamp.mc322.lab06.musicfy;

public class Video extends MediaEntity {
    private final int pixelAmount;
    private final int fps;
    private static final double SIZE_PER_MINUTES_MB = 5;

    public Video(String name, String artist, double durationSeconds, int pixelAmount, int fps) {
        super(name, artist, durationSeconds, SIZE_PER_MINUTES_MB);
        this.pixelAmount = pixelAmount;
        this.fps = fps;
    }

    @Override
    protected double getTotalStorageMB() {
        return (fps * pixelAmount + mbPerMinutes) * getDurationMinutes();
    }

    @Override
    public String toString() {
        return String.format("(Video - %s - %s - %ss", name, artist, durationSeconds);
    }
}
