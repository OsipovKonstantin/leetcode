package org.example;

//    medium. #String; #counting
//    https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
//    You are given two strings of the same length s and t. In one step you can choose any character of t and
//    replace it with another character.
//    Return the minimum number of steps to make t an anagram of s.
//    An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
//    Example 1:
//    Input: s = "bab", t = "aba"
//    Output: 1
//    Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
//    Example 2:
//    Input: s = "leetcode", t = "practice"
//    Output: 5
//    Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
//    Example 3:
//    Input: s = "anagram", t = "mangaar"
//    Output: 0
//    Explanation: "anagram" and "mangaar" are anagrams.
public class SolutionDay34 {
    public static int minSteps(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int n = s.length();
        int[] diff = new int[26];
        for (int i = 0; i < n; i++) {
            diff[sChars[i] - 'a']++;
            diff[tChars[i] - 'a']--;
        }
        int ans = 0;
        for (int num : diff) {
            ans += Math.max(num, 0);
        }
        return ans;
    }
}
