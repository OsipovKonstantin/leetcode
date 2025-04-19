package org.example.java;

//    medium #string
//    Time complexity is O(n), where n is the length of s string
//    Space complexity is O(n)
//    https://leetcode.com/problems/reverse-words-in-a-string
public class SolutionDay176Second {
    public static String reverseWords(String s) {
        String[] words = s.replaceAll("\\s+", " ").trim().split(" ");
        int len = words.length;
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }
        return sb.toString();
    }
}
