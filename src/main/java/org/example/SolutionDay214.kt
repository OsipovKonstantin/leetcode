package org.example

//    easy #kotlin #array
//    Time complexity is O(n^2), where n is the size of the nums array
//    Space complexity is O(1)
//    https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array
class SolutionDay214 {
    companion object {
        fun countPairs(nums: IntArray, k: Int): Int {
            var ans = 0
            val len = nums.size
            for (i in 0 until len) {
                for (j in i + 1 until len) {
                    if (nums[i] == nums[j] && (i * j) % k == 0) ans++
                }
            }
            return ans
        }
    }
}