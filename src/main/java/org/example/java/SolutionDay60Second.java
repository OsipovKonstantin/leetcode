package org.example.java;

import java.util.ArrayList;
import java.util.List;

//    medium #dynamic programming. Recursive approach without memoization because it is not needed here
//    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number
//    could represent. Return the answer in any order.
//    A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map
//    to any letters.
//    Example 1:
//    Input: digits = "23"
//    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//    Example 2:
//    Input: digits = ""
//    Output: []
//    Example 3:
//    Input: digits = "2"
//    Output: ["a","b","c"]
public class SolutionDay60Second {
    public static List<String> letterCombinations(String digits) {
        if (digits.equals("")) return new ArrayList<>();
        int[] numOfChars = new int[]{0, 0, 3, 6, 9, 12, 15, 19, 22, 26};
        List<String> ans = new ArrayList<>();
        traverse(numOfChars, ans, digits, "");
        return ans;
    }

    private static void traverse(int[] numOfChars, List<String> ans, String digits, String s) {
        if (s.length() == digits.length()) ans.add(s);
        else {
            int digit = Character.getNumericValue(digits.charAt(s.length()));
            int start = numOfChars[digit - 1];
            int end = numOfChars[digit];
            for (int i = start; i < end; i++)
                traverse(numOfChars, ans, digits, s + (char) (i + 'a'));
        }
    }
}
