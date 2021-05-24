package com.unicamp.mc322.lab08.twittery.entity.tweet;

import com.unicamp.mc322.lab08.twittery.entity.user.User;

public class TextTweet extends Tweet {
    private String text;
    private final static int MAX_CHARS = 1200;
    private Language language;

    public TextTweet(User author, String title, String text, Language language) {
        super(author, title);
        this.text = text.substring(0, Math.min(text.length(), MAX_CHARS));
        this.language = language;
    }
}
