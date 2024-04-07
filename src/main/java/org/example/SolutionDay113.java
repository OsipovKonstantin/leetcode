package org.example;

//    medium #string
//    Time complexity is O(n)
//    Space complexity is O(n) due to char[] that I used to reduce time. Without char[] space complexity is O(1)
//    https://leetcode.com/problems/valid-parenthesis-string/
//    Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
//    The following rules define a valid string:
//    Any left parenthesis '(' must have a corresponding right parenthesis ')'.
//    Any right parenthesis ')' must have a corresponding left parenthesis '('.
//    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
//    '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
//    Example 1:
//    Input: s = "()"
//    Output: true
//    Example 2:
//    Input: s = "(*)"
//    Output: true
//    Example 3:
//    Input: s = "(*))"
//    Output: true
public class SolutionDay113 {
    public static boolean checkValidString(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int stars = 0;
        int balance = 0;
        for (char c : cs) {
            if (c == '(') balance++;
            else if (c == ')') balance--;
            else stars++;
            if (stars + balance < 0) return false;
        }
        if (stars < balance) return false;
        stars = 0;
        balance = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (cs[i] == ')') balance++;
            else if (cs[i] == '(') balance--;
            else stars++;
            if (stars + balance < 0) return false;
        }
        return stars >= balance;
    }
}
