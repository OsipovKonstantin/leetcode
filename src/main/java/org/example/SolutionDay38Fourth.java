package org.example;

//    medium (actually easy). #modulo (reminder of division)
//    https://leetcode.com/problems/integer-break/description
//    Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those
//    integers.
//    Return the maximum product you can get.
//    Example 1:
//    Input: n = 2
//    Output: 1
//    Explanation: 2 = 1 + 1, 1 × 1 = 1.
//    Example 2:
//    Input: n = 10
//    Output: 36
//    Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
public class SolutionDay38Fourth {
    public static int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int ans = 1;
        if (n % 3 == 1) {
            ans *= 4;
            n -= 4;
        }
        if (n % 3 == 2) {
            ans *= 2;
            n -= 2;
        }
        if (n > 1) {
            ans *= Math.pow(3, n / 3);
        }
        return ans;
    }
}
