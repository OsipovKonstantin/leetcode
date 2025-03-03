package org.example;

//    medium #two pointers
//    Time complexity is O(n), where n is the size of nums array
//    Space complexity is O(n)
//    https://leetcode.com/problems/partition-array-according-to-given-pivot
public class SolutionDay180Second {
    public static int[] pivotArray(int[] nums, int pivot) {
        int len = nums.length;
        int[] ans = new int[len];
        int left = 0;
        int right = len - 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] < pivot) ans[left++] = nums[i];
            if (nums[len - i - 1] > pivot) ans[right--] = nums[len - i - 1];
        }
        while (left <= right) ans[left++] = pivot;
        return ans;
    }
}
