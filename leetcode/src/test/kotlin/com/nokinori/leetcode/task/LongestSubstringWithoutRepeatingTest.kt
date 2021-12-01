package com.nokinori.leetcode.task

import com.nokinori.leetcode.TestCase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class LongestSubstringWithoutRepeatingTest {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution(s: String, expect: Int) {
        val result = LongestSubstringWithoutRepeating.lengthOfLongestSubstring(s)
        assertThat(result).isEqualTo(expect)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun provideArguments(): Stream<Arguments> = Stream
            .of(
                TestCase.create(
                    input = "abcabcbb",
                    expect = 3
                ),
                TestCase.create(
                    input = "bbbbb",
                    expect = 1
                ),
                TestCase.create(
                    input = "pwwkew",
                    expect = 3
                ),
                TestCase.create(
                    input = "",
                    expect = 0
                ),
                TestCase.create(
                    input = "aab",
                    expect = 2
                ),
                TestCase.create(
                    input = "dvdf",
                    expect = 3
                )
            )
            .map { it.asArguments() }
    }
}