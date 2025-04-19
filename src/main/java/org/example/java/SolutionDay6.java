package org.example.java;

//    https://leetcode.com/problems/valid-anagram
//    Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using
//    all the original letters exactly once.
//    Example 1:
//    Input: s = "anagram", t = "nagaram"
//    Output: true
//    Example 2:
//    Input: s = "rat", t = "car"
//    Output: false
//    Constraints:
//    1 <= s.length, t.length <= 5 * 104
//    s and t consist of lowercase English letters.
//    Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
public class SolutionDay6 {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] counter = new int[26];
        for (char c : s.toCharArray())
            counter[c - 'a']++;
        for (char c : t.toCharArray())
            if (--counter[c - 'a'] < 0)
                return false;
        return true;
    }
}
