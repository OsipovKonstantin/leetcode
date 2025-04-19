package org.example.java;

//    hard #sliding window
//    Time complexity is O(n)
//    Space complexity is O(1)
//    https://leetcode.com/problems/count-subarrays-with-fixed-bounds
//    You are given an integer array nums and two integers minK and maxK.
//    A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
//    The minimum value in the subarray is equal to minK.
//    The maximum value in the subarray is equal to maxK.
//    Return the number of fixed-bound subarrays.
//    A subarray is a contiguous part of an array.
//    Example 1:
//    Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
//    Output: 2
//    Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
//    Example 2:
//    Input: nums = [1,1,1,1], minK = 1, maxK = 1
//    Output: 10
//    Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.
public class SolutionDay110 {
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int first = -1;
        int lastMin = -1;
        int lastMax = -1;
        long ans = 0;
        for (int end = 0; end < n; end++) {
            int num = nums[end];
            if (num > maxK || num < minK) {
                first = -1;
                lastMin = -1;
                lastMax = -1;
                continue;
            }
            if (first == -1) first = end;
            if (num == minK) lastMin = end;
            if (num == maxK) lastMax = end;
            if (lastMin != -1 && lastMax != -1) ans += (Math.min(lastMin, lastMax) - first + 1);
        }
        return ans;
    }
}
