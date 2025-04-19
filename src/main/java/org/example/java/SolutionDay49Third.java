package org.example.java;

import java.util.HashMap;
import java.util.Map;

//    medium (really very advance solution) #prefix sum with storing in hashmap
//    Time complexity is O(n) instead of brute force solution with O(n^2). Space complexity O(n)
//    meanwhile brute force - O(1)
//    https://leetcode.com/problems/subarray-sum-equals-k
//    Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//    A subarray is a contiguous non-empty sequence of elements within an array.
//    Example 1:
//    Input: nums = [1,1,1], k = 2
//    Output: 2
//    Example 2:
//    Input: nums = [1,2,3], k = 3
//    Output: 2
//    Constraints:
//    1 <= nums.length <= 2 * 104
//    -1000 <= nums[i] <= 1000
//    -107 <= k <= 107
public class SolutionDay49Third {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);
        int ans = 0;
        int curSum = 0;
        for (int num : nums) {
            curSum += num;
            int diff = curSum - k;
            ans += prefixSums.getOrDefault(diff, 0);
            prefixSums.put(curSum, prefixSums.getOrDefault(curSum, 0) + 1);
        }
        return ans;
    }
}