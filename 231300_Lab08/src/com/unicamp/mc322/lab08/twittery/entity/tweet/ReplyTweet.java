package com.unicamp.mc322.lab08.twittery.entity.tweet;

import com.unicamp.mc322.lab08.twittery.entity.user.User;

import java.time.LocalDateTime;

public class ReplyTweet {

    private Tweet inReplyTo;
    private LocalDateTime date;
    private com

    private final static int MAX_LENGTH_COMMENT = 100;

    public ReplyTweet(Tweet inReplyTo, String comment) {
        this.inReplyTo = inReplyTo;
        this.date = LocalDateTime.now();
    }
}
