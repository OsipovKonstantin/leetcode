package org.example;

//    medium #math
//    Time complexity is O(n), where n is the size of nums array
//    Space complexity is O(n)
//    https://leetcode.com/problems/rotate-array/description
public class SolutionDay169Second {
    public static void rotate(int[] nums, int k) {
        int[] nums2 = nums.clone();
        int len = nums.length;
        int shift = k%len;
        for(int i = 0; i < len; i++) {
            nums[i]=nums2[(len-shift+i)%len];
        }
    }
}
