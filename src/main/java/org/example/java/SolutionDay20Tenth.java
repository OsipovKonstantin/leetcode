package org.example.java;

//    easy. Array instead of hashmap
//    https://leetcode.com/problems/find-words-that-can-be-formed-by-characters
//    You are given an array of strings words and a string chars.
//    A string is good if it can be formed by characters from chars (each character can only be used once).
//    Return the sum of lengths of all good strings in words.
//    Example 1:
//    Input: words = ["cat","bt","hat","tree"], chars = "atach"
//    Output: 6
//    Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
//    Example 2:
//    Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
//    Output: 10
//    Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
public class SolutionDay20Tenth {
    public static int countCharacters(String[] words, String chars) {
        int[] charCount = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charCount[chars.charAt(i) - 'a']++;
        }
        int res = 0;
        for (String s : words) {
            if (isValid(charCount, s)) {
                res += s.length();
            }
        }
        return res;
    }

    static boolean isValid(int[] charCount, String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
            if (charCount[c - 'a'] < count[c - 'a']) {
                return false;
            }
        }
        return true;
    }
}
