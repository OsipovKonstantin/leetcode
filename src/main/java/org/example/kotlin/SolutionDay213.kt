package org.example.kotlin

//    medium #sliding window #kotlin
//    Time complexity is O(n), where n is the size of the nums array
//    Space complexity is O(n) due to map
//    https://leetcode.com/problems/count-the-number-of-good-subarrays
class SolutionDay213 {
    companion object {
        fun countGood(nums: IntArray, k: Int): Long {
            val len = nums.size
            val map = mutableMapOf<Int, Int>()
            var end = 0
            var quantity = 0
            var ans = 0L
            for (start in 0 until len) {
                while (end < len && quantity < k) {
                    val endNum = nums[end]
                    map[endNum] = (map[endNum] ?: 0) + 1
                    quantity += (map[endNum] ?: 0) - 1
                    end++
                }
                if (end == len && quantity < k) break
                ans += (len - end + 1)
                val startNum = nums[start]
                quantity -= (map[startNum] ?: 0) - 1
                map[startNum] = (map[startNum] ?: 0) - 1
            }
            return ans
        }
    }
}