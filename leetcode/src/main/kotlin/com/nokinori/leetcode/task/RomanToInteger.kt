package com.nokinori.leetcode.task

/**
 * [Task](https://leetcode.com/problems/roman-to-integer/)
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * For example, 2 is written as II in Roman numeral, just two one's added together.
 * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 *
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Given a roman numeral, convert it to an integer.
 *
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
object RomanToInteger {
    fun romanToInt(s: String): Int {
        if (s.length > 15) return 0

        val chars = s.toCharArray()

        var num = 0

        var i = chars.lastIndex
        while (i >= 0) {
            val current = chars[i]
            if (canBeComposite(current)) {
                if (i - 1 >= 0 && getCompositeNumOrNull(chars[i - 1], current) != null) {
                    num += getCompositeNumOrNull(chars[i - 1], current)!!
                    i -= 2
                } else {
                    num += oneSymbolNum(current)
                    i--
                }
            } else {
                num += oneSymbolNum(current)
                i--
            }
        }

        return num
    }


    private fun canBeComposite(char: Char) = when (char) {
        'M', 'D', 'C', 'L', 'X', 'V' -> true
        else -> false
    }

    private fun getCompositeNumOrNull(char1: Char, char2: Char) = when {
        char1 == 'C' && char2 == 'M' -> 900
        char1 == 'C' && char2 == 'D' -> 400
        char1 == 'X' && char2 == 'C' -> 90
        char1 == 'X' && char2 == 'L' -> 40
        char1 == 'I' && char2 == 'X' -> 9
        char1 == 'I' && char2 == 'V' -> 4
        else -> null
    }

    private fun oneSymbolNum(char: Char) = when (char) {
        'M' -> 1000
        'D' -> 500
        'C' -> 100
        'L' -> 50
        'X' -> 10
        'V' -> 5
        'I' -> 1
        else -> error("Not valid $char")
    }
}