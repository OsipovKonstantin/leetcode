package org.example.java;

//    hard. #dynamic programming. Tried on my own, wrote with redundant loops, saw good solution, rewrote by myself
//    https://leetcode.com/problems/max-dot-product-of-two-subsequences
//    Given two arrays nums1 and nums2.
//    Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.
//    A subsequence of a array is a new array which is formed from the original array by deleting some (can be none)
//    of the characters without disturbing the relative positions of the remaining characters. (ie, [2,3,5] is a
//    subsequence of [1,2,3,4,5] while [1,5,3] is not).
//    Example 1:
//    Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
//    Output: 18
//    Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
//    Their dot product is (2*3 + (-2)*(-6)) = 18.
//    Example 2:
//    Input: nums1 = [3,-2], nums2 = [2,-6,7]
//    Output: 21
//    Explanation: Take subsequence [3] from nums1 and subsequence [7] from nums2.
//    Their dot product is (3*7) = 21.
//    Example 3:
//    Input: nums1 = [-1,-1], nums2 = [1,1]
//    Output: -1
//    Explanation: Take subsequence [-1] from nums1 and subsequence [1] from nums2.
//    Their dot product is -1.
public class SolutionDay38 {
    public static int maxDotProduct(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;
        int[][] dp = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                dp[i][j] = nums2[i] * nums1[j];
                if (i > 0 && j > 0)
                    dp[i][j] += Math.max(0, dp[i - 1][j - 1]);
                if (i > 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if (j > 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
            }
        }
        return dp[y - 1][x - 1];
    }
}
