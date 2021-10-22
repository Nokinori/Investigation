package com.nokinori.research.structure

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SumIntListTest {

    @Test
    fun `get value by index`() {
        val range = 1..10
        val summer = SumIntListImpl().fillWithNumbers(range)

        range.forEach {
            val value = it
            val index = value - 1
            assertThat(value).isEqualTo(summer[index])
        }
    }

    @Test
    fun `get sum of range`() {
        val range = 1..10
        val expected = listOf(1, 3, 6, 10, 15, 21, 28, 36, 45, 55)
        val summer: SumIntListImpl = SumIntListImpl().fillWithNumbers(range) as SumIntListImpl

        assertThat(summer.sums).containsExactly(*expected.toTypedArray())

        range.forEachIndexed { index, value ->
            assertThat(value).isEqualTo(summer[index])
        }

        Assertions.assertEquals(expected[3], summer.getSum(0, 3))
        Assertions.assertEquals(expected[4] - expected[1], summer.getSum(2, 4))
        Assertions.assertEquals(expected[6] - expected[2], summer.getSum(3, 6))
    }

    @Test
    fun `wrong values`() {
        val summer = SumIntListImpl().fillWithNumbers()
        assertThatThrownBy { summer.add(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasNoCause()

        assertThatThrownBy { summer[-1] }
            .isInstanceOf(IndexOutOfBoundsException::class.java)
            .hasNoCause()

        assertThatThrownBy { summer.getSum(-1, 5) }
            .isInstanceOf(IndexOutOfBoundsException::class.java)
            .hasNoCause()

        assertThatThrownBy { summer.getSum(1, -5) }
            .isInstanceOf(IndexOutOfBoundsException::class.java)
            .hasNoCause()

        assertThatThrownBy { summer.getSum(10000, 50000) }
            .isInstanceOf(IndexOutOfBoundsException::class.java)
            .hasNoCause()
    }

    /**
     * Result for 1..10 = [1, 3, 6, 10, 15, 21, 28, 36, 45, 55]
     */
    private fun SumIntList.fillWithNumbers(intRange: IntRange = 1..10) = apply {
        intRange.forEach { this.add(it) }
    }
}