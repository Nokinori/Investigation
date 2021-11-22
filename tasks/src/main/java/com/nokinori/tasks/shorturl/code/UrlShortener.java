package com.nokinori.tasks.shorturl.code;

interface UrlShortener {
    String shortUrl(String url, String keyword) throws KeywordNotValidException;
    String shortUrl(String url) throws KeywordNotValidException;
}

