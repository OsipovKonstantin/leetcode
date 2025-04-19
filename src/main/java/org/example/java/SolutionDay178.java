package org.example.java;

//    easy #stringbuilder #two pointers
//    Time complexity is O(n), where n is the length of s string
//    Space complexity is O(n), because of cs array and sb stringbuilder
//    https://leetcode.com/problems/valid-palindrome
public class SolutionDay178 {
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) sb.append(c);
            else if (c >= 'A' && c <= 'Z') sb.append((char) (c - 'A' + 'a'));
        }
        int len = sb.length();
        for (int i = 0; i < len; i++) {
            if (sb.charAt(i) != sb.charAt(len - i - 1)) return false;
        }
        return true;
    }
}
