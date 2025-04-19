package org.example.java;

import java.util.HashSet;
import java.util.Set;

//    medium #set
//    Time complexity is O(n), where n is the size of nums array
//    Space complexity is O(n)
//    https://leetcode.com/problems/longest-consecutive-sequence
public class SolutionDay187Second {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num);
        }
        int ans = 0;
        for (int val : unique) {
            int cur = val;
            if (unique.contains(cur - 1)) continue;
            int counter = 1;
            while (unique.contains(cur + 1)) {
                counter++;
                cur++;
            }
            ans = Math.max(ans, counter);
        }
        return ans;
    }
}
