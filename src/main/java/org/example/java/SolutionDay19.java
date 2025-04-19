package org.example.java;

//    level - hard. Solution via Dynamic Programming. Approach in Dynamic Programming - tabulation
//    https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule
//    You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish
//    all the jobs j where 0 <= j < i).
//    You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of
//    each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.
//    You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].
//    Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
//    Example 1:
//    Input: jobDifficulty = [6,5,4,3,2,1], d = 2
//    Output: 7
//    Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
//    Second day you can finish the last job, total difficulty = 1.
//    The difficulty of the schedule = 6 + 1 = 7
//    Example 2:
//    Input: jobDifficulty = [9,9,9], d = 4
//    Output: -1
//    Explanation: If you finish a job per day you will still have a free day. you cannot find a schedule for the given jobs.
//    Example 3:
//    Input: jobDifficulty = [1,1,1], d = 3
//    Output: 3
//    Explanation: The schedule is one job per day. total difficulty will be 3.
//    Example 4:
//    Input: jobDifficulty = [1, 7, 1, 7, 1], d = 3
//    Output: 9
//    Explanation: First day dificulty 1, second - 7 (group of 7, 1, 7), third - 1. Overall difficulty = 1 + 7 + 1 = 9
public class SolutionDay19 {
    public static int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }

        int[][] dp = new int[d + 1][n + 1];
        for (int i = 0; i <= d; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 10000;
            }
        }
        dp[0][0] = 0;

        for (int day = 1; day <= d; day++) {
            for (int job = day; job <= n; job++) {
                int maxDifficulty = 0;
                for (int i = job; i >= day; i--) {
                    maxDifficulty = Math.max(maxDifficulty, jobDifficulty[i - 1]);
                    dp[day][job] = Math.min(dp[day][job], dp[day - 1][i - 1] + maxDifficulty);
                }
            }
        }

        return dp[d][n];
    }
}
