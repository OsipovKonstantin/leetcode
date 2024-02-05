package org.example;

//    easy #counting
//    https://leetcode.com/problems/first-unique-character-in-a-string
//    Time complexity and space complexity is O(n)
//    Given a string s, find the first non-repeating character in it and return its index. If it does not exist,
//    return -1.
//    Example 1:
//    Input: s = "leetcode"
//    Output: 0
//    Example 2:
//    Input: s = "loveleetcode"
//    Output: 2
//    Example 3:
//    Input: s = "aabb"
//    Output: -1
public class SolutionDay57Second {
    public static int firstUniqChar(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] freq = new int[26];
        for (char c : cs) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (freq[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
