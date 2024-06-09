package org.example;

//    medium
//    Time complexity is O(n)
//    Space complexity is O(10001)
//    https://leetcode.com/problems/subarray-sums-divisible-by-k
//    Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible
//    by k.
//    A subarray is a contiguous part of an array.
//    Example 1:
//    Input: nums = [4,5,0,-2,-3,1], k = 5
//    Output: 7
//    Explanation: There are 7 subarrays with a sum divisible by k = 5:
//    [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
//    Example 2:
//    Input: nums = [5], k = 9
//    Output: 0
public class SolutionDay148 {
    public static int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int[] map = new int[10001];
        map[0] = 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int remainder = (sum + nums[i]) % k;
            sum = remainder < 0 ? remainder + k : remainder;
            map[sum]++;
            ans += (map[sum] - 1);
        }
        return ans;
    }
}
