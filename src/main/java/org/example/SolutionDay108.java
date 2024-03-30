package org.example;

import java.util.HashMap;
import java.util.Map;

//hard #sliding window
//Time complexity is O(n)
//Space complexity is O(n)
//https://leetcode.com/problems/subarrays-with-k-different-integers
//Given an integer array nums and an integer k, return the number of good subarrays of nums.
//A good array is an array where the number of different integers in that array is exactly k.
//For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
//A subarray is a contiguous part of an array.
//Example 1:
//Input: nums = [1,2,1,2,3], k = 2
//Output: 7
//Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
//Example 2:
//Input: nums = [1,2,1,3,4], k = 3
//Output: 3
//Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
public class SolutionDay108 {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> unique = new HashMap<>();
        int n = nums.length;
        int ans = 0;
        int start = 0;
        int counter = 0;
        int prefCounter = 0;
        for (int end = 0; end < n; end++) {
            if (unique.getOrDefault(nums[end], 0) == 0) counter++;
            unique.put(nums[end], unique.getOrDefault(nums[end], 0) + 1);
            if (counter > k) {
                prefCounter = 0;
                while (start < end && counter > k) {
                    if (unique.get(nums[start]) == 1) counter--;
                    unique.put(nums[start], unique.get(nums[start]) - 1);
                    start++;
                }
            }
            if (counter == k) {
                while (start < end && unique.get(nums[start]) > 1) {
                    unique.put(nums[start], unique.get(nums[start]) - 1);
                    start++;
                    prefCounter++;
                }
                ans += prefCounter + 1;
            }
        }
        return ans;
    }
}
