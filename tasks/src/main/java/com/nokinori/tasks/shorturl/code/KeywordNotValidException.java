package com.nokinori.tasks.shorturl.code;

public class KeywordNotValidException extends Exception {
    public KeywordNotValidException() {
    }

    public KeywordNotValidException(String message) {
        super(message);
    }

    public KeywordNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public KeywordNotValidException(Throwable cause) {
        super(cause);
    }

    public KeywordNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
