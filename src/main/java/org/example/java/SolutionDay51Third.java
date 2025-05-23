package org.example.java;

//    easy #dynamic programming. Time complexity O(n) instead of brute force O(n*logn)
//    https://leetcode.com/problems/counting-bits
//    Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number
//    of 1's in the binary representation of i.
//    Example 1:
//    Input: n = 2
//    Output: [0,1,1]
//    Explanation:
//    0 --> 0
//    1 --> 1
//    2 --> 10
//    Example 2:
//    Input: n = 5
//    Output: [0,1,1,2,1,2]
//    Explanation:
//    0 --> 0
//    1 --> 1
//    2 --> 10
//    3 --> 11
//    4 --> 100
//    5 --> 101
public class SolutionDay51Third {
    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int offset = 1;
        for (int i = 1; i < n + 1; i++) {
            if (offset * 2 == i) offset = i;
            dp[i] = 1 + dp[i - offset];
        }
        return dp;
        // first intuitive solution. Time complexity O(n*logn), logn - counting bits by dividing by 2; n elements in for loop
        //int[] ans = new int[n+1];
        //for(int i = 0; i < n+1; i++){
        //    ans[i] = Integer.bitCount(i);
        //}
        //return ans;
    }
}