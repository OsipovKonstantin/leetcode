package org.example;

//    medium #dynamic programming - tabulation. Space optimized solution (instead if dp[m][n] we use two arrays int[n])
//    time complexity O(n*m), where n - size of String text1, n - size of String text2. Space complexity O(n)
//    https://leetcode.com/problems/longest-common-subsequence
//    Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common
//    subsequence, return 0.
//    A subsequence of a string is a new string generated from the original string with some characters (can be none)
//    deleted without changing the relative order of the remaining characters.
//    For example, "ace" is a subsequence of "abcde".
//    A common subsequence of two strings is a subsequence that is common to both strings.
//    Example 1:
//    Input: text1 = "abcde", text2 = "ace"
//    Output: 3
//    Explanation: The longest common subsequence is "ace" and its length is 3.
//    Example 2:
//    Input: text1 = "abc", text2 = "abc"
//    Output: 3
//    Explanation: The longest common subsequence is "abc" and its length is 3.
//    Example 3:
//    Input: text1 = "abc", text2 = "def"
//    Output: 0
//    Explanation: There is no such common subsequence, so the result is 0.
public class SolutionDay46 {
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] prev = new int[n];
        int[] curr = new int[n];
        char[] cN = text1.toCharArray();
        char[] cM = text2.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cM[i] == cN[j]) {
                    curr[j] = 1 + ((j > 0 && i > 0) ? prev[j - 1] : 0);
                } else {
                    curr[j] = Math.max((i > 0 ? prev[j] : 0), (j > 0 ? curr[j - 1] : 0));
                }
            }
            prev = curr;
            curr = new int[n];
        }
        return prev[n - 1];
    }
}
