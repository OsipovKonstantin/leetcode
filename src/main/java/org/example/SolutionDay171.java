package org.example;

//    medium #two pointers (greedy)
//    Time complexity is O(n), where n is the size of nums array
//    Space complexity is O(1)
//    https://leetcode.com/problems/jump-game/
public class SolutionDay171 {
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = 1;
        while (r < len) {
            if (l == r) return false;
            int temp = r;
            for (int i = l; i < temp; i++) {
                r = Math.max(r, i + nums[i] + 1);
            }
            l = temp;
        }
        return true;
    }
}
