package org.example.java;

import java.util.Arrays;

//    easy #sorting
//    Time complexity is O(nlogn)
//    Space complexity is O(logn)
//    https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x
//    You are given an array nums of non-negative integers. nums is considered special if there exists a number x such
//    that there are exactly x numbers in nums that are greater than or equal to x.
//    Notice that x does not have to be an element in nums.
//    Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for
//    x is unique.
//    Example 1:
//    Input: nums = [3,5]
//    Output: 2
//    Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.
//    Example 2:
//    Input: nums = [0,0]
//    Output: -1
//    Explanation: No numbers fit the criteria for x.
//    If x = 0, there should be 0 numbers >= x, but there are 2.
//    If x = 1, there should be 1 number >= x, but there are 0.
//    If x = 2, there should be 2 numbers >= x, but there are 0.
//    x cannot be greater since there are only 2 numbers in nums.
//    Example 3:
//    Input: nums = [0,4,3,0,4]
//    Output: 3
//    Explanation: There are 3 values that are greater than or equal to 3.
public class SolutionDay135 {
    public static int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (n - i <= nums[i]) {
                if (i == 0 || n - i > nums[i - 1]) return n - i;
            }
        }
        return -1;
    }
}
