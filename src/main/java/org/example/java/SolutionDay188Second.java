package org.example.java;

import java.util.ArrayList;
import java.util.List;

//    easy #string builder
//    Time complexity is O(n), where n is the size of nums array
//    Space complexity is O(n) due to ans list
//    https://leetcode.com/problems/summary-ranges
public class SolutionDay188Second {
    public static List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            while (i + 1 < len && nums[i + 1] == nums[i] + 1) i++;
            if (nums[i] == cur) ans.add(String.valueOf(cur));
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(cur);
                sb.append("->");
                sb.append(nums[i]);
                ans.add(sb.toString());
            }
        }
        return ans;
    }
}
