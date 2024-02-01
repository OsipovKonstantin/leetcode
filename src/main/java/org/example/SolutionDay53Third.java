package org.example;

//    medium #dynamic programming (very good task to make it second time after a while). Tabulation approach
//    https://leetcode.com/problems/interleaving-string
//    Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
//    An interleaving of two strings s and t is a configuration where s and t are divided into n and m
//    substrings
//     respectively, such that:
//    s = s1 + s2 + ... + sn
//    t = t1 + t2 + ... + tm
//    |n - m| <= 1
//    The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
//    Note: a + b is the concatenation of strings a and b.
//    Example 1:
//    Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//    Output: true
//    Explanation: One way to obtain s3 is:
//    Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
//    Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
//    Since s3 can be obtained by interleaving s1 and s2, we return true.
//    Example 2:
//    Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//    Output: false
//    Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
//    Example 3:
//    Input: s1 = "", s2 = "", s3 = ""
//    Output: true
public class SolutionDay53Third {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (n1 + n2 != n3) {
            return false;
        }
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        char[] cs3 = s3.toCharArray();

        boolean[][] dp = new boolean[n2 + 1][n1 + 1];
        dp[n2][n1] = true;
        for (int i = n2; i >= 0; i--) {
            for (int j = n1; j >= 0; j--) {
                if (i < n2 && dp[i + 1][j] && cs3[i + j] == cs2[i]) {
                    dp[i][j] = true;
                }
                if (j < n1 && dp[i][j + 1] && cs3[i + j] == cs1[j]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }
}
