package org.example

//    easy #unique counting #kotlin
//    Time complexity is O(n), where n is the size of the nums array
//    Space complexity is O(1)
//    https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k
class SolutionDay207Third {
    companion object {
        fun minOperations(nums: IntArray, k: Int): Int {
            val unique = BooleanArray(101)
            for (num in nums) {
                if (num < k) return -1
                unique[num] = true
            }
            var ans = 0
            for (i in unique.indices) {
                if (i == k) continue
                if (unique[i]) ans++
            }
            return ans
        }
    }
}