package com.nokinori.leetcode.task

import java.time.Duration
import java.time.LocalTime
import kotlin.math.min

/**
 *
 * Read the array of strings stored in strArr which will be an unsorted list of times in a twelve-hour format like so: HH:MM(am/pm).
 *
 * Your goal is to determine the smallest difference in minutes between two of the times in the list.
 *
 * For example: if strArr is ["2:10pm", "1:30pm", "10:30am*, "4:42pm") then your program should return 40 because
 * the smallest difference is between 1:30pm and 2:10pm with a difference of 40 minutes.
 *
 * The input array will always contain at least two elements and all of the elements will be in the correct format and unique.
 */
object DiffTwoDateTimeIn12HFormat {
    fun solution(input: Array<String>): Int {
        //parse time and sort
        val sortedTimes = input
            .map {
                val arr = it.split(":")
                Triple(arr[0], arr[1].substring(0, 2), arr[1].substring(2, 4) == "am")
            }
            .map { (hh, mm, am) ->
                val hh24 = if (am && hh == "12") "00"
                else (hh.toInt() + 12).toString()

                LocalTime.parse("$hh24:$mm")
            }
            .sorted()


        var minDiff = Int.MAX_VALUE

        for (i in 0..sortedTimes.size - 2) {
            val curDif = Duration.between(sortedTimes[i], sortedTimes[i + 1])
            minDiff = min(minDiff, curDif.toMinutes().toInt())
        }

        return minDiff
    }
}