package com.unicamp.mc322.lab08.twittery.entity.tweet.media;

public class Video extends Media {
    private final double durationMinutes;
    private final static double MB_PER_MINUTE = 3;

    public Video(VideoFormat format, double durationMinutes) {
        super(format);

        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Video duration in minutes has to be > 0");
        }

        this.durationMinutes = durationMinutes;
    }

    @Override
    public void getTotalFileSizeMB() {
        this.totalSizeMB = durationMinutes * MB_PER_MINUTE;
    }
}
