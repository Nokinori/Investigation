package com.nokinori.leetcode.task

import com.nokinori.leetcode.TestCase
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class ContainerWithMostWaterTest {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution(input: IntArray, expect: Int) {
        val result = ContainerWithMostWater.maxArea(input)
        Assertions.assertThat(result).isEqualTo(expect)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun provideArguments(): Stream<Arguments> = Stream
            .of(
                TestCaseImpl(input = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7), expect = 49),
                TestCaseImpl(input = intArrayOf(1, 1), expect = 1),
                TestCaseImpl(input = intArrayOf(4, 3, 2, 1, 4), expect = 16),
                TestCaseImpl(input = intArrayOf(1, 2, 1), expect = 2),
            )
            .map { it.asArguments() }

    }

    @Suppress("ArrayInDataClass")
    data class TestCaseImpl(
        override val input: IntArray,
        override val expect: Int
    ) : TestCase<IntArray, Int> {
        override fun asArguments(): Arguments = Arguments.arguments(input, expect)
    }
}