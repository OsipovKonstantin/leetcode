package org.example;

//    hard #binary search (mid; mid+1)
//    Time complexity is O(nlogmax) where n is number of elements in array (nums or cost), max is maximum value
//    among nums
//    Space complexity is O(1)
//    https://leetcode.com/problems/minimum-cost-to-make-array-equal
//    You are given two 0-indexed arrays nums and cost consisting each of n positive integers.
//    You can do the following operation any number of times:
//    Increase or decrease any element of the array nums by 1.
//    The cost of doing one operation on the ith element is cost[i].
//    Return the minimum total cost such that all the elements of the array nums become equal.
//    Example 1:
//    Input: nums = [1,3,5,2], cost = [2,3,1,14]
//    Output: 8
//    Explanation: We can make all the elements equal to 2 in the following way:
//    - Increase the 0th element one time. The cost is 2.
//    - Decrease the 1st element one time. The cost is 3.
//    - Decrease the 2nd element three times. The cost is 1 + 1 + 1 = 3.
//    The total cost is 2 + 3 + 3 = 8.
//    It can be shown that we cannot make the array equal with a smaller cost.
//    Example 2:
//    Input: nums = [2,2,2,2,2], cost = [4,2,8,1,3]
//    Output: 0
//    Explanation: All the elements are already equal, so no operations are needed.
public class SolutionDay85Second {
    public static long minCost(int[] nums, int[] cost) {
        int max = 0;
        for (int num : nums) max = Math.max(max, num);
        int left = 0;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            long midCost = calculateCost(mid, nums, cost);
            long midPlusCost = calculateCost(mid + 1, nums, cost);
            if (midCost < midPlusCost)
                right = mid;
            else
                left = mid + 1;
        }
        return calculateCost(left, nums, cost);
    }

    private static long calculateCost(int val, int[] nums, int[] cost) {
        int n = nums.length;
        long totalCost = 0;
        for (int i = 0; i < n; i++)
            totalCost += (long) (nums[i] - val > 0 ? nums[i] - val : val - nums[i]) * cost[i];
        return totalCost;
    }
}
