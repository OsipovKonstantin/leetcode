package org.example;

//    medium #sliding window
//    Time complexity is O(n), where n is the size of colors array
//    Space complexity is O(1)
//    https://leetcode.com/problems/alternating-groups-ii
public class SolutionDay186 {
    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int count = 0;
        int end = 0;
        int len = colors.length;
        for (int start = 0; start < len; start++) {
            while (colors[end % len] != colors[(end + 1) % len] && end - start < k - 1) end++;
            if (end - start == k - 1) count++;
            else {
                start = end;
                end++;
            }
        }
        return count;
    }
}
