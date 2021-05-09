package com.unicamp.mc322.lab06.musicfy;

import com.unicamp.mc322.lab06.musicfy.exception.UserException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private final String name;
    private final String cpf;
    private final LocalDateTime birth;
    private final Gender gender;
    private boolean subscriber;
    private final List<Playlist> playlists;
    private static final int MAX_MB_SUBSCRIBER = 900;
    private static final int MAX_MB_NON_SUBSCRIBER = 200;
    private final double MAX_ALLOWED_DURATION_SECONDS = 60;

    public User(String name, String cpf, LocalDateTime birth, Gender gender) {
        this.name = name;
        this.cpf = cpf;
        this.birth = birth;
        this.gender = gender;
        this.playlists = new ArrayList<>();
    }

    private boolean isMBLimitApplicable(Playlist playlist) {
        return !playlist.isEmpty() && playlist.longerLastingItem().getDurationSeconds() >= MAX_ALLOWED_DURATION_SECONDS;
    }

    private boolean cannotAddPlaylist(Playlist playlist) {
        return isMBLimitApplicable(playlist) && playlist.getTotalStorageMB() + this.totalStorage() > maxAllowedStorage();
    }

    private boolean cannotAddItemOnPlaylist(Playlist playlist, Item item) {
        return isMBLimitApplicable(playlist) && playlist.getTotalStorageMB() + this.totalStorage() + item.getTotalStorageMB() > maxAllowedStorage();
    }

    public void addToPlaylist(Playlist playlist, Item item) {
        if (cannotAddItemOnPlaylist(playlist, item)) {
            throw new UserException("Cannot add this item: max storage reached!");
        }

        if (!this.playlists.contains(playlist)) {
            throw new UserException("This user doesn't have this playlist!");
        }

        int index = this.playlists.indexOf(playlist);
        this.playlists.get(index).addItem(item);
    }

    public void removeFromPlaylist(Playlist playlist, Item item) {
        if (!this.playlists.contains(playlist)) {
            throw new UserException("This user doesn't have this playlist!");
        }

        int index = this.playlists.indexOf(playlist);
        this.playlists.get(index).deleteItem(item);
    }

    public void addPlaylist(Playlist playlist) {
        if (this.playlists.contains(playlist)) {
            return;
        }

        if (cannotAddPlaylist(playlist)) {
            throw new UserException("Cannot add this playlist because max storage is reached!");
        }

        this.playlists.add(playlist);
    }

    public void removePlaylist(Playlist playlist) {
        if (!this.playlists.contains(playlist)) {
            throw new UserException("This user doesn't have this playlist!");
        }

        this.playlists.remove(playlist);
    }

    public void transferPlaylist(Playlist playlist, User other) {
        if (this.playlists.contains(playlist)) {
            other.addPlaylist(playlist);
            this.playlists.remove(playlist);
        }
    }

    public Item playPlaylist(Playlist playlist) {
        return playPlaylist(playlist, false);
    }

    public Item playPlaylist(Playlist playlist, boolean shuffle) {
        if (!this.playlists.contains(playlist)) {
            throw new UserException("This user does not have this playlist!");
        }

        return this.playlists.get(this.playlists.indexOf(playlist)).play(shuffle);
    }

    private int maxAllowedStorage() {
        return this.subscriber ? MAX_MB_SUBSCRIBER : MAX_MB_NON_SUBSCRIBER;
    }

    public double totalStorage() {
        return this.playlists.stream().mapToDouble(Playlist::getTotalStorageMB).sum();
    }

    public void subscribe() {
        this.subscriber = true;
    }

    public void unsubscribe() {
        this.subscriber = false;

        while (maxAllowedStorage() < totalStorage()) {
            this.playlists.remove(0);
        }
    }

    @Override
    public String toString() {
        return "User: " + name + (subscriber  ? " (S)" : "") + " - Playlists=" + playlists;
    }
}
