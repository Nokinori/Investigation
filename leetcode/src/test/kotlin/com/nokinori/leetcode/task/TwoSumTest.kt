package com.nokinori.leetcode.task

import com.nokinori.leetcode.TestCase
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


internal class TwoSumTest {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution(nums: List<Int>, target: Int, expect: List<Int>) {
        val result = TwoSum.twoSum(nums.toIntArray(), target)
        Assertions.assertThat(result).containsExactlyInAnyOrder(*expect.toIntArray())
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun provideArguments(): Stream<Arguments> = TestCase
            .of(
                TestCase.create(input = listOf(2, 7, 11, 15) to 9, expect = listOf(0, 1)),
                TestCase.create(input = listOf(3, 2, 4) to 6, expect = listOf(1, 2)),
                TestCase.create(input = listOf(3, 3) to 6, expect = listOf(0, 1)),
                TestCase.create(input = listOf(1, 3, 6, 7, 4, 5) to 12, expect = listOf(3, 5)),
            )
    }
}


