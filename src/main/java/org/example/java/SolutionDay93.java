package org.example.java;

//    medium #sliding window
//    Time complexity is O(n), where n is size of nums array
//    Space complexity is O(1)
//    https://leetcode.com/problems/binary-subarrays-with-sum
//    Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
//    A subarray is a contiguous part of the array.
//    Example 1:
//    Input: nums = [1,0,1,0,1], goal = 2
//    Output: 4
//    Explanation: The 4 subarrays are bolded and underlined below:
//    [1,0,1,0,1]
//    [1,0,1,0,1]
//    [1,0,1,0,1]
//    [1,0,1,0,1]
//    Example 2:
//    Input: nums = [0,0,0,0,0], goal = 0
//    Output: 15
public class SolutionDay93 {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int start = 0;
        int preZeros = 0;
        int sum = 0;
        int ans = 0;
        for (int end = 0; end < n; end++) {
            sum += nums[end];
            while (start < end && (sum > goal || nums[start] == 0)) {
                if (nums[start] == 0) preZeros++;
                else preZeros = 0;
                sum -= nums[start++];
            }
            if (sum == goal) ans += 1 + preZeros;
        }
        return ans;
    }
}
