package com.nokinori.research.structure

/**
 * Create implementation of this interface with maximum optimization in memory and asymptotic performance.
 * All values are positive numbers.
 *
 * This structure provide possibility to get sum of numbers in range. Inclusive from and to.
 * For ex:
 * [1,2,3,4,5] - getSum(1,3) = 9
 * [1,2,3,4,5] - getSum(0,3) = 10
 * [1,2,3,4,5] - getSum(3,3) = 3
 *
 * And get stored value by index.
 */
internal interface SumIntList {
    fun add(value: Int)
    operator fun get(index: Int): Int
    fun getSum(from: Int, to: Int): Int
}

/**
 * The optimal realization with O(1) asymptotic performance.
 * Algorithm of [getSum] based on formula: V = sums[ K ] - sums[ L - 1 ]. Where K - index, L - index - 1
 * It's possible because we store sums of previously added values
 */
class SumIntListImpl : SumIntList {
    /**
     * Store sum of previously added values.
     * For Ex:
     *  adding 1, 2, 3 resulting in [1, 3, 6]
     */
    val sums = mutableListOf<Int>()
    private var index = -1

    /**
     * Add [value] with O(1)
     */
    override fun add(value: Int) {
        when {
            value < 0 -> throw IllegalArgumentException("Value must be positive $value")
            index == -1 -> sums.add(value)
            else -> sums.add(sums[index] + value)
        }
        index++
    }

    /**
     * Get value by [index] with O(1)
     */
    override fun get(index: Int): Int = when {
        index < 0 -> throw IndexOutOfBoundsException("Index: $index can't be negative")
        index >= sums.size -> throw IndexOutOfBoundsException("Index: $index is more than array size: ${sums.size}")

        index == 0 -> sums[index]
        else -> sums[index] - sums[index - 1]
    }

    /**
     * Get sum in range [from] [to] with O(1)
     */
    override fun getSum(from: Int, to: Int): Int = when {
        from < 0 || to < 0 -> throw IndexOutOfBoundsException("Range index can't be negative. From: $from, To: $to")
        to >= sums.size -> throw IndexOutOfBoundsException("To: $to is more than array size: ${sums.size}")

        from == 0 -> sums[to]
        else -> sums[to] - sums[from - 1]
    }

    override fun toString(): String = sums.toString()
}