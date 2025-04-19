package org.example.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//    medium #sorting
//    Time complexity is O(nlogn), where n is the size of intervals array
//    Space complexity is O(n) due to the ans array
//    https://leetcode.com/problems/merge-intervals
public class SolutionDay189Second {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int len = intervals.length;
        for (int i = 0; i < len; i++) {
            int[] cur = intervals[i];
            while (i + 1 < len && intervals[i + 1][0] <= cur[1]) {
                cur[1] = Math.max(cur[1], intervals[i + 1][1]);
                i++;
            }
            ans.add(cur);
        }
        return ans.toArray(size -> new int[size][]);
    }
}
