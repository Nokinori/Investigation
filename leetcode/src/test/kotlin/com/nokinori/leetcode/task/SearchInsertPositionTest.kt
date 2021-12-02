package com.nokinori.leetcode.task

import com.nokinori.leetcode.TestCase
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class SearchInsertPositionTest {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution(input: IntArray, target: Int, expect: Int) {
        val result = SearchInsertPosition.searchInsert(input, target)
        Assertions.assertThat(result).isEqualTo(expect)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun provideArguments(): Stream<Arguments> = TestCase
            .of(
                TestCase.create(input = intArrayOf(1, 3, 5, 6) to 5, expect = 2),
                TestCase.create(input = intArrayOf(1, 3, 5, 6) to 2, expect = 1),
                TestCase.create(input = intArrayOf(1, 3, 5, 6) to 7, expect = 4),
                TestCase.create(input = intArrayOf(1, 3, 5, 6) to 0, expect = 0),
                TestCase.create(input = intArrayOf(1) to 0, expect = 0),
            )
    }
}
