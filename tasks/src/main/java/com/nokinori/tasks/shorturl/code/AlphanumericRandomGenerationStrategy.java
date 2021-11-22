package com.nokinori.tasks.shorturl.code;

import java.util.Random;

public class AlphanumericRandomGenerationStrategy implements RandomGenerationStrategy {
    private final String[] chars;
    private final int length;

    public AlphanumericRandomGenerationStrategy() {
        this(4);
    }

    public AlphanumericRandomGenerationStrategy(int length) {
        this(new String[]{"a", "b", "c", "d", "1", "2", "3"}, length);
    }

    public AlphanumericRandomGenerationStrategy(String[] chars, int length) {
        this.chars = chars;
        this.length = length;
    }

    public String generateKeyword() {
        if (length < 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder keyword = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int charIndex = new Random().nextInt(chars.length);
            keyword.append(chars[charIndex]);
        }
        return keyword.toString();
    }
}
