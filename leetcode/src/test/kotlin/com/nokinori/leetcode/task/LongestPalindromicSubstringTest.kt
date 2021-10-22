package com.nokinori.leetcode.task

import com.nokinori.leetcode.TestCase
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class LongestPalindromicSubstringTest {
    @Disabled
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution(input: String, expect: String) {
        val result = LongestPalindromicSubstring.longestPalindrome(input)
        Assertions.assertThat(result).isEqualTo(expect)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun provideArguments(): Stream<Arguments> = Stream
            .of(
                TestCaseImpl(input = "babad", expect = "bab"),
                TestCaseImpl(input = "cbbd", expect = "bb"),
                TestCaseImpl(input = "a", expect = "a"),
                TestCaseImpl(input = "ac", expect = "a"),
                TestCaseImpl(input = "", expect = ""),
            )
            .map { it.asArguments() }

    }

    data class TestCaseImpl(
        override val input: String,
        override val expect: String
    ) : TestCase<String, String> {
        override fun asArguments(): Arguments = Arguments.arguments(input, expect)
    }
}