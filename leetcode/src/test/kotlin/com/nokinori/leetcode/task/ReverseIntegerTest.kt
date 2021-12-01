package com.nokinori.leetcode.task

import com.nokinori.leetcode.TestCase
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class ReverseIntegerTest {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution(input: Int, expect: Int) {
        val result = ReverseInteger.reverseAsString(input)
        Assertions.assertThat(result).isEqualTo(expect)
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution2(input: Int, expect: Int) {
        val result = ReverseInteger.reverse(input)
        Assertions.assertThat(result).isEqualTo(expect)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun provideArguments(): Stream<Arguments> = TestCase
            .of(
                TestCase.create(input = 123, expect = 321),
                TestCase.create(input = -123, expect = -321),
                TestCase.create(input = 120, expect = 21),
                TestCase.create(input = 0, expect = 0),
                TestCase.create(input = 1534236469, expect = 0),
            )
    }
}