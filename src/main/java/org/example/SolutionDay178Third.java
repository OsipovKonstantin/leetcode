package org.example;

//    easy #two pointers
//    Time complexity is O(n), where n is the size of nums array
//    Space complexity is O(1)
//    https://leetcode.com/problems/apply-operations-to-an-array
public class SolutionDay178Third {
    public static int[] applyOperations(int[] nums) {
        int len = nums.length;
        int start = 0;
        int zeros = 0;
        for (int end = 0; end < len; end++) {
            if (end + 1 < len && nums[end] == nums[end + 1] && nums[end] != 0) {
                nums[start] = nums[end] * 2;
                start++;
                end++;
                zeros++;
            } else if (nums[end] != 0) {
                nums[start] = nums[end];
                start++;
            } else {
                zeros++;
            }
        }
        while (zeros > 0) {
            nums[start++] = 0;
            zeros--;
        }
        return nums;
    }
}
