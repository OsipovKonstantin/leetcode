package org.example.java;

//    medium #bit manipulation (XOR)
//    Time complexity is O(n), where n is the size of nums array
//    Space complexity is O(1)
//    https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i
public class SolutionDay195 {
    public static int minOperations(int[] nums) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                count++;
            }
        }
        return (nums[len - 2] == 1 && nums[len - 1] == 1) ? count : -1;
    }
}
