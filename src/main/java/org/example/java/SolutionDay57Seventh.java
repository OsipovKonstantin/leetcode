package org.example.java;

//    medium #dynamic programming Tabulation approach
//    Time complexity is O(m*n), space complexity is O(n), where m is number of coins,
//    n is variable amount in task condition
//    https://leetcode.com/problems/coin-change-ii
//    You are given an integer array coins representing coins of different denominations and an integer amount
//    representing a total amount of money.
//    Return the number of combinations that make up that amount. If that amount of money cannot be made up by any
//    combination of the coins, return 0.
//    You may assume that you have an infinite number of each kind of coin.
//    The answer is guaranteed to fit into a signed 32-bit integer.
//    Example 1:
//    Input: amount = 5, coins = [1,2,5]
//    Output: 4
//    Explanation: there are four ways to make up the amount:
//    5=5
//    5=2+2+1
//    5=2+1+1+1
//    5=1+1+1+1+1
//    Example 2:
//    Input: amount = 3, coins = [2]
//    Output: 0
//    Explanation: the amount of 3 cannot be made up just with coins of 2.
//    Example 3:
//    Input: amount = 10, coins = [10]
//    Output: 1
public class SolutionDay57Seventh {
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        int[] cur = new int[amount + 1];
        for (int i = n - 1; i >= 0; i--) {
            cur[0] = 1;
            for (int j = 1; j < amount + 1; j++) {
                cur[j] = (j - coins[i] >= 0 ? cur[j - coins[i]] : 0) + (i + 1 < n ? prev[j] : 0);
            }
            prev = cur;
            cur = new int[amount + 1];
        }
        return prev[amount];
    }
}
