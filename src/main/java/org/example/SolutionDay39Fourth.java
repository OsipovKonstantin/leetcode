package org.example;

//    easy. #String reversion
//    https://leetcode.com/problems/reverse-words-in-a-string-iii
//    Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//    Example 1:
//    Input: s = "Let's take LeetCode contest"
//    Output: "s'teL ekat edoCteeL tsetnoc"
//    Example 2:
//    Input: s = "Mr Ding"
//    Output: "rM gniD"
public class SolutionDay39Fourth {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder(reverse(words[0]));
        for (int i = 1; i < words.length; i++) {
            sb.append(" " + reverse(words[i]));
        }
        return sb.toString();
    }

    private static String reverse(String word) {
        char[] chars = word.toCharArray();
        int n = word.length();
        StringBuilder revertedWord = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            revertedWord.append(chars[i]);
        }
        return revertedWord.toString();
    }
}
