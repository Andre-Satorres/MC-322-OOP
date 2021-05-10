package com.unicamp.mc322.lab06.musicfy.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Album extends Item {
    private final List<Song> songs;
    private static final String VARIOUS_ARTISTS = "Various artists";
    private static final String NO_ARTIST = "No artist";

    public Album(String name) {
        super(name, NO_ARTIST, 0);
        songs = new ArrayList<>();
    }

    public Album(String name, Song ... initialSongs) {
        this(name);
        this.songs.addAll(Arrays.asList(initialSongs));

        if (songs.isEmpty()) {
            return;
        }

        String firstArtist = songs.get(0).artist;
        if (songs.stream().allMatch(s -> s.artist.equals(songs.get(0).artist))) {
            this.artist = firstArtist;
        } else {
            this.artist = VARIOUS_ARTISTS;
        }
    }

    public void addSong(Song song) {
        if (this.songs.isEmpty()) {
            this.artist = song.artist;
        }

        if (!songs.contains(song)) {
            songs.add(song);
            durationSeconds += song.durationSeconds;

            if (!song.artist.equals(songs.get(0).artist)) { // other indexes are not different, because they would have been checked before
                this.artist = VARIOUS_ARTISTS;
            }
        }
    }

    public void removeSong(Song song) {
        if (songs.contains(song)) {
            songs.remove(song);
            durationSeconds -= song.durationSeconds;

            if (songs.isEmpty()) {
                this.artist = NO_ARTIST;
            }

            if (songs.stream().allMatch(s -> s.artist.equals(songs.get(0).artist))) {
                this.artist = songs.get(0).artist;
            }
        }
    }

    @Override
    protected double getTotalStorageMB() {
        return songs.stream().mapToDouble(Song::getTotalStorageMB).sum();
    }

    @Override
    public String toString() {
        return String.format("(Album - %s - %s - %ss)", name, artist, durationSeconds);
    }
}
