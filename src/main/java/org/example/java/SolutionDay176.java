package org.example.java;

//    easy #string
//    Time complexity is O(n), where n is the size of strs array
//    Space complexity is O(1)
//    https://leetcode.com/problems/longest-common-prefix
public class SolutionDay176 {
    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        int common = Integer.MAX_VALUE;
        for (String s : strs) {
            int strLen = s.length();
            if (common > strLen) common = strLen;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < common; j++) {
                if (strs[i].charAt(j) != strs[0].charAt(j)) {
                    common = j;
                }
            }
        }
        return strs[0].substring(0, common);
    }
}
