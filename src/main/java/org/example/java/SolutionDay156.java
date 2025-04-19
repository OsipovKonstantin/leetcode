package org.example.java;

import java.util.Arrays;
import java.util.PriorityQueue;

//    medium #priority queue (two priority queues!)
//    Time complexity is O(nlogn+mlogm), where n is number of elements in array worker and m is number of elements in
//    array difficulty or profit
//    Space complexity is O(logn+m)
//    https://leetcode.com/problems/most-profit-assigning-work
//    You have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:
//    difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
//    worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most
//    worker[j]).
//    Every worker can be assigned at most one job, but one job can be completed multiple times.
//    For example, if three workers attempt the same job that pays $1, then the total profit will be $3. If a worker
//    cannot complete any job, their profit is $0.
//    Return the maximum profit we can achieve after assigning the workers to the jobs.
//    Example 1:
//    Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
//    Output: 100
//    Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get a profit of [20,20,30,30] separately.
//    Example 2:
//    Input: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
//    Output: 0
public class SolutionDay156 {
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        PriorityQueue<int[]> byDifficulty = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> byProfit = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < difficulty.length; i++) {
            byDifficulty.offer(new int[]{difficulty[i], profit[i]});
        }
        int ans = 0;
        for (int i = 0; i < worker.length; i++) {
            int maxDifficulty = worker[i];
            while (!byDifficulty.isEmpty() && byDifficulty.peek()[0] <= maxDifficulty) {
                byProfit.offer(byDifficulty.poll());
            }
            ans += byProfit.isEmpty() ? 0 : byProfit.peek()[1];
        }
        return ans;
    }
}
