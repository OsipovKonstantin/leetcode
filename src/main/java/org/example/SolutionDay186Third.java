package org.example;

import java.util.HashSet;
import java.util.Set;

//    easy #sliding window
//    Time complexity is O(n), where n is the length of nums array
//    Space complexity is O(k) due to the usage of the seen set
//    https://leetcode.com/problems/contains-duplicate-ii
public class SolutionDay186Third {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        int e = 0;
        Set<Integer> seen = new HashSet<>();
        for (int s = 0; s < len; s++) {
            while (e < len && e - s <= k) {
                if (seen.contains(nums[e])) return true;
                seen.add(nums[e]);
                e++;
            }
            seen.remove(nums[s]);
        }
        return false;
    }
}
