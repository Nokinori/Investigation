package com.nokinori.leetcode.task

/**
 * [Task](https://leetcode.com/problems/integer-to-roman/)
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 *
 * There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Given an integer 1 <= num <= 3999, convert it to a roman numeral.
 */
object IntegerToRoman {
    private val intToRoman = mapOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I",
    ).entries

    fun intToRoman(num: Int): String {
        if (num <= 0 || num >= 4000) return ""

        var number = num
        val result = StringBuilder()

        for ((int, romanNum) in intToRoman) {
            if (number >= int) {
                val divides = number / int
                repeat(divides) {
                    result.append(romanNum)
                }
                number -= divides * int
            }
        }

        return result.toString()
    }
}