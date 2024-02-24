package org.example;

import java.util.Arrays;

//    easy #String.
//    Time complexity is O(n), space complexity is O(n), where n is number of characters in string S or goal
//    https://leetcode.com/problems/buddy-strings
//    Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal,
//    otherwise, return false.
//    Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the
//    characters at s[i] and s[j].
//    For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
//    Example 1:
//    Input: s = "ab", goal = "ba"
//    Output: true
//    Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
//    Example 2:
//    Input: s = "ab", goal = "ab"
//    Output: false
//    Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
//    Example 3:
//    Input: s = "aa", goal = "aa"
//    Output: true
//    Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
public class SolutionDay76 {
    public static boolean buddyStrings(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if (n != m) return false;
        int[] swap = new int[2];
        Arrays.fill(swap, -1);
        int[] freq = new int[26];
        char[] cS = s.toCharArray();
        char[] cGoal = goal.toCharArray();
        for (int i = 0; i < n; i++) {
            freq[cS[i] - 'a']++;
            if (cS[i] != cGoal[i]) {
                if (swap[0] == -1) swap[0] = i;
                else if (swap[1] == -1) swap[1] = i;
                else return false;
            }
        }
        if (swap[0] != -1 && swap[1] == -1) return false;
        if (swap[0] != -1) {
            if (cS[swap[0]] != cGoal[swap[1]] || cS[swap[1]] != cGoal[swap[0]]) return false;
            else return true;
        }
        int maxFreq = 0;
        for (int counter : freq)
            if (counter > 1) maxFreq = counter;
        return maxFreq > 1 ? true : false;
    }
}
