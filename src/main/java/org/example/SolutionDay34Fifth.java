package org.example;

//    easy #string comparison
//    https://leetcode.com/problems/backspace-string-compare
//    Given two strings s and t, return true if they are equal when both are typed into empty text editors.
//    '#' means a backspace character.
//    Note that after backspacing an empty text, the text will continue empty.
//    Example 1:
//    Input: s = "ab#c", t = "ad#c"
//    Output: true
//    Explanation: Both s and t become "ac".
//    Example 2:
//    Input: s = "ab##", t = "c#d#"
//    Output: true
//    Explanation: Both s and t become "".
//    Example 3:
//    Input: s = "a#c", t = "b"
//    Output: false
//    Explanation: s becomes "c" while t becomes "b".
public class SolutionDay34Fifth {
    public static boolean backspaceCompare(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        String sAfter = restoreString(sChars);
        String tAfter = restoreString(tChars);
        return sAfter.equals(tAfter);
    }

    private static String restoreString(char[] fromChars) {
        StringBuilder sb = new StringBuilder();
        int sharps = 0;
        for (int i = fromChars.length - 1; i >= 0; i--) {
            if (i >= 0 && fromChars[i] == '#') {
                sharps++;
                continue;
            }
            if (sharps > 0) {
                sharps--;
                continue;
            } else {
                sb.append(fromChars[i]);
            }
        }
        return sb.toString();
    }
}
