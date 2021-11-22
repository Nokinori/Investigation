package com.nokinori.tasks.shorturl.code;

import java.util.concurrent.atomic.AtomicLong;

public class IncrementalRandomGenerationStrategy implements RandomGenerationStrategy {
    private final AtomicLong counter = new AtomicLong(1);

    @Override
    public String generateKeyword() {
        if (counter.get() == Long.MAX_VALUE) {
            counter.set(0);
        }

        return String.valueOf(counter.getAndIncrement());
    }
}
