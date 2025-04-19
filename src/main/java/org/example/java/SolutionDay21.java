package org.example.java;

//    easy. String
//    https://leetcode.com/problems/largest-substring-between-two-equal-characters
//    Given a string s, return the length of the longest substring between two equal characters, excluding the two
//    characters. If there is no such substring return -1.
//    A substring is a contiguous sequence of characters within a string.
//    Example 1:
//    Input: s = "aa"
//    Output: 0
//    Explanation: The optimal substring here is an empty substring between the two 'a's.
//    Example 2:
//    Input: s = "abca"
//    Output: 2
//    Explanation: The optimal substring here is "bc".
//    Example 3:
//    Input: s = "cbzxy"
//    Output: -1
//    Explanation: There are no characters that appear twice in s.
public class SolutionDay21 {
    public static int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        int[] charCount = new int[26];
        int res = -1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (charCount[c - 'a'] == 0) {
                charCount[c - 'a'] = i + 1;
            } else {
                res = Math.max(res, i - charCount[c - 'a']);
            }
        }
        return res;
    }
}
