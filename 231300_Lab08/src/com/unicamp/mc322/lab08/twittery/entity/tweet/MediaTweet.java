package com.unicamp.mc322.lab08.twittery.entity.tweet;

import com.unicamp.mc322.lab08.twittery.entity.tweet.media.Media;
import com.unicamp.mc322.lab08.twittery.entity.user.User;

public abstract class MediaTweet extends Tweet {
    protected Media media;

    public MediaTweet(User author, String title, Media media) {
        super(author, title);

        this.media = media;
    }
}
