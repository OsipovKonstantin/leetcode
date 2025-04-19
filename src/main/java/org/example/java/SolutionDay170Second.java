package org.example.java;

//    easy #предварительный расчёт (массив макс и массив мин)
//    Time complexity is O(n), space complexity is O(n). We can optimize up to O(1)
//    https://leetcode.com/problems/best-time-to-buy-and-sell-stock
public class SolutionDay170Second {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int[] leftMin = new int[len];
        int[] rightMax = new int[len];
        for (int i = 0; i < len; i++) {
            leftMin[i] = i == 0 ? prices[0] : Math.min(prices[i], leftMin[i - 1]);
            rightMax[len - 1 - i] = i == 0 ? prices[len - 1] : Math.max(prices[len - 1 - i], rightMax[len - i]);
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, rightMax[i] - leftMin[i]);
        }
        return ans;
    }
}
