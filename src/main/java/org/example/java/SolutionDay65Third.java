package org.example.java;

//    easy #two pointers
//    Time complexity is O(n*m), where n is number of words and m is length of the longest word.
//    Space complexity is O(1)
//    https://leetcode.com/problems/find-first-palindromic-string-in-the-array
//    Given an array of strings words, return the first palindromic string in the array. If there is no such string,
//    return an empty string "".
//    A string is palindromic if it reads the same forward and backward.
//    Example 1:
//    Input: words = ["abc","car","ada","racecar","cool"]
//    Output: "ada"
//    Explanation: The first string that is palindromic is "ada".
//    Note that "racecar" is also palindromic, but it is not the first.
//    Example 2:
//    Input: words = ["notapalindrome","racecar"]
//    Output: "racecar"
//    Explanation: The first and only string that is palindromic is "racecar".
//    Example 3:
//    Input: words = ["def","ghi"]
//    Output: ""
//    Explanation: There are no palindromic strings, so the empty string is returned.
public class SolutionDay65Third {
    public static String firstPalindrome(String[] words) {
        for (String word : words)
            if (isPalindrome(word)) return word;
        return "";
    }

    private static boolean isPalindrome(String word) {
        int n = word.length();
        for (int i = 0; i < n / 2; i++)
            if (word.charAt(i) != word.charAt(n - 1 - i)) return false;
        return true;
    }
}
