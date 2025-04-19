package org.example.java;

import java.util.ArrayList;
import java.util.List;

//    hard #backtrack
//    Time complexity is O(m^n), where m is the number of words in the dictionary and n is the length of string s
//    Space complexity is O(n) because of the maximum height of recursion stack
//    https://leetcode.com/problems/word-break-ii
//    Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word
//    is a valid dictionary word. Return all such possible sentences in any order.
//    Note that the same word in the dictionary may be reused multiple times in the segmentation.
//    Example 1:
//    Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
//    Output: ["cats and dog","cat sand dog"]
//    Example 2:
//    Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
//    Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
//    Explanation: Note that you are allowed to reuse a dictionary word.
//    Example 3:
//    Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//    Output: []
public class SolutionDay133 {
    private static List<String> ans = new ArrayList<>();

    public static List<String> wordBreak(String s, List<String> wordDict) {
        backtrack(s, wordDict, 0, new ArrayList<>());
        return ans;
    }

    private static void backtrack(String s, List<String> wordDict, int index, List<String> cur) {
        if (index == s.length()) ans.add(String.join(" ", cur));
        for (String word : wordDict) {
            if (s.startsWith(word, index)) {
                cur.add(word);
                backtrack(s, wordDict, index + word.length(), cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
