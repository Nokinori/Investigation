package com.nokinori.leetcode.task

/**
 * [Task](https://leetcode.com/problems/binary-search/)
 *
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
object BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.lastIndex

        while (start <= end) {
            val middle = (start + end) / 2
            val current = nums[middle]

            when {
                current > target -> end = middle - 1
                current < target -> start = middle + 1
                else -> return middle
            }
        }
        return -1
    }
}