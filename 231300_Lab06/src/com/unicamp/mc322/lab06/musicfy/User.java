package com.unicamp.mc322.lab06.musicfy;

import java.util.Date;
import java.util.List;

public class User {
    private String name;
    private String cpf;
    private Date birth;
    private Gender gender;
    private boolean subscriber;
    private List<Playlist> playlists;

    void addPlaylist(Playlist playlist) {
        if (!this.playlists.contains(playlist)) {
            this.playlists.add(playlist);
        }
    }

    void removePlaylist(Playlist playlist) {
        this.playlists.remove(playlist);
    }

    void transferPlaylist(Playlist playlist, User other) {
        if (this.playlists.contains(playlist)) {
            other.addPlaylist(playlist);
            this.playlists.remove(playlist);
        }
    }

    double totalStorage() {
        return this.playlists.stream().mapToDouble(Playlist::getTotalStorageMB).sum();
    }

    void subscribe() {
        this.subscriber = true;
    }

    void unsubscribe() {
        this.subscriber = false;
    }

}
