package com.unicamp.mc322.lab06.musicfy;

import java.util.ArrayList;
import java.util.List;

public class Album extends Item {
    private final List<Song> songs;

    public Album(String name, String artist) {
        super(name, artist, 0);
        songs = new ArrayList<>();
    }

    void addSong(Song song) {
        if (!songs.contains(song)) {
            songs.add(song);
            durationSeconds += song.durationSeconds;
        }
    }

    void removeSong(Song song) {
        if (songs.contains(song)) {
            songs.remove(song);
            durationSeconds -= song.durationSeconds;
        }
    }

    @Override
    protected double calcTotalStorageMB() {
        return songs.stream().mapToDouble(Song::calcTotalStorageMB).sum();
    }
}
