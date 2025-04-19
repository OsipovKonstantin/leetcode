package org.example.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//hard (really medium) #sliding window
//https://leetcode.com/problems/minimum-window-substring
//Given two strings s and t of lengths m and n respectively, return the minimum window
//substring
// of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
//The testcases will be generated such that the answer is unique.
//Example 1:
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
//Example 2:
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
//Example 3:
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
public class SolutionDay56 {
    public static String minWindow(String s, String t) {
        int sLen = s.length();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character, Integer> tFreq = new HashMap<>();
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        for (char c : tChars)
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);

        int start = 0;
        int counter = t.length();
        for (int end = 0; end < sLen; end++) {
            char c = sChars[end];
            if (tFreq.containsKey(c)) {
                int freq = tFreq.get(c);
                if (freq > 0) counter--;
                tFreq.put(c, freq - 1);
            }

            while (counter == 0) {
                if (ans[1] - ans[0] > end - start || ans[0] == -1) {
                    ans[0] = start;
                    ans[1] = end;
                }
                start++;
                char prevChar = sChars[start - 1];
                if (tFreq.containsKey(prevChar)) {
                    int prevFreq = tFreq.get(prevChar);
                    if (prevFreq == 0) counter++;
                    tFreq.put(prevChar, prevFreq + 1);
                }
            }
        }
        return ans[0] == -1 ? "" : s.substring(ans[0], ans[1] + 1);
    }
}