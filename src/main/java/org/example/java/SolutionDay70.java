package org.example.java;

import java.util.Arrays;

//    hard #sorting #dynamic programming #binary search. Recursion approach with memoization.
//    Time complexity is O(n*k*logn) because number of operation is equal size of memo (n*k)
//    and for each operation we find nextIndex with binary search (logn).
//    Space complexity is O(n*k) for storing 2D array memo
//    https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii
//    You are given an array of events where events[i] = [startDayi, endDayi, valuei]. The ith event starts at startDayi
//    and ends at endDayi, and if you attend this event, you will receive a value of valuei. You are also given an
//    integer k which represents the maximum number of events you can attend.
//    You can only attend one event at a time. If you choose to attend an event, you must attend the entire event.
//    Note that the end day is inclusive: that is, you cannot attend two events where one of them starts and the other
//    ends on the same day.
//    Return the maximum sum of values that you can receive by attending events.
//    Example 1:
//    Input: events = [[1,2,4],[3,4,3],[2,3,1]], k = 2
//    Output: 7
//    Explanation: Choose the green events, 0 and 1 (0-indexed) for a total value of 4 + 3 = 7.
//    Example 2:
//    Input: events = [[1,2,4],[3,4,3],[2,3,10]], k = 2
//    Output: 10
//    Explanation: Choose event 2 for a total value of 10.
//    Notice that you cannot attend any other event as they overlap, and that you do not have to attend k events.
//    Example 3:
//    Input: events = [[1,1,1],[2,2,2],[3,3,3],[4,4,4]], k = 3
//    Output: 9
//    Explanation: Although the events do not overlap, you can only attend 3 events. Pick the highest valued three.
public class SolutionDay70 {
    public static int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int[][] memo = new int[k + 1][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        return traverse(memo, events, 0, k);
    }

    private static int traverse(int[][] memo, int[][] events, int index, int leftK) {
        if (index == events.length || leftK == 0) return 0;
        if (memo[leftK][index] != -1) return memo[leftK][index];

        int nextIndex = binarySearchNext(events, events[index][1]);
        memo[leftK][index] = Math.max(traverse(memo, events, index + 1, leftK), traverse(memo, events, nextIndex, leftK - 1) + events[index][2]);
        return memo[leftK][index];
    }

    private static int binarySearchNext(int[][] events, int target) {
        int start = 0;
        int end = events.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (events[mid][0] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
