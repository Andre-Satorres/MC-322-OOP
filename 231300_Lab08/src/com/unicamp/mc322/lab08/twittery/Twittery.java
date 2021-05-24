package com.unicamp.mc322.lab08.twittery;

import com.unicamp.mc322.lab08.twittery.entity.tweet.Language;
import com.unicamp.mc322.lab08.twittery.entity.tweet.Tweet;
import com.unicamp.mc322.lab08.twittery.entity.tweet.media.Image;
import com.unicamp.mc322.lab08.twittery.entity.tweet.media.Video;
import com.unicamp.mc322.lab08.twittery.entity.user.Country;
import com.unicamp.mc322.lab08.twittery.entity.user.Gender;
import com.unicamp.mc322.lab08.twittery.entity.user.User;
import com.unicamp.mc322.lab08.twittery.entity.user.UserInfo;
import com.unicamp.mc322.lab08.twittery.exception.EmailAlreadyInUseException;
import com.unicamp.mc322.lab08.twittery.exception.NickAlreadyInUseException;
import com.unicamp.mc322.lab08.twittery.exception.UserNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Twittery {
    private final List<User> users;

    public Twittery() {
        this.users = new ArrayList<>();
    }

    public void addUser(String name, String email, String password, String nick, Gender gender, Country country, LocalDateTime birthDate) {
        User newUser = new User(UserInfo.of(name, email, password, nick, gender, country, birthDate));

        if (isEmailInUse(email)) {
            throw new EmailAlreadyInUseException("This email is already in use!");
        }

        if (isNicknameInUse(nick)) {
            throw new NickAlreadyInUseException("This nickname is already in use!");
        }

        users.add(newUser);
    }

    public void createAFollow(String nicknameFollower, String nicknameToFollow) {
        User follower = getUser(nicknameFollower);
        User toFollow = getUser(nicknameToFollow);
        follower.follow(toFollow);
    }

    public void generateTweet(String nickname, String title, String text, Language language) {
        User user = getUser(nickname);
        user.tweet(title, text, language);
    }

    public void generateTweet(String nickname, String title, String url, LocalDateTime visitDate) {
        User user = getUser(nickname);
        user.tweet(title, url, visitDate);
    }

    public void generateTweet(String nickname, String title, Image image) {
        User user = getUser(nickname);
        user.tweet(title, image);
    }

    public void generateTweet(String nickname, String title, Video video) {
        User user = getUser(nickname);
        user.tweet(title, video);
    }

    public String getTimeline(String userNick) {
        StringJoiner stringJoiner = new StringJoiner("\n\n");
        getUser(userNick).timeline().forEach(it -> stringJoiner.add(it.toString()));
        return stringJoiner.toString();
    }

    public String getLikedTweets(String nick) {
        StringJoiner stringJoiner = new StringJoiner("\n\n");
        getUser(nick).getLikedTweets().forEach(it -> stringJoiner.add(it.toString()));
        return stringJoiner.toString();
    }

    public void makeLike(String nick, int tweetIndexOnTimeline) {
        Tweet tweet = getFromTimeline(nick, tweetIndexOnTimeline);
        getUser(nick).likeTweet(tweet);
    }

    public void makeComment(String nick, int tweetIndexOnTimeline) {
        Tweet tweet = getFromTimeline(nick, tweetIndexOnTimeline);
        getUser(nick).likeTweet(tweet);
    }

//
//    public void makeRT(String nick, Tweet tweet) {
//        getUser(nick).likeTweet(tweet);
//    }

    private User getUser(String nickname) {
        return this.users.stream()
                .filter(user -> user.getNickname().equalsIgnoreCase(nickname))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User '" + nickname + "' not found!"));
    }

    private Tweet getFromTimeline(String userNick, int index) {
        try {
            return getUser(userNick).timeline().get(index);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    private boolean isEmailInUse(String email) {
        return users.stream().anyMatch(it -> it.getEmail().equalsIgnoreCase(email));
    }

    private boolean isNicknameInUse(String nickname) {
        return users.stream().anyMatch(it -> it.getNickname().equalsIgnoreCase(nickname));
    }
}
