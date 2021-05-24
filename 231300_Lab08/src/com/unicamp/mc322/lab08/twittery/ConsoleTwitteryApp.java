package com.unicamp.mc322.lab08.twittery;

import com.unicamp.mc322.lab08.twittery.entity.tweet.media.Video;
import com.unicamp.mc322.lab08.twittery.entity.tweet.media.VideoFormat;
import com.unicamp.mc322.lab08.twittery.entity.user.Country;
import com.unicamp.mc322.lab08.twittery.entity.user.Gender;

import java.time.LocalDateTime;
import java.time.Month;

public class ConsoleTwitteryApp {
    private static final String REPLACER = "\\{}";
    private Twittery twittery;

    public void start() {
        this.twittery = new Twittery();
        this.welcomeMessage();
        this.runFlux();
    }

    private void welcomeMessage() {
        ptl("Welcome to Twittery!");
    }

    private void ptl(String str, String... args) {
        for (String arg : args) {
            str = str.replaceFirst(REPLACER, arg);
        }

        System.out.println(str);
    }

    private void runFlux() {
        twittery.addUser("Joao Costa", "joaoc@gmail.com", "jo@o12345", "joaoc", Gender.MALE,
                Country.BRAZIL, LocalDateTime.of(1986, Month.MAY, 2, 0, 0));

        twittery.addUser("Maria Silva", "msilva@outlook.com", "m@ria@", "msilva", Gender.FEMALE,
                Country.ARGENTINA, LocalDateTime.of(1975, Month.APRIL, 6, 0, 0));

        twittery.addUser("Carlos Vargas", "carlos.vargas@gmail.com", "carlos123", "varguinhas",
                Gender.NON_BINARY, Country.BRAZIL, LocalDateTime.of(2001, Month.DECEMBER, 21, 0, 0));

        twittery.createAFollow("joaoc", "msilva");
        twittery.createAFollow("joaoc", "varguinhas");
        twittery.createAFollow("varguinas", "joaoc");
        twittery.createAFollow("msilva", "joaoc");
        twittery.createAFollow("msilva", "varguinhas");

        // • João publica um vídeo com título “Primeiro dia na Praia”, no formato avi, com 20 minutos de
        //duração. Carlos curte e comenta: “Parabéns pelo passeio.”.

        twittery.generateTweet("joaoc", "Primeiro dia na Praia", new Video(VideoFormat.AVI, 20));
        twittery.makeLike("varguinhas", 0);
    }
}
