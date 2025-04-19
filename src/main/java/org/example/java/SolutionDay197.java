package org.example.java;

import java.util.Arrays;

//    medium #sorting
//    Time complexity is O(nlogn)
//    Space complexity is O(logn)
//    https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/
public class SolutionDay197 {
    public static boolean checkValidCuts(int n, int[][] rectangles) {
        int counter = 0;
        int len = rectangles.length;
        Arrays.sort(rectangles, (a, b) -> a[0] - b[0]);
        int end = 0;
        for (int i = 0; i < len - 1; i++) {
            end = Math.max(end, rectangles[i][2]);
            while (i < len - 1 && end > rectangles[i + 1][0]) {
                end = Math.max(end, rectangles[i + 1][2]);
                i++;
            }
            if (i < len - 1) counter++;
            if (counter == 2) return true;
        }
        Arrays.sort(rectangles, (a, b) -> a[1] - b[1]);
        counter = 0;
        end = 0;
        for (int i = 0; i < len - 1; i++) {
            end = Math.max(end, rectangles[i][3]);
            while (i < len - 1 && end > rectangles[i + 1][1]) {
                end = Math.max(end, rectangles[i + 1][3]);
                i++;
            }
            if (i < len - 1) counter++;
            if (counter == 2) return true;
        }
        return false;
    }
}
