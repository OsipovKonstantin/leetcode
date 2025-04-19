package org.example.java;

//    medium #two pointers
//    Time complexity is O(n), where n is the size of height array
//    Space complexity is O(1)
//    https://leetcode.com/problems/container-with-most-water
public class SolutionDay179 {
    public static int maxArea(int[] height) {
        int len = height.length;
        int l = 0;
        int r = len - 1;
        int ans = 0;
        while (l < r && r >= 0 && l != len) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            int hL = height[l];
            int hR = height[r];
            if (hL > hR) r = findNextR(r, height);
            else if (hL < hR) l = findNextL(l, height);
            else {
                r = findNextR(r, height);
                l = findNextL(l, height);
            }
        }
        return ans;
    }

    public static int findNextR(int r, int[] height) {
        int hR = height[r];
        while (r >= 0 && height[r] <= hR) r--;
        return r;
    }

    public static int findNextL(int l, int[] height) {
        int hL = height[l];
        int len = height.length;
        while (l < len && height[l] <= hL) l++;
        return l;
    }
}
