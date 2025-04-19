package org.example.java;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//    medium #dynamic programming. Recursive approach with memoization. Solved it on iPhone without hints
//    https://leetcode.com/problems/word-break
//    Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
//    sequence of one or more dictionary words.
//    Note that the same word in the dictionary may be reused multiple times in the segmentation.
//    Example 1:
//    Input: s = "leetcode", wordDict = ["leet","code"]
//    Output: true
//    Explanation: Return true because "leetcode" can be segmented as "leet code".
//    Example 2:
//    Input: s = "applepenapple", wordDict = ["apple","pen"]
//    Output: true
//    Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//    Note that you are allowed to reuse a dictionary word.
//    Example 3:
//    Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//    Output: false
public class SolutionDay60 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Boolean[] memo = new Boolean[n];
        Set<String> dict = new HashSet<>(wordDict);
        return traverse(s, 0, dict, memo);
    }

    private static boolean traverse(String s, int start, Set<String> dict, Boolean[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];

        boolean ans = false;
        for (int end = start; end < s.length(); end++) {
            if (dict.contains(s.substring(start, end + 1))) {
                ans = ans || traverse(s, end + 1, dict, memo);
            }
        }
        memo[start] = ans;
        return ans;
    }
}
