package com.nokinori.leetcode.task

import com.nokinori.leetcode.TestCase
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class PalindromeNumberTest {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution(input: Int, expect: Boolean) {
        val result = PalindromeNumber.isPalindromeAsString(input)
        Assertions.assertThat(result).isEqualTo(expect)
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution2(input: Int, expect: Boolean) {
        val result = PalindromeNumber.isPalindrome(input)
        Assertions.assertThat(result).isEqualTo(expect)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun provideArguments(): Stream<Arguments> = TestCase
            .of(
                TestCase.create(input = 121, expect = true),
                TestCase.create(input = 1234321, expect = true),
                TestCase.create(input = -121, expect = false),
                TestCase.create(input = 10, expect = false),
                TestCase.create(input = -101, expect = false),
                TestCase.create(input = 1223, expect = false),
                TestCase.create(input = 0, expect = true),
                TestCase.create(input = 1, expect = true),
                TestCase.create(input = 11, expect = true),
            )
    }
}