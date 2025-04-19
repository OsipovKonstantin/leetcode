package org.example.java;

import java.util.Arrays;

//    medium. Theme of exercise - first and last indices. Boolean visited 10 times faster than hashset for storing
//    https://leetcode.com/problems/unique-length-3-palindromic-subsequences
//    Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
//    Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
//    A palindrome is a string that reads the same forwards and backwards.
//    A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
//    For example, "ace" is a subsequence of "abcde".
//    Example 1:
//    Input: s = "aabca"
//    Output: 3
//    Explanation: The 3 palindromic subsequences of length 3 are:
//    - "aba" (subsequence of "aabca")
//    - "aaa" (subsequence of "aabca")
//    - "aca" (subsequence of "aabca")
//    Example 2:
//    Input: s = "adc"
//    Output: 0
//    Explanation: There are no palindromic subsequences of length 3 in "adc".
//    Example 3:
//    Input: s = "bbcbaba"
//    Output: 4
//    Explanation: The 4 palindromic subsequences of length 3 are:
//    - "bbb" (subsequence of "bbcbaba")
//    - "bcb" (subsequence of "bbcbaba")
//    - "bab" (subsequence of "bbcbaba")
//    - "aba" (subsequence of "bbcbaba")
public class SolutionDay25Sixth {
    public static int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int charInt = s.charAt(i) - 'a';
            if (first[charInt] == -1) {
                first[charInt] = i;
            }
            last[charInt] = i;
        }
        for (int j = 0; j < 26; j++) {
            if (first[j] == -1) {
                continue;
            }
            boolean[] visited = new boolean[26];
            for (int k = first[j] + 1; k < last[j]; k++) {
                char c = s.charAt(k);
                if (!visited[c - 'a']) {
                    visited[c - 'a'] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
