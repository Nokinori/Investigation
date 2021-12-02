package com.nokinori.leetcode.task

import com.nokinori.leetcode.TestCase
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class RomanToIntegerTest {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution(input: String, expect: Int) {
        val result = RomanToInteger.romanToInt(input)
        Assertions.assertThat(result).isEqualTo(expect)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun provideArguments(): Stream<Arguments> = TestCase
            .of(
                TestCase.create(input = "III", expect = 3),
                TestCase.create(input = "IV", expect = 4),
                TestCase.create(input = "IX", expect = 9),
                TestCase.create(input = "LVIII", expect = 58), //L = 50, V = 5, III = 3.
                TestCase.create(input = "CXLVI", expect = 146), //L = 50, V = 5, III = 3.
                TestCase.create(input = "MCMXCIV", expect = 1994), //M = 1000, CM = 900, XC = 90 and IV = 4.
                TestCase.create(input = "MMMCMXCVIII", expect = 3998),
                TestCase.create(input = "MMMDCCCLXXXVIII", expect = 3888),
            )
    }
}