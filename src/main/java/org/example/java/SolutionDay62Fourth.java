package org.example.java;

//    medium #dynamic programming. Tabulation approach with space optimization.
//    Time complexity is O(len1*len2), where len1 is length of string s1, len2 is length of string s2.
//    Space complexity is O(len1)
//    https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings
//    Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.
//    Example 1:
//    Input: s1 = "sea", s2 = "eat"
//    Output: 231
//    Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
//    Deleting "t" from "eat" adds 116 to the sum.
//    At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
//    Example 2:
//    Input: s1 = "delete", s2 = "leet"
//    Output: 403
//    Explanation: Deleting "dee" from "delete" to turn the string into "let",
//    adds 100[d] + 101[e] + 101[e] to the sum.
//    Deleting "e" from "leet" adds 101[e] to the sum.
//    At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
//    If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
public class SolutionDay62Fourth {
    public static int minimumDeleteSum(String s1, String s2) {
        int ans = 0;
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();
        for (char c : cs1) {
            ans += c;
        }
        for (char c : cs2) {
            ans += c;
        }
        int[] prev = new int[len1];
        int[] cur = new int[len1];

        for (int row = 0; row < len2; row++) {
            for (int col = 0; col < len1; col++) {
                cur[col] = Math.max(col - 1 < 0 ? 0 : cur[col - 1], row - 1 < 0 ? 0 : prev[col]);
                cur[col] = Math.max(cur[col],
                        (row - 1 < 0 || col - 1 < 0 ? 0 : prev[col - 1]) + (cs1[col] == cs2[row] ? cs1[col] : 0));
            }
            prev = cur;
            cur = new int[len1];
        }
        return ans - 2 * prev[len1 - 1];
    }
}

//    without space optimization
//    public static int minimumDeleteSum(String s1, String s2) {
//        int ans = 0;
//        char[] cs1 = s1.toCharArray();
//        char[] cs2 = s2.toCharArray();
//        int len1 = s1.length();
//        int len2 = s2.length();
//        for (char c : cs1) {
//            ans += c;
//        }
//        for (char c : cs2) {
//            ans += c;
//        }
//        int[][] dp = new int[len2][len1];
//        for (int row = 0; row < len2; row++) {
//            for (int col = 0; col < len1; col++) {
//                dp[row][col] = Math.max(col - 1 < 0 ? 0 : dp[row][col - 1], row - 1 < 0 ? 0 : dp[row - 1][col]);
//                dp[row][col] = Math.max(dp[row][col],
//                        (row - 1 < 0 || col - 1 < 0 ? 0 : dp[row - 1][col - 1]) + (cs1[col] == cs2[row] ? cs1[col] : 0));
//            }
//        }
//        return ans - 2 * dp[len2 - 1][len1 - 1];
//    }