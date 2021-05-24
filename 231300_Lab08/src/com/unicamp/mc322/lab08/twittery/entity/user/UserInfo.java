package com.unicamp.mc322.lab08.twittery.entity.user;

import java.time.LocalDateTime;
import java.util.StringJoiner;

public class UserInfo {
    private final String name;
    private final String email;
    private final String password;
    private final String nick;
    private final Gender gender;
    private final Country country;
    private final LocalDateTime birthDate;

    public UserInfo(String name, String email, String password, String nick, Gender gender, Country country, LocalDateTime birthDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.nick = nick;
        this.gender = gender;
        this.country = country;
        this.birthDate = birthDate;
    }

    public static UserInfo of(String name, String email, String password, String nick, Gender gender, Country country, LocalDateTime birthDate) {
        return new UserInfo(name, email, password, nick, gender, country, birthDate);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNick() {
        return nick;
    }

    public Gender getGender() {
        return gender;
    }

    public Country getCountry() {
        return country;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "UserInfo[", "]")
                .add("name='" + name + "'")
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .add("nick='" + nick + "'")
                .add("gender=" + gender)
                .add("country=" + country)
                .add("birthDate=" + birthDate)
                .toString();
    }
}
