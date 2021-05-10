package com.unicamp.mc322.lab06.musicfy;

import com.unicamp.mc322.lab06.musicfy.entity.*;

import java.time.LocalDateTime;

public class Musicfy {

    public void start() {
        User user = new User("Andre", "123.456.789-56", LocalDateTime.now(), Gender.MALE);
        user.subscribe();

        System.out.println(user);

        Playlist thisIsTwentyOnePilots = new Playlist("This is Twenty One Pilots");
        Song heavyDirtySoul = new Song("Heavydirtysoul", "Twenty One Pilots", 251);
        Song ride = new Song("Ride", "Twenty One Pilots", 226);
        Song loc = new Song("Level of Concern", "Twenty One Pilots", 233);
        Song longestMusic = new Song("Long Music", "Twenty One Pilots", 2330);

        user.addPlaylist(thisIsTwentyOnePilots);
        user.addToPlaylist(thisIsTwentyOnePilots, heavyDirtySoul);
        user.addToPlaylist(thisIsTwentyOnePilots, ride);
        user.addToPlaylist(thisIsTwentyOnePilots, loc);
        user.addToPlaylist(thisIsTwentyOnePilots, longestMusic);

        Song allAboutThatBass = new Song("All Abount That Bass", "Meghan Trainor", 226);
        Song dearFutureHusband = new Song("Dear Future Husband", "Meghan Trainor", 235);
        Playlist thisIsMeghanTrainor = new Playlist("This is Meghan Trainor", allAboutThatBass, dearFutureHusband);

        Song mySelfishHeart = new Song("My Selfish Heart", "Meghan Trainor", 432);
        Album title = new Album("Title", allAboutThatBass, dearFutureHusband);
        title.addSong(mySelfishHeart);

        Playlist meghanAlbums = new Playlist("Meghan Albums");
        user.addPlaylist(meghanAlbums);
        user.addToPlaylist(meghanAlbums, title);

        user.addPlaylist(thisIsMeghanTrainor);

        // user.unsubscribe();

        System.out.println(thisIsTwentyOnePilots);

        user.removeFromPlaylist(thisIsTwentyOnePilots, ride);

        System.out.println(thisIsTwentyOnePilots);
        System.out.println(user);

        System.out.println(user.playPlaylist(thisIsTwentyOnePilots));
        System.out.println(user.playPlaylist(thisIsTwentyOnePilots));
        System.out.println(user.playPlaylist(thisIsTwentyOnePilots));
        System.out.println(user.playPlaylist(thisIsTwentyOnePilots, false));
        System.out.println(user.playPlaylist(thisIsTwentyOnePilots, false));

        System.out.println(user.playPlaylist(thisIsMeghanTrainor, true));
        System.out.println(user.playPlaylist(thisIsMeghanTrainor, true));

        Song sm1 = new Song("Short 1", "Shorter", 59);
        Song sm2 = new Song("Short 2", "Shorter", 59);
        Song sm3 = new Song("Short 3", "Shorter", 59);
        Song sm4 = new Song("Short 4", "Shorter", 59);
        Song sm5 = new Song("Short 5", "Shorter", 59);
        Song sm6 = new Song("Short 6", "Shorter", 59);
        Song sm7 = new Song("Short 7", "Shorter", 59);
        Video video = new Video("Choker Video", "Twenty one Pilots", 59, 1980 * 1060, 60);

        User user2 = new User("Jose", "234.567.890-8", LocalDateTime.now(), Gender.PREFER_NOT_MENTION);
        Playlist shortPlaylist = new Playlist("Short Musics!", sm1, sm2, sm3, sm4, sm5, sm6, sm7, video);
        user2.addPlaylist(shortPlaylist);
        user2.subscribe();
        // user.transferPlaylist(thisIsTwentyOnePilots, user2);

        System.out.println(user2);
        // user2.removePlaylist(thisIsTwentyOnePilots);
        // System.out.println(user2);

        System.out.println(thisIsMeghanTrainor.avgItemDuration());
        System.out.println(thisIsMeghanTrainor.longerLastingItem());
        System.out.println(thisIsMeghanTrainor.leastLastingItem());
        System.out.println(thisIsMeghanTrainor.totalDuration());
    }
}
