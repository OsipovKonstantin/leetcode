package org.example.java;

import java.util.Arrays;

//    hard #dynamic programming. Recursive approach with memoization
//    Time complexity is O(n^3), where n is length of string s. n^2 times we iterate to find each left-right pair.
//    Computation of value for each left-right pair costs O(n), because we iterate with variable i from left to right
//    Space complexity is O(n^2), because we store 2D array memo
//    https://leetcode.com/problems/strange-printer
//    There is a strange printer with the following two special properties:
//    The printer can only print a sequence of the same character each time.
//    At each turn, the printer can print new characters starting from and ending at any place and will cover the
//    original existing characters.
//    Given a string s, return the minimum number of turns the printer needed to print it.
//    Example 1:
//    Input: s = "aaabbb"
//    Output: 2
//    Explanation: Print "aaa" first and then print "bbb".
//    Example 2:
//    Input: s = "aba"
//    Output: 2
//    Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the
//    existing character 'a'.
public class SolutionDay62Fifth {
    private static int[][] memo;
    private static char[] cs;
    private static int n;

    public static int strangePrinter(String s) {
        n = s.length();
        memo = new int[n][n];
        cs = s.toCharArray();
        for (int[] row : memo) Arrays.fill(row, -1);
        return 1 + traverse(0, n - 1);
    }

    private static int traverse(int left, int right) {
        if (memo[left][right] != -1) return memo[left][right];
        int j = -1;
        memo[left][right] = n;
        for (int i = left; i < right; i++) {
            if (j == -1 && cs[i] != cs[right]) j = i;
            if (j != -1) memo[left][right] = Math.min(
                    memo[left][right], 1 + traverse(j, i) + traverse(i + 1, right));
        }
        if (j == -1) memo[left][right] = 0;
        return memo[left][right];
    }
}
