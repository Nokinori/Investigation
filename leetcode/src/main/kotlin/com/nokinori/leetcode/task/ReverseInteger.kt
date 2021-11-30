package com.nokinori.leetcode.task

/**
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).



Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0


Constraints:

-231 <= x <= 231 - 1
 */
object ReverseInteger {
    fun reverseAsString(x: Int): Int {
        if (x == 0) return 0
        val isNegative = x < 0
        return try {
            val toInt = Math.abs(x).toString().reversed().toInt()
            if (isNegative) toInt.unaryMinus()
            else toInt
        } catch (e: NumberFormatException) {
            0
        }
    }

    fun reverse(x: Int): Int {
        var reversed: Long = 0
        val isNegative = x < 0
        var original = if (isNegative) Math.abs(x) else x
        while (original >= 1) {
            val lastDigit = original % 10 // get the last digit
            reversed = reversed * 10 + lastDigit // add last digit to reverted
            original /= 10 // remove last digit
        }
        return when {
            reversed > Int.MAX_VALUE || reversed < Int.MIN_VALUE -> return 0
            isNegative -> reversed.unaryMinus().toInt()
            else ->  reversed.toInt()
        }
    }
}