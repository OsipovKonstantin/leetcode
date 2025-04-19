package org.example.java;

//    easy #two pointers
//    Time complexity is O(n) where n is size of nums array
//    Space complexity is O(1)
//    https://leetcode.com/problems/remove-element/description/
public class SolutionDay168Second {
    public static int removeElement(int[] nums, int val) {
        int last = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                while (last > 0 && nums[last] == val) last--;
                if (last < i) break;
                nums[i] = nums[last];
                nums[last] = val;
            }
        }
        int ans = 0;
        int i = 0;
        while (i < nums.length && nums[i] != val) {
            ans++;
            i++;
        }
        return ans;
    }
}
