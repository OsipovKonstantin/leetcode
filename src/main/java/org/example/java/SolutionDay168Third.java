package org.example.java;

//    easy #two pointers
//    Time complexity is O(n) where n is size of nums array
//    Space complexity is O(1)
//    https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class SolutionDay168Third {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int a = 0;
        int b = 1;
        while (a < len) {
            while (b < len && nums[b] == nums[a]) b++;
            if (b >= len) break;
            nums[a + 1] = nums[b];
            a++;
        }
        return a + 1;
    }
}
