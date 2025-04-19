package org.example.java;

//    medium #difference array #binary search
//    Time complexity is O((n+m)logn), where n and m are the sizes of nums and queries arrays respectively
//    Space complexity is O(m)
//    https://leetcode.com/problems/zero-array-transformation-ii
public class SolutionDay190 {
    public static int minZeroArray(int[] nums, int[][] queries) {
        int l = 0;
        int r = queries.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (isValid(mid, nums, queries)) r = mid;
            else l = mid + 1;
        }
        if (l == queries.length) return -1;
        if (l == 0 && isValid(-1, nums, queries)) return 0;
        return l + 1;
    }

    private static boolean isValid(int mid, int[] nums, int[][] queries) {
        int len = nums.length;
        int[] diffArray = new int[len + 1];
        for (int i = 0; i <= mid; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int val = queries[i][2];
            diffArray[start] += val;
            diffArray[end + 1] -= val;
        }
        int prefixSum = 0;
        for (int i = 0; i < len; i++) {
            prefixSum = (i > 0 ? prefixSum : 0) + diffArray[i];
            if (prefixSum < nums[i]) return false;
        }
        return true;
    }
}
