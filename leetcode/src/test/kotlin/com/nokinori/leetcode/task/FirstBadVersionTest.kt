package com.nokinori.leetcode.task

import com.nokinori.leetcode.TestCase
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class FirstBadVersionTest {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution(input: Int, expect: Int) {
        val result = FirstBadVersion.firstBadVersion(input)
        Assertions.assertThat(result).isEqualTo(expect)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun provideArguments(): Stream<Arguments> = TestCase
            .of(
                TestCase.create(input = 10, expect = 4)
            )
    }
}
