package org.example.java;

import java.util.HashMap;
import java.util.Map;

//    medium #two pointers #hashmap
//    Time complexity is O(n), where n is length of s string
//    Space complexity is O(n) because of cs array and seen map
//    https://leetcode.com/problems/longest-substring-without-repeating-characters
public class SolutionDay180 {
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int ans = 0;
        int start = 0;
        char[] cs = s.toCharArray();
        Map<Character, Integer> seen = new HashMap<>();
        for (int end = 0; end < len; end++) {
            if (seen.containsKey(cs[end]) && seen.get(cs[end]) >= start) {
                start = seen.get(cs[end]) + 1;
            }
            seen.put(cs[end], end);
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}
