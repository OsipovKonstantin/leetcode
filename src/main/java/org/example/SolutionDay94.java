package org.example;

import java.util.Arrays;

//    medium #prefix sum (prefix multiplier)
//    Time complexity is O(n), space complexity is O(1)
//    https://leetcode.com/problems/product-of-array-except-self
//    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the
//    elements of nums except nums[i].
//    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//    You must write an algorithm that runs in O(n) time and without using the division operation.
//    Example 1:
//    Input: nums = [1,2,3,4]
//    Output: [24,12,8,6]
//    Example 2:
//    Input: nums = [-1,1,0,-3,3]
//    Output: [0,0,9,0,0]
public class SolutionDay94 {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prefix = 1;
        int postfix = 1;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = 0; i < n - 1; i++) {
            prefix *= nums[i];
            postfix *= nums[n - 1 - i];
            ans[i + 1] *= prefix;
            ans[n - 2 - i] *= postfix;
        }
        return ans;
    }
}
