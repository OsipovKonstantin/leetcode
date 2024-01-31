package org.example;

import java.util.Arrays;

//    hard #greedy (very smart solution). Time complexity O(n*logn+n)
//    https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden
//    There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n.
//    (i.e., the length of the garden is n).
//    There are n + 1 taps located at points [0, 1, ..., n] in the garden.
//    Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap
//    can water the area [i - ranges[i], i + ranges[i]] if it was open.
//    Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered
//    return -1.
//    Example 1:
//    Input: n = 5, ranges = [3,4,1,1,0,0]
//    Output: 1
//    Explanation: The tap at point 0 can cover the interval [-3,3]
//    The tap at point 1 can cover the interval [-3,5]
//    The tap at point 2 can cover the interval [1,3]
//    The tap at point 3 can cover the interval [2,4]
//    The tap at point 4 can cover the interval [4,4]
//    The tap at point 5 can cover the interval [5,5]
//    Opening Only the second tap will water the whole garden [0,5]
//    Example 2:
//    Input: n = 3, ranges = [0,0,0,0]
//    Output: -1
//    Explanation: Even if you activate all the four taps you cannot water the whole garden.
public class SolutionDay52 {
    public static int minTaps(int n, int[] ranges) {
        int curIndex = 0;
        int maxIndex = 0;
        int[][] arr = new int[n + 1][2];
        for (int i = 0; i < n + 1; i++) {
            arr[i][0] = i - ranges[i];
            arr[i][1] = i + ranges[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int steps = 0;
        for (int i = 0; i < n + 1; i++) {
            steps++;
            int[] tap = arr[i];
            int startIndex = tap[0];
            maxIndex = Math.max(maxIndex, tap[1]);
            if (startIndex > curIndex) {
                return -1;
            }
            while (i + 1 < n + 1 && arr[i + 1][0] <= curIndex) {
                i++;
                int[] nextTap = arr[i];
                startIndex = nextTap[0];
                maxIndex = Math.max(maxIndex, nextTap[1]);
            }
            curIndex = maxIndex;
            if (maxIndex >= n) {
                break;
            }
        }
        return steps;
    }
}
