package com.unicamp.mc322.lab10.pidao.random;

import java.security.SecureRandom;

public class RandomAlphaGenerator {
    private static final String ALL_ALPHA_NUMERIC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final SecureRandom random;
    private final int stringLength;

    public RandomAlphaGenerator(int length) {
        this.random = new SecureRandom();
        this.stringLength = length;
    }

    public String randomString() {
        StringBuilder sb = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++)
            sb.append(ALL_ALPHA_NUMERIC.charAt(random.nextInt(ALL_ALPHA_NUMERIC.length())));
        return sb.toString();
    }
}
