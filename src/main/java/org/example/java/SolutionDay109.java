package org.example.java;

//easy #strings
//Time complexity is O(n)
//Space complexity is O(n)
//https://leetcode.com/problems/length-of-last-word
//Given a string s consisting of words and spaces, return the length of the last word in the string.
//A word is a maximal
//substring
// consisting of non-space characters only.
//Example 1:
//Input: s = "Hello World"
//Output: 5
//Explanation: The last word is "World" with length 5.
//Example 2:
//Input: s = "   fly me   to   the moon  "
//Output: 4
//Explanation: The last word is "moon" with length 4.
//Example 3:
//Input: s = "luffy is still joyboy"
//Output: 6
//Explanation: The last word is "joyboy" with length 6.
public class SolutionDay109 {
    public static int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" ");
        return words[words.length - 1].length();
    }
}
