package com.unicamp.mc322.lab06.musicfy;

public class Video extends Song {
    private int pixelAmount;
    private int fps;

    public Video(String name, double duration, String artist, int episodesAmount) {
        super(name, duration, artist, episodesAmount);
    }

    @Override
    protected double calcTotalStorageMB() {
        return super.calcTotalStorageMB() + pixelAmount * fps * duration;
    }
}
