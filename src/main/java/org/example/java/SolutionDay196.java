package org.example.java;

import java.util.Arrays;

//    medium #sorting
//    Time complexity is O(nlogn)
//    Space complexity is O(logn)
//    https://leetcode.com/problems/count-days-without-meetings
public class SolutionDay196 {
    public static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int ans = meetings[0][0] - 1;
        int len = meetings.length;
        int end = 0;
        for (int i = 0; i < len; i++) {
            end = Math.max(end, meetings[i][1]);
            while (i < len - 1 && meetings[i + 1][0] <= end) {
                end = Math.max(end, meetings[i + 1][1]);
                i++;
            }
            if (i == len - 1) {
                ans += end > days ? 0 : days - end;
            } else {
                ans += (meetings[i + 1][0] - end - 1);
            }
        }
        return ans;
    }
}
