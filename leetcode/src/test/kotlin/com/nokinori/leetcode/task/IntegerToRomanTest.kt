package com.nokinori.leetcode.task

import com.nokinori.leetcode.TestCase
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class IntegerToRomanTest {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution(input: Int, expect: String) {
        val result = IntegerToRoman.intToRoman(input)
        Assertions.assertThat(result).isEqualTo(expect)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun provideArguments(): Stream<Arguments> = TestCase
            .of(
                TestCase.create(input = 3, expect = "III"),
                TestCase.create(input = 4, expect = "IV"),
                TestCase.create(input = 9, expect = "IX"),
                TestCase.create(input = 58, expect = "LVIII"), //L = 50, V = 5, III = 3.
                TestCase.create(input = 146, expect = "CXLVI"), //L = 50, V = 5, III = 3.
                TestCase.create(input = 1994, expect = "MCMXCIV"), //M = 1000, CM = 900, XC = 90 and IV = 4.
                TestCase.create(input = 3998, expect = "MMMCMXCVIII"),
            )
    }
}
