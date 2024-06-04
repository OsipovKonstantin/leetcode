package org.example;

import java.util.HashMap;
import java.util.Map;

//    easy #string
//    Time complixity is O(n) where n is number of chars in string s
//    Space complexity is O(n)
//    https://leetcode.com/problems/longest-palindrome
//    Given a string s which consists of lowercase or uppercase letters, return the length of the longest
//    palindrome
//     that can be built with those letters.
//    Letters are case sensitive, for example, "Aa" is not considered a palindrome.
//    Example 1:
//    Input: s = "abccccdd"
//    Output: 7
//    Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
//    Example 2:
//    Input: s = "a"
//    Output: 1
//    Explanation: The longest palindrome that can be built is "a", whose length is 1.
public class SolutionDay143 {
    public static int longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : cs) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        boolean hasOdd = false;
        int ans = 0;
        for (int val : freq.values()) {
            if (val % 2 == 1) {
                hasOdd = true;
                ans += (val - 1);
            } else {
                ans += val;
            }
        }
        return ans + (hasOdd ? 1 : 0);
    }
}
