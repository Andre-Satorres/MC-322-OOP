package com.unicamp.mc322.lab08.twittery.event;

import com.unicamp.mc322.lab08.twittery.entity.tweet.Tweet;

public class TweetEvent extends TwitteryEvent {

    public TweetEvent(Tweet tweet) {
        super(tweet);
    }

    public Tweet getTweet() {
        return (Tweet) this.twitteryObject;
    }

    @Override
    public String toString() {
        return "(On date " + this.eventDate + ") - " + this.getTweet();
    }
}
