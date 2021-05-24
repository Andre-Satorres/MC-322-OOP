package com.unicamp.mc322.lab08.twittery.entity.tweet.media;

import com.unicamp.mc322.lab08.twittery.entity.tweet.MediaTweet;
import com.unicamp.mc322.lab08.twittery.entity.user.User;

public class VideoTweet extends MediaTweet {
    public VideoTweet(User author, String title, Video video) {
        super(author, title, video);
    }
}
