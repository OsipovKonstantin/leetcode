package org.example

class SolutionDay204 {
    companion object {
        fun maximumTripletValue(nums: IntArray): Long {
            val len = nums.size
            var prefixSum: Long = nums[0].toLong()
            var maxDiff: Long = 0
            var ans: Long = 0

            for (k in 0 until len) {
                val cur = nums[k].toLong()
                ans = maxOf(ans, cur * maxDiff)
                prefixSum = maxOf(prefixSum, cur)
                maxDiff = maxOf(maxDiff, prefixSum - cur)
            }
            return ans
        }
    }
}