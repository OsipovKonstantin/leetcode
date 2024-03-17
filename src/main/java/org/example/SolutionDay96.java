package org.example;

import java.util.ArrayList;
import java.util.List;

//    medium #array
//    Time complexity is O(n), space complexity is O(n)
//    https://leetcode.com/problems/insert-interval
//    You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the
//    start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given
//    an interval newInterval = [start, end] that represents the start and end of another interval.
//    Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
//    still does not have any overlapping intervals (merge overlapping intervals if necessary).
//    Return intervals after the insertion.
//    Note that you don't need to modify intervals in-place. You can make a new array and return it.
//    Example 1:
//    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//    Output: [[1,5],[6,9]]
//    Example 2:
//    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//    Output: [[1,2],[3,10],[12,16]]
//    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
public class SolutionDay96 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (newInterval[1] < intervals[i][0]) {
                ans.add(newInterval);
                int[][] ansArray = new int[ans.size() + n - i][2];
                for (int j = 0; j < ans.size(); j++)
                    ansArray[j] = ans.get(j);
                int diff = i - ans.size();
                System.arraycopy(intervals, i, ansArray, i - diff, n - i);
                return ansArray;
            } else if (newInterval[0] > intervals[i][1]) ans.add(intervals[i]);
            else
                newInterval = new int[]{Math.min(newInterval[0], intervals[i][0]), Math.max(newInterval[1], intervals[i][1])};
        }
        ans.add(newInterval);
        int[][] ansArray = new int[ans.size()][2];
        for (int i = 0; i < ansArray.length; i++) ansArray[i] = ans.get(i);
        return ansArray;
    }
}
