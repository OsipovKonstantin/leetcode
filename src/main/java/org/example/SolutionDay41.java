package org.example;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//    medium (really hard) #stack (deque is faster, so we use it instead) for constructing two 1D arrays
//    (int[] left and int[] right) for the indexes of the first minimum element to the left of the ith number and
//    to the right of the ith number. Time complexity O(n)! Dynamic programming approach for this task has TC O(n^2)
//    https://leetcode.com/problems/sum-of-subarray-minimums
//    Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
//    Since the answer may be large, return the answer modulo 109 + 7.
//    Example 1:
//    Input: arr = [3,1,2,4]
//    Output: 17
//    Explanation:
//    Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
//    Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
//    Sum is 17.
//    Example 2:
//    Input: arr = [11,81,94,43,3]
//    Output: 444
public class SolutionDay41 {
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;
        long ans = 0;
        int[] left = new int[n];
        Arrays.fill(left, -1);
        int[] right = new int[n];
        Arrays.fill(right, n);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        for (int j = 0; j < n; j++) {
            long multiplier = (j - left[j]) * (right[j] - j) % mod;
            long numAns = (arr[j] * multiplier) % mod;
            ans = (ans + numAns) % mod;
        }
        return (int) ans;
    }
}
