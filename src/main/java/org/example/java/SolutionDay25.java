package org.example.java;

import java.util.Arrays;

//    medium. Sliding window
//    https://leetcode.com/problems/frequency-of-the-most-frequent-element
//    The frequency of an element is the number of times it occurs in an array.
//    You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and
//    increment the element at that index by 1.
//    Return the maximum possible frequency of an element after performing at most k operations.
//    Example 1:
//    Input: nums = [1,2,4], k = 5
//    Output: 3
//    Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
//    4 has a frequency of 3.
//    Example 2:
//    Input: nums = [1,4,8,13], k = 5
//    Output: 2
//    Explanation: There are multiple optimal solutions:
//    - Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
//    - Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
//    - Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
//    Example 3:
//    Input: nums = [3,9,6], k = 2
//    Output: 1
public class SolutionDay25 {
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        int left = 0;
        long windowSum = 0;
        for (int right = 0; right < n; right++) {
            int target = nums[right];
            windowSum += target;
            if ((long) target * (right - left + 1) - windowSum > k) {
                windowSum -= nums[left];
                left++;
            }
        }
        return n - left;
    }
}
