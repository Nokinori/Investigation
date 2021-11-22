package com.nokinori.tasks.shorturl.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UrlShorterServiceTest {

    private UrlShortenerConfiguration configuration;
    private UrlShorterService service;

    @BeforeEach
    void setUp() {
        configuration = new UrlShortenerConfiguration();
        service = new UrlShorterService(configuration);
    }

    static Stream<Arguments> provideArguments() {
        return Stream.of(
                "http://looooong.com/somepath/|MY-NEW-WS",
                "http://looooong.com/somepath/|POTATO"
            )
            .map(it -> Arguments.of((Object[]) it.split("\\|")));
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void shortUrlTest(String input, String keyword) throws KeywordNotValidException {
        var expected = configuration.getShortUrlPrefix() + keyword;

        String result = service.shortUrl(input, keyword);

        assertThat(result)
            .isNotNull()
            .isNotBlank()
            .contains(keyword)
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void shortUrlNotValid(String input, String keyword) {
        configuration.setMaxKeyWordLength(3);
        configuration.setRandomKeyWordLength(5);

        assertThatThrownBy(() -> service.shortUrl(input, keyword))
            .isInstanceOf(KeywordNotValidException.class);
    }

    @Test
    void shortUrlWithRandomPostfix() throws KeywordNotValidException {
        var input = "http://looooong.com/somepath/";

        service = new UrlShorterService(configuration,
            new AlphanumericRandomGenerationStrategy(configuration.getRandomKeyWordLength()));

        String result = service.shortUrl(input);

        assertThat(result)
            .isNotNull()
            .isNotBlank()
            .startsWith(configuration.getShortUrlPrefix());

        var postfix = result.substring(configuration.getShortUrlPrefix().length());

        assertThat(postfix)
            .isNotNull()
            .isNotBlank()
            .hasSize(configuration.getRandomKeyWordLength())
            .containsPattern(Pattern.compile("[a-zA-Z0-9]"));
    }

    @Test
    void shortUrlWithIncrementalPostfix() throws KeywordNotValidException {
        var input = "http://looooong.com/somepath/";

        service = new UrlShorterService(configuration, new IncrementalRandomGenerationStrategy());

        for (int i = 1; i < 10; i++) {
            String result = service.shortUrl(input);

            assertThat(result)
                .isNotNull()
                .isNotBlank()
                .startsWith(configuration.getShortUrlPrefix());

            var postfix = result.substring(configuration.getShortUrlPrefix().length());

            assertThat(postfix)
                .isNotNull()
                .isNotBlank()
                .isEqualTo(String.valueOf(i));
        }
    }
}