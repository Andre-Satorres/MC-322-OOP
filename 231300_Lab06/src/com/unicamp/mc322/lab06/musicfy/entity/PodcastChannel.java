package com.unicamp.mc322.lab06.musicfy.entity;

import java.util.ArrayList;
import java.util.List;

public class PodcastChannel extends Item {
    private final List<Podcast> podcasts;

    public PodcastChannel(String name, String artist) {
        super(name, artist, 0);
        podcasts = new ArrayList<>();
    }

    void addPodcast(Podcast podcast) {
        if (!podcasts.contains(podcast)) {
            podcasts.add(podcast);
            durationSeconds += podcast.durationSeconds;
        }
    }

    void removePodcast(Podcast podcast) {
        if (podcasts.contains(podcast)) {
            podcasts.remove(podcast);
            durationSeconds -= podcast.durationSeconds;
        }
    }


    @Override
    protected double getTotalStorageMB() {
        return podcasts.stream().mapToDouble(Item::getTotalStorageMB).sum() * podcasts.size();
    }
}
