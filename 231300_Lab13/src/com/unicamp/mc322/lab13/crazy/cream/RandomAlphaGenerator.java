package com.unicamp.mc322.lab13.crazy.cream;

import java.security.SecureRandom;

public class RandomAlphaGenerator {
    private static final String ALL_ALPHA_NUMERIC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final SecureRandom random;
    private static final RandomAlphaGenerator INSTANCE = new RandomAlphaGenerator();

    private RandomAlphaGenerator() {
        this.random = new SecureRandom();
    }

    public static RandomAlphaGenerator getInstance() {
        return INSTANCE;
    }

    public String randomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(ALL_ALPHA_NUMERIC.charAt(random.nextInt(ALL_ALPHA_NUMERIC.length())));
        return sb.toString();
    }
}
