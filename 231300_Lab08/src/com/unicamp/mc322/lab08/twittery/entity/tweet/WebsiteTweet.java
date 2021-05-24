package com.unicamp.mc322.lab08.twittery.entity.tweet;

import com.unicamp.mc322.lab08.twittery.entity.user.User;

import java.time.LocalDateTime;

public class WebsiteTweet extends Tweet {
    private String url;
    private LocalDateTime visitDate;

    public WebsiteTweet(User author, String title, String url, LocalDateTime visitDate) {
        super(author, title);
        this.url = url;
        this.visitDate = visitDate;
    }
}
