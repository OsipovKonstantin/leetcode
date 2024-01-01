package org.example;

//    medium. 4 temp variables instead of dynamic programming 2D array [n+1][4]. Space complexity O(1)
//    https://leetcode.com/problems/knight-dialer
//    The chess knight has a unique movement, it may move two squares vertically and one square horizontally,
//     or two squares horizontally and one square vertically (with both forming the shape of an L)
//    We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell.
//    [[1,2,3],[4,5,6],[7,8,9],[*,0,#]]
//    Given an integer n, return how many distinct phone numbers of length n we can dial.
//    You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 jumps to dial
//     a number of length n. All jumps should be valid knight jumps.
//    As the answer may be very large, return the answer modulo 109 + 7.
//    Example 1:
//    Input: n = 1
//    Output: 10
//    Explanation: We need to dial a number of length 1, so placing the knight over any numeric cell of the 10 cells is
//    sufficient.
//    Example 2:
//    Input: n = 2
//    Output: 20
//    Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76,
//    81, 83, 92, 94]
//    Example 3:
//    Input: n = 3131
//    Output: 136006598
//    Explanation: Please take care of the mod.
public class SolutionDay22Third {
    public static int knightDialer(int n) {
        if (n == 1) {
            return 10;
        }
        int mod = 1000000007;
        //  we combine numbers 1,3,7,9 (variable a); 2,8 (variable b); 4,6(variable c); 0 (variable d)
        //  number 5 has no input from other numbers
        //  a is sum of previous 2*c+2*b
        //  b is previous a
        //  c is sum of previous a+2*d
        //  d is previous c
        int a = 4;
        int b = 2;
        int c = 2;
        int d = 1;
        for (int i = 2; i <= n; i++) {
            int tempA = a;
            int tempB = b;
            int tempC = c;
            int tempD = d;

            a = (2 * tempB % mod + 2 * tempC % mod) % mod;
            b = tempA % mod;
            c = (tempA % mod + 2 * tempD % mod) % mod;
            d = tempC % mod;
        }

        int res = 0;
        res = (res + a) % mod;
        res = (res + b) % mod;
        res = (res + c) % mod;
        return (res + d) % mod;
    }
}