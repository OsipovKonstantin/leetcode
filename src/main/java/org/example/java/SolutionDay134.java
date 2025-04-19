package org.example.java;

import java.util.Arrays;

//    hard #dynamic programming
//    Time complexity is O(n) where n is answer (number of combinations)
//    Space complexity is O(n)
//    https://leetcode.com/problems/student-attendance-record-ii
//    An attendance record for a student can be represented as a string where each character signifies whether the
//    student was absent, late, or present on that day. The record only contains the following three characters:
//    'A': Absent.
//    'L': Late.
//    'P': Present.
//    Any student is eligible for an attendance award if they meet both of the following criteria:
//    The student was absent ('A') for strictly fewer than 2 days total.
//    The student was never late ('L') for 3 or more consecutive days.
//    Given an integer n, return the number of possible attendance records of length n that make a student eligible
//    for an attendance award. The answer may be very large, so return it modulo 109 + 7.
//    Example 1:
//    Input: n = 2
//    Output: 8
//    Explanation: There are 8 records with length 2 that are eligible for an award:
//    "PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
//    Only "AA" is not eligible because there are 2 absences (there need to be fewer than 2).
//    Example 2:
//    Input: n = 1
//    Output: 3
//    Example 3:
//    Input: n = 10101
//    Output: 183236316
public class SolutionDay134 {
    private static int[][][] memo;
    private static int mod = 1000000007;

    public static int checkRecord(int n) {
        memo = new int[n + 1][2][3];
        for (int[][] rowcol : memo) {
            for (int[] row : rowcol) {
                Arrays.fill(row, -1);
            }
        }
        return traverse(n, 0, 0);
    }

    private static int traverse(int n, int totalAbsents, int sequenceLates) {
        if (totalAbsents > 1 || sequenceLates > 2) return 0;
        if (n == 0) return 1;
        if (memo[n][totalAbsents][sequenceLates] != -1) {
            return memo[n][totalAbsents][sequenceLates];
        }
        //if present
        int sum = traverse(n - 1, totalAbsents, 0) % mod;
        //if absent
        sum = (sum + traverse(n - 1, totalAbsents + 1, 0)) % mod;
        //if late
        sum = (sum + traverse(n - 1, totalAbsents, sequenceLates + 1)) % mod;

        memo[n][totalAbsents][sequenceLates] = sum;
        return sum;
    }
}
