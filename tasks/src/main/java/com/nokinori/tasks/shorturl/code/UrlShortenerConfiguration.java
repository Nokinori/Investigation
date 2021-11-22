package com.nokinori.tasks.shorturl.code;

public class UrlShortenerConfiguration {
    private String shortUrlPrefix;
    private int maxKeyWordLength;
    private int randomKeyWordLength;


    public UrlShortenerConfiguration() {
        this.maxKeyWordLength = 20;
        this.randomKeyWordLength = 4;
        this.shortUrlPrefix = "http://short.com/";
    }

    public UrlShortenerConfiguration(String shortUrlPrefix, int maxKeyWordLength, int randomKeyWordLenght) {
        this.shortUrlPrefix = shortUrlPrefix;
        this.maxKeyWordLength = maxKeyWordLength;
        this.randomKeyWordLength = randomKeyWordLenght;
    }

    public String getShortUrlPrefix() {
        return shortUrlPrefix;
    }

    public void setShortUrlPrefix(String shortUrlPrefix) {
        this.shortUrlPrefix = shortUrlPrefix;
    }

    public int getKeyWordMaxLength() {
        return maxKeyWordLength;
    }

    public void setMaxKeyWordLength(int maxKeyWordLength) {
        this.maxKeyWordLength = maxKeyWordLength;
    }

    public int getRandomKeyWordLength() {
        return randomKeyWordLength;
    }

    public void setRandomKeyWordLength(int randomKeyWordLength) {
        this.randomKeyWordLength = randomKeyWordLength;
    }
}
