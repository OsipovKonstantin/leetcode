package org.example.java;

//    medium #two pointers
//    Time complexity is O(n), where n is the size of nums array
//    Space complexity is O(1)
//    https://leetcode.com/problems/jump-game-ii/
public class SolutionDay172 {
    public static int jump(int[] nums) {
        int ans = 0;
        int len = nums.length;
        int l = 0;
        int r = 1;
        while (r < len) {
            int temp = r;
            for (int i = l; i < temp; i++) {
                r = Math.max(r, i + nums[i] + 1);
            }
            l = temp;
            ans++;
        }
        return ans;
    }
}
