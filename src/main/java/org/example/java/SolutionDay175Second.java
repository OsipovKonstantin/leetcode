package org.example.java;

//    medium #prefix sum (not optimal solution, it can be 4 times faster)
//    Time complexity is O(n), where n is the size of nums array
//    Space complexity is O(n) because prefixSum and postfixSum arrays each contain n elements
//    https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray
public class SolutionDay175Second {
    public static int maxAbsoluteSum(int[] nums) {
        int len = nums.length;
        int[] prefixSum = new int[len];
        int[] postfixSum = new int[len];
        int lMax = Integer.MIN_VALUE;
        int rMax = Integer.MIN_VALUE;
        int lMin = Integer.MAX_VALUE;
        int rMin = Integer.MAX_VALUE;
        int lMaxIndex = 0;
        int rMaxIndex = 0;
        int lMinIndex = 0;
        int rMinIndex = 0;
        for (int i = 0; i < len; i++) {
            prefixSum[i] = nums[i] + (i - 1 >= 0 ? prefixSum[i - 1] : 0);
            postfixSum[len - i - 1] = nums[len - i - 1] + (i - 1 >= 0 ? postfixSum[len - i] : 0);
            if (lMax < prefixSum[i]) {
                lMax = prefixSum[i];
                lMaxIndex = i;
            }
            if (lMin > prefixSum[i]) {
                lMin = prefixSum[i];
                lMinIndex = i;
            }
            if (rMax < postfixSum[len - i - 1]) {
                rMax = postfixSum[len - i - 1];
                rMaxIndex = len - i - 1;
            }
            if (rMin > postfixSum[len - i - 1]) {
                rMin = postfixSum[len - i - 1];
                rMinIndex = len - i - 1;
            }
        }
        int maxSum = rMaxIndex > 0 ? prefixSum[lMaxIndex] - prefixSum[rMaxIndex - 1] : prefixSum[lMaxIndex];
        int minSum = rMinIndex > 0 ? prefixSum[lMinIndex] - prefixSum[rMinIndex - 1] : prefixSum[lMinIndex];
        return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }
}
