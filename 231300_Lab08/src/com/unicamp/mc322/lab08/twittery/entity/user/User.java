package com.unicamp.mc322.lab08.twittery.entity.user;

import com.unicamp.mc322.lab08.twittery.Twittery;
import com.unicamp.mc322.lab08.twittery.entity.TwitteryEntity;
import com.unicamp.mc322.lab08.twittery.entity.tweet.*;
import com.unicamp.mc322.lab08.twittery.entity.tweet.media.*;
import com.unicamp.mc322.lab08.twittery.event.TweetEvent;
import com.unicamp.mc322.lab08.twittery.event.UserEvent;
import com.unicamp.mc322.lab08.twittery.exception.UserUnderEighteenException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class User extends TwitteryEntity {
    private final UserInfo userInfo;
    private final List<UserEvent> following;
    private final List<UserEvent> followers;
    private final List<Tweet> tweets;
    private final List<TweetEvent> likedTweets;

    public User(UserInfo userInfo) {
        this.userInfo = userInfo;

        if (this.isUnderEighteen()) {
            throw new UserUnderEighteenException("Users can't be under eighteen years old!");
        }

        this.following = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.likedTweets = new ArrayList<>();
        this.tweets = new ArrayList<>();
    }

    public String getNickname() {
        return this.userInfo.getNick();
    }

    public String getEmail() {
        return this.userInfo.getEmail();
    }

    public void follow(User other) {
        this.following.add(new UserEvent(other));
        other.followers.add(new UserEvent(this));
    }

    public Tweet tweet(String title, String text, Language language) {
        TextTweet textTweet = new TextTweet(this, title, text, language);
        this.tweets.add(textTweet);
        return textTweet;
    }

    public Tweet tweet(String title, String url, LocalDateTime visitDate) {
        WebsiteTweet websiteTweet = new WebsiteTweet(this, title, url, visitDate);
        this.tweets.add(websiteTweet);
        return websiteTweet;
    }

    public Tweet tweet(String title, Image image) {
        return this.tweetMedia(new ImageTweet(this, title, image));
    }

    public Tweet tweet(String title, Video video) {
        return this.tweetMedia(new VideoTweet(this, title, video));
    }

    private Tweet tweetMedia(MediaTweet mediaTweet) {
        this.tweets.add(mediaTweet);
        return mediaTweet;
    }

    public List<TweetEvent> getLikedTweets() {
        return new ArrayList<>(this.likedTweets);
    }

    public void likeTweet(Tweet tweet) {
        this.likedTweets.add(new TweetEvent(tweet));
        tweet.receiveLike(this);
    }

    public void comment(Tweet tweet) {
        Tweet newTweet = new ReplyTweet(this, )
    }

    public List<Tweet> timeline() {
        return this.following.stream().flatMap(userEv -> userEv.getUser().tweets.stream()).collect(Collectors.toList());
    }

    public List<Tweet> getTweets() {
        return new ArrayList<>(this.tweets);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");

        stringJoiner.add("User " + this.getNickname() + ":");

        StringJoiner helper = new StringJoiner(", ", "[", "]");
        this.followers.forEach(follower -> helper.add(follower.getUser().getNickname()));
        stringJoiner.add(" - Followers: " + helper);

        StringJoiner helper2 = new StringJoiner(", ", "[", "]");
        this.following.forEach(following -> helper2.add(following.getUser().getNickname()));
        stringJoiner.add(" - Following: " + helper2);

        return stringJoiner.toString();
    }

    private boolean isUnderEighteen() {
        LocalDateTime eighteenYearsAgo = LocalDateTime.now().minusYears(18);
        return this.userInfo.getBirthDate().isAfter(eighteenYearsAgo);
    }
}
