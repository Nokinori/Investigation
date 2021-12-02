package com.nokinori.leetcode.task

/**
 * [Task](https://leetcode.com/problems/search-insert-position/)
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
object SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {

        if (target < nums[0]) return 0
        if (target > nums[nums.lastIndex]) return nums.lastIndex + 1

        var start = 0
        var end = nums.lastIndex

        while (start <= end) {
            val middle = start + (end - start) / 2

            val current = nums[middle]
            when {
                current == target -> return middle
                current > target -> end = middle - 1
                else -> start = middle + 1
            }
        }
        return start
    }
}