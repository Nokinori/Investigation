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
        fun provideArguments(): Stream<Arguments> = TestCase
            .of(
                TestCase.create(input = "babad", expect = "bab"),
                TestCase.create(input = "cbbd", expect = "bb"),
                TestCase.create(input = "a", expect = "a"),
                TestCase.create(input = "ac", expect = "a"),
                TestCase.create(input = "", expect = ""),
            )
    }
}