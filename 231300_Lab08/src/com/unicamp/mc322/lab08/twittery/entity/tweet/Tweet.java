package com.unicamp.mc322.lab08.twittery.entity.tweet;

import com.unicamp.mc322.lab08.twittery.entity.TwitteryEntity;
import com.unicamp.mc322.lab08.twittery.entity.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public abstract class Tweet extends TwitteryEntity {
    protected User author;
    protected String title;
    protected LocalDateTime postDate;
    protected List<User> likes;
    protected List<Tweet> retweets;
    protected List<Tweet> comments;
    private final static int MAX_LENGTH_TITLE = 60;

    public Tweet(User author, String title) {
        this.author = author;
        this.title = title.substring(0, Math.min(title.length(), MAX_LENGTH_TITLE));
        this.postDate = LocalDateTime.now();
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.retweets = new ArrayList<>();
    }

    public void receiveLike(User liker) {
        this.likes.add(liker);
    }

    public void receiveComment(ReplyTweet comment) {
        this.comments.add(comment);
    }

    public void receiveRT(Retweet rt) {
        this.retweets.add(rt);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add("Tweet from " + author.getNickname() + " - " + postDate);
        stringJoiner.add(title);
        stringJoiner.add(likes.size() + " likes | " + retweets.size() + " retweets | " + comments.size() + " comments");
        return stringJoiner.toString();
    }
}
