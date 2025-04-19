package org.example.java;

//    medium #greedy
//    Time complexity is O(n), where n is the size of prices array
//    Space complexity is O(1)
//    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
public class SolutionDay170Third {
    public static int maxProfit(int[] prices) {
        int ans = 0;
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            ans += Math.max(0, prices[i + 1] - prices[i]);
        }
        return ans;
    }
}
