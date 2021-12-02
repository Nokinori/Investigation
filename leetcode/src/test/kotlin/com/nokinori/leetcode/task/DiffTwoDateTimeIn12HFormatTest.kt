package com.nokinori.leetcode.task

import com.nokinori.leetcode.TestCase
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class DiffTwoDateTimeIn12HFormatTest {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution(input: Array<String>, expect: Int) {
        val result = DiffTwoDateTimeIn12HFormat.solution(input)
        Assertions.assertThat(result).isEqualTo(expect)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun provideArguments(): Stream<Arguments> = TestCase
            .of(
                TestCase.create(input = arrayOf("2:10pm", "1:30pm", "10:30am", "4:42pm"), expect = 40)
            )
    }
}