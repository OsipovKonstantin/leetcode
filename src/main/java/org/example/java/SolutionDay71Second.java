package org.example.java;

//    easy #bit manipulation
//    Time complexity is O(1), space complexity is O(1)
//    https://leetcode.com/problems/power-of-two
//    Given an integer n, return true if it is a power of two. Otherwise, return false.
//    An integer n is a power of two, if there exists an integer x such that n == 2x.
//    Example 1:
//    Input: n = 1
//    Output: true
//    Explanation: 20 = 1
//    Example 2:
//    Input: n = 16
//    Output: true
//    Explanation: 24 = 16
//    Example 3:
//    Input: n = 3
//    Output: false
public class SolutionDay71Second {
    public static boolean isPowerOfTwo(int n) {
        return Long.bitCount(n) == 1;
    }
}

//second approach
//    public boolean isPowerOfTwo(int n) {
//        return n > 0 && (n & (n-1)) == 0;
//    }
