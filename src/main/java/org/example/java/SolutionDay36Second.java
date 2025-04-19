package org.example.java;

//    hard. #dynamic programming with 2 1D arrays instead of 2D array
//    https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps
//    You have a pointer at index 0 in an array of size arrLen. At each step, you can move 1 position to the left,
//    1 position to the right in the array, or stay in the same place (The pointer should not be placed outside the
//    array at any time).
//    Given two integers steps and arrLen, return the number of ways such that your pointer is still at index 0
//    after exactly steps steps. Since the answer may be too large, return it modulo 109 + 7.
//    Example 1:
//    Input: steps = 3, arrLen = 2
//    Output: 4
//    Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
//    Right, Left, Stay
//    Stay, Right, Left
//    Right, Stay, Left
//    Stay, Stay, Stay
//    Example 2:
//    Input: steps = 2, arrLen = 4
//    Output: 2
//    Explanation: There are 2 differents ways to stay at index 0 after 2 steps
//    Right, Left
//    Stay, Stay
//    Example 3:
//    Input: steps = 4, arrLen = 2
//    Output: 8
public class SolutionDay36Second {
    public static int numWays(int steps, int arrLen) {
        int mod = 1000000007;
        int properLen = steps / 2 + 1 < arrLen ? steps / 2 + 1 : arrLen;
        int[] curr = new int[properLen];
        curr[0] = 1;
        int[] next;
        for (int i = 1; i < steps + 1; i++) {
            next = new int[properLen];
            for (int j = 0; j < properLen; j++) {
                next[j] = ((curr[j] + (j > 0 ? curr[j - 1] : 0)) % mod + (j < properLen - 1 ? curr[j + 1] : 0)) % mod;
            }
            curr = next;
        }
        return curr[0];
    }
}
