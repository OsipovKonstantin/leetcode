package org.example;

//    medium #two pointers
//    Time complexity is O(n), where n is the size of nums array
//    Space complexity is O(1)
//    https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description
public class SolutionDay169 {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = 0;
        while (r < len) {
            int counter = 1;
            while (r + 1 < len && nums[r] == nums[r + 1]) {
                r++;
                counter++;
            }
            for (int i = 0; i < Math.min(2, counter); i++) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }
}
