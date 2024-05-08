package org.example;

//    hard #two pointers
//    Time complexity is O(n)
//    Space complexity is O(1)
//    https://leetcode.com/problems/trapping-rain-water
//    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
//    water it can trap after raining.
//    Example 1:
//    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//    Output: 6
//    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this
//    case, 6 units of rain water (blue section) are being trapped.
//    Example 2:
//    Input: height = [4,2,0,3,2,5]
//    Output: 9
public class SolutionDay119 {
    public static int trap(int[] height) {
        int n = height.length;
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (max < height[i]) {
                max = height[i];
                maxIndex = i;
            }
        }
        int ans = 0;
        int curMax = 0;
        for (int i = 0; i < maxIndex; i++) {
            curMax = Math.max(curMax, height[i]);
            ans += (curMax - height[i]);
        }
        curMax = 0;
        for (int i = n - 1; i >= maxIndex; i--) {
            curMax = Math.max(curMax, height[i]);
            ans += (curMax - height[i]);
        }
        return ans;
    }
}
