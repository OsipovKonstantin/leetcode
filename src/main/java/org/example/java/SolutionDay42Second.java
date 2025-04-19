package org.example.java;

//    easy #two pointers
//    https://leetcode.com/problems/is-subsequence
//    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
//    A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
//    of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a
//    subsequence of "abcde" while "aec" is not).
//    Example 1:
//    Input: s = "abc", t = "ahbgdc"
//    Output: true
//    Example 2:
//    Input: s = "axc", t = "ahbgdc"
//    Output: false
public class SolutionDay42Second {
        public static boolean isSubsequence(String s, String t) {
            int sLen = s.length();
            int tLen = t.length();
            int sPointer = 0;
            int tPointer = 0;
            int counter = 0;
            while(sPointer<sLen && tPointer<tLen) {
                if(s.charAt(sPointer)==t.charAt(tPointer)) {
                    counter++;
                    sPointer++;
                }
                tPointer++;
            }
            return counter == sLen;
        }
}
