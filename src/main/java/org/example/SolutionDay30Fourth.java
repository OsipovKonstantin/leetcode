package org.example;

//    medium. #Dynamic programming with 2D boolean array
//    There are faster solutions (Expand from center and Manchester's algorithm) but this one is simple to understand
//    https://leetcode.com/problems/longest-palindromic-substring
//    Given a string s, return the longest palindromic substring in s.
//    Example 1:
//    Input: s = "babad"
//    Output: "bab"
//    Explanation: "aba" is also a valid answer.
//    Example 2:
//    Input: s = "cbbd"
//    Output: "bb"
public class SolutionDay30Fourth {
    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int[] ans = new int[]{0, 0};
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                dp[i][i + 1] = true;
                ans[0] = i;
                ans[1] = i + 1;
            }
        }
        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                if (chars[i] == chars[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }
}
