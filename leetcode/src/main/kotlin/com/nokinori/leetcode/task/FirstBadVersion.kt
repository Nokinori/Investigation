package com.nokinori.leetcode.task

/**
 * [Task](https://leetcode.com/problems/first-bad-version/)
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 *
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
object FirstBadVersion : VersionControl {
    override fun firstBadVersion(n: Int): Int {
        var start = 1
        var end = n
        var firstBadVersion = start
        var middle: Int

        while (start <= end) {
            middle = start + (end - start) / 2
            if (isBadVersion(middle)) {
                firstBadVersion = middle
                end = middle - 1
            } else {
                start = middle + 1
            }

        }

        return firstBadVersion
    }
}

interface VersionControl {
    fun isBadVersion(n: Int) = n >= 4
    fun firstBadVersion(n: Int): Int
}