package com.nokinori.leetcode.task

import com.nokinori.leetcode.TestCase
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class BinarySearchTest {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution(input: IntArray, target: Int, expect: Int) {
        val result = BinarySearch.search(input, target)
        Assertions.assertThat(result).isEqualTo(expect)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun provideArguments(): Stream<Arguments> = TestCase
            .of(
//                TestCase.create(input = intArrayOf(-1, 0, 3, 5, 9, 12) to 9, expect = 4),
                TestCase.create(input = intArrayOf(-1, 0, 3, 5, 9, 12) to 2, expect = -1)
            )
    }
}
