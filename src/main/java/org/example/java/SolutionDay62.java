package org.example.java;

//    medium #dynamic programming. Tabulation approach with space optimization
//    Time complexity is O(n^2), where n - is length of string.
//    Space complexity is O(n), because we use three 1D arrays (prevPrev, prev and cur) instead of 2D array (int[][] dp)
//    https://leetcode.com/problems/palindromic-substrings
//    Given a string s, return the number of palindromic substrings in it.
//    A string is a palindrome when it reads the same backward as forward.
//    A substring is a contiguous sequence of characters within the string.
//    Example 1:
//    Input: s = "abc"
//    Output: 3
//    Explanation: Three palindromic strings: "a", "b", "c".
//    Example 2:
//    Input: s = "aaa"
//    Output: 6
//    Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
public class SolutionDay62 {
    public static int countSubstrings(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] prevPrev = new int[n];
        int[] prev = new int[n];
        int[] cur = new int[n];
        int counter = 0;
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                cur[col] = cs[col] == cs[col - row] ? 1 : 0;
                cur[col] = col - 1 >= 0 && row - 2 >= 0 && prevPrev[col - 1] == 0 ? 0 : cur[col];
                counter += cur[col];
            }
            prevPrev = prev;
            prev = cur;
            cur = new int[n];
        }
        return counter;
    }
}
