package org.example;

//easy #pointers
//https://leetcode.com/problems/repeated-substring-pattern
//Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
//Example 1:
//Input: s = "abab"
//Output: true
//Explanation: It is the substring "ab" twice.
//Example 2:
//Input: s = "aba"
//Output: false
//Example 3:
//Input: s = "abcabcabcabc"
//Output: true
//Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
public class SolutionDay54Fifth {
    public static boolean repeatedSubstringPattern(String s) {
        int start = 0;
        int counter;
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int step = 1; step <= n / 2; step++) {
            counter = 0;
            if (n % step != 0) continue;
            while (start + step + counter < n && cs[start + counter] == cs[start + step + counter]) {
                counter++;
            }
            if (start + step + counter == n && counter >= step) {
                return true;
            }
        }
        return false;
    }
}
