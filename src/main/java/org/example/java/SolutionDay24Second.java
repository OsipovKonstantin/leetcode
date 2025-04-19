package org.example.java;

import java.util.HashMap;
import java.util.Map;

//    medium. Cool approach for reversion of integer
//    https://leetcode.com/problems/count-nice-pairs-in-an-array
//    You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the
//    non-negative integer x. For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it
//    satisfies all of the following conditions:
//    0 <= i < j < nums.length
//    nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
//    Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.
//    Example 1:
//    Input: nums = [42,11,1,97]
//    Output: 2
//    Explanation: The two pairs are:
//     - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
//     - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
//    Example 2:
//    Input: nums = [13,10,35,24,76]
//    Output: 4
public class SolutionDay24Second {
    public static int countNicePairs(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        int res = 0;
        int mod = 1000000007;
        for (int num : nums) {
            int diff = num - rev(num);
            int value = counter.getOrDefault(diff, 0);
            res = (res + value) % mod;
            counter.put(diff, value + 1);
        }
        return res;
    }

    public static int rev(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        return rev;
    }
}
