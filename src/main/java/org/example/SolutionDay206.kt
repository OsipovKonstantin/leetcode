package org.example

//    medium #dp #kotlin
//    Time complexity is O(n*target), where n is the size of nums array and target is sum of nums array divided by 2
//    Space complexity is O(target)
//    https://leetcode.com/problems/partition-equal-subset-sum
class SolutionDay206 {
    companion object {
        fun canPartition(nums: IntArray): Boolean {
            val sum = nums.sum()
            if (sum % 2 != 0) return false
            val target = sum / 2

            var sums = BooleanArray(target + 1)
            sums[0] = true
            for (num in nums) {
                val temp = BooleanArray(target + 1)
                for (i in 0..target) {
                    if (sums[i]) {
                        temp[i] = true
                        if (i + num <= target) {
                            temp[i + num] = true
                        }
                    }
                }
                if (temp[target]) return true
                sums = temp
            }
            return sums[target]
        }
    }
}