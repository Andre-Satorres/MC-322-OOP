package com.unicamp.mc322.lab08.twittery.entity.tweet.media;

import com.unicamp.mc322.lab08.twittery.entity.tweet.MediaTweet;
import com.unicamp.mc322.lab08.twittery.entity.user.User;

public class ImageTweet extends MediaTweet {
    public ImageTweet(User author, String title, Image image) {
        super(author, title, image);
    }
}
