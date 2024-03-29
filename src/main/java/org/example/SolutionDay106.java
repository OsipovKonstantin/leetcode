package org.example;

//    medium #sliding window
//    Time complexity is O(n)
//    Space complexity is O(1)
//    https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times
//    You are given an integer array nums and a positive integer k.
//    Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
//    A subarray is a contiguous sequence of elements within an array.
//    Example 1:
//    Input: nums = [1,3,2,3,3], k = 2
//    Output: 6
//    Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3],
//    [3,2,3,3], [2,3,3] and [3,3].
//    Example 2:
//    Input: nums = [1,4,2,1], k = 3
//    Output: 0
//    Explanation: No subarray contains the element 4 at least 3 times.
public class SolutionDay106 {
    public static long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        long ans = 0;
        int max = Integer.MIN_VALUE;
        int maxCount = 0;
        for (int num : nums) max = Math.max(max, num);

        for (int end = 0; end < n; end++) {
            if (nums[end] == max) maxCount++;
            while (maxCount > k) {
                if (nums[start] == max) maxCount--;
                start++;
            }
            while (start < end && nums[start] != max) start++;
            if (maxCount == k) ans += start + 1;
        }
        return ans;
    }
}
