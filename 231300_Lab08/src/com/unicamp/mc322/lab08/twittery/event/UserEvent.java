package com.unicamp.mc322.lab08.twittery.event;

import com.unicamp.mc322.lab08.twittery.entity.user.User;

import java.util.StringJoiner;

public class UserEvent extends TwitteryEvent {

    public UserEvent(User user) {
        super(user);
    }

    public User getUser() {
        return (User) this.twitteryObject;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserEvent.class.getSimpleName() + "[", "]")
                .add("user=" + this.getUser().getNickname())
                .add("eventDate=" + eventDate)
                .toString();
    }
}
