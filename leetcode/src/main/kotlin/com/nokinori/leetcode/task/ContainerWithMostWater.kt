package com.nokinori.leetcode.task


/**
 * [Task](https://leetcode.com/problems/container-with-most-water/)
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
 * Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 */
object ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        if (height.isEmpty()) return 0

        var maxArea = 0

        var start = 0
        var end = height.lastIndex

        while (start < end) {
            val leftLineHeight = height[start]
            val rightLineHeight = height[end]
            val shortestLineHeight = minOf(leftLineHeight, rightLineHeight)
            val containerSize = end - start
            val currentArea = containerSize * shortestLineHeight

            maxArea = maxOf(maxArea, currentArea)
            if (leftLineHeight < rightLineHeight) start++
            else end--
        }
        return maxArea
    }
}