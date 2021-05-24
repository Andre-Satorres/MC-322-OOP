package com.unicamp.mc322.lab08.twittery.entity.tweet.media;

public abstract class Media {
    protected MediaFormat format;
    protected double totalSizeMB;

    public Media(MediaFormat format) {
        this.format = format;
    }

    public abstract void getTotalFileSizeMB();
}
