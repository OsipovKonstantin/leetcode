package org.example.java;

import java.util.Arrays;

//    hard. Dynamic programming + binary tree
//    https://leetcode.com/problems/maximum-profit-in-job-scheduling
//    We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of
//    profit[i].
//    You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are
//    no two jobs in the subset with overlapping time range.
//    If you choose a job that ends at time X you will be able to start another job that starts at time X.
//    Example 1:
//    Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
//    Output: 120
//    Explanation: The subset chosen is the first and fourth job.
//    Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
//    Example 2:
//    Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
//    Output: 150
//    Explanation: The subset chosen is the first, fourth and fifth job.
//    Profit obtained 150 = 20 + 70 + 60.
//    Example 3:
//    Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
//    Output: 6
public class SolutionDay27 {
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        if (n == 1) {
            return profit[0];
        }
        Triplet[] array = new Triplet[n];
        for (int i = 0; i < n; i++) {
            array[i] = new Triplet(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(array, (p1, p2) -> p1.end - p2.end);
        int[] dp = new int[n + 1];
        for (int j = 1; j < n + 1; j++) {
            int profitCurr = array[j - 1].profit;
            int startCurr = array[j - 1].start;
            //lastNonConflictIndexInDP = index in array + 1 because in dp all values shifted + 1
            dp[j] = Math.max(dp[j - 1], profitCurr + dp[lastNonConflictIndexInDP(array, j - 1, startCurr)]);
        }
        return dp[n];
    }

    public static int lastNonConflictIndexInDP(Triplet[] array, int highIndex, int highStart) {
        int low = 0;
        int high = highIndex;
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[mid].end > highStart) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static class Triplet {
        int start;
        int end;
        int profit;

        public Triplet(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
}
