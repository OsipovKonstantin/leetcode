package org.example;

//    medium #postfix sum
//    Time complexity is O(n), where n is the size of gas array
//    Space complexity is O(n)
//    https://leetcode.com/problems/gas-station/description
public class SolutionDay174 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] sum = new int[len];
        int sumAll = 0;
        for (int i = 0; i < len; i++) {
            sum[i] = gas[i] - cost[i];
            sumAll += sum[i];
        }
        if (sumAll < 0) return -1;
        int[] postfixSum = new int[len];
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = len - 1; i >= 0; i--) {
            postfixSum[i] = sum[i] + (i + 1 < len ? postfixSum[i + 1] : 0);
            if (max < postfixSum[i]) {
                max = postfixSum[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
