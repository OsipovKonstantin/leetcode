package org.example.java;

//    medium #sliding window. Time complexity is O(n), space complexity is O(1)
//    https://leetcode.com/problems/minimum-size-subarray-sum
//    Given an array of positive integers nums and a positive integer target, return the minimal length of a
//    subarray
//     whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
//    Example 1:
//    Input: target = 7, nums = [2,3,1,2,4,3]
//    Output: 2
//    Explanation: The subarray [4,3] has the minimal length under the problem constraint.
//    Example 2:
//    Input: target = 4, nums = [1,4,4]
//    Output: 1
//    Example 3:
//    Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//    Output: 0
public class SolutionDay74Third {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int slidingSum = 0;
        int start = 0;
        int ans = Integer.MAX_VALUE;
        for (int end = 0; end < n; end++) {
            slidingSum += nums[end];
            while (slidingSum >= target) {
                ans = Math.min(ans, end - start + 1);
                slidingSum -= nums[start];
                start++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
