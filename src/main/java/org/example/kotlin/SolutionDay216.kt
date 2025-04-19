package org.example.kotlin

//    medium #binary search #two pointers #kotlin
//    Time complexity is O(nlogn) because of sorting
//    Space complexity is O(logn) because of sorting
//    https://leetcode.com/problems/count-the-number-of-fair-pairs
class SolutionDay216 {
    companion object {
        fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
            nums.sort()
            var ans = 0L
            val len = nums.size
            var start = 0
            var end = len - 1
            while (start < end) {
                if (nums[start] + nums[end] < lower) {
                    var l = start + 1
                    var r = end - 1
                    while (l < r) {
                        val mid = (l + r) / 2
                        if (nums[mid] + nums[end] >= lower) r = mid
                        else l = mid + 1
                    }
                    start = l
                }
                if (nums[start] + nums[end] > upper) {
                    var l = start + 1
                    var r = end - 1
                    while (l < r) {
                        val mid = r - (r - l) / 2
                        if (nums[start] + nums[mid] <= upper) l = mid
                        else r = mid - 1
                    }
                    end = l
                }
                if (nums[start] + nums[end] > upper || nums[start] + nums[end] < lower) {
                    start++
                    continue
                }
                var l = start + 1
                var r = end
                while (l < r) {
                    val mid = (l + r) / 2
                    if (nums[start] + nums[mid] >= lower) r = mid
                    else l = mid + 1
                }
                ans += end - l + 1
                start++
            }
            return ans
        }
    }
}