package org.example;

//    medium #recusion.
//    Time complexity is O(logn), space complexity is O(logn) due to the stack space used by recursive calls
//    https://leetcode.com/problems/powx-n
//    Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
//    Example 1:
//    Input: x = 2.00000, n = 10
//    Output: 1024.00000
//    Example 2:
//    Input: x = 2.10000, n = 3
//    Output: 9.26100
//    Example 3:
//    Input: x = 2.00000, n = -2
//    Output: 0.25000
//    Explanation: 2-2 = 1/22 = 1/4 = 0.25
public class SolutionDay65Second {
    public static double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        long m = n;
        double ans = traverse(x, Math.abs(m));
        ans = m > 0 ? ans : 1 / ans;
        return ans;
    }

    private static double traverse(double x, long m) {
        if (m == 0) return 1;
        if (m % 2 == 1) return x * traverse(x, m - 1);
        else return Math.pow(traverse(x, m / 2), 2);
    }
}
