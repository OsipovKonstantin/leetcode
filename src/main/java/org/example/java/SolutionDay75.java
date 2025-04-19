package org.example.java;

//    medium #sliding window. Time complexity is O(n), space complexity is O(1)
//    https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element
//    Given a binary array nums, you should delete one element from it.
//    Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there
//    is no such subarray.
//    Example 1:
//    Input: nums = [1,1,0,1]
//    Output: 3
//    Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
//    Example 2:
//    Input: nums = [0,1,1,1,0,1,1,0,1]
//    Output: 5
//    Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's
//    is [1,1,1,1,1].
//    Example 3:
//    Input: nums = [1,1,1]
//    Output: 2
//    Explanation: You must delete one element.
public class SolutionDay75 {
    public static int longestSubarray(int[] nums) {
        int n = nums.length;
        int start = 0;
        int ans = 0;
        int zeroCount = 0;
        for (int end = 0; end < n; end++) {
            zeroCount += nums[end] == 0 ? 1 : 0;
            while (zeroCount > 1) {
                zeroCount -= nums[start] == 0 ? 1 : 0;
                start++;
            }
            ans = Math.max(ans, end - start);
        }
        return ans;
    }
}
