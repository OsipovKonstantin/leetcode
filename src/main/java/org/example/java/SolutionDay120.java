package org.example.java;

import java.util.Arrays;

//    easy #sorting
//    Time complexity is  O(nlogn), where n is number of scores
//    Space complexity is O(n)
//    https://leetcode.com/problems/relative-ranks
//    You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition.
//    All the scores are guaranteed to be unique.
//    The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place
//    athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:
//    The 1st place athlete's rank is "Gold Medal".
//    The 2nd place athlete's rank is "Silver Medal".
//    The 3rd place athlete's rank is "Bronze Medal".
//    For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's
//    rank is "x").
//    Return an array answer of size n where answer[i] is the rank of the ith athlete.
//    Example 1:
//    Input: score = [5,4,3,2,1]
//    Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
//    Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
//    Example 2:
//    Input: score = [10,3,8,9,4]
//    Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
//    Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].
public class SolutionDay120 {
    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] sortedScore = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedScore[i][0] = i;
            sortedScore[i][1] = score[i];
        }
        Arrays.sort(sortedScore, (a, b) -> b[1] - a[1]);
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) ans[sortedScore[i][0]] = "Gold Medal";
            else if (i == 1) ans[sortedScore[i][0]] = "Silver Medal";
            else if (i == 2) ans[sortedScore[i][0]] = "Bronze Medal";
            else ans[sortedScore[i][0]] = Integer.toString(i + 1);
        }
        return ans;
    }
}
