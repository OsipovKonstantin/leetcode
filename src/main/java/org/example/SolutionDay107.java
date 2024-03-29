package org.example;

//    medium #slidingwindow
//    Time complexity is O(n)
//    Space complexity is O(1)
//    https://leetcode.com/problems/subarray-product-less-than-k
//    Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of
//    all the elements in the subarray is strictly less than k.
//    Example 1:
//    Input: nums = [10,5,2,6], k = 100
//    Output: 8
//    Explanation: The 8 subarrays that have product less than 100 are:
//    [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
//    Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
//    Example 2:
//    Input: nums = [1,2,3], k = 0
//    Output: 0
public class SolutionDay107 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int ans = 0;
        int product = nums[start];
        for (int num : nums) ans += num < k ? 1 : 0;
        for (int end = 1; end < n; end++) {
            product *= nums[end];
            while (start + 1 < end && product >= k) {
                product /= nums[start];
                start++;
            }
            if (product < k) ans += (end - start);
        }
        return ans;
    }
}
