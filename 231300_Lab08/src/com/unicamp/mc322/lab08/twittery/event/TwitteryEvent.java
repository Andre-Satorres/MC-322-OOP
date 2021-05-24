package com.unicamp.mc322.lab08.twittery.event;

import com.unicamp.mc322.lab08.twittery.entity.TwitteryEntity;

import java.time.LocalDateTime;

public abstract class TwitteryEvent {
    protected final TwitteryEntity twitteryObject;
    protected final LocalDateTime eventDate;

    public TwitteryEvent(TwitteryEntity twitteryObject) {
        this.twitteryObject = twitteryObject;
        this.eventDate = LocalDateTime.now();
    }
}
