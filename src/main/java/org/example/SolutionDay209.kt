package org.example

//    easy #set #kotlin
//    Time complexity is O(n), where n is the number of elements in the nums array
//    Space complexity is O(n)
//    https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct
class SolutionDay209 {
    companion object {
        fun minimumOperations(nums: IntArray): Int {
            val len = nums.size
            val unique = BooleanArray(101)
            for (i in len - 1 downTo 0) {
                if (unique[nums[i]]) {
                    return (i + 3) / 3
                }
                unique[nums[i]] = true
            }
            return 0
        }
    }
}