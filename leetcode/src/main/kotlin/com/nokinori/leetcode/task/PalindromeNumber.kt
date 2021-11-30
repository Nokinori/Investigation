package com.nokinori.leetcode.task

/**
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.

Example 1:

Input: x = 121
Output: true
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Example 4:

Input: x = -101
Output: false


Constraints:

-231 <= x <= 231 - 1
 */
object PalindromeNumber {
    fun isPalindromeAsString(x: Int): Boolean {
        if (x == 0) return true
        if (x < 0 || x % 10 == 0) return false

        val chars = x.toString().toCharArray()

        var isPalindrome = true

        var start = 0
        var end = chars.lastIndex
        while (start < end) {
            if (chars[start++] != chars[end--]) {
                isPalindrome = false
                break
            }
        }
        return isPalindrome
    }

    fun isPalindrome(x: Int): Boolean {
        if (x == 0) return true
        if (x < 0 || x % 10 == 0) return false

        var reversed = 0
        var original = x
        while (original >= 1) {
            reversed = reversed * 10 + original % 10
            original /= 10
        }
        return x == reversed
    }
}