package org.example.java;

//    medium #sliding window
//    Time complexity is O(n), where n is the size of nums array
//    Space complexity is O(1)
//    https://leetcode.com/problems/longest-nice-subarray
public class SolutionDay194 {
    public static int longestNiceSubarray(int[] nums) {
        int ans = 1;
        int end = 0;
        int curValue = nums[0];
        int len = nums.length;
        for (int start = 0; start < len; start++) {
            while (end + 1 < len && (curValue & nums[end + 1]) == 0) {
                curValue |= nums[end + 1];
                end++;
            }
            ans = Math.max(ans, end - start + 1);
            curValue ^= nums[start];
        }
        return ans;
    }
}
