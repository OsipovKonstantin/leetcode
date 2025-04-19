package org.example.java;

//    medium #string #two pointers
//    Time complexity is O(n), where n is number of chars in string s
//    Space complexity is O(1)
//    https://leetcode.com/problems/append-characters-to-string-to-make-subsequence
//    You are given two strings s and t consisting of only lowercase English letters.
//    Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence
//    of s.
//    A subsequence is a string that can be derived from another string by deleting some or no characters without
//    changing the order of the remaining characters.
//    Example 1:
//    Input: s = "coaching", t = "coding"
//    Output: 4
//    Explanation: Append the characters "ding" to the end of s so that s = "coachingding".
//    Now, t is a subsequence of s ("coachingding").
//    It can be shown that appending any 3 characters to the end of s will never make t a subsequence.
//    Example 2:
//    Input: s = "abcde", t = "a"
//    Output: 0
//    Explanation: t is already a subsequence of s ("abcde").
//    Example 3:
//    Input: s = "z", t = "abcde"
//    Output: 5
//    Explanation: Append the characters "abcde" to the end of s so that s = "zabcde".
//    Now, t is a subsequence of s ("zabcde").
//    It can be shown that appending any 4 characters to the end of s will never make t a subsequence.
public class SolutionDay142 {
    public static int appendCharacters(String s, String t) {
        int ns = s.length();
        int tindex = 0;
        int nt = t.length();
        for (int i = 0; i < ns; i++) {
            if (tindex == nt) break;
            if (s.charAt(i) == t.charAt(tindex)) tindex++;
        }
        return nt - tindex;
    }
}
