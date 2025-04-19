package org.example.java;

//    medium (really hard for me). #sliding window (first we find max subarray with smaller or equal sum and then slide)
//    Dynamic programming and recursion don't work for this task due to constraint 1<=nums.length<=10^5
//    https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero
//    You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the
//    rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future
//    operations.
//    Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
//    Example 1:
//    Input: nums = [1,1,4,2,3], x = 5
//    Output: 2
//    Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
//    Example 2:
//    Input: nums = [5,6,7,8,9], x = 4
//    Output: -1
//    Example 3:
//    Input: nums = [3,2,20,1,1,3], x = 10
//    Output: 5
//    Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in
//    total) to reduce x to zero.
public class SolutionDay42Fourth {
    public static int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for (int k = 0; k < n; k++) {
            sum += nums[k];
        }
        if (sum < x) {
            return -1;
        }

        int ans = Integer.MAX_VALUE;
        int sumLeft = 0;
        int maxLenLeft = 0;
        while (maxLenLeft < n && sumLeft + nums[maxLenLeft] <= x) {
            sumLeft += nums[maxLenLeft];
            maxLenLeft++;
        }
        if (sumLeft == x) {
            ans = Math.min(ans, maxLenLeft);
        }
        int sumRight = 0;
        int maxLenRight = 0;
        while (maxLenRight < n && sumRight + nums[n - 1 - maxLenRight] <= x) {
            sumRight += nums[n - 1 - maxLenRight];
            maxLenRight++;
        }
        if (sumRight == x) {
            ans = Math.min(ans, maxLenRight);
        }
        int len = 0;
        if (maxLenLeft > maxLenRight) {
            len = maxLenLeft;
            for (int i = n - 1; i > n - 1 - maxLenRight; i--) {
                while (sumLeft > x) {
                    sumLeft -= nums[maxLenLeft - 1];
                    maxLenLeft--;
                    len--;
                }
                if (sumLeft == x) {
                    ans = Math.min(ans, len);
                }
                sumLeft += nums[i];
                len++;
                if (sumLeft == x) {
                    ans = Math.min(ans, len);
                }
            }
        } else {
            len = maxLenRight;
            for (int i = 0; i < maxLenLeft; i++) {
                while (sumRight > x) {
                    sumRight -= nums[n - maxLenRight];
                    maxLenRight--;
                    len--;
                }
                if (sumRight == x) {
                    ans = Math.min(ans, len);
                }
                sumRight += nums[i];
                len++;
                if (sumRight == x) {
                    ans = Math.min(ans, len);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
