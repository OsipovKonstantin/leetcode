package org.example;

//    easy. #loop #math
//    https://leetcode.com/problems/power-of-four
//    Given an integer n, return true if it is a power of four. Otherwise, return false.
//    An integer n is a power of four, if there exists an integer x such that n == 4x.
//    Example 1:
//    Input: n = 16
//    Output: true
//    Example 2:
//    Input: n = 5
//    Output: false
//    Example 3:
//    Input: n = 1
//    Output: true
public class SolutionDay33Fourth {
    public static boolean isPowerOfFour(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}

//    improved solution without recursion and loop. Bit manipulation n&(n-1)==0 check whether number is power of 2,
//    expression n%3==1 find numbers among power of 2 that power of 4
//    class Solution {
//        public boolean isPowerOfFour(int n) {
//            return n > 0 && (n&(n-1))==0 && n%3 == 1;
//        }
//    }
