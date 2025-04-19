package org.example.java;

//    medium #binary search
//    Time complexity is O(nlogn)
//    Space complexity is O(1)
//    https://leetcode.com/problems/house-robber-iv
public class SolutionDay192 {
    public static int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        while (min < max) {
            int mid = (min + max) / 2;
            if (isValid(nums, k, mid)) max = mid;
            else min = mid + 1;
        }
        return min;
    }

    private static boolean isValid(int[] nums, int k, int mid) {
        int fromOdd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                i++;
                fromOdd++;
            }
        }
        return fromOdd >= k;
    }
}
