package org.example;

import java.util.HashMap;
import java.util.Map;

//    medium(very interesting task!) #hashmap
//    Time complexity is O(n), where n is number of elements in nums
//    Space complexity is O(n)
//    https://leetcode.com/problems/contiguous-array
//    Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
//    Example 1:
//    Input: nums = [0,1]
//    Output: 2
//    Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
//    Example 2:
//    Input: nums = [0,1,0]
//    Output: 2
//    Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
public class SolutionDay95 {
    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 0) count--;
            else count++;
            if (!map.containsKey(count)) map.put(count, i);
            else ans = Math.max(ans, i - map.get(count));
        }
        return ans;
    }
}
