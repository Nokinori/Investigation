package com.nokinori.leetcode

import org.junit.jupiter.params.provider.Arguments
import java.util.*
import java.util.stream.Stream

interface TestCase<IN, EX> {
    val input: IN
    val expect: EX

    fun asArguments(): Arguments = when (input) {
        is Pair<*, *> -> Arguments.of((input as Pair<*, *>).first, (input as Pair<*, *>).second, expect)
        else -> Arguments.of(input, expect)
    }

    companion object {
        fun of(vararg testCases: TestCase<*, *>): Stream<Arguments> = Arrays.stream(testCases).map { it.asArguments() }

        fun create(input: Pair<*, *>, expect: Any) = object : TestCase<Pair<*, *>, Any> {
            override val input: Pair<*, *> = input
            override val expect: Any = expect
        }

        fun create(input: Any, expect: Any) = object : TestCase<Any, Any> {
            override val input: Any = input
            override val expect: Any = expect
        }
    }
}