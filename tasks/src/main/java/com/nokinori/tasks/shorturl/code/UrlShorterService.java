package com.nokinori.tasks.shorturl.code;

public class UrlShorterService implements UrlShortener {

    private final UrlShortenerConfiguration configuration;

    private final RandomGenerationStrategy randomGenerationStrategy;

    public UrlShorterService(UrlShortenerConfiguration configuration) {
        this.configuration = configuration;
        this.randomGenerationStrategy = new AlphanumericRandomGenerationStrategy(configuration.getRandomKeyWordLength());
    }

    public UrlShorterService(UrlShortenerConfiguration configuration, RandomGenerationStrategy randomGenerationStrategy) {
        this.configuration = configuration;
        this.randomGenerationStrategy = randomGenerationStrategy;
    }

    @Override
    public String shortUrl(String url, String keyword) throws KeywordNotValidException {
        validate(keyword);
        String resultUrl = configuration.getShortUrlPrefix();
        if (!resultUrl.endsWith("/")) {
            resultUrl += "/";
        }
        return resultUrl + keyword;
    }

    @Override
    public String shortUrl(String url) throws KeywordNotValidException {
        String keyword = randomGenerationStrategy.generateKeyword();
        return shortUrl(url, keyword);
    }

    private void validate(String keyword) throws KeywordNotValidException {
        if (keyword.length() >= configuration.getKeyWordMaxLength()) {
            throw new KeywordNotValidException("Length of keyword is wrong. Max length is " + configuration.getKeyWordMaxLength());
        }
    }
}
