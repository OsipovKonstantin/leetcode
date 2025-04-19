package org.example.java;

//    medium(really hard. Solution about how computers works!) #bit manipulation.
//    I solved with support of leetcode community
//    Time complexity is O(n)
//    Space complexity is O(1)
//    https://leetcode.com/problems/single-number-ii
//    Given an integer array nums where every element appears three times except for one, which appears exactly once.
//    Find the single element and return it.
//    You must implement a solution with a linear runtime complexity and use only constant extra space.
//    Example 1:
//    Input: nums = [2,2,3,2]
//    Output: 3
//    Example 2:
//    Input: nums = [0,1,0,1,0,1,99]
//    Output: 99
public class SolutionDay75Third {
    public static int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        int threes;
        for (int num : nums) {
            twos = twos | (ones & num);
            ones = ones ^ num;
            threes = ones & twos;
            ones = ones & ~threes;
            twos = twos & ~threes;
        }
        return ones;
    }
}
