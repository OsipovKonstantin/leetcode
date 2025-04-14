package org.example

import kotlin.math.abs

//    easy #prefix sum #kotlin
//    Time complexity is O(n^2+n*max), where n is the size of arr array
//    and max is the maximum value of the elements in the arr array
//    Space complexity is O(max)
//    https://leetcode.com/problems/count-good-triplets
class SolutionDay211 {
    companion object {
        fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
            var ans = 0
            val len = arr.size
            val prefixSum = IntArray(1001)
            for (j in 0 until len) {
                for (k in j + 1 until len) {
                    if (abs(arr[j] - arr[k]) > b) continue
                    val left = maxOf(0, maxOf(arr[j] - a, arr[k] - c))
                    val right = minOf(1000, minOf(arr[j] + a, arr[k] + c))
                    if (left > right) continue
                    ans += prefixSum[right] - if (left == 0) 0 else prefixSum[left - 1]
                }
                for (p in arr[j]..1000) {
                    prefixSum[p]++
                }
            }
            return ans
        }
    }
}