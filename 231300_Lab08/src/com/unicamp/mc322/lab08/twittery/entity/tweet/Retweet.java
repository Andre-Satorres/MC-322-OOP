package com.unicamp.mc322.lab08.twittery.entity.tweet;

import com.unicamp.mc322.lab08.twittery.entity.user.User;

public class Retweet extends Tweet {
    public Retweet(User author, String title) {
        super(author, title);
    }
}
