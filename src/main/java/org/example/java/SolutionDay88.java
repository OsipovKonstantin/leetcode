package org.example.java;

//    easy #counting
//    Time complexity is O(n), where n is number of elements in nums
//    space complexity is O(1), because size of array freq is constant (101 elements)
//    https://leetcode.com/problems/count-elements-with-maximum-frequency
//    You are given an array nums consisting of positive integers.
//    Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
//    The frequency of an element is the number of occurrences of that element in the array.
//    Example 1:
//    Input: nums = [1,2,2,3,1,4]
//    Output: 4
//    Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
//    So the number of elements in the array with maximum frequency is 4.
//    Example 2:
//    Input: nums = [1,2,3,4,5]
//    Output: 5
//    Explanation: All elements of the array have a frequency of 1 which is the maximum.
//    So the number of elements in the array with maximum frequency is 5.
public class SolutionDay88 {
    public static int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxFreq = 0;
        for (int num : nums) {
            freq[num]++;
            maxFreq = Math.max(maxFreq, freq[num]);
        }
        int ans = 0;
        for (int i = 0; i < freq.length; i++)
            if (freq[i] == maxFreq) ans += freq[i];
        return ans;
    }
}
