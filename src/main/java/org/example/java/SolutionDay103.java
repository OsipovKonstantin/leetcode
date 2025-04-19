package org.example.java;

import java.util.ArrayList;
import java.util.List;

//    medium #array (tricky approach)
//    Time complexity is O(n), space complexity is O(1)
//    https://leetcode.com/problems/find-all-duplicates-in-an-array
//    Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer
//    appears once or twice, return an array of all the integers that appears twice.
//    You must write an algorithm that runs in O(n) time and uses only constant extra space.
//    Example 1:
//    Input: nums = [4,3,2,7,8,2,3,1]
//    Output: [2,3]
//    Example 2:
//    Input: nums = [1,1,2]
//    Output: [1]
//    Example 3:
//    Input: nums = [1]
//    Output: []
public class SolutionDay103 {
    public static List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int absNum = Math.abs(num);
            if (nums[absNum - 1] > 0) nums[absNum - 1] *= -1;
            else ans.add(absNum);
        }
        return ans;
    }
}

